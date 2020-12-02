package com.naver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AttendeeExitCommand implements Command{
	
	// 출근한 사원의 퇴근시간을 등록하는 class
	// 출근시간이 있는 사원들에 한해서 퇴근시간이 등록되도록 하였고
	// 한번 퇴근 등록을 한 사원은 다시 등록되지 않도록 메서드를 구현함
	// 등록되지 않았거나 intime 레코드가 없는 id를 입력받은 경우, 
	// 등록되지 않았다는 알림멘트를 띄우며 메뉴로 돌아간다.

	@Override
	public void execute(Scanner sc) {
		System.out.println("사원 ID를 입력하세요.");
		String id = sc.nextLine();
		
		AttendeeDAO oDao = new AttendeeDAO();
		AttendeeDTO oDto = oDao.selectById(id);
		
		
		try {
			if (oDto.getIntime() != null) {
				
				if (oDto.getExittime() == null) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date time = new Date();
					String exittime = format.format(time);
					
					AttendeeDTO dto = new AttendeeDTO(id, oDto.getName(), oDto.getIntime(), exittime);
					oDao.exittime(dto);
					System.out.println("퇴근시간이 등록되었습니다.");
					System.out.println("수고하셨습니다.");
				
				} else
				
					System.out.println("이미 퇴근한 사원입니다.");
				}
			
		} catch (Exception e) {

			System.out.println("등록되지 않았거나 출근하지 않은 사원 ID입니다.");
			System.out.println("퇴근 등록을 처음부터 다시 시작해주세요.");
		}
		
		
		
	}

	@Override
	public String toString() {
		return "퇴근 등록";
	}

}