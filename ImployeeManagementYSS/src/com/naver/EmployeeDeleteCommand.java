package com.naver;

import java.util.Scanner;

public class EmployeeDeleteCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("������ �����ȣ�� �Է��ϼ���.");
		String id = sc.nextLine();
		
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO odto = dao.selectById(id);
		
		try {
			odto.getId();
		} catch (Exception e) {
			System.out.println("��ϵ��� ���� ID�Դϴ�.");
			return;
		}
		
		EmployeeDTO dto = new EmployeeDTO(id, null, null);

		dao.delete(dto);
		System.out.println("�����ȣ "+id+"���� ������ �����Ǿ����ϴ�.");
	}
	
	@Override
	public String toString() {
		return "�����������";
	}

	
}