package koreait.jdbc.day3;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoTest {
	
	public static void main(String[] args) {
		
		StudentDao dao = new StudentDao();
		
		System.out.println("1. insert 테스트");
		System.out.println("2023009 김땡구 17 강남구 - 데이터 입력");
		StudentDto dto = new StudentDto("2023009","김땡구",17,"강남구");
		try {
			int count = dao.insert(dto);
			System.out.println("학생 등록 " + count + "건 입력 성공!!");
			System.out.println("입력 결과 조회 : " + dao.selectOne(dto.getStuno()));

		} catch (SQLException e) {
			System.out.println("예외 - " + e.getMessage());
		}
		
		
		System.out.println("2. update 테스트");
		System.out.println("2023009 김땡구 16 용산구 - 데이터 수정");
		dto = new StudentDto("2023009","김땡구",16,"용산구");
		
		try {
			int count = dao.update(dto);
			System.out.println("학생 등록 " + count + "건 수정 성공!!");
			System.out.println("입력 결과 조회 : " + dao.selectOne(dto.getStuno()));
		} catch (SQLException e) {
			System.out.println("예외 - " + e.getMessage());
		}
		
		System.out.println("3. delete 테스트");
		System.out.println("2023009 - 데이터 삭제");
		try {
			int count = dao.delete("2023009");
			System.out.println("학생 등록 " + count + "건이 삭제 되었습니다.");
			System.out.println("입력 결과 조회 : " + dao.selectOne("2023009"));

		} catch (SQLException e) {
			System.out.println("예외 - " + e.getMessage());
		}
		
		System.out.println("4. select(1명) 테스트");
		try {
			int count = dao.insert(dto);
			System.out.println("학생 등록 " + count + "건이 조회 되었습니다.");
			System.out.println("입력 결과 조회 : " + dao.selectOne(dto.getStuno()));
		} catch (SQLException e) {
			System.out.println("예외 - " + e.getMessage());
		}
		
		System.out.println("5. select all 테스트");
		System.out.println("학생 테이블의 모든 데이터 조회하여 출력합니다.");
		try {
			List<StudentDto> list = dao.selectAll();
			for(StudentDto stu : list) {
				System.out.println(stu);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
