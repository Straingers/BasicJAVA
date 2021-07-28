package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Controller.Controller;
import util.JDBCUtil;

public class AdminDao {
	private AdminDao(){}
	private static AdminDao instance;
	public static AdminDao getInstance(){
		if (instance == null){
			instance = new AdminDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int insertAdmin(Map<String, Object> param) {
		String sql = "INSERT INTO ADMIN(ADMIN_ID, ADMIN_PW)"
				+ " VALUES(?, ?)";
		List<Object> p = new ArrayList<>();
		p.add(param.get("ADMIN_ID"));
		p.add(param.get("ADMIN_PW"));
		
		return jdbc.update(sql, p);
	}
	
	public Map<String, Object> adminSelect(String admin_id, String admin_pw){
		String sql = "SELECT ADMIN_ID, ADMIN_PW"
				+ " FROM ADMIN"
				+ " WHERE ADMIN_ID = ? "
				+ " AND ADMIN_PW = ?";
		List<Object> p = new ArrayList<>();
		p.add(admin_id);
		p.add(admin_pw);
		
		return jdbc.selectOne(sql, p);
	}
	
	public Map<String , Object> adminInfo(){
		String sql = " SELECT ADMIN_ID"
				+ " ,ADMIN_PW"
				+ " FROM ADMIN"
				+ " WHERE ADMIN_ID = ?";
		String adminId= Controller.LoginAdmin.get("ADMIN_ID").toString();
		List<Object> p = new ArrayList<>();
		p.add(adminId);
		
		return jdbc.selectOne(sql, p);
	}

	public int updateAdminInfo(String adminpw){
		String sql = "UPDATE ADMIN"
				+ " SET ADMIN_PW = ?"
				+ "WHERE ADMIN_ID = ?";
		String adminId= Controller.LoginAdmin.get("ADMIN_ID").toString();		
		List<Object> param = new ArrayList<>();
		param.add(adminpw);
		param.add(adminId);

		return jdbc.update(sql, param);
	}
	
	public int DeleteAdminInfo(){
		
		String sql = "delete from admin "
				+ " where admin_id = ?";
		String adminId=Controller.LoginAdmin.get("ADMIN_ID").toString();
		List<Object> param =new ArrayList<>();
		param.add(adminId);
		
		return jdbc.update(sql, param);
	}
	
	
	
	
	
}





