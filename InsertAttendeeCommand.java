package com.naver;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InsertAttendeeCommand implements Command{
	
	// employeeDTO�� �ִ� id�� �����ͼ�
	// �Է¹��� id�� employeeDTO�� �ִ� id�� ������ ��ٽð��� �Է��ϰ� ���� Ŭ�����Դϴ�
	// �ٵ� �� �� ������ ����??

	
	@Override
	public void execute(Scanner sc) {
		
		System.out.println("��� �ð��� ����մϴ�.");
		System.out.println("��� ID�� �Է��ϼ���.");
		
		String id = sc.nextLine();
		
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO odto = dao.selectById(id);
		
		
		if (id == odto.getId()) {
				System.out.println(odto.getName() + "�� �ȳ��ϼ���.");
				System.out.println("��� �ð��� ����մϴ�.");
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // HH=24h, hh=12h
				java.util.Date date = new java.util.Date();
				String intime = df.format(date);
				AttendeeDAO aDao = new AttendeeDAO();
				
				AttendeeDTO aDto = new AttendeeDTO(id, odto.getName(), intime, null);
				aDao.insertIntime(aDto);
				System.out.println("��ٽð��� ��ϵǾ����ϴ�.");
		
		} else {
			System.out.println("��ϵ��� ���� ��� ID�Դϴ�.");
			System.out.println("��� ����� ó������ �ٽ� �õ����ּ���.");
		}
		
	}

	@Override
	public String toString() {
		return "��� ���";
	}
	
	

}
