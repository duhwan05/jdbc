package koreait.jdbc.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDeleteMenu {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "iclass";
		String password = "0419";
	    System.out.println(":::::::::::::::::::: 학생 정보 삭제 메뉴입니다 ::::::::::::::::::::");
	    System.out.println("<< 지정된 학번에 대해 정보를 삭제할 수 있습니다. >>");
	    try (Connection conn = DriverManager.getConnection(url,user,password); 
	    ){
	    	deleteStudent(conn);
		} catch (Exception e) {
			System.out.println("오류 메세지 = " + e.getMessage());
		}
	}

	
//	@SuppressWarnings("resource")	//해석 : 리소스와 관련 경고는 표시하지 않게 해주세요.
	private static void deleteStudent(Connection conn) {
		Scanner sc = new Scanner(System.in);
		String stuno;
		String sql = "delete from TMP_STUDENT where stuno = ?";
		
		System.out.println("학생번호 0000 입력은 삭제 취소입니다.");
		System.out.print("삭제할 학번을 입력하세요 >>> ");
		stuno = sc.nextLine();
		
		if(stuno.equals("0000")) {
			System.out.println("삭제 취소입니다.");
			return;		//리턴에 값이 없을 때는 단순하게 메소드 종료로 실행됩니다.
		}
		
		try (
			PreparedStatement ps = conn.prepareStatement(sql);
		){	//매개변수의 순서와 형식을 확인하고 전달하는 setXXX 메소드를 실행합니다.
			ps.setString(1, stuno);
			int count = ps.executeUpdate();
			
			System.out.println("학생정보 " + count + "건 삭제되었습니다.");
		} catch (SQLException e) {
			System.out.println("데이터 수정에 문제가 생겼습니다." + e.getMessage());
		}
		sc.close();
		
	}
	
}
