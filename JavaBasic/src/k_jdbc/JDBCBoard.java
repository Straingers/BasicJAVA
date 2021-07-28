package k_jdbc;

import j_collection.Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import e_oop.ScanUtil;

public class JDBCBoard {
	
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String USER = "pc15";
	private final static String PASSWORD = "java";

	public static void main(String[] args) {
/*
 * 오라클 데이터베이스에서 게시판 테이블을 생성하고, 게시판 프로그램을 만들어주세요.
 * 테이블 : TB_JDBC_BOARD
 * 컬럼  : BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE
 * 
 * 1. 게시판 List
 * 2. 게시판 등록
 * 3. 게시판 상세보기
 * 4. 게시판 수정
 * 5. 게시판 삭제
 * 
 * JDBC순서
 * 1. url, user, password -> DB에 접근할 모든 곳에 공통 => 어떻게 빼놓으면 좋을까요?
 * 2. DB접속 => Connection 객체
 * 	  - url => ip, port, sid
 * 3. Query생성
 * 4. 질의 => PreparedStatement
 * 5. 결과 저장 => ResultSet
 * 6. 자원 반납 close()
 */
		ArrayList<ResultSet> boardList = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "SELECT * FROM TB_JDBC_BOARD";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			ResultSetMetaData md = rs.getMetaData();
			
			int columnCount = md.getColumnCount();
			
			while(true){
				System.out.println("-----------------------------------");
				System.out.println("번호\t제목\t작성자\t작성일");
				System.out.println("-----------------------------------");
				while(rs.next()){
					for (int i = 1; i <= columnCount; i++) {
						if(i != 2 && i != 5){
							Object value = rs.getObject(i);
							System.out.print(value + "\t");
						} if (i == 5){
							System.out.print(sdf.format(rs.getObject(5)));
						}
					}
					System.out.println();
				}
				System.out.println("-----------------------------------");
				System.out.println("1.조회\t2.등록\t0.종료");
				System.out.print("입력 : ");
				int input = ScanUtil.nextInt();
				
				switch (input) {
					case 1:
						read(boardList);
						break;
					case 2:
						insert(boardList);
						break;
					case 0:
						System.out.println("프로그램이 종료되었습니다.");
						System.exit(0);
						break;
					default:
						System.out.println("잘못된 입력입니다.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
	}
	
	//조회
	private static void read(ArrayList<ResultSet> boardList) {
		System.out.print("게시글 번호 입력 : ");
		int board_no = ScanUtil.nextInt();
		
		String sql = "SELECT * FROM TB_JDBC_BOARD";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ResultSetMetaData md = rs.getMetaData();

			int columnCount = md.getColumnCount();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//등록
	private static void insert(ArrayList<ResultSet> boardList) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "INSERT INTO TB_JDBC_BOARD(BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE) VALUES(?, ?, ?, ?, sysdate)";
			
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(sql);
			
			System.out.print("번호 : ");
			int boardNo = ScanUtil.nextInt();
			System.out.print("제목 : ");
			String title = ScanUtil.nextLine();
			System.out.print("내용 : ");
			String content = ScanUtil.nextLine();
			System.out.print("작성자 : ");
			String user = ScanUtil.nextLine();
			
			ps.setInt(1, boardNo);
			ps.setString(2, title);
			ps.setString(3, content);
			ps.setString(4, user);
			
			rs = ps.executeQuery();
			
			con.commit();
			
			System.out.println("등록이 완료되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
	
	}

	

}









