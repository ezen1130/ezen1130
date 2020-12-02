package com.naver;

import java.util.Scanner;

public class EmployeeUpdateCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		System.out.println("정보를 변경할 사원ID를 입력하세요.");
		String id = sc.nextLine();
		System.out.println("새로 변경할 이름을 입력하세요.");
		String name = sc.nextLine();
		System.out.println("새로 변경할 직급을 입력하세요.");
		String position = sc.nextLine();
		
		EmployeeDTO dto = new EmployeeDTO(id, name, position);
		EmployeeDAO dao = new EmployeeDAO();	
		dao.update(dto);
		
		
	}

	@Override
	public String toString() {
		return "사원정보변경";
	}

}
