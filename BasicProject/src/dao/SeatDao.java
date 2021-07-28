package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Controller.Controller;
import util.JDBCUtil;

public class SeatDao {
	private SeatDao(){}
	private static SeatDao instance;
	public static SeatDao getInstance(){
		if(instance == null){
			instance = new SeatDao();
		}
		return instance;
	}
	
	private JDBCUtil  jdbc = JDBCUtil.getInstance();
	
	public List< Map<String,Object>> selectSeatList(Object flight_code, Object check){ 
		String sql = "SELECT A.SEAT_REAL"
				+ " ,C.PLANE_CODE 비행기"
				+ " FROM SEAT A LEFT OUTER JOIN AIRLINE B ON (A.PLANE_CODE = B.PLANE_CODE)"
				+ " LEFT OUTER JOIN FLIGHT C ON(B.PLANE_CODE = C.PLANE_CODE)"
				+ " WHERE C.FLIGHT_CODE = ?"
				+ " AND A.SEAT_REAL LIKE  ? || '%'" ;
		List<Object> param = new ArrayList<>();
		param.add(flight_code);
		param.add(check);
		return jdbc.selectList(sql, param);
	}	

	public int InsertSeatList(Object seat_num, Object flight_code){
		String sql = " INSERT INTO RES_SEAT(RES_SEAT_CODE, SEAT_NUM, RES_NO)"
	            + " VALUES((SELECT NVL(MAX(TO_NUMBER(RES_SEAT_CODE)), 0) + 1 FROM RES_SEAT),"
	            + " (SELECT A.SEAT_NUM FROM SEAT A LEFT OUTER JOIN AIRLINE B ON (A.PLANE_CODE = B.PLANE_CODE)"
	            + "  LEFT OUTER JOIN FLIGHT C ON(B.PLANE_CODE = C.PLANE_CODE) "
	            + " WHERE A.SEAT_REAL = ?"
	            + " AND C.FLIGHT_CODE = ?),"
	            + " (SELECT MAX(A.RES_NO) FROM RESERVATION A WHERE A.MEM_ID = ?))";
		String memId = Controller.LoginUser.get("MEM_ID").toString();
		List<Object> param = new ArrayList<>();
		param.add(seat_num);
		param.add(flight_code);
		param.add(memId);
		
		return jdbc.update(sql, param);
	}
	
	public Map<String, Object> resseatSelect(Object SEAT_NUM){
		String sql = "SELECT RES_NO"
				+ " FROM RES_SEAT"
				+ " WHERE SEAT_NUM = ?";
		List<Object> param = new ArrayList<>();
		param.add(SEAT_NUM);
		return jdbc.selectOne(sql, param);
	}
	
	public int DeleteMemResseat(Object resno){
		String sql= "DELETE FROM RES_SEAT"
				+ " WHERE RES_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(resno);
		return jdbc.update(sql, param);
	}
	
	public Map<String, Object> resCheck(Object seatReal){
		String sql = "SELECT A.SEAT_REAL"
				+ " FROM   SEAT A, RES_SEAT B "
				+ " WHERE  A.SEAT_NUM = B.SEAT_NUM"
				+ " AND    A.SEAT_REAL = ?";
		List<Object> param = new ArrayList<>();
		param.add(seatReal);
		
		return jdbc.selectOne(sql, param);
	}
	
	public List<Map<String,Object>> reseatcheck(Object planecode, String seat){
		
		String sql= "SELECT A.SEAT_NUM"
				+ " , A.SEAT_REAL"
				+ " , NVL(B.RES_SEAT_CODE,0) 확인"
				+ " FROM SEAT A LEFT OUTER JOIN RES_SEAT B ON (A.SEAT_NUM = B.SEAT_NUM )"
				+ " LEFT OUTER JOIN RESERVATION C ON(B.RES_NO = C.RES_NO)"
				+ " WHERE A.PLANE_CODE = ?"
				+ " AND SEAT_REAL LIKE  ? ||'%'"
				+ " ORDER BY 1";
		
		List<Object> param = new ArrayList<>();
		param.add(planecode);
		param.add(seat);
		
		return jdbc.selectList(sql, param);
		
	}
	
}

