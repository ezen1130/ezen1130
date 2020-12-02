package com.naver;

import java.util.List;
import java.util.Scanner;

public class AttendeeSelectCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("메뉴를 선택하세요.");
		System.out.println("1: 개인 조회, 2: 전체 조회");
		
		int menu = sc.nextInt();
		sc.nextLine();
		
		AttendeeDAO dao = new AttendeeDAO();
		List<AttendeeDTO> list =  dao.attendeeCheck();
		
		
		switch (menu) {
		case 1:
			System.out.println("조회 할 ID를 입력하세요.");
			String id = sc.nextLine();
			AttendeeDTO dto = dao.intimeCheck(id);
			try {
				if(dto.getIntime() != null) {
					String name = dto.getName();
					String intime = dto.getIntime();
					
					dto = new AttendeeDTO(id, name, intime, dto.getExittime());
					System.out.println(dto);

				} else {
					
					break;
				}
				
			} catch (Exception e) {
				System.out.println("출근하지 않은 사원입니다.");
			}
						
			break;
			
		case 2:
			
			for (int i = 0; i < list.size(); i++) {
				dto = list.get(i);
				if(dto.getExittime() != null) {
					continue;
				} else {
					System.out.println(dto);
				}
			}
			
			break;

		default:
			
			if(menu>2) {
				menu = 2;
			} else if(menu<1) {
				menu = 1;
			}
			
			break;
		}
		
	}

	@Override
	public String toString() {
		return "출근자 조회";
	}

	
	
}