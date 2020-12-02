package com.naver;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InsertAttendeeCommand implements Command{
	

	
	@Override
	public void execute(Scanner sc) {

		
		System.out.println("사원 ID를 입력하세요.");
		
		String id = sc.nextLine();
		
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO odto = dao.selectById(id);
		
		
		try {
			if (id == odto.getId()) {
					System.out.println(odto.getName() + "님 안녕하세요.");
					
					
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // HH=24h, hh=12h
					java.util.Date date = new java.util.Date();
					String intime = df.format(date);
					AttendeeDAO aDao = new AttendeeDAO();
					
					AttendeeDTO aDto = new AttendeeDTO(id, odto.getName(), intime, null);
					aDao.intime(aDto);
					System.out.println("열일하세요 ~ ^^.");
			
			} 
				
			
			
		} catch (Exception e) {
			System.out.println("등록되지 않은 사원 ID입니다.");
			
		}
		
	}

	@Override
	public String toString() {
		return "출근하기";
	}
	

}
