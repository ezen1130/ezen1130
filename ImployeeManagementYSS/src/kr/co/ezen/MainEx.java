package kr.co.ezen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.naver.AttendeeSelectCommand;
import com.naver.Command;
import com.naver.EmployeeDeleteCommand;
import com.naver.EmployeeSelectCommand;
import com.naver.EmployeeUpdateCommand;
import com.naver.ExittimeCommand;
import com.naver.AttendeeDeleteEndCommand;
import com.naver.AttendeeInsertCommand;
import com.naver.EmployeeInsertCommand;
import com.naver.EmployeeSelectByIdCommand;

public class MainEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// ��ĳ�� ǥ���Է�(Ű����)
		
		// Ŀ�ǵ忡 ��ӵ� ���̵� �迭�� �����ֱ�
		Command[] menus = {new AttendeeInsertCommand(),
				           new ExittimeCommand(),
				           new AttendeeSelectCommand(),
				           new EmployeeInsertCommand(),
				           new EmployeeUpdateCommand(),
				           new EmployeeSelectCommand(),
				           new EmployeeSelectByIdCommand(),
				           new EmployeeDeleteCommand(),
						   new AttendeeDeleteEndCommand()};
		
//		while (true) {
//		// �迭
//		System.out.println("�޴��� �����Ͽ� �ֽʽÿ�.");
//		System.out.print("| ");
//		for (int i = 0; i < menus.length; i++) {
//			Command com = menus[i];
//			System.out.print(i+":");
//			System.out.print(com);
//			if (i == menus.length-1) {
//				break;
//			}
//			System.out.print(" | ");
//		}
//		System.out.println(" |");
//		int idx = sc.nextInt();
//		sc.nextLine();
//		try {
//			menus[idx].execute(sc);
//		} catch (Exception e) {
//			System.out.println("0~"+(menus.length-1)+"������ ���ڸ� �Է��Ͽ� �ֽʽÿ�.");
//		}
//	}
		
		
		
		Map<Integer, Command> map = new HashMap<Integer, Command>();
		// Ű�� ���ڷ�, ����� Ŀ�ǵ�� ������ Map
		
		for (int i = 0; i < menus.length; i++) {
			// �ʿ� �迭 �־��ֱ� �ݺ���
			map.put(i, menus[i]);
		}
		
//		while (true) {
//			// ���ο� �迭�� ���� Map
//			System.out.println("�޴��� �����Ͽ� �ֽʽÿ�.");
//			System.out.print("| ");
//			for (int i = 0; i < map.size(); i++) {
//				Command com = map.get(i);
//				System.out.print(i+":");
//				System.out.print(com);
//				if (i == map.size()) {
//					break;
//				}
//				System.out.print(" | ");
//			}
//			System.out.println();
//			int idx = sc.nextInt();
//			sc.nextLine();
//			try {
//				map.get(idx).execute(sc);
//			} catch (Exception e) {
//				System.out.println("0~"+(map.size()-1)+"������ ���ڸ� �Է��Ͽ� �ֽʽÿ�.");
//			}
//		}
		
		
		
		List<Command> list = new ArrayList<Command>();
		// �ڷ����� Command�� ArrayList ����
		
		for (int i = 0; i < menus.length; i++) {
			// ����Ʈ�� �迭 �־��ֱ� �ݺ���
			list.add(menus[i]);
		}
		
		while (true) {
			// ���ο� �迭�� ���� List
			System.out.println("�޴��� �����Ͽ� �ֽʽÿ�.");
			System.out.print("| ");
			for (int i = 0; i < list.size(); i++) {
				Command com = list.get(i);
				System.out.print(i+":");
				System.out.print(com);
				if (i == list.size()) {
					break;
				}
				System.out.print(" | ");
			}
			System.out.println();
			int idx = sc.nextInt();
			sc.nextLine();
			try {
				list.get(idx).execute(sc);
			} catch (Exception e) {
				System.out.println("0~"+(list.size()-1)+"������ ���ڸ� �Է��Ͽ� �ֽʽÿ�.");
			}
		}
	}

}
