package com.naver;

import java.util.Scanner;

public class EmployeeDeleteCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("삭제할 사원번호를 입력하세요.");
		String id = sc.nextLine();
		
		EmployeeDTO dto = new EmployeeDTO(id, null, null);
		EmployeeDAO dao = new EmployeeDAO();
		dao.delete(dto);
	}
	
	@Override
	public String toString() {
		return "사원삭제";
	}

	
}