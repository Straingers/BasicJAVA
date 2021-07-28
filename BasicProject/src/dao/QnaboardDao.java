package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Controller.Controller;
import service.MenuService;
import util.JDBCUtil;

public class QnaboardDao {
	private QnaboardDao(){}
	private static QnaboardDao instance;
	public static QnaboardDao getInstance(){
		if (instance == null){
			instance = new QnaboardDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	public List<Map<String ,Object>> qnaboardList(){
		String sql = "SELECT QNA_NO"
				+ " , QNA_TITLE"
				+ " , MEM_ID"
				+ " , QNA_DATE"
				+ " FROM QNABOARD"
				+ " WHERE MEM_ID = ?";
		
		String userId= Controller.LoginUser.get("MEM_ID").toString();
		List<Object> param = new ArrayList<>();
		param.add(userId);
		
		return jdbc.selectList(sql, param);	
	}

	public List<Map<String ,Object>> qnaboardadminList(){
		String sql = "SELECT QNA_NO"
				+ " , QNA_TITLE"
				+ " , MEM_ID"
				+ " , QNA_DATE"
				+ " FROM QNABOARD";
		
		return jdbc.selectList(sql);	
	}
	
	
	public int InsertQnaboard (String title , String content){
		String sql = "INSERT INTO QNABOARD(QNA_NO,QNA_TITLE,MEM_ID,QNA_CONTENT,QNA_DATE)"
				+ " VALUES ((SELECT NVL(MAX(TO_NUMBER(QNA_NO)), 0) + 1 FROM QNABOARD), ?, ?, ?, SYSDATE)";
		String userId=Controller.LoginUser.get("MEM_ID").toString();
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(userId);
		param.add(content);
		
		return jdbc.update(sql, param);
	}
	
	public List<Map<String ,Object>> SelectQnaBoardList(String num){
		String sql = "SELECT QNA_NO"
				+ " , QNA_TITLE"
				+ " , MEM_ID"
				+ " , QNA_CONTENT"
				+ " , QNA_DATE"
				+ " FROM QNABOARD"
				+ " WHERE MEM_ID = ?"
				+ " AND QNA_NO =?";

		String userId= Controller.LoginUser.get("MEM_ID").toString();
		List<Object> param = new ArrayList<>();
		param.add(userId);
		param.add(num);
		
		return jdbc.selectList(sql, param);
	}
	
	public List<Map<String ,Object>> SelectQnaBoardList2(String num){
		String sql = "SELECT QNA_NO"
				+ " , QNA_TITLE"
				+ " , MEM_ID"
				+ " , QNA_CONTENT"
				+ " , QNA_DATE"
				+ " FROM QNABOARD"
				+ " WHERE QNA_NO = ?";

		List<Object> param = new ArrayList<>();
		param.add(num);

		return jdbc.selectList(sql, param);
	}
	
	public int updateQnaBoardList(String content ,String num){
		String sql = "UPDATE QNABOARD"
				+ " SET QNA_CONTENT = ?"
				+ " WHERE QNA_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(content);
		param.add(num);
		
		return jdbc.update(sql, param);
	}
	
	public int updateQnaAdminBoard(String content ,String num){
		String sql = "UPDATE QNABOARD"
				+ " SET QNA_CONTENT = QNA_CONTENT || '\n(관리자 답변) : ' || ?"
				+ " , ADMIN_ID = ?"
				+ " WHERE QNA_NO = ?";
		String adminId= Controller.LoginAdmin.get("ADMIN_ID").toString();
		List<Object> param = new ArrayList<>();
		param.add(content);
		param.add(adminId);
		param.add(num);
		
		return jdbc.update(sql, param);
	}
	
	public int deleteQnaBoardList(String num){
		String sql = "DELETE FROM QNABOARD"
				+ " WHERE QNA_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(num);
		
		return jdbc.update(sql, param);
	}
		
}
