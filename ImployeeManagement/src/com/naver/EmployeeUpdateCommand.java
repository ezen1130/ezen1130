package com.naver;

import java.util.Scanner;

public class EmployeeUpdateCommand implements Command{

	

	@Override
	public void execute(Scanner sc) {

		EmployeeDAO dao = new EmployeeDAO();	
		
		System.out.println("���ID�� �Է��Ͻÿ�.");
		String id = sc.nextLine();
		EmployeeDTO dto = dao.selectById(id);
		
		if (dto != null) {
			System.out.println("������ �̸��� �Է��Ͻÿ�.");
			String name = sc.nextLine();
			System.out.println("������ ������ �Է��Ͻÿ�.");
			String position = sc.nextLine();
			EmployeeDTO edto = new EmployeeDTO(id, name, position);
			dao.update(edto);
		}else {
			System.out.println("��ϵ������� ID�Դϴ�. �ٽ� �õ����ּ���.");
		}
		
		
	}

	@Override
	public String toString() {
		return "�����������";
	}

}
