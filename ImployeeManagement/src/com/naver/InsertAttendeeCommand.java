package com.naver;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InsertAttendeeCommand implements Command{
	
	// employeeDTO에 있는 id를 가져와서
	// 입력받은 id가 employeeDTO에 있는 id와 같으면 출근시간을 입력하게 만든 클래스입니다
	// 근데 전 왜 에러가 뜰까요??

	
	@Override
	public void execute(Scanner sc) {

		
		System.out.println("사원 ID를 입력하세요.");
		
		String id = sc.nextLine();
		
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO odto = dao.selectById(id);
		
		
		if (id == odto.getId()) {
				System.out.println(odto.getName() + "님 안녕하세요.");
				
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // HH=24h, hh=12h
				java.util.Date date = new java.util.Date();
				String intime = df.format(date);
				AttendeeDAO aDao = new AttendeeDAO();
				
				AttendeeDTO aDto = new AttendeeDTO(id, odto.getName(), intime, null);
				aDao.intime(aDto);
				System.out.println("열일하세요 ~ ^^.");
		
		} else {
			System.out.println("등록되지 않은 사원 ID입니다.");
		
		}
		
	}

	@Override
	public String toString() {
		return "출근하기";
	}
	

}
