package com.naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DefaltLoading {

	// 중복되는 변수 클래스에 담아서 friendly처리 (같은 패키지 내에서만 사용가능)
	String DRIVER = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER_NAME = "ezen";
	String PASSWORD = "ezen";

	public DefaltLoading() {
		// 드라이버 로딩
		// 실행 검증됨
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}

	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		// 중복되는 close메서드 처리
		// 실행 검증됨
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
