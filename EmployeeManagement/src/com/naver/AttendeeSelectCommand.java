  
package com.naver;

import java.util.List;
import java.util.Scanner;

public class AttendeeSelectCommand implements Command {
	
	// 현재 출근한 사원들의 레코드를 조회할 수 있다
	// ID를 입력해 개인별로 조회가 가능하고
	// 전체 사원은 조회 후 사원ID의 오름차순으로 정렬될 수 있도록 하였다.
	// exittime에 레코드가 저장되어있는 경우, 퇴근자로 간주하여
	// 출근자 조회에서는 보이지 않도록 하였다.

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
			AttendeeDTO dto = dao.selectById(id);
			
			String name = dto.getName();
			String intime = dto.getIntime();
					
			dto = new AttendeeDTO(id, name, intime, dto.getExittime());
			System.out.println(dto);

			break;
			
		case 2:
			
			for (int i = 0; i < list.size(); i++) {
				dto = list.get(i);
				System.out.println(dto);
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
		return "출퇴근 기록 조회";
	}

	
	
}