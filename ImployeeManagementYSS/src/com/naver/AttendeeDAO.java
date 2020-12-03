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
		// ����ϱ�
		// ���� ������
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
				System.out.println("��ٽð��� ��ϵǾ����ϴ�.");
			} catch (Exception e) {
				System.out.println("�̹� ���ó���Ǿ����ϴ�.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			loading.closeAll(null, pstmt, conn);
		}
	}

	public AttendeeDTO selectById(String id) {
		// ����ٱ�� id�� ���� ��ȸ�ϱ�
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
		// ����ϱ�
		// ���� ������
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
		// ��ٽð� üũ
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
		// ����� ����Ʈ üũ
		// ���� ������
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
		// ����� ���̺� ���ڵ� �ʱ�ȭ
		// ���� ������
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
		// ����ٱ�� ��ȸ
		// ���� ������
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
