package com.naver;

import java.util.Scanner;

public class ProgramCloseCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("프로그램이 종료됩니다.");
		sc.close();
		
		System.exit(0);

	}

	@Override
	public String toString() {
		return "프로그램 종료";
	}
	
	

}
