package service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Controller.Controller;
import util.ScanUtil;
import util.View;
import dao.ReservationDao;
import dao.UserDao;

public class UserService {
	private UserService(){}
	private static UserService instance;
	public static UserService getInstance(){
		if (instance == null){
			instance = new UserService();
		}
		return instance;
	}
	private UserDao userDao = UserDao.getInstance();
	
	public int userJoin(){
		String idRegex = "[a-z0-9_-]{5,20}"; //정규표현식 아이디
		String hpRegex = "^0\\d{1,3}-\\d{3,4}-\\d{4}"; //정규표현식 전화번호
		
		System.out.println("============== 회원가입 ===============");
		String mem_id = null;
		while(true){
			System.out.print("ID > ");
			mem_id = ScanUtil.nextLine();
			Pattern ptId = Pattern.compile(idRegex);
			Matcher mcId = ptId.matcher(mem_id);
			if(mcId.matches() == false) System.out.println("형식에 맞지 않습니다. 다시 입력해주세요.");
			else break;
		}
		System.out.print("PW > ");
		String mem_pw = ScanUtil.nextLine();
		System.out.print("성명 > ");
		String mem_name = ScanUtil.nextLine();
		System.out.print("여권번호 > ");
		String mem_passport = ScanUtil.nextLine();
		System.out.print("주소 > ");
		String mem_add = ScanUtil.nextLine();
		String mem_hp = null;
		while(true){			
			System.out.print("전화번호 > ");
			mem_hp = ScanUtil.nextLine();
			Pattern ptHp = Pattern.compile(hpRegex);
			Matcher mcHp = ptHp.matcher(mem_hp); 
			if(mcHp.matches() == false) System.out.println("형식에 맞지 않습니다. 다시 입력해주세요.");
			else break;
		}
		System.out.println("=====================================");
		
		Map<String, Object> param = new HashMap<>();
		param.put("MEM_ID", mem_id);
		param.put("MEM_PW", mem_pw);
		param.put("MEM_NAME", mem_name);
		param.put("MEM_PASSPORT", mem_passport);
		param.put("MEM_ADD", mem_add);
		param.put("MEM_HP", mem_hp);
		
		int result = userDao.insertUser(param);
		if (0 < result) {
			System.out.println("회원가입 성공");
			return View.HOME;
		} else {
			System.out.println("회원가입 실패");
			System.out.println("다시 입력해주세요.");
		}
		return View.HOME;
	}
	
	public int userLogin(){
		System.out.println("=============== 회원 로그인 =================");
		System.out.print("ID > ");
		String mem_id = ScanUtil.nextLine();
		System.out.print("PW > ");
		String mem_pw = ScanUtil.nextLine();
		Map<String, Object> user = userDao.memberSelect(mem_id, mem_pw);
		
		if (user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		} else {
			Controller.LoginUser = user;
			System.out.println("로그인 성공");
			return View.USERMENU;
		}
		return userLogin();
	}
	
}
