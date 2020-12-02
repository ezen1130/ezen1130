package com.naver;

import java.util.Scanner;

public class EmployeeDeleteCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		EmployeeDAO dao = new EmployeeDAO();
		
		System.out.println("삭제할 사원ID를 입력하세요.");
		String id = sc.nextLine();
		
		EmployeeDTO dto = dao.selectById(id);
		
		if (dto != null) {
			EmployeeDTO edto = new EmployeeDTO(id, null, null);
			EmployeeDAO edao = new EmployeeDAO();
			dao.delete(edto);
			System.out.println("삭제처리되었습니다.");
		}else {
			System.out.println("등록되지않은 ID입니다 다시 시도해주세요.");
		}
	}
	
	@Override
	public String toString() {
		return "사원삭제";
	}

	
}