package com.naver;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AttendeeInsertCommand implements Command {

	// employeeDTO�� �ִ� id�� �����ͼ�
	// �Է¹��� id�� employeeDTO�� �ִ� id�� ������ ��ٽð��� �Է��ϰ� ���� Ŭ�����Դϴ�
	// �ٵ� �� �� ������ ����??

	@Override
	public void execute(Scanner sc) {

		System.out.println("��� ID�� �Է��ϼ���.");

		String id = sc.nextLine();

		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO odto = dao.selectById(id);

		try {
			if (id == odto.getId()) {
				System.out.println(odto.getName() + "�� �ȳ��ϼ���.");

				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // HH=24h, hh=12h
				java.util.Date date = new java.util.Date();
				String intime = df.format(date);
				AttendeeDAO aDao = new AttendeeDAO();

				AttendeeDTO aDto = new AttendeeDTO(id, odto.getName(), intime, null);
				aDao.intime(aDto);

			}
		} catch (Exception e) {
			System.out.println("��ϵ��� ���� ��� ID�Դϴ�.");
			System.out.println();
		}

	}

	@Override
	public String toString() {
		return "����ϱ�";
	}

}
