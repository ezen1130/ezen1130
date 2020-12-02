package com.naver;

import java.util.List;
import java.util.Scanner;

public class EmployeeSelectCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("메뉴를 선택하세요.");
		System.out.println("1: 개인 조회, 2: 전체 조회");
		
		int menu = sc.nextInt();
		sc.nextLine();
		
		EmployeeDAO dao = new EmployeeDAO();
		List<EmployeeDTO> list = dao.select();
		
		if(menu == 2) {
			
			for (int i = 0; i < list.size() ; i++) {
				EmployeeDTO dto = list.get(i);
				
				String position = dto.getPosition();
				
				if(position.contains("a")) {
					dto.setPosition("부장");
				} else if(position.contains("b")) {
					dto.setPosition("차장");
				} else if(position.contains("c")) {
					dto.setPosition("과장");
				} else if(position.contains("d")) {
					dto.setPosition("대리");
				} else if(position.contains("e")) {
					dto.setPosition("사원");
				} else {
					System.out.println("인턴");
				}
				
				System.out.println(dto);
			}
		} else if (menu == 1) {
			
			System.out.println("1: 사원ID로 조회, 2: 이름으로 조회");
			int menu2 = sc.nextInt();
			sc.nextLine();
			
			switch (menu2) {
			
			case 1:
				
				System.out.println("검색할 ID를 입력하세요.");
				String id = sc.nextLine();
				
				EmployeeDTO dto = dao.selectById(id);
				String position = dto.getPosition();
				
				if(position.contains("a")) {
					dto.setPosition("부장");
				} else if(position.contains("b")) {
					dto.setPosition("차장");
				} else if(position.contains("c")) {
					dto.setPosition("과장");
				} else if(position.contains("d")) {
					dto.setPosition("대리");
				} else if(position.contains("e")) {
					dto.setPosition("사원");
				} else {
					System.out.println("인턴");
				}
				
				break;
				
			case 2:
				
				System.out.println("검색할 사원 이름을 입력하세요.");
				String name = sc.nextLine();
				
				List<EmployeeDTO> nameList = dao.selectByName(name);
				
				for (int i = 0; i < nameList.size(); i++) {
					
					dto = list.get(i);
					position = dto.getPosition();
					
					if (position.contains("a")) {
						dto.setPosition("부장");
					} else if (position.contains("b")) {
						dto.setPosition("차장");
					} else if (position.contains("c")) {
						dto.setPosition("과장");
					} else if (position.contains("d")) {
						dto.setPosition("대리");
					} else if (position.contains("e")) {
						dto.setPosition("사원");
					} else {
						System.out.println("인턴");
					}
					
					System.out.println(dto);
				}
	
				break;
				
			default:
				if(menu2>2) {
					menu2 = 2;
				} else if(menu2<1) {
					menu2 = 1;
				}
				
				break;
			}
			
			
			
		} else {
			if(menu>2) {
				menu = 2;
			} else if(menu<1) {
				menu = 1;
			}
		}
	
		}

	@Override
	public String toString() {
		return "사원 조회";
	}
		
	
}
