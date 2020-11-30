package com.naver;

import java.util.Scanner;

public class DeleteAttendeeCommand implements Command {
	
	// 출퇴근 정보를 초기화하는 클래스
	// 1을 누르면 초기화되게 설정했습니다

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("출퇴근 정보를 초기화합니다.");
		System.out.println("정말 초기화 하시겠습니까?");
		System.out.println("1: 초기화 하기, 2: 돌아가기");
		
		int key = sc.nextInt();
		
		
		switch (key) {
		case 1:
			AttendeeDAO dao = new AttendeeDAO();
			dao.deleteAttendee();
			System.out.println("출퇴근 정보가 초기화 되었습니다.");
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
