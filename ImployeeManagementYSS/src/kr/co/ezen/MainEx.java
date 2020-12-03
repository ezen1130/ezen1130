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
		// 스캐너 표준입력(키보드)
		
		// 커맨드에 상속된 아이들 배열로 묶어주기
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
//		// 배열
//		System.out.println("메뉴를 선택하여 주십시오.");
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
//			System.out.println("0~"+(menus.length-1)+"사이의 숫자를 입력하여 주십시오.");
//		}
//	}
		
		
		
		Map<Integer, Command> map = new HashMap<Integer, Command>();
		// 키를 숫자로, 밸류를 커맨드로 선언한 Map
		
		for (int i = 0; i < menus.length; i++) {
			// 맵에 배열 넣어주기 반복문
			map.put(i, menus[i]);
		}
		
//		while (true) {
//			// 내부에 배열을 넣은 Map
//			System.out.println("메뉴를 선택하여 주십시오.");
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
//				System.out.println("0~"+(map.size()-1)+"사이의 숫자를 입력하여 주십시오.");
//			}
//		}
		
		
		
		List<Command> list = new ArrayList<Command>();
		// 자료형이 Command인 ArrayList 선언
		
		for (int i = 0; i < menus.length; i++) {
			// 리스트에 배열 넣어주기 반복문
			list.add(menus[i]);
		}
		
		while (true) {
			// 내부에 배열을 넣은 List
			System.out.println("메뉴를 선택하여 주십시오.");
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
				System.out.println("0~"+(list.size()-1)+"사이의 숫자를 입력하여 주십시오.");
			}
		}
	}

}
