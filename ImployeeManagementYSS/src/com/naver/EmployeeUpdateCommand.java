package com.naver;

import java.util.Scanner;

public class EmployeeUpdateCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		System.out.println("������ ������ ���ID�� �Է��ϼ���.");
		String id = sc.nextLine();
		
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO odto = dao.selectById(id);
		
		try {
			if (odto.getId() == null) {
				return;
			}
		} catch (Exception e) {
			System.out.println("��ϵ��� ���� ID�Դϴ�.");
			return;
		}
		
		System.out.println("���� ������ �̸��� �Է��ϼ���.");
		String name = sc.nextLine();
		System.out.println("���� ������ ������ �Է��ϼ���.");
		String position = sc.nextLine();
		
		EmployeeDTO dto = new EmployeeDTO(id, name, position);
		
		dao.update(dto);
		
		
	}

	@Override
	public String toString() {
		return "�����������";
	}

}
