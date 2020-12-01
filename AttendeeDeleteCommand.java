package com.naver;

import java.util.Scanner;

public class AttendeeDeleteCommand implements Command {
	
	@Override
	public void execute(Scanner sc) {
		
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
			}
			break;
		}

	}

	@Override
	public String toString() {
		return "출퇴근 정보 초기화";
	}
	
	

}
