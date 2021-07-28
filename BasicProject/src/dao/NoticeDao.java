package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Controller.Controller;
import service.MenuService;
import util.JDBCUtil;

public class NoticeDao {

	private NoticeDao(){}
	private static NoticeDao instance;
	public static NoticeDao getInstance(){
		if (instance == null){
			instance = new NoticeDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	public List<Map<String,Object>> SelectNoticeList(){
		String sql ="SELECT NOTICE_NO"
				+ " , NOTICE_TITLE"
				+ " FROM NOTICE";
		return jdbc.selectList(sql);
	}
	
	public List<Map<String ,Object>> selectNoticeContent(String num){
		String sql = "SELECT NOTICE_NO"
				+ " , NOTICE_TITLE"
				+ " , NOTICE_CONTENT"
				+ " FROM NOTICE"
				+ " WHERE NOTICE_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(num);
		return jdbc.selectList(sql, param);		
	}
	
	public int insertNoticeadmin(String title,String content){
		String sql = "INSERT INTO NOTICE(NOTICE_NO,NOTICE_TITLE,ADMIN_ID,NOTICE_CONTENT)"
				+ " VALUES ((SELECT NVL(MAX(TO_NUMBER(NOTICE_NO)), 0) + 1 FROM NOTICE), ?, ?, ?)";
		String adminId= Controller.LoginAdmin.get("ADMIN_ID").toString();	
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(adminId);
		param.add(content);	
		
		return jdbc.update(sql, param);
		
	}
	
}
