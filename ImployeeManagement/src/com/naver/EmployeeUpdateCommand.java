package com.naver;

import java.util.Scanner;

public class EmployeeUpdateCommand implements Command{

	

	@Override
	public void execute(Scanner sc) {

		EmployeeDAO dao = new EmployeeDAO();	
		
		System.out.println("사원ID를 입력하시오.");
		String id = sc.nextLine();
		EmployeeDTO dto = dao.selectById(id);
		
		if (dto != null) {
			System.out.println("개명한 이름을 입력하시오.");
			String name = sc.nextLine();
			System.out.println("변경할 직급을 입력하시오.");
			String position = sc.nextLine();
			EmployeeDTO edto = new EmployeeDTO(id, name, position);
			dao.update(edto);
		}else {
			System.out.println("등록되지않은 ID입니다. 다시 시도해주세요.");
		}
		
		
	}

	@Override
	public String toString() {
		return "사원정보변경";
	}

}
