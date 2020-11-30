package kr.co.ezen;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import com.naver.AttendeeDAO;
import com.naver.AttendeeDTO;
import com.naver.AttendeeSelectCommand;
import com.naver.Command;
import com.naver.Employee2DAO;
import com.naver.Employee2DTO;
import com.naver.Employee2DeleteCommand;
import com.naver.EndCommand;

public class MainEx {

	public static void main(String[] args) {
		Employee2DAO edao = new Employee2DAO();
//		edao.addemployee(new Employee2DTO("kim", "test", "���Ի��"));
		// ���� ������
//		AttendeeDAO adao = new AttendeeDAO();
		// ���� ������
//		Date date = new Date(Calendar.getInstance().getTimeInMillis());
//		adao.inWork(new AttendeeDTO("kim", null, date, null));
		// ���� ������
//		edao.delete(new Employee2DTO("kim2", null, null));
		// ���� ������
//		adao.checkAttendee();
		// ���� ������
		
		Command[] menus = {new AttendeeSelectCommand(), new Employee2DeleteCommand(), 
						   new EndCommand()};
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("�޴��� �����Ͽ� �ֽʽÿ�.");
			System.out.print("| ");
			for (int i = 0; i < menus.length; i++) {
				Command com = menus[i];
				System.out.print(i+":");
				System.out.print(com);
				if (i == menus.length-1) {
					break;
				}
				System.out.print(" | ");
			}
			System.out.println(" |");
			int idx = sc.nextInt();
			sc.nextLine();
			menus[idx].execute(sc);
		}
	}
}
