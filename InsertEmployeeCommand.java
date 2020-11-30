package com.naver;

import java.util.Scanner;

public class InsertEmployeeCommand implements Command{
	
	// 사원 등록하는 클래스입니다.

	@Override
	public void execute(Scanner sc) {
		System.out.println("사원 등록을 시작합니다.");
		System.out.println("사원 ID를 입력하세요.");
		String id = sc.nextLine();
		
		System.out.println("사원 이름을 입력하세요.");
		String name = sc.nextLine();
		
		System.out.println("직급을 입력하세요.");
		String position = sc.nextLine();
		
		EmployeeDTO dto = new EmployeeDTO(id, name, position);
		EmployeeDAO dao = new EmployeeDAO();
		
		dao.insertEmployee(dto);
		
		System.out.println("사원 등록이 완료되었습니다.");
		
	}

	@Override
	public String toString() {
		return "사원 등록";
	}
	
	
	

}
