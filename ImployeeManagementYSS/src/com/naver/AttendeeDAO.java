package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AttendeeDAO {

	DefaltLoading loading = new DefaltLoading();
	
	public void intime(AttendeeDTO dto) {
		// 출근하기
		// 실행 검증됨
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO attendee (id, name, intime) VALUES (?, ?, ?)";

		try {
			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getIntime());

			try {
				pstmt.execute();
				System.out.println("출근시간이 등록되었습니다.");
			} catch (Exception e) {
				System.out.println("이미 출근처리되었습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			loading.closeAll(null, pstmt, conn);
		}
	}

	public AttendeeDTO selectById(String id) {
		// 출퇴근기록 id로 정보 조회하기
		AttendeeDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM attendee WHERE id = ? ";
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				String name = rs.getString("name");
				String intime = rs.getString("intime");
				String exittime = rs.getString("exittime");

				dto = new AttendeeDTO(id, name, intime, exittime);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			loading.closeAll(rs, pstmt, conn);
		}

		return dto;
	}
	
	public void exittime(AttendeeDTO dto) {
		// 퇴근하기
		// 실행 검증됨
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "UPDATE attendee SET exittime = ?  WHERE id = ?";

		try {
			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getExittime());
			pstmt.setString(2, dto.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			loading.closeAll(rs, pstmt, conn);
		}

	}

	public AttendeeDTO intimeCheck(String id) {
		// 출근시간 체크
		AttendeeDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT intime FROM attendee WHERE id = ?";

		try {

			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String intime = rs.getString("intime");
				dto = new AttendeeDTO(id, name, intime, null);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			loading.closeAll(rs, pstmt, conn);
		}

		return dto;

	}

	public List<AttendeeDTO> attendeeCheck() {
		// 출퇴근 리스트 체크
		// 실행 검증됨
		List<AttendeeDTO> list = new ArrayList<AttendeeDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM attendee";

		try {
			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String intime = rs.getString("intime");
				String exittime = rs.getString("exittime");
				AttendeeDTO dto = new AttendeeDTO(id, name, intime, exittime);
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			loading.closeAll(rs, pstmt, conn);
		}

		return list;

	}

	public void deleteAttendee() {
		// 출근자 테이블 레코드 초기화
		// 실행 검증됨
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "TRUNCATE TABLE attendee";

		try {
			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
			pstmt = conn.prepareStatement(sql);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			loading.closeAll(null, pstmt, conn);
		}
	}

	public List<AttendeeDTO> checkAttendee() {
		// 출퇴근기록 조회
		// 실행 검증됨
		List<AttendeeDTO> list = new ArrayList<AttendeeDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM attendee";
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String intime = rs.getString("intime");
				String exittime = rs.getString("exittime");

				AttendeeDTO dto = new AttendeeDTO(id, name, intime, exittime);
				list.add(dto);
				System.out.println(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			loading.closeAll(rs, pstmt, conn);
		}

		return list;
	}

}
