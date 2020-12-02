package com.naver;

import java.util.Scanner;

public class ProgramCloseCommand implements Command{
	
	// 프로그램을 종료하는 class
	// 단순히 종료기능을 하는 class이기 때문에
	// 저장된 내용이 삭제되지 않고 보존된다.

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
