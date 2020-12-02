package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	DefaltLoading loading = new DefaltLoading();

	public void insert(EmployeeDTO dto) {
		// 사원등록
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employee2 VALUES (?, ?, ?)";

		try {
			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPosition());

			try {
				pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("이미 중복된 ID입니다. 처음부터 다시 시도하여 주십시오.");
				System.out.println();
				return;
			}
			System.out.println("사원 등록이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			loading.closeAll(null, pstmt, conn);
		}

	}

	public List<EmployeeDTO> select() {
		// 사원 리스트 조회
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM employee2";

		try {
			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
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
		} finally {
			loading.closeAll(rs, pstmt, conn);
		}

		return list;
	}

	public EmployeeDTO selectById(String id) {
		// 사원id로 사원정보 조회
		EmployeeDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM employee2 WHERE id = ?";

		try {
			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
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
			loading.closeAll(rs, pstmt, conn);
		}

		return dto;
	}

	public void update(EmployeeDTO dto) {
		// 사원정보 수정
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE employee2 SET name = ?, position = ? WHERE id = ?";

		try {
			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPosition());
			pstmt.setString(3, dto.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			loading.closeAll(null, pstmt, conn);
		}

	}

	public void delete(EmployeeDTO dto) {
		// 출근정보 삭제 후 사원정보 삭제 (테이블 상속관계 때문에 이렇게 처리함)
		// 실행 검증됨
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM attendee WHERE id = ?";
		String sql2 = "DELETE FROM employee2 WHERE id = ?";

		try {
			conn = DriverManager.getConnection(loading.URL, loading.USER_NAME, loading.PASSWORD);
			conn.setAutoCommit(false);

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

}
