package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO {
	
	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "ezen";
	private final String PASSWORD = "ezen";
	
	public EmployeeDAO() {
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EmployeeDTO selectById(String id) {
		
		EmployeeDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM employee WHERE id = ?";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				String name = rs.getString("name");
				String position = rs.getString("position");
				
				dto = new EmployeeDTO(id, name, position);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			closeAll(null, pstmt, conn);
		}
		
		return dto;
	}
	
	public void insertEmployee(EmployeeDTO dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employee VALUES (?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPosition());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			closeAll(null, pstmt, conn);
			
		}
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		
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

}
