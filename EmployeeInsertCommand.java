package com.naver;

import java.util.Scanner;

public class EmployeeInsertCommand implements Command{
	
	// 사원 등록하는 클래스입니다.
	@Override
	public void execute(Scanner sc) {
		
		System.out.println("사원 등록을 시작합니다.");
		String id;
		while (true) {
			System.out.println("사원 ID를 입력하세요.");
			id = sc.nextLine();
			if(id.length() > 8) {
				System.out.println("사원 ID는 영문과 숫자를 포함해 8자 이내로 입력해주세요.");
			} else {
				break;
			}
		}
		
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
