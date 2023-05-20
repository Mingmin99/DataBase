package com.day_0513.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.day_0513.util.JDBCutil;

public class Main5 {

	public static void main(String[] args) {

		// 1. Oracle JDBC 드라이버를 로드합니다.
		Connection conn = null;

		// 2. 데이터베이스에 연결합니다.
		try {
			// Oracle JDBC 드라이버 로드
			conn = JDBCutil.getConnection();
			// dbms 연결상태 확인
			if (conn != null) {
				System.out.println("DBMS와 연결되었습니다.");
			} else {
				System.out.println("DBMS와 연결되지 않았습니다.");
				return;
			}
			long startTime = System.currentTimeMillis();
			// 3. SQL 쿼리를 실행합니다.
			Statement stmt = conn.createStatement();
			int rowsAffected = stmt.executeUpdate("INSERT INTO BONUS\r\n" + "SELECT E.ENAME, E.JOB,E.SAL,\r\n"
					+ "                    CASE WHEN E.JOB IN ('ANALYST','PRESIDENT') THEN 0\r\n"
					+ "                         WHEN C.CUSCNT >= 100000 THEN NVL(E.COMM,0)+2000\r\n"
					+ "                         ELSE NVL(E.COMM,0)+1000\r\n" + "                    END AS COMM\r\n"
					+ "FROM EMP E\r\n" + "LEFT JOIN (SELECT MGR_EMPNO,COUNT(MGR_EMPNO) AS CUSCNT\r\n"
					+ "            FROM CUSTOMER\r\n" + "            GROUP BY MGR_EMPNO) C\r\n"
					+ "ON E.EMPNO=C.MGR_EMPNO");
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
			System.out.println(rowsAffected + " rows affected.");
			System.out.println("실행 시간 : " + elapsedTime + "ms");

		} catch (SQLException e) {
			// 데이터베이스 연결 및 쿼리 실행 중 예외가 발생한 경우 처리합니다.
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// 연결 닫기 중 예외가 발생한 경우 처리합니다.
				e.printStackTrace();
			}
		}
	}

}