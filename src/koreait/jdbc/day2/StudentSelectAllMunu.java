package koreait.jdbc.day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 모든 학생 조회하는 StudentSelectAllMunu 클래스 : 1줄에 1개 행을 출력하세요.
public class StudentSelectAllMunu {
	public static void main(String[] args) {
		Connection conn = OracleUtility.getConnection();
		System.out.println("::::::::::::::::::::: 모든학생을 조회하는 메뉴 :::::::::::::::::::::");
		selectAllStudent(conn);
		
		OracleUtility.close(conn);
	}

	private static void selectAllStudent(Connection conn) {
		String sql = "select * from tbl_student";
		System.out.println("모든 학생 조회를 시작합니다.");
		
		try (
			PreparedStatement ps = conn.prepareStatement(sql);
		){
			ResultSet rs = ps.executeQuery();
			System.out.println("rs 객체의 구현 클래스는 " + rs.getClass().getName());
		while(rs.next()) {
//			System.out.print("학번 : " + rs.getString("stuno"));
//			System.out.print("이름 : " + rs.getString("name"));
//			System.out.print("나이 : " + rs.getInt("age"));
//			System.out.print("주소 : " + rs.getString("address") + "\n");
			System.out.println("----------------------------------------------------");
			System.out.println(String.format("학번 : %s | 이름 : %s | 나이 : %s| 주소 : %s", rs.getString("stuno"),rs.getString("name"),rs.getInt("age"),rs.getString("address")));
		}  
			
		} catch (SQLException e) {
			System.out.println("데이터 조회에 문제가 생겼습니다. 상새내용 - " + e.getMessage());
		}
	}
}
