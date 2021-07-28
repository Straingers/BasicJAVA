package Controller;

import java.util.Map;

import service.AdminSerivce;
import service.MenuService;
import service.UserService;
import util.ScanUtil;
import util.View;

public class Controller {
	
	public static void main(String[] args) {
		
		new Controller().start();
	
	}
	
	public static Map<String, Object> LoginUser;
	public static Map<String, Object> LoginAdmin;
	
	private UserService userService = UserService.getInstance();
	private AdminSerivce adminService = AdminSerivce.getInstance();
	private MenuService menuService = MenuService.getInstance();
	
	private void start() {
		int view = View.HOME;
		while(true){
			switch (view) {
				case View.HOME: view = home(); break;
				case View.LOGIN: view = totallogin(); break;
				case View.JOIN: view = totaljoin(); break;
				case View.USERMENU: view = menuService.userMenu(); break;
				case View.ADMINMENU: view = menuService.adminMenu(); break;
			}
		}
	}

	private int home() {
		while(true){
			System.out.println("============================================================");
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⣽⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⣿⣿" + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠉⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⢀⣿⣿" + "▄▄▄▄▄░█░░░░▄░░█░▄██▄░█░░░▄░░░▄░░");
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣁⣀⣀⣼⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⢸⣿⣿" + "░▄██░░█▄▄░█▄░░█░█░░█░█▄▄░█░░░█░░");
			System.out.println("⣿⣿⣿⣿⣟⣛⣻⡏⢉⡉⢉⡉⣉⠉⣉⠉⣉⠉⣉⢉⡉⠉⠉⠉⠁⠀⠀⢸⣿⣿" + "█▀░▀█░█░░█▀░█░█░▀▀▀▀░█░░░█░░░█▀▀");
			System.out.println("⣿⣿⣏⡉⠉⠉⠉⠁⠈⣁⣈⣁⣉⣀⣉⣀⠉⠀⠉⠈⠁⠀⠻⣿⡛⢻⣆⣾⣿⣿" + "░░░░░░▀░░░░░░░▀░░░░░░▀░░░▀▀▀░█░░");
			System.out.println("⣿⣿⣿⣿⣿⣶⣶⣶⣤⣽⣿⣍⠉⠉⠉⢻⣶⣶⣿⣿⣿⣿⣿⣿⣷⣄⣻⣿⣿⣿" + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + "░░▄▀█▄░░░░██▄▄░░▄▄▄▄▄░░░░░░░█░░░");
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + "░░█▄▄█▄░░█▀░░░█░▀█░░▀▀▄░░▄▄▄█░░░");
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + "░░░░░▄█░░▀▀█▀▀░░░▀▀▀▀▀▀░░█░░█░░░");
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + "░░█▄▄█░░░░░░░░░░░░░░░░░░░█▄▄█░░░");
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("[1]로그인\t\t\t[2]회원가입\t\t[0]종료");
			System.out.println("============================================================");
			System.out.print("입력 > ");
			int input = 3;
			try {
				input = ScanUtil.nextInt();
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력 해주세요");
			}
			switch (input) {
				case 1: return View.LOGIN;
				case 2: return View.JOIN;
				case 0: System.out.println("이용해주셔서 감사합니다."); System.exit(0);
			}
			return View.HOME;
		}
	}
	
	private int totallogin() {
		while(true){
			System.out.println("=========================================");
			System.out.println("[1]회원 로그인\t[2]관리자 로그인\t[0]돌아가기");
			System.out.println("=========================================");
			System.out.print("입력 > ");
			int input = 0;
			try {
				input = ScanUtil.nextInt();
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력 해주세요");
			}
			int view = View.HOME;
			switch (input) {
				case 1: view = userService.userLogin(); break;
				case 2: view = adminService.adminLogin(); break;
				case 0: return view = View.HOME;
			}
			return view;
		}
	}
	
	private int totaljoin() {
		while(true) {
			System.out.println("=========================================");
			System.out.println("[1]일반 회원 가입\t[2]관리자 회원가입\t[0]돌아가기");
			System.out.println("=========================================");
			System.out.print("입력 > ");
			int input = 0;
			try {
				input = ScanUtil.nextInt();
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력 해주세요");
			}
			int view = View.HOME;
			switch (input) {
				case 1: view = userService.userJoin(); break;
				case 2: view = adminService.adminJoin(); break;
				case 0: view = View.JOIN;
			}
			return view;
		}
	}

}
