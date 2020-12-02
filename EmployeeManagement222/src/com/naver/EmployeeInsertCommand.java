package com.naver;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeInsertCommand implements Command{
	
	// 사원 등록하는 클래스입니다.
	// 사원 id를 영문과 숫자로만 입력받을 수 있게 했으며
	// 8자리를 초과한 경우 등록이 되지 않고
	// 입력창이 반복되도록 처리함.
	
	@Override
	public void execute(Scanner sc) {
		
		System.out.println("사원 등록을 시작합니다.");
		String id;
		while (true) {
			System.out.println("사원 ID를 입력하세요.");
			id = sc.nextLine();
			
			// 사원 ID를 영문과 숫자로만 입력받을 수 있게 했어요
			String p = "^[a-zA-Z0-9]*$";
			boolean i = Pattern.matches(p, id);
			
			if(id.length() > 8) {
				System.out.println("사원 ID는 8자 이내로 입력해주세요.");
			} else if(id.length()<9 && i == false){
				// 조건식이 true (i = 입력받은 id가 영문과 숫자로만 이루어져 있으면 true)가 아니면
				// syso(사원아이디 어쩌구)가 출력됩니다.
				
				System.out.println("사원 ID는 영문과 숫자로만 입력해주세요.");
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
		
	}

	@Override
	public String toString() {
		return "사원 등록";
	}
	
	
	

}
