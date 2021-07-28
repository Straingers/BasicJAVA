package k_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCUtilTest {

	public static void main(String[] args) {
		
		JDBCUtil jdbc = JDBCUtil.getInstance();
		
		String sql = "SELECT * FROM MEMBER WHERE MEM_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add("a001");
		
		Map<String, Object> row = jdbc.selectOne(sql, param);
		System.out.println(row);
		
		
		String sql2 = "SELECT * FROM CART WHERE CART_MEMBER = ?";
		List<Object> param2 = new ArrayList<>();
		param2.add("a001");
		
		List<Map<String,Object>> list = jdbc.selectList(sql2, param2);
		System.out.println(list);
		
		
		String sql3 = "INSERT INTO TB_JDBC_BOARD VALUES("
				+ "(SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TB_JDBC_BOARD)"
//				+ "TESTSEQ_SEQ.NEXTVAL" //시퀀스를 사용하는 경우
				+ ", ?, ?, ?, SYSDATE)";
		List<Object> param3 = new ArrayList<>();
		param3.add("제목입니다");
		param3.add("내용입니다");
		param3.add("a001");
		
		int result = jdbc.update(sql3, param3);
		System.out.println(result + "행이 영향을 받았습니다.");
		
		
	}

}





