package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AttendeeDAO {

	private final String DRIVERNAME_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "ezen";
	private final String USER_PASSWORD = "ezen";
	
	
	public AttendeeDAO() {
		try {
			Class.forName(DRIVERNAME_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void intime(AttendeeDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO attendee (id, name, intime) VALUES (?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getIntime());
			
			pstmt.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			closeAll(null, pstmt, conn);
		}
	}
	
	public void exittime(AttendeeDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update attendee set exittime = ?  where id = ?";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getExittime());
			pstmt.setString(2, dto.getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
	}
	
	public AttendeeDTO intimeCheck(String id) {
		AttendeeDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select intime from attendee where id = ?";
		
		try {
			
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
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
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return dto;
		
	}
	
	public List<AttendeeDTO> attendeeCheck() {
		List<AttendeeDTO> list = new ArrayList<AttendeeDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select *from attendee";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
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
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return list;
		
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt , Connection conn) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public void deleteAttendee() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "TRUNCATE TABLE attendee";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			closeAll(null, pstmt, conn);
		}
	}
public List<AttendeeDTO> checkAttendee() {
	// 출근자정보 전체확인
	// 실행 검증됨
	List<AttendeeDTO> list = new ArrayList<AttendeeDTO>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "SELECT * FROM attendee";
	ResultSet rs = null;
	
	try {
		conn = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
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
		closeAll(rs, pstmt, conn);
	}
	
	
	return list;
}



	
}
