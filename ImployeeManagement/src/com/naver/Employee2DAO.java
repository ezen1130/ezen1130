package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 사원등록, 사원리스트 전체조회 2가지 기능이 구현된 DAO클래스입니다.

public class Employee2DAO {
	
	DefaltLoading loading = new DefaltLoading();

	
	public void delete(Employee2DTO dto) {
		// 출근정보 삭제 후 사원정보 삭제 (테이블 상속관계 때문에 이렇게 처리함)
		// 실행 검증됨
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM attendee WHERE id = ?";
		String sql2 = "DELETE FROM employee2 WHERE id = ?";
		
		try {
			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
			
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
			loading.closeAll(null, pstmt, conn);
		}
		
	}
	
	public List<Employee2DTO> listEmployee() {
		// 사원리스트 전체조회
		// 실행 검증됨
		List<Employee2DTO> list = new ArrayList<Employee2DTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT id 사원번호, name 이름, position 직급 FROM employee2";
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			System.out.println("================[사원 리스트]================");
			while (rs.next()) {
				String id = rs.getString("사원번호");
				String name = rs.getString("이름");
				String position = rs.getString("직급");

				Employee2DTO dto = new Employee2DTO(id, name, position);
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

	public void addemployee(Employee2DTO dto) {
		// 사원정보 등록
		// 실행 검증됨
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employee2 VALUES (?, ?, ?)";

		try {
			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPosition());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			loading.closeAll(null, pstmt, conn);
		}
	}

}
