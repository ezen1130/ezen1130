package com.naver;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InsertEmployeeCommand implements Command{
	
	// 사원 등록하는 클래스입니다.

	@Override
	public void execute(Scanner sc) {
		
			System.out.println("사원 등록을 시작합니다.");
			String id;
			
			
			while (true) {
				System.out.println("사원ID를 입력하세요");
				id = sc.nextLine();
				
				// 사원 ID를 영문과 숫자로만 입력받을 수 있게 했어요
				String p = "^[a-zA-Z0-9]*$";
				// 영문, 숫자만 들어갔다면 true, 아니라면 false 반환합니다.
				boolean i = Pattern.matches(p, id);
				
				if (id.length() != 8) {
					System.out.println("사원 ID는 8자리입니다.");
				} else if(i == false) {
					System.out.println("사원 ID는 영문과 숫자로만 입력하여 주세요.");
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
			System.out.println("사원 등록이 완료되었습니다.");
			dao.insert(dto);
			
			
	
		}
		
	

	@Override
	public String toString() {
		return "사원 등록";
	}
	
	
	

}
