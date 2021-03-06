package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	
	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "ezen";
	private final String PASSWORD = "ezen";
	
	public EmployeeDAO() {
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			
			System.out.println("드라이버 연결에 실패하였습니다.");
		}
	}
	
	public void delete(EmployeeDTO dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM attendee WHERE id = ?";
		String sql2 = "DELETE FROM employee WHERE id = ?";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME,PASSWORD);
			
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
			System.out.println("사원 삭제가 제대로 실행되지 않았습니다. ");
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}
	
	public List<EmployeeDTO> select() {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id 사원번호, name 이름, position 직급 from employee ORDER BY position ASC, id ASC";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			System.out.println("====================[사원 리스트]====================");
			while (rs.next()) {
				String id = rs.getString("사원번호");
				String name = rs.getString("이름");
				String position = rs.getString("직급");
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
	
	public void update(EmployeeDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update Employee set name = ?, position = ? where id = ?";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt  = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPosition());
			pstmt.setString(3, dto.getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("등록되지 않은 사원 ID입니다.");
			System.out.println("다시 한 번 확인 해 주세요.");
		}finally {
	
			closeAll(null, pstmt, conn);
		}
				
	}
	
	public List<EmployeeDTO> selectByName(String name) {
		
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM employee WHERE name = ? ORDER BY id ASC";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String id = rs.getString("id");
				String position = rs.getString("position");
				
				EmployeeDTO dto = new EmployeeDTO(id, name, position);
				list.add(dto);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			closeAll(rs, pstmt, conn);
		}

		return list;
		
	}
	
	public EmployeeDTO selectById(String id) {
		
		EmployeeDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM employee WHERE id = ? ";
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
			System.out.println("등록되지 않은 사원 ID입니다.");
			System.out.println("다시 한 번 확인 해 주세요.");
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
			System.out.println("사원 등록이 완료되었습니다.");
			
		} catch (Exception e) {
			System.out.println("중복된 ID이거나 사용할 수 없는 ID입니다.");
			System.out.println("다시 한 번 확인해주세요.");
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
			System.out.println("메모리가 해제되지 않았습니다.");
		}
	}

}
