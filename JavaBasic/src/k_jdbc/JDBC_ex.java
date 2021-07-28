package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC_ex {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "pc15";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
	    try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO DAWICE2(DW_ACTINFO, DW_ACTYEAR, DW_MEMBER) VALUES('KRIS2', 2017, '크리스2')";
			
			ps = con.prepareStatement(sql);
			
//			rs = ps.executeQuery();
			
			int result = ps.executeUpdate();
			System.out.println(result + "개 행이 삽입되었습니다.");
			
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();
			
			while(rs.next()){
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(md.getCatalogName(i) + " : ");
					System.out.print(rs.getObject(i) + "\t");
				}
				System.out.println();
			}
						 
	    } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
	}

}
