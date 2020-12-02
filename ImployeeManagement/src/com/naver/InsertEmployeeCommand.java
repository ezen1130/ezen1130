package com.naver;

import java.util.Scanner;

public class InsertEmployeeCommand implements Command{
	
	// ��� ����ϴ� Ŭ�����Դϴ�.

	@Override
	public void execute(Scanner sc) {
		try {
			System.out.println("��� ����� �����մϴ�.");
			String id;
			while (true) {
				System.out.println("���ID�� �Է��ϼ���");
				id = sc.nextLine();
				if (id.length() != 8) {
					System.out.println("���ID�� 8�ڸ��Դϴ�.");
				}else {
					break;
				}
			}
			
			
			System.out.println("��� �̸��� �Է��ϼ���.");
			String name = sc.nextLine();
			
			System.out.println("������ �Է��ϼ���.");
			String position = sc.nextLine();
			
			EmployeeDTO dto = new EmployeeDTO(id, name, position);
			EmployeeDAO dao = new EmployeeDAO();
			System.out.println("��� ����� �Ϸ�Ǿ����ϴ�.");
			dao.insert(dto);
			
			
		} catch (Exception e) {
			System.out.println("�ߺ��� ID�Դϴ�.");
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		return "��� ���";
	}
	
	
	

}
