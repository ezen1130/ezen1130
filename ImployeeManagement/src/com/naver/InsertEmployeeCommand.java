package com.naver;

import java.util.Scanner;

public class InsertEmployeeCommand implements Command{
	
	// 사원 등록하는 클래스입니다.

	@Override
	public void execute(Scanner sc) {
		try {
			System.out.println("사원 등록을 시작합니다.");
			String id;
			while (true) {
				System.out.println("사원ID를 입력하세요");
				id = sc.nextLine();
				if (id.length() != 8) {
					System.out.println("사원ID는 8자리입니다.");
				}else {
					break;
				}
			}
			
			
			System.out.println("사원 이름을 입력하세요.");
			String name = sc.nextLine();
			
			System.out.println("직급을 입력하세요.");
			String position = sc.nextLine();
			
			EmployeeDTO dto = new EmployeeDTO(id, name, position);
			EmployeeDAO dao = new EmployeeDAO();
			System.out.println("사원 등록이 완료되었습니다.");
			dao.insert(dto);
			
			
		} catch (Exception e) {
			System.out.println("중복된 ID입니다.");
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		return "사원 등록";
	}
	
	
	

}
