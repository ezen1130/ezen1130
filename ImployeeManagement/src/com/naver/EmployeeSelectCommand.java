package com.naver;


import java.util.List;
import java.util.Scanner;

public class EmployeeSelectCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		EmployeeDAO dao = new EmployeeDAO();
		List<EmployeeDTO> list = dao.select();
		
		for (int i = 0; i < list.size() ; i++) {
			EmployeeDTO dto = list.get(i);
			System.out.println(dto);
		}
		
		
			
		}

	@Override
	public String toString() {
		return "사원조회";
	}
		
	
	}


