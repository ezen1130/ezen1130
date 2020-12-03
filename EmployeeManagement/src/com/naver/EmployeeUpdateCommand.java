package com.naver;

import java.util.Scanner;

public class EmployeeUpdateCommand implements Command{
	
	// 사원 정보를 수정할 수 있는 class
	// 사원 id를 입력하면 이름과 직급을 선택하여 수정할 수 있도록 함
	// 직급은 a~e까지 입력이 가능하고
	// 입력된 알파벳 값을 직급으로 대입해 출력되도록 설계함

	@Override
	public void execute(Scanner sc) {
		
		EmployeeDAO dao = new EmployeeDAO();
		
		System.out.println("사원 ID를 입력해주세요.");
		String id = sc.nextLine();
		EmployeeDTO oDto = dao.selectById(id);
		
		try {
			oDto.getId();
			
		} catch (Exception e) {
			System.out.println("등록되지 않은 ID입니다.");
			System.out.println("사원정보 변경을 처음부터 다시 시작해주세요.");
			return;
		}
	
		System.out.println("수정 할 메뉴를 선택하세요.");
		System.out.println("1: 이름, 2: 직급");
		
		int menu = sc.nextInt();
		sc.nextLine();
		
		switch (menu) {
		case 1:
			System.out.println("수정 할 이름을 입력하세요.");
			String nName = sc.nextLine();
			EmployeeDTO dto = new EmployeeDTO(oDto.getId(), nName,oDto.getPosition());
			dao.update(dto);
			System.out.println("이름이 "+nName+"으로 수정되었습니다.");
			break;
			
		case 2:
			System.out.println("변경 할 직급을 입력하세요.");
			String nPosition = sc.nextLine();
			dto = new EmployeeDTO(oDto.getId(), oDto.getName(), nPosition);
			dao.update(dto);
			
			if(nPosition.contains("a")) {
				dto.setPosition("부장");
			} else if(nPosition.contains("b")) {
				dto.setPosition("차장");
			} else if(nPosition.contains("c")) {
				dto.setPosition("과장");
			} else if(nPosition.contains("d")) {
				dto.setPosition("대리");
			} else if(nPosition.contains("e")) {
				dto.setPosition("사원");
			} else {
				System.out.println("인턴");
			}
			
			System.out.println("직급이 "+dto.getPosition()+"으로 변경되었습니다.");
			break;
			
		default:
			System.out.println("메뉴를 다시 선택하세요.");
			break;
		}
		

	}

	@Override
	public String toString() {
		return "사원정보 변경";
	}

}