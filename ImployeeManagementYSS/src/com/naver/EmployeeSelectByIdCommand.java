package com.naver;

import java.util.Scanner;

public class EmployeeSelectByIdCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("��ȸ�� ID�� �Է����ּ���.");
		String id = sc.nextLine();
		
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO list = dao.selectById(id);
		String id2 = null;
		try {
			id2 = list.getId();
		} catch (Exception e) {
			System.out.println("�������� �ʴ� ID�Դϴ�.");
			return;
		}
		String name = list.getName();
		String position = list.getPosition();
		EmployeeDTO dto = new EmployeeDTO(id2, name, position);
		System.out.println(dto);
		
	}

	@Override
	public String toString() {
		return "���������ȸ";
	}
	
	
}
