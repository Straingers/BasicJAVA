package service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.ScanUtil;
import util.View;
import Controller.Controller;
import dao.AdminDao;

public class AdminSerivce {
	private AdminSerivce(){}
	private static AdminSerivce instance;
	public static AdminSerivce getInstance(){
		if (instance == null){
			instance = new AdminSerivce();
		}
		return instance;
	}
	
	private AdminDao adminDao = AdminDao.getInstance();
	
	public int adminLogin(){
		System.out.println("=============== 관리자 로그인 ===============");
		System.out.print("ID > ");
		String admin_id = ScanUtil.nextLine();
		System.out.print("PW > ");
		String admin_pw = ScanUtil.nextLine();
		
		Map<String, Object> admin = adminDao.adminSelect(admin_id, admin_pw);
		
		if (admin == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		} else {
			Controller.LoginAdmin = admin;
			System.out.println("관리자 로그인 성공");
			return View.ADMINMENU;
		}
		return adminLogin();
	}
	
	public int adminJoin(){
		String idRegex = "[a-z0-9_-]{5,20}"; //정규표현식 아이디
		String hpRegex = "^0\\d{1,3}-\\d{3,4}-\\d{4}"; //정규표현식 전화번호
				
		System.out.println("============= 관리자 회원가입 =============");
		String admin_id = null;
		while(true){
			System.out.print("ID > ");
			admin_id = ScanUtil.nextLine();
			Pattern ptId = Pattern.compile(idRegex);
			Matcher mcId = ptId.matcher(admin_id);
			if(mcId.matches() == false) System.out.println("형식에 맞지 않습니다. 다시 입력해주세요.");
			else break;
		}
		System.out.print("PW > ");
		String admin_pw = ScanUtil.nextLine();
		System.out.println("=======================================");
		
		Map<String, Object> param = new HashMap<>();
		param.put("ADMIN_ID", admin_id);
		param.put("ADMIN_PW", admin_pw);
		
		int result = adminDao.insertAdmin(param);
		if (0 < result) {
			System.out.println("회원가입 성공");
			return View.HOME;
		} else {
			System.out.println("회원가입 실패");
			System.out.println("다시 입력해주세요.");
		}
		return View.HOME;
	}
	
}

