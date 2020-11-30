package com.naver;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AttendeeInsertCommand implements Command{
	
	// employeeDTO에 있는 id를 가져와서
	// 입력받은 id가 employeeDTO에 있는 id와 같으면 출근시간을 입력하게 만든 클래스입니다


	
	@Override
	public void execute(Scanner sc) {
		
		System.out.println("출근 시간을 등록합니다.");
		System.out.println("사원 ID를 입력하세요.");
		
		String id = sc.nextLine();
		
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO odto = dao.selectById(id);
		AttendeeDAO aDao = new AttendeeDAO();
		AttendeeDTO aDto =aDao.selectById(id);
		
		
		
		
		try {
			if (id == odto.getId()) {
				
				System.out.println(odto.getName() + "님 안녕하세요.");
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date date = new java.util.Date();
				String intime = df.format(date);
				aDto = new AttendeeDTO(id, odto.getName(), intime, null);
				
				aDao.insertIntime(aDto);
			
			}
			
		} catch (Exception e) {

			System.out.println("등록되지 않은 사원 ID입니다.");
			System.out.println("출근 등록을 처음부터 다시 시도해주세요.");
			
		} 

	}

	@Override
	public String toString() {
		return "출근 등록";
	}
	
	

}
