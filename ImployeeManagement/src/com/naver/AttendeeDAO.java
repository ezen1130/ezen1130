package com.naver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// ����ϱ�, ����ϱ�, �����Ȯ�� 3���� ����� ������ DAO�Դϴ�.

public class AttendeeDAO {
	
	DefaltLoading loading = new DefaltLoading();
	
	
	public List<AttendeeDTO> checkAttendee() {
		// ��������� ��üȮ��
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
				Date intime = rs.getDate("intime");
				Date exittime = rs.getDate("exittime");
				
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
	
	public void exitWork(AttendeeDTO dto) {
		// ����ϱ�
		// ���� �������� ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE attendee SET exittime = ? WHERE id = ?";
		
		try {
			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDate(1, dto.getExittme());
			pstmt.setString(2, dto.getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			loading.closeAll(null, pstmt, conn);
		}
	}
	
	public void inWork(AttendeeDTO dto) {
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
			pstmt.setDate(3, dto.getIntime());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			loading.closeAll(null, pstmt, conn);
		}
	}

}
