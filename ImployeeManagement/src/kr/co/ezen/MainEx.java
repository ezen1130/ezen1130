package kr.co.ezen;


import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.naver.AttendeeDAO;
import com.naver.AttendeeDTO;
import com.naver.Command;
import com.naver.EmployeeDAO;
import com.naver.EmployeeDTO;
import com.naver.EmployeeSelectCommand;
import com.naver.EmployeeUpdateCommand;
import com.naver.ExittimeCommand;


public class MainEx {
// sql문에 date를 varchar2로 바꾸기부터 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Command> menu = new ArrayList<Command>();
		menu.add(new EmployeeSelectCommand());
		menu.add(new EmployeeUpdateCommand());
		menu.add(new ExittimeCommand());
		
		boolean isOk = true;
		int idx = -1;
		
		try {
			while (isOk) {
				System.out.println("메뉴를 선택하시오");
				for (int i = 0; i < menu.size(); i++) {
					Command com = menu.get(i);
					System.out.print(i+".");
					System.out.print(com);
					if (i != menu.size()) {
						System.out.println();
					}
				}
				System.out.println();
				
				idx = sc.nextInt();
				sc.nextLine();
				
				menu.get(idx).execute(sc);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}
				
		

		
		
		
	
		
		
		
		
		

		
		

	}

}
