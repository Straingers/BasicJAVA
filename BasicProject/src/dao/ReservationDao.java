package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import Controller.Controller;

public class ReservationDao {
	private ReservationDao(){}
	private static ReservationDao instance;
	public static ReservationDao getInstance(){
		if(instance == null){
			instance = new ReservationDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int insertReservatioin(Object flightCode, Object resCost){
		
		String userId = Controller.LoginUser.get("MEM_ID").toString();
		
		String sql = "INSERT INTO RESERVATION(RES_NO, FLIGHT_CODE, MEM_ID, RES_COST)"
				+ " VALUES ((SELECT NVL(MAX(TO_NUMBER(RES_NO)), 0) + 1 FROM RESERVATION), ?, ?, ?)";
		List<Object> param = new ArrayList<>();
		param.add(flightCode);
		param.add(userId);
		param.add(resCost);
		
		return jdbc.update(sql, param);
	}
	
	public Map<String, Object> resMoneyCheck(){
		String sql = "SELECT A.RES_NO"
				+ " , A.RES_COST"
				+ " FROM RESERVATION A, FLIGHT B"
				+ " WHERE A.FLIGHT_CODE = B.FLIGHT_CODE"
				+ " AND A.MEM_ID = ?";
		String userId = Controller.LoginUser.get("MEM_ID").toString();
		List<Object> param = new ArrayList<>();
		param.add(userId);
		return jdbc.selectOne(sql, param);
	}
	
	public int insertResMoney(int money, Object resNo){
		String memId = Controller.LoginUser.get("MEM_ID").toString();
		String sql = "UPDATE RESERVATION"
				+ " SET RES_COST = RES_COST + ?"
				+ " WHERE MEM_ID = ?"
				+ " AND RES_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(money);
		param.add(memId);
		param.add(resNo);
		
		return jdbc.update(sql, param);
	}
	
	public Map<String, Object> moneyCheck(){
		String sql = " SELECT MEM_MONEY "
				+ " FROM MEMBER"
				+ " WHERE MEM_ID = ?";
		String memId = Controller.LoginUser.get("MEM_ID").toString();
		List<Object> param = new ArrayList<>();
		param.add(memId);
		
		return jdbc.selectOne(sql, param);
	}
	
	public int moneyDelete(Object object){
		String sql = "UPDATE MEMBER"
				+ " SET MEM_MONEY = MEM_MONEY - ?"
				+ " WHERE MEM_ID = ?";
		String memId = Controller.LoginUser.get("MEM_ID").toString();
		List<Object> param = new ArrayList<>();
		param.add(object);
		param.add(memId);
		
		return jdbc.update(sql, param);
	}
	
	public int moneyreturn(Object object){
		String sql = "UPDATE MEMBER"
				+ " SET MEM_MONEY = MEM_MONEY + ?"
				+ " WHERE MEM_ID = ?";
		String memId = Controller.LoginUser.get("MEM_ID").toString();
		List<Object> param = new ArrayList<>();
		param.add(object);
		param.add(memId);
		
		return jdbc.update(sql, param);
	}
	
	public int getMemMileage(Object mileage){
		String sql = "UPDATE MEMBER"
				+ " SET MEM_MILEAGE = MEM_MILEAGE + ?"
				+ " WHERE MEM_ID = ?";
		String memId = Controller.LoginUser.get("MEM_ID").toString();	
		List<Object> param = new ArrayList<>();
		param.add(mileage);
		param.add(memId);
		
		return jdbc.update(sql, param);
	}

	public int outMemMileage(Object mileage){
		String sql = "UPDATE MEMBER"
				+ " SET MEM_MILEAGE = MEM_MILEAGE - ?"
				+ " WHERE MEM_ID = ?";
		String memId = Controller.LoginUser.get("MEM_ID").toString();	
		List<Object> param = new ArrayList<>();
		param.add(mileage);
		param.add(memId);
		
		return jdbc.update(sql, param);
	}
	
	public int DeleteMemReservation(Object resno){
		String sql="DELETE FROM RESERVATION"
				+ " WHERE MEM_ID = ?"
				+ " AND RES_NO=?";
		String memId = Controller.LoginUser.get("MEM_ID").toString();			
		List<Object> param = new ArrayList<>();
		param.add(memId);
		param.add(resno);
		
	return jdbc.update(sql, param);
	}
	
	public Map<String ,Object> getBagpackMoney(Object resno){
		
		String sql = "SELECT BAG_COST"
				+ " FROM BAGPACK"
				+ " WHERE RES_NO=?"
				+ " AND MEM_ID = ?";
		String memId = Controller.LoginUser.get("MEM_ID").toString();
		List<Object> param = new ArrayList<>();
		param.add(resno);
		param.add(memId);
		
		return jdbc.selectOne(sql, param);
	}
	
}
