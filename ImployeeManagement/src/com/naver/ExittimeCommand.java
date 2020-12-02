package com.naver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExittimeCommand implements Command {

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
				} else {
					System.out.println("이미 퇴근한 사원입니다.");
					System.out.println();
				}

			}

		} catch (Exception e) {
			System.out.println("등록되지 않은 사원 ID입니다.");
			System.out.println();
		}

	}

	@Override
	public String toString() {
		return "퇴근하기";
	}

}
