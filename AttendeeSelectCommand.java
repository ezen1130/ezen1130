  
package com.naver;

import java.util.List;
import java.util.Scanner;

public class AttendeeSelectCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		AttendeeDAO dao = new AttendeeDAO();
		List<AttendeeDTO> list =  dao.attendeeCheck();	
		for (int i = 0; i < list.size(); i++) {
			AttendeeDTO dto = list.get(i);
			if(dto.getExittime() != null) {
				continue;
			} else {
				System.out.println(dto);
			}
		}
	}

	@Override
	public String toString() {
		return "출근자 조회";
	}

	
	
}