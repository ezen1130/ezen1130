package com.naver;

import java.util.List;
import java.util.Scanner;

public class AttendeeSelectCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		AttendeeDAO dao = new AttendeeDAO();
		List<AttendeeDTO> list = dao.checkAttendee();

		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}
	}

	@Override
	public String toString() {
		return "ÃâÅð±Ù±â·Ï";
	}

}