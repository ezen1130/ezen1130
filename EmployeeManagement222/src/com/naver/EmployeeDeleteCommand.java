package com.naver;

import java.util.Scanner;

public class EmployeeDeleteCommand implements Command {
	
	// 등록한 사원 정보를 삭제하는 class
	// 사원번호로 조회하여, 사원번호가 없으면 등록되지 않았다는 멘트를 띄우며 메뉴로 돌아감

	@Override
	public void execute(Scanner sc) {
		EmployeeDAO dao = new EmployeeDAO();
		
		System.out.println("삭제할 사원번호를 입력하세요.");
		String id = sc.nextLine();
		
		EmployeeDTO dto = dao.selectById(id);
		
		if (dto != null) {
			
			dto = new EmployeeDTO(id, null, null);
			dao = new EmployeeDAO();
			dao.delete(dto);
			System.out.println("사원 정보가 삭제되었습니다.");
		} else {
			System.out.println("등록되지 않은 ID입니다.");
			System.out.println("다시 시도해주세요.");
		}
	}
	
	@Override
	public String toString() {
		return "사원 삭제";
	}

	
}