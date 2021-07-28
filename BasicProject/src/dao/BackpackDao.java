package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Controller.Controller;
import util.JDBCUtil;

public class BackpackDao {
	private BackpackDao(){}
	private static BackpackDao instance;
	public static BackpackDao getInstance(){
		if(instance == null){
			instance = new BackpackDao();
		}
		return instance;	
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int backpackInsert(Object resNo, Object bagKg, Object bagCost){
		String userId = Controller.LoginUser.get("MEM_ID").toString();
		String sql = " INSERT INTO BAGPACK(BAG_NO, MEM_ID, RES_NO, BAG_KG, BAG_COST)"
				+ " VALUES ((SELECT NVL(MAX(TO_NUMBER(BAG_NO)), 0) + 1 FROM BAGPACK), ?, ?, ?, ?)";
		List<Object> p = new ArrayList<>();
		p.add(userId);
		p.add(resNo);
		p.add(bagKg);
		p.add(bagCost);
		
		return jdbc.update(sql, p); 
	}
	
	public int DeleteMemBagpack(Object resno){
		String sql = "DELETE FROM BAGPACK"
				+ " WHERE MEM_ID=?"
				+ " and res_no = ?";
		String memId = Controller.LoginUser.get("MEM_ID").toString();			
		List<Object> param = new ArrayList<>();
		param.add(memId);
		param.add(resno);
		
		return jdbc.update(sql, param);
		
	}
	
	public Map<String , Object > selectBagPack(Object resno){
		String sql = "SELECT BAG_COST"
				+ " FROM BAGPACK"
				+ " WHERE MEM_ID=?"
				+ " AND RES_NO=?";
		String memId = Controller.LoginUser.get("MEM_ID").toString();			
		List<Object> param = new ArrayList<>();
		param.add(memId);
		param.add(resno);
		return jdbc.selectOne(sql, param);
	}
	
}
