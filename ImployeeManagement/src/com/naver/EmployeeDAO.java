package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	private final String DRIVERNAME_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "ezen";
	private final String USER_PASSWORD = "ezen";
	
	
	public EmployeeDAO() {
		try {
			Class.forName(DRIVERNAME_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(EmployeeDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into employee values (?,?,?)";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPosition());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
	}
	
	public List<EmployeeDTO> select() {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select *from employee";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String position = rs.getString("position");
				EmployeeDTO dto = new EmployeeDTO(id, name, position);
				list.add(dto);
						
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public EmployeeDTO selectById(String id) {
		EmployeeDTO dto = null; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select *from employee where id = ?";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
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
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		
		return dto;
	}
	
	public void update(EmployeeDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update Employee set name = ?, position = ? where id = ?";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
			pstmt  = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPosition());
			pstmt.setString(3, dto.getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	
			closeAll(null, pstmt, conn);
		}
				
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
	
	public void delete(EmployeeDTO dto) {
		// 출근정보 삭제 후 사원정보 삭제 (테이블 상속관계 때문에 이렇게 처리함)
		// 실행 검증됨
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM attendee WHERE id = ?";
		String sql2 = "DELETE FROM employee WHERE id = ?";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.executeUpdate();
			
			if (pstmt != null) {
				pstmt.close();
			}
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, dto.getId());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}
	
}
