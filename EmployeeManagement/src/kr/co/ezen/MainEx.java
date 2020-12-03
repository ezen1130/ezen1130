package kr.co.ezen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.naver.Command;
import com.naver.EmployeeDeleteCommand;
import com.naver.AttendeeDeleteCommand;
import com.naver.AttendeeExitCommand;
import com.naver.AttendeeInsertCommand;
import com.naver.AttendeeSelectCommand;
import com.naver.EmployeeInsertCommand;
import com.naver.EmployeeSelectCommand;
import com.naver.EmployeeUpdateCommand;
import com.naver.ProgramCloseCommand;

public class MainEx {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		List<Command> coms = new ArrayList<Command>();
		
		coms.add(new AttendeeInsertCommand());
		coms.add(new AttendeeExitCommand());
		coms.add(new AttendeeSelectCommand());
		coms.add(new AttendeeDeleteCommand());
		coms.add(new EmployeeInsertCommand());
		coms.add(new EmployeeSelectCommand());
		coms.add(new EmployeeUpdateCommand());
		coms.add(new EmployeeDeleteCommand());
		coms.add(new ProgramCloseCommand());
		
		boolean isTrue = true;
		
		while (isTrue) {
			System.out.println();
			System.out.println("====출퇴근 등록 시스템====");
			for(int i=0; i<coms.size(); i++) {
				System.out.print(i+": ");
				System.out.println(coms.get(i));
			}
			System.out.println("=====================");
			System.out.println();
			
			try {
			
				int menu = sc.nextInt();
				sc.nextLine();
				coms.get(menu).execute(sc);
			
			} catch (Exception e) {
				System.out.println("잘못된 접근입니다.");
				System.out.println("프로그램을 다시 실행해주세요.");
				break;
			} 
		}
		
		
	}

}
