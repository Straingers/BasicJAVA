package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Controller.Controller;
import util.JDBCUtil;

public class UserDao {
	private UserDao(){}
	private static UserDao instance;
	public static UserDao getInstance(){
		if (instance == null){
			instance = new UserDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int insertUser(Map<String, Object> param){
		String sql = " INSERT INTO MEMBER(MEM_ID, MEM_PW, MEM_NAME, MEM_PASSPORT, MEM_ADD, MEM_HP, MEM_MONEY, MEM_MILEAGE)"
				+ " VALUES (?, ?, ?, ?, ?, ?, 0, 0)";
		List<Object> p = new ArrayList<>();
		p.add(param.get("MEM_ID"));
		p.add(param.get("MEM_PW"));
		p.add(param.get("MEM_NAME"));
		p.add(param.get("MEM_PASSPORT"));
		p.add(param.get("MEM_ADD"));
		p.add(param.get("MEM_HP"));
		
		return jdbc.update(sql, p);
	}
	
	public Map<String, Object> memberSelect(String mem_id, String mem_pw){
		String sql = "SELECT MEM_ID, MEM_PW "
				+ " FROM MEMBER"
				+ " WHERE MEM_ID = ? AND MEM_PW = ?";
		List<Object> p = new ArrayList<>();
		p.add(mem_id);
		p.add(mem_pw);
		
		return jdbc.selectOne(sql, p);
	}
	
	public int updateMemInfo (String memname, String mempw, String passport, String add, String hp){
		String sql = "UPDATE MEMBER"
				+ " SET MEM_NAME = ?"
				+ " , MEM_PW = ?"
				+ " , MEM_PASSPORT = ?"
				+ " , MEM_ADD = ?"
				+ " , MEM_HP = ?"
				+ " WHERE MEM_ID = ?";
		String userId= Controller.LoginUser.get("MEM_ID").toString();
		List<Object> param = new ArrayList<>();
		param.add(memname);	
		param.add(mempw);	
		param.add(passport);	
		param.add(add);	
		param.add(hp);	
		param.add(userId);	

		return jdbc.update(sql, param);
	}
	
	public int updateMemMoney (int mon){
		String sql = "UPDATE MEMBER"
				+ " SET MEM_MONEY = MEM_MONEY + ?"
				+ " WHERE MEM_ID = ?";
		String userId= Controller.LoginUser.get("MEM_ID").toString();
		List<Object> param = new ArrayList<>();
		param.add(mon);
		param.add(userId);	

		return jdbc.update(sql, param);	
	}
	
	public int deleteMeminfo(Object userPw) {

		String sql = "DELETE FROM MEMBER" + " WHERE MEM_ID = ? "
				+ " AND MEM_PW = ?";

		String userId = Controller.LoginUser.get("MEM_ID").toString();
		List<Object> param = new ArrayList<>();
		param.add(userId);
		param.add(userPw);

		return jdbc.update(sql, param);
	}

	public Map<String, Object> passwordCheck() {
		String sql = "SELECT MEM_PW FROM MEMBER WHERE MEM_ID = ?";

		String userId = Controller.LoginUser.get("MEM_ID").toString();
		List<Object> param = new ArrayList<>();
		param.add(userId);

		return jdbc.selectOne(sql, param);

	}
	
	public List<Map<String ,Object>> AdminMemberList(){
		String sql= "SELECT *"
				+ " FROM MEMBER";
		
		return jdbc.selectList(sql);
	}
	
	public int AdminMemberDelete (Object id){
		String sql1 = "DELETE FROM RESERVATION "
				+ " WHERE MEM_ID = ?";	
		String sql2 = "DELETE FROM BAGPACK "
				+ " WHERE MEM_ID = ?";	
		String sql3 = "DELETE FROM MEMBER "
				+ " WHERE MEM_ID = ?";	
		List<Object> param = new ArrayList<>();
		param.add(id);
		
		jdbc.update(sql1, param);
		jdbc.update(sql2, param);
		
		return jdbc.update(sql3, param);
	}
	
	public List<Map<String,Object>> AdminReservationList(){
		String sql = "SELECT * "
				+ " FROM RESERVATION";
		
		return jdbc.selectList(sql);
	}
	
	public int AdminReservaionDelete(Object resno) {
		String sql = "DELETE FROM RESERVATION" 
		          + " WHERE RES_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(resno);

		return jdbc.update(sql, param);
	}
	
}
