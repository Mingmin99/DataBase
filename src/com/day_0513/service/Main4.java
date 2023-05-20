//package com.day_0513.service;
//
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import com.day_0513.util.JDBCutil;
//
//public class Main4  {
//	public static void main(String[] args) {
//		Connection conn = null;
//		CallableStatement cstmt = null;
//
//		try {
//			// Oracle JDBC 드라이버 로드
//			conn = JDBCutil.getConnection();
//
//			// dbms 연결상태 확인
//			if (conn != null) {
//				System.out.println("DBMS와 연결되었습니다.");
//			} else {
//				System.out.println("DBMS와 연결되지 않았습니다.");
//				return;
//			}
//
//			// PL/SQL 코드 실행
//			// 프로시저 호출을 위한 CallableStatement 준비
//			cstmt = conn.prepareCall("{call CALCULATE_BONUS2}");
//			// 프로시저 실행
//			cstmt.execute();
//
//			System.out.println("프로시저 실행이 완료되었습니다.");
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			// 자원 해제
//			JDBCutil.closeConnection(conn);
//			JDBCutil.closeStatement(cstmt);
//		}
//	}
//}
