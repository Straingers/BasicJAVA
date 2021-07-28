package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	public static void main(String[] args) {
/*
 * JDBC(Java Database Connectivity)
 * - 자바와 데이터베이스를 연결해주는 라이브러리
 * - ojdbc : 오라클 JDBC
 * 
 * JDBC 작성단계
 * 1. Connection 생성(DB 연결)
 * 2. Statement 생성(쿼리 작성)
 * 3. Query 실행
 * 4. ResultSet에서 결과 추출(select인 경우)
 * 5. ResultSet, Statement, Connection 닫기
 */
		
		//데이터베이스 접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "pc15";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//DriverManager : 데이터베이스에 접속하기 위한 드라이버를 관리해주는 클래스
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT * FROM MEMBER";
			ps = con.prepareStatement(sql); //statement 생성
			
			//select 일때 쓰는 메서드
			rs = ps.executeQuery();
			
			//insert, update, delete 일때 쓰는 메서드
//			int result = ps.executeUpdate();  //몇개의 row가 영향을 받았는지 반환해준다.
			
			while(rs.next()){
				System.out.println(rs.getString(1));
				System.out.println(rs.getString("MEM_NAME"));
				
				//컬럼에 맞는 타입의 데이터를 불러와야한다.
//				rs.getInt(1);
//				rs.getDate(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//열어준 순서의 역순으로 닫아준다.
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
	}
	
}









