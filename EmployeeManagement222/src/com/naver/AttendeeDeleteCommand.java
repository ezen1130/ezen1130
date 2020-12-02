package com.naver;

import java.util.Scanner;

public class AttendeeDeleteCommand implements Command {
	
	@Override
	public void execute(Scanner sc) {
		
		// DB에 저장된 출퇴근 정보를 초기화 하는 class
		// sql = "TRUNCATE TABLE attendee" 을 이용해
		// 테이블의 컬럼은 남아있으나 레코드만 한번에 삭제될 수 있도록 하였고,
		// 초기화를 선택하면 초기화와 함께 시스템을 종료시키는 메서드를 구현함
		
		
		System.out.println("출퇴근 정보를 초기화합니다.");
		System.out.println("초기화 후에는 모든 출근정보가 사라지며 프로그램이 종료됩니다.");
		System.out.println("정말로 초기화 하시겠습니까?");
		
		System.out.println("1: 초기화 하기, 2: 메뉴로 돌아가기");
		
		int key = sc.nextInt();
		
		
		switch (key) {
		case 1:
			AttendeeDAO dao = new AttendeeDAO();
			dao.deleteAttendee();
			System.out.println("출퇴근 정보가 초기화 되었습니다..");
			sc.close();
			System.out.println("시스템이 종료됩니다.");
			System.exit(0);
			
			break;
	
		case 2:
			
			System.out.println("메뉴로 돌아갑니다.");
			break;
		
		default:
			if(key>2) {
				key = 2;
			} else {
				key = 1;
			}
			break;
		}

	}

	@Override
	public String toString() {
		return "출퇴근 정보 초기화";
	}
	
	

}
