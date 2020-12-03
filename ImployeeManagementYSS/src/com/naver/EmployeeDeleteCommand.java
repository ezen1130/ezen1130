package com.naver;

import java.util.Scanner;

public class EmployeeDeleteCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("삭제할 사원번호를 입력하세요.");
		String id = sc.nextLine();
		
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO odto = dao.selectById(id);
		
		try {
			odto.getId();
		} catch (Exception e) {
			System.out.println("등록되지 않은 ID입니다.");
			return;
		}
		
		EmployeeDTO dto = new EmployeeDTO(id, null, null);

		dao.delete(dto);
		System.out.println("사원번호 "+id+"님의 정보가 삭제되었습니다.");
	}
	
	@Override
	public String toString() {
		return "사원정보삭제";
	}

	
}