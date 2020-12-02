package kr.co.ezen;

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

public class MainEx {

	public static void main(String[] args) {

		Command[] menus = {new AttendeeInsertCommand(),
				           new ExittimeCommand(),
				           
				           new AttendeeSelectCommand(),
				           new EmployeeInsertCommand(),
				           new EmployeeUpdateCommand(),
				           new EmployeeSelectCommand(),
				           new EmployeeDeleteCommand(),
						   new AttendeeDeleteEndCommand()};
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("메뉴를 선택하여 주십시오.");
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
