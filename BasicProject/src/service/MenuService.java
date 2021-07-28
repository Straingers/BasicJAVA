package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import util.ScanUtil;
import util.View;
import Controller.Controller;
import dao.AdminDao;
import dao.BackpackDao;
import dao.FlightDao;
import dao.NoticeDao;
import dao.QnaboardDao;
import dao.ReservationDao;
import dao.SeatDao;
import dao.UserDao;

public class MenuService {
	private MenuService(){}
	private static MenuService instance;
	public static MenuService getInstance(){
		if (instance == null){
			instance = new MenuService();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	private FlightService flightService = FlightService.getInstance();
	private QnaboardService qnaboardService = QnaboardService.getInstance();
	private NoticeService noticeService=NoticeService.getInstance();
	private UserDao userDao = UserDao.getInstance();
	private AdminDao adminDao = AdminDao.getInstance();
	private QnaboardDao qnaboardDao = QnaboardDao.getInstance();
	private NoticeDao notiveDao = NoticeDao.getInstance();
	private FlightDao flightDao =FlightDao.getInstance();
	private SeatDao seatDao = SeatDao.getInstance();
	private BackpackDao backpackDao = BackpackDao.getInstance();
	private ReservationDao reservationDao = ReservationDao.getInstance();
	private NoticeDao noticeDao = notiveDao.getInstance();
	
	public int userMenu(){
		System.out.println("==================================================");
		System.out.println("[1]항공편 예매\t[2]마이페이지\t[0]로그아웃");
		System.out.print("입력 > ");
		int input = 4;
		try {
			input = ScanUtil.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력 해주세요");
		}
		int view=View.HOME;
		switch (input) {
			case 1: flightService.ResFlight();
			case 2: 
				System.out.println("============================= 마이페이지 ============================"); //마이페이지
				System.out.println("[1]회원정보\t[2]공지사항\t[3]Q&A\t[4]티켓확인\t[0]돌아가기");
				System.out.println("입력 > ");
				int input2 = 5;
				try {
					input2 = ScanUtil.nextInt();
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					System.out.println("다시 입력 해주세요");
				}
				switch (input2) {
					case 1: return view = memInfo(); 
					case 2: return view = noticeService.selectnotice(); 
					case 3: return view = qnaboardService.qna();
					case 4: return view = tiketInfo();
					case 0: return view = View.USERMENU;
				}
			case 0: 
				System.out.println("로그아웃 되었습니다.");
				return view;
		}
		return View.USERMENU;
	}
	
	public int tiketInfo() {
		String sql=" SELECT A.SEAT_NUM 자리코드"
				+ " ,(SELECT SEAT_REAL FROM SEAT WHERE SEAT_NUM=A.SEAT_NUM ) 자리번호"
				+ " ,(SELECT PORT_NAME FROM FLIGHT C,AIRPORT D WHERE C.FLIGHT_CODE=B.FLIGHT_CODE AND C.PORT_DEPT = D.PORT_CODE) 출발공항"
				+ " ,(SELECT PORT_NAME FROM FLIGHT C,AIRPORT D WHERE C.FLIGHT_CODE=B.FLIGHT_CODE AND C.PORT_ARRI = D.PORT_CODE) 도착공항"
				+ " ,(SELECT DEPT_TIME FROM FLIGHT WHERE FLIGHT_CODE=B.FLIGHT_CODE) 출발시간"
				+ " ,(SELECT ARRI_TIME FROM FLIGHT WHERE FLIGHT_CODE=B.FLIGHT_CODE) 도착시간"
				+ " ,B.MEM_ID 회원아이디"
				+ " ,B.RES_NO 예약번호"
				+ " FROM RES_SEAT A,RESERVATION B"
				+ " WHERE  A.RES_NO = B.RES_NO"
				+ " and B.MEM_ID = ? ";
		String userId= Controller.LoginUser.get("MEM_ID").toString();
		List<Object> param = new ArrayList<>();
		param.add(userId);
		
		List<Map<String,Object>> tiket =jdbc.selectList(sql, param);
		int check =0;
		System.out.println("==================================================");
		for(int i = 0; i < tiket.size(); i++){
			Map<String, Object> flight = tiket.get(i);
			System.out.println("["+(i+1)+"]"+"번 ");
			System.out.println("자리코드\t: "+flight.get("자리코드"));
			System.out.println("자리번호\t: " + flight.get("자리번호"));
			System.out.println("출발공항\t: " + flight.get("출발공항"));
			System.out.println("도착공항\t: "+ flight.get("도착공항"));
			System.out.println("출발시간\t: "+ flight.get("출발시간"));
			System.out.println("도착시간\t: "+ flight.get("도착시간"));
			System.out.println("회원아이디\t: "+ flight.get("회원아이디"));
			System.out.println("==================================================");
			check=1;
		}
		if (0 < check) {
			System.out.println("이용하실 메뉴를 선택해 주세요");
			System.out.println("[1]예매취소\t[0]돌아가기");
			int view = View.USERMENU;
			int a = ScanUtil.nextInt();
			switch(a){
			case 1:
			System.out.println("==================================================");
			System.out.println("취소하실 티켓번호를 입력하시오 > ");
			int in = ScanUtil.nextInt();
			String sql2=" SELECT A.SEAT_NUM 자리코드"
					+ " ,(SELECT SEAT_REAL FROM SEAT WHERE SEAT_NUM=A.SEAT_NUM ) 자리번호"
					+ " ,(SELECT PORT_NAME FROM FLIGHT C,AIRPORT D WHERE C.FLIGHT_CODE=B.FLIGHT_CODE AND C.PORT_DEPT = D.PORT_CODE) 출발공항"
					+ " ,(SELECT PORT_NAME FROM FLIGHT C,AIRPORT D WHERE C.FLIGHT_CODE=B.FLIGHT_CODE AND C.PORT_ARRI = D.PORT_CODE) 도착공항"
					+ " ,(SELECT DEPT_TIME FROM FLIGHT WHERE FLIGHT_CODE=B.FLIGHT_CODE) 출발시간"
					+ " ,(SELECT ARRI_TIME FROM FLIGHT WHERE FLIGHT_CODE=B.FLIGHT_CODE) 도착시간"
					+ " ,B.MEM_ID 회원아이디"
					+ " ,B.RES_NO 예약번호"
					+ " FROM RES_SEAT A,RESERVATION B"
					+ " WHERE  A.RES_NO = B.RES_NO"
					+ " and B.MEM_ID = ? ";
			String userId2= Controller.LoginUser.get("MEM_ID").toString();
			List<Object> param2 = new ArrayList<>();
			param2.add(userId2);
			List<Map<String,Object>> tiket2 =jdbc.selectList(sql2, param2);
			Map<String, Object> restemp= tiket2.get(in - 1);
			Object resno = restemp.get("예약번호");
			Map<String, Object> rs = reservationDao.resMoneyCheck();
			Map<String,Object> bagpack =backpackDao.selectBagPack(resno);

			int result11 = 0;
			if(bagpack != null){
				 result11 = reservationDao.outMemMileage(((Integer.valueOf((String) rs.get("RES_COST")))
						 -Integer.valueOf(String.valueOf(bagpack.get("BAG_COST"))))*0.1);
			}else{
				result11 = reservationDao.outMemMileage((Integer.valueOf((String) rs.get("RES_COST")) * 0.1));	
			}
			int result22 = reservationDao.moneyreturn(Integer.valueOf((String) rs.get("RES_COST")));
			
			int result1 = seatDao.DeleteMemResseat(resno);
			int result2 = backpackDao.DeleteMemBagpack(resno);
			int result3 = reservationDao.DeleteMemReservation(resno);
			int result4 = result1+result2+result3;
			
			if(0<result4){
				System.out.println("예매가 취소되었습니다 ");
				return View.USERMENU;	
			}else {
				System.out.println("취소가 실패하였습니다 ");
				System.out.println("다시 시도해주세요");
			}
			case 0:
				return view;
			}
			return View.USERMENU;
		} else {
			System.out.println("예매한 티켓이 없습니다");
			return View.USERMENU;
		}
	}

	public int memInfo() {
		String sql = "SELECT MEM_NAME, MEM_PASSPORT, MEM_ADD, MEM_HP, MEM_MONEY, MEM_MILEAGE"
				+ " FROM MEMBER"
				+ " WHERE MEM_ID = ?";
		
		String userId = Controller.LoginUser.get("MEM_ID").toString();
		List<Object> p = new ArrayList<>();
		p.add(userId);
		
		Map<String, Object> list = jdbc.selectOne(sql, p);
		
		System.out.println("============== 회원정보 ==============");
		System.out.println("회원명 \t: " + list.get("MEM_NAME"));
		System.out.println("여권번호 \t: " + list.get("MEM_PASSPORT"));
		System.out.println("주소 \t: " + list.get("MEM_ADD"));
		System.out.println("전화번호 \t: " + list.get("MEM_HP"));
		System.out.println("잔액\t: " + list.get("MEM_MONEY"));
		System.out.println("마일리지 \t: " + list.get("MEM_MILEAGE"));
		System.out.println("====================================");
		System.out.println("[1]정보수정\t[2]잔액충전\t[3]회원탈퇴\t[0]돌아가기");
		System.out.print("입력 > ");
		int input = 0;
		try {
			input = ScanUtil.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력 해주세요");
		}
		switch (input) {
			case 1: return memupdate();
			case 2: return memMoney();
			case 3: return memdelete();
			case 0: return View.USERMENU;
		}
		return View.USERMENU;
	}
	
	public int memMoney() {
		System.out.println("얼마를 충전하시겠습니까?");
		System.out.print("입력 > ");
		int mon = ScanUtil.nextInt();

		int a = userDao.updateMemMoney(mon);
		if (0 < a) {
			System.out.println("충전하였습니다 ");
			return View.USERMENU;
		} else {
			System.out.println("충전에 실패하였습니다 ");
			System.out.println("다시 시도해주세요");
		}
		return View.USERMENU;
	}

	public int memupdate(){
		System.out.println("============== 회원정보수정 ==============");
		System.out.print("수정할 이름을 입력해주세요 > ");
		String memname =ScanUtil.nextLine();
		System.out.print("수정할 비밀번호를 입력해주세요 > ");
		String mempw =ScanUtil.nextLine();
		System.out.println("수정할 여권번호를 입력해주세요 > ");
		String passport =ScanUtil.nextLine();
		System.out.print("수정할 주소를 입력해주세요 > ");
		String add =ScanUtil.nextLine();
		System.out.print("수정할 전화번호를 입력해주세요 > ");
		String hp =ScanUtil.nextLine();
		int a = userDao.updateMemInfo(memname, mempw, passport, add, hp);
		if(0 < a){
			System.out.println("정보수정을 성공하였습니다 ");
			return View.USERMENU;
		}else {
			System.out.println("수정이 실패하였습니다 ");
			System.out.println("다시 시도해주세요");
		}
		return View.USERMENU;
	}
	
	public int memdelete(){
		System.out.println("============== 회원탈퇴 ==============");
		System.out.println("회원 탈퇴를 하시겠습니까?");
		System.out.println("[1]네\t[2]아니오");
		System.out.print("입력 > ");
		int input = 0;
		try {
			input = ScanUtil.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력 해주세요");
		}
		switch (input) {
			case 1: 
				System.out.println("비밀번호를 입력해주세요");
				System.out.print("입력 > ");
				String pw = ScanUtil.nextLine();
				Map<String,Object> aa = userDao.passwordCheck();
				if(pw.equals(aa.get("MEM_PW"))) {
					System.out.println("정말 탈퇴하시겠습니까?"); 
					System.out.println("[1]네\t[2]아니오");
					System.out.print("입력 > ");
					int num = 0;
					try {
						num = ScanUtil.nextInt();
					} catch (Exception e) {
						System.out.println("잘못된 입력입니다.");
						System.out.println("다시 입력 해주세요");
					}
					switch (num) {
						case 1:
							int a = userDao.deleteMeminfo(pw);
							if (0 < a) {
								System.out.println("탈퇴를 성공하였습니다.");
								System.out.println("로그아웃하였습니다.");
								return View.HOME;
							} else {
								System.out.println("탈퇴를 실패하였습니다.");
							}
						case 2:
							System.out.println("취소합니다.");
							return View.USERMENU;
					}
				} else {
					System.out.println("비밀번호를 잘못 입력하셨습니다.");
					return View.USERMENU;
				}
			case 2:
				return View.USERMENU;
		}
		return View.HOME;
	}
	
	public int adminMenu(){
		System.out.println("======================== 관리자 페이지 =========================");
		System.out.println("[1]관리자정보\t[2]항공편 등록/수정/삭제\t[3]예매확인\t[4]공지사항\t");
		System.out.println("[5]Q&A\t[6]가입회원 정보\t[0]로그아웃");
		System.out.println("============================================================");
		System.out.println("입력 > ");
		int input = 0;
		try {
			input = ScanUtil.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력 해주세요");
		}
		int view = View.HOME; 
		switch (input) {
			case 1: return view = adminInfo();
			case 2: return view = adminFlight();
			case 3: return view = adminReservation();
			case 4: return view = adminnotice();
			case 5: return view = adminqna();
			case 6: return view = adminmember();
			case 0: 
				System.out.println("로그아웃 되었습니다.");
				return view;
		}
		
		return view = View.ADMINMENU;
	}
	
	public int adminReservation() {
		System.out.println("====================예매 목록=====================");
		System.out.println("예매번호\t항공편코드\t회원아이디\t금액");	
		System.out.println("-----------------------------------------------");
		int check = 0;
		List<Map<String,Object>> resList = userDao.AdminReservationList();
		for (int i = 0; i < resList.size(); i++) {
			Map<String ,Object> res = resList.get(i);
			System.out.println("[" + (i + 1) + "]" + res.get("RES_NO")
					+ "\t" + res.get("FLIGHT_CODE")
					+ "\t" + res.get("MEM_ID")
					+ "\t" + res.get("RES_COST"));
			check =1;
		}		
		if(check == 0){
			System.out.println("----------------------------------------------");
			System.out.println("예매기록이 없습니다");
			return View.ADMINMENU;
		}	

		return View.ADMINMENU;	
	}
	
	public int adminmember() {
		System.out.println("====================가입 회원 목록=====================");
		System.out.println("아이디\t이름\t비밀번호\t여권번호\t주소\t전화번호\t잔액\t마일리지");	
		System.out.println("---------------------------------------------------");
		int check = 0;
		List<Map<String, Object>> memList = userDao.AdminMemberList();
		for (int i = 0; i < memList.size(); i++) {
			Map<String ,Object> mem = memList.get(i);
			System.out.println("[" + (i + 1) + "]" + mem.get("MEM_ID")
					+ "\t" + mem.get("MEM_NAME")
					+ "\t" + mem.get("MEM_PW")
					+ "\t" + mem.get("MEM_PASSPORT")
					+ "\t" + mem.get("MEM_ADD")
					+ "\t" + mem.get("MEM_HP")
					+ "\t" + mem.get("MEM_MONEY")
					+ "\t" + mem.get("MEM_MILEAGE"));
			check = 1;
		}		
		if(check == 0){
			System.out.println("----------------------------------------------");
			System.out.println("회원이 없습니다");
			return View.ADMINMENU;
		}	
		System.out.println("----------------------------------------------");
		System.out.println("[1]회원삭제\t[0]돌아가기");
		System.out.print("입력 > ");
		int put = 0;
		try {
			put = ScanUtil.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력 해주세요");
		}
		switch(put){
			case 1:
				System.out.print("삭제할 회원의 번호를 입력하시오 ");
				System.out.print("입력 > ");
				int memNum = 0;
				try {
					memNum = ScanUtil.nextInt();
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					System.out.println("다시 입력 해주세요");
				}
				Map<String, Object> mem = memList.get(memNum - 1);
				Object id = mem.get("MEM_ID");
				
				int re = userDao.AdminMemberDelete(id);
				
				if (0 < re) {
					System.out.println("회원을 삭제하였습니다 ");
					return View.ADMINMENU;
				} else {
					System.out.println("삭제가 실패하였습니다 ");
					System.out.println("다시 시도해주세요");
				}
			case 0:
				return View.ADMINMENU;
		}
		return View.ADMINMENU;
	}
	
	public int adminFlight() {
		System.out.println("==================================================");
		System.out.println("[1]항공편 등록\t[2]항공편수정\t[3]항공편삭제\t[0]돌아가기");
		System.out.println("==================================================");
		System.out.print("입력 > ");
		int input = 0;
		try {
			input = ScanUtil.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력 해주세요");
		}
		switch (input){
			case 1:
				System.out.println("===================== 항공편 등록 =======================");
				System.out.println("비행기 코드\t항공사 이름\t비행기 이름");
				System.out.println("-----------------------------------------------------");
				List<Map<String, Object>> flightList =flightDao.adminairPlane();
				for (int i = 0; i < flightList.size(); i++) {
					Map<String, Object> flight = flightList.get(i);
					System.out.print("["+(i+1)+"]" + flight.get("PLANE_CODE"));
					System.out.print("\t"+flight.get("LINE_NAME"));
					System.out.println("\t"+flight.get("PLANE_NAME"));
				}
				System.out.println("원하는 비행기를 선택하시오 > ");
				int a =ScanUtil.nextInt();
				Map<String,Object> airplane =flightList.get(a-1);
				Object planecode =airplane.get("PLANE_CODE");
				
				System.out.println("공항코드\t공항이름\t도시코드\t국가코드");
				System.out.println("---------------------------------");
				List<Map<String, Object>> airList =flightDao.adminairport();
				for (int i = 0; i < airList.size(); i++) {
					Map<String, Object> air = airList.get(i);
					System.out.print("[" + (i + 1) + "]" + air.get("PORT_CODE"));
					System.out.print("\t" + air.get("PORT_NAME"));
					System.out.print("\t" + air.get("CITY_CODE"));
					System.out.println("\t" + air.get("COUNTRY_CODE"));
				}
				System.out.print("출발공항을 선택하시오 > ");
				 int b =ScanUtil.nextInt();
				Map<String ,Object> airport =airList.get(b-1);
				Object portdept =airport.get("PORT_CODE");
				
				System.out.println("공항코드\t공항이름\t도시코드\t국가코드");
				System.out.println("-------------------------------");
				airList = flightDao.adminairport();
				for (int i = 0; i < airList.size(); i++) {
					Map<String, Object> air = airList.get(i);
					System.out.print("["+(i+1)+"]" +air.get("PORT_CODE"));
					System.out.print("\t"+air.get("PORT_NAME"));
					System.out.print("\t"+air.get("CITY_CODE"));
					System.out.println("\t"+air.get("COUNTRY_CODE"));
				}
				System.out.println("도착공항을 선택하시오 > ");
				int c = ScanUtil.nextInt();
				airport = airList.get(c - 1);
				Object portarri =airport.get("PORT_CODE");
					
				System.out.println("수정할 금액을 입력하시오");
				System.out.println("==================== 금액선택 예시 =====================");
				System.out.println("[1]퍼스트 :" + "3000000");
				System.out.println("[2]비즈니스 :" + "2500000");
				System.out.println("[3]이코노미 :" + "2000000");
				System.out.println("====================================================");
				System.out.println();
				System.out.print("퍼스트 금액 > ");
				int flightcost1 =ScanUtil.nextInt();
				
				System.out.println();
				System.out.print("비즈니스 금액 > ");
				int flightcost2 =ScanUtil.nextInt();
				
				System.out.println();
				System.out.print("이코노미 금액 > ");
				int flightcost3 =ScanUtil.nextInt();
				
				//21/03/01 07:00
				System.out.println("출발 년도을 입력하시오");
				System.out.println("예) 21");
				System.out.print("입력 > ");
			    String aa=ScanUtil.nextLine();
				
				System.out.println("출발 월을 입력하시오");
				System.out.println("예) 03");
				System.out.print("입력 > ");
				String bb=ScanUtil.nextLine();
				
				System.out.println("출발 일을 입력하시오 > ");
				System.out.println("예) 01");
				System.out.print("입력 > ");
				String cc=ScanUtil.nextLine();
				
				System.out.println("출발 시간을 입력하시오 > ");
				System.out.println("예) 14");
				System.out.print("입력 > ");
				String dd=ScanUtil.nextLine();
				
				System.out.println("출발 분을 입력하시오 > ");
				System.out.println("예) 30");
				System.out.print("입력 > ");
				String ee=ScanUtil.nextLine();
				
				String depttime = aa + "/" + bb + "/" + cc + " " + dd + ":" + ee;
				
				System.out.println("도착 년도을 입력하시오 ");
				System.out.println("예) 21");
				System.out.print("입력 > ");
			    aa=ScanUtil.nextLine();
				
				System.out.println("도착 월을 입력하시오 ");
				System.out.println("예) 03");
				System.out.print("입력 > ");
				 bb=ScanUtil.nextLine();
				
				System.out.println("도착 일을 입력하시오 ");
				System.out.println("예) 01");
				System.out.print("입력 > ");
				 cc=ScanUtil.nextLine();
				
				System.out.println("도착 시간을 입력하시오 ");
				System.out.println("예) 14");
				System.out.print("입력 > ");
				 dd=ScanUtil.nextLine();
				
				System.out.println("도착 분을 입력하시오 ");
				System.out.println("예) 30");
				System.out.print("입력 > ");
				 ee=ScanUtil.nextLine();
				
				String arritime = aa + "/" + bb + "/" + cc + " " + dd + ":" + ee;
				
				int fina = flightDao.AdminFlight(planecode, portdept, portarri, flightcost1, flightcost2, flightcost3, depttime, arritime);
	
				if (0 < fina) {
					System.out.println("추가하였습니다 ");
					return View.ADMINMENU;
				} else {
					System.out.println("추가가 실패하였습니다 ");
					System.out.println("다시 시도해주세요");
				}
			case 2:
				List<Map<String, Object>> flightList2 = flightDao.FlightList();
				for(int i = 0; i < flightList2.size(); i++){
					Map<String, Object> flight2 = flightList2.get(i);
					System.out.println("[" + (i + 1) + "] " + flight2.get("PORT_NAME"));
				}
				System.out.println("=============================");
				System.out.println("출발공항을 입력하시오 > ");
				System.out.print("입력 > ");
				int dept = ScanUtil.nextInt();
				System.out.println("=============================");
				System.out.println("도착공항을 입력하시오 > ");
				System.out.print("입력 > ");
				int arri = ScanUtil.nextInt();
				
				System.out.println("==================================== 항공편 LIST ========================================");
				System.out.println("항공편번호\t비행기번호\t출발공항\t도착공항\t퍼스트\t비즈니스"
						+ "\t이코노미\t출발시간\t도착시간");
				System.out.println("---------------------------------------------------------------------------------------");
				int check = 0;
				List<Map<String, Object>> selectflightList = flightDao.selectFlightList(dept, arri);
				for(int i = 0; i < selectflightList.size(); i++){
					Map<String, Object> flight = selectflightList.get(i);
					System.out.println("[" + (i + 1) + "] "
							+ "\t" + flight.get("PLANE_CODE")
							+ "\t" + flight.get("DEPT_NAME")
							+ "\t" + flight.get("ARRI_NAME")
							+ "\t" + flight.get("FLIGHT_COST1")
							+ "\t" + flight.get("FLIGHT_COST2")
							+ "\t" + flight.get("FLIGHT_COST3")
							+ "\t" + flight.get("DEPT_TIME")
							+ "\t" + flight.get("ARRI_TIME"));
					check = 1;
				}
				if(check == 0){
					System.out.println("항공편이 없습니다.");
					return View.ADMINMENU;	
				}else{
					System.out.println("---------------------------------------------------------------------------------------");
					System.out.print("수정할 항공편 번호를 입력하시오 > ");
					int re = ScanUtil.nextInt();	
					Map<String, Object> restemp = selectflightList.get(re - 1);
					Object num = restemp.get("FLIGHT_CODE");
					
					System.out.println("비행기 코드\t항공사 이름\t비행기 이름");
					System.out.println("-------------------------------");
					List<Map<String, Object>> flightList1 = flightDao.adminairPlane();
					for (int i = 0; i < flightList1.size(); i++) {
						Map<String, Object> flight1 = flightList1.get(i);
						System.out.print("[" + (i + 1) + "]" + flight1.get("PLANE_CODE"));
						System.out.print("\t" + flight1.get("LINE_NAME"));
						System.out.println("\t" + flight1.get("PLANE_NAME"));
					}
					System.out.println("원하는 비행기를 선택하시오 > ");
					int a1 = ScanUtil.nextInt();
					Map<String, Object> airplane1 = flightList1.get(a1-1);
					Object planecode1 = airplane1.get("PLANE_CODE");
					
					
					System.out.println("공항코드\t공항이름\t도시코드\t국가코드");
					System.out.println("---------------------------------");
					List<Map<String, Object>> airList1 = flightDao.adminairport();
					for (int i = 0; i < airList1.size(); i++) {
						Map<String, Object> air1 = airList1.get(i);
						System.out.print("[" + (i + 1) + "]" + air1.get("PORT_CODE"));
						System.out.print("\t" + air1.get("PORT_NAME"));
						System.out.print("\t" + air1.get("CITY_CODE"));
						System.out.println("\t" + air1.get("COUNTRY_CODE"));
					}
					System.out.println("출발공항을 선택하시오 > ");
					 int b1 = ScanUtil.nextInt();
					Map<String, Object> airport1 = airList1.get(b1-1);
					Object portdept1 = airport1.get("PORT_CODE");
					
					
					System.out.println("공항코드\t공항이름\t도시코드\t국가코드");
					System.out.println("-----------------------------------");
					         airList1 = flightDao.adminairport();
					for (int i = 0; i < airList1.size(); i++) {
						Map<String, Object> air1 = airList1.get(i);
						System.out.print("[" + (i + 1) + "]" + air1.get("PORT_CODE"));
						System.out.print("\t" + air1.get("PORT_NAME"));
						System.out.print("\t" + air1.get("CITY_CODE"));
						System.out.println("\t" + air1.get("COUNTRY_CODE"));
					}
					System.out.print("도착공항을 선택하시오 > ");
					int c1 =ScanUtil.nextInt();
					Map<String, Object>  airport2 = airList1.get(c1-1);
					Object portarri1 = airport2.get("PORT_CODE");
					
					System.out.println("각 자리에 금액을 입력하시오");
					System.out.println("==================== 금액선택 예시 =====================");
					System.out.println("[1]퍼스트 : " + "3000000");
					System.out.println("[2]비즈니스 : " + "2500000");
					System.out.println("[3]이코노미 : " + "2000000");
					System.out.println("=================================================");
					System.out.println();
					System.out.print("퍼스트 금액 입력 > ");
					int flightcost12 =ScanUtil.nextInt();
					
					System.out.println();
					System.out.print("비즈니스 금액 입력 > ");
					int flightcost22 =ScanUtil.nextInt();
					
					System.out.println();
					System.out.print("이코노미 금액 입력 > ");
					int flightcost32 =ScanUtil.nextInt();
					
					//21/03/01 07:00
					System.out.println("출발 년도");
					System.out.println("예) 21");
					System.out.print("입력 > ");
				    String aa1=ScanUtil.nextLine();
					
					System.out.println("출발 월");
					System.out.println("예) 03");
					System.out.print("입력 > ");
					String bb1=ScanUtil.nextLine();
					
					System.out.println("출발 일자");
					System.out.println("예) 01");
					System.out.print("입력 > ");
					String cc1=ScanUtil.nextLine();
					
					System.out.println("출발 시간");
					System.out.println("예) 14");
					System.out.print("입력 > ");
					String dd1=ScanUtil.nextLine();
					
					System.out.println("출발 분");
					System.out.println("예) 30");
					System.out.print("입력 > ");
					String ee1=ScanUtil.nextLine();
					
					String depttime1 =aa1+"/"+bb1+"/"+cc1+" "+dd1+":"+ee1;
					
					System.out.println("도착 년도");
					System.out.println("예) 21");
					System.out.print("입력 > ");
				    aa1=ScanUtil.nextLine();
					
					System.out.println("도착 월");
					System.out.println("예) 03");
					System.out.print("입력 > ");
					bb1=ScanUtil.nextLine();
					
					System.out.println("도착 일자");
					System.out.println("예) 01");
					System.out.print("입력 > ");
					cc1=ScanUtil.nextLine();
					
					System.out.println("도착 시간");
					System.out.println("예) 14");
					System.out.print("입력 > ");
					dd1=ScanUtil.nextLine();
					
					System.out.println("도착 분");
					System.out.println("예) 30");
					System.out.print("입력 > ");
					ee1=ScanUtil.nextLine();
					
					String arritime1 =aa1 + "/" + bb1 + "/" + cc1 + " " + dd1 + ":" + ee1;
					
					int upfin = flightDao.AdminUpdateFlight(planecode1, portdept1, portarri1, flightcost12, flightcost22, flightcost32, depttime1, arritime1, num);
					if (0 < upfin) {
						System.out.println("수정하였습니다 ");
						return View.ADMINMENU;
					} else {
						System.out.println("수정이 실패하였습니다 ");
						System.out.println("다시 시도해주세요");
					}		
				}
			case 3:
				List<Map<String, Object>> flightList3 = flightDao.FlightList();
				for(int i = 0; i < flightList3.size(); i++){
					Map<String,Object> flight3 = flightList3.get(i);
					System.out.println("[" + (i + 1) + "] " + flight3.get("PORT_NAME"));
				}
				System.out.println("=============================");
				System.out.print("출발공항 입력 > ");
				int dept2 = ScanUtil.nextInt();
				System.out.println("=============================");
				System.out.print("도착공항 입력 > ");
				int arri2 = ScanUtil.nextInt();
				
				System.out.println("==================================== 항공편 LIST ========================================");
				System.out.println("항공편번호\t비행기번호\t출발공항\t도착공항\t퍼스트\t비즈니스"
						+ "\t이코노미\t출발시간\t도착시간");
				System.out.println("---------------------------------------------------------------------------------------");
				int check2 = 0;
				List<Map<String, Object>> selectflightList3 = flightDao.selectFlightList(dept2, arri2);
				
				for(int i = 0; i < selectflightList3.size(); i++){
					Map<String, Object> flight = selectflightList3.get(i);
					System.out.println("[" + (i + 1) + "] "
							+ "\t" + flight.get("PLANE_CODE")
							+ "\t" + flight.get("DEPT_NAME")
							+ "\t" + flight.get("ARRI_NAME")
							+ "\t" + flight.get("FLIGHT_COST1")
							+ "\t" + flight.get("FLIGHT_COST2")
							+ "\t" + flight.get("FLIGHT_COST3")
							+ "\t" + flight.get("DEPT_TIME")
							+ "\t" + flight.get("ARRI_TIME"));
					check2 = 1;
				}
				if(check2 == 0){
					System.out.println("항공편이 없습니다.");
					return View.ADMINMENU;	
				}else{
					System.out.println("---------------------------------------------------------------------------------------");
					System.out.print("삭제하실 항공편 번호를 입력하시오 > ");
					int re2 = ScanUtil.nextInt();	
					Map<String, Object> restemp3 = selectflightList3.get(re2 - 1);
					Object num2 = restemp3.get("FLIGHT_CODE");
					int result = flightDao.AdminDeleteFlight(num2);
					
					if(0<result){
						System.out.println("삭제하였습니다 ");
						return View.ADMINMENU;	
					}else {
						System.out.println("삭제가 실패하였습니다 ");
						System.out.println("다시 시도해주세요");
					}
				}
			case 0:
				return View.ADMINMENU;
		}
		return View.ADMINMENU;
	}

	public int adminnotice() {
		System.out.println("====================공지 목록=====================");
		System.out.println("등록번호\t제목");		
		int check = 0;
		List<Map<String,Object>> noticeList = noticeDao.SelectNoticeList();
		for (int i = 0; i < noticeList.size(); i++) {
			Map<String, Object> no = noticeList.get(i);
			System.out.println(no.get("NOTICE_NO") + "\t" + no.get("NOTICE_TITLE"));
		check = 1;
		}	
		if(check == 0){
			System.out.println("----------------------------------------------");
			System.out.println("작성한 글이 없습니다");
		}	
		System.out.println("----------------------------------------------");
		System.out.println("[1]내용확인\t[2]공지작성\t[0]돌아가기");
		System.out.print("입력 > ");
		int input = 0;
		try {
			input = ScanUtil.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력 해주세요");
		}
		switch(input){
			case 1:
				System.out.println("확인할 게시물 번호를 입력하시오");
				System.out.print("입력 > ");
				String num = ScanUtil.nextLine();
				List<Map<String,Object>> selectnoticeList = noticeDao.selectNoticeContent(num);
				for (int i = 0; i < selectnoticeList.size(); i++) {
					Map<String ,Object> no = selectnoticeList.get(i);
					System.out.println("공지 번호: " + no.get("NOTICE_NO"));
					System.out.println("공지 제목: " + no.get("NOTICE_TITLE"));
					System.out.println("게시물 내용: " + no.get("NOTICE_CONTENT"));		
				}
				System.out.println("----------------------------------------------");
				return View.ADMINMENU;
			case 2:
				System.out.println("----------------------------------------------");
				System.out.println("제목 > ");
				String title = ScanUtil.nextLine();	
				System.out.println("내용 > ");
				String content = ScanUtil.nextLine();	
				
				int a = notiveDao.insertNoticeadmin(title, content);
				if (0 < a) {
					System.out.println("공지를 게시하였습니다.");
					return View.ADMINMENU;
				} else {
					System.out.println("게시를 실패하였습니다.");
					System.out.println("다시 시도해주세요");
				}
				return View.ADMINMENU;
			case 0:
				return View.ADMINMENU;
		}
		return View.ADMINMENU;
	}

	public int adminqna() {
		System.out.println("====================QNA 목록=====================");
		System.out.println("번호\t제목\t회원아이디\t등록일");	
		int check = 0;
		List<Map<String,Object>> qnaList = qnaboardDao.qnaboardadminList();
		for (int i = 0; i < qnaList.size(); i++) {
			Map<String ,Object> qna = qnaList.get(i);
			System.out.println(qna.get("QNA_NO") + "\t" + qna.get("QNA_TITLE")
					+"\t" + qna.get("MEM_ID") + "\t" + qna.get("QNA_DATE"));
		check = 1;
		} if(check == 0){
			System.out.println("----------------------------------------------");
			System.out.println("게시글이 없습니다.");
		}	
		System.out.println("----------------------------------------------");
		System.out.println("[1]게시글 내용확인\t[0]돌아가기");
		System.out.print("입력 > ");
		int input = 2;
		try {
			input = ScanUtil.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력 해주세요");
		}
		switch(input){
			case 1:
			System.out.print("확인할 게시물 번호를 입력하시오 > ");
			String num=ScanUtil.nextLine();
			List<Map<String,Object>> selectQnaBoardList =qnaboardDao.SelectQnaBoardList2(num);
			for (int i = 0; i < selectQnaBoardList.size(); i++) {
				Map<String ,Object> qna = selectQnaBoardList.get(i);
				System.out.println("[" + i + "]" + "번 글");
				System.out.println("------------------------------------");
				System.out.println("게시물 번호\t: "+qna.get("QNA_NO"));
				System.out.println("게시물 제목\t: "+qna.get("QNA_TITLE"));
				System.out.println("회원 아이디\t: "+qna.get("MEM_ID"));
				System.out.println("게시물 내용\t: "+qna.get("QNA_CONTENT"));
				System.out.println("등록 날짜\t:"+qna.get("QNA_DATE"));		
			}
			System.out.println("----------------------------------------------");
			System.out.println("메뉴를 선택하시오");
			System.out.println("[1]답변 입력\t[0]돌아가기");
			System.out.print("입력 > ");
			int b = 2;
			try {
				b = ScanUtil.nextInt();
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력 해주세요");
			}
			switch (b) {
				case 1:
					System.out.println("----------------------------------------------");
					System.out.print("답변할 내용을 입력하시오 > ");
					String content2 = ScanUtil.nextLine();
					int a = qnaboardDao.updateQnaAdminBoard(content2, num);
					if (0 < a) {
						System.out.println("답변 성공 ");
						return View.ADMINMENU;
					} else {
						System.out.println("입력이 실패하였습니다 ");
						System.out.println("다시 시도해주세요");
					}
				case 0:
					return View.ADMINMENU;
			}
			case 0:
				return View.ADMINMENU;
		}
		return View.ADMINMENU;
	}

	public int adminInfo() {
		String adminId= Controller.LoginAdmin.get("ADMIN_ID").toString();
		List<Object> p = new ArrayList<>();
		p.add(adminId);
				
		Map<String, Object>list = adminDao.adminInfo();
		
		System.out.println("============= 관리자 정보 =============");
		System.out.println("관리자ID\t: " + list.get("ADMIN_ID"));
		System.out.println("관리자PW\t: " + list.get("ADMIN_PW"));
		System.out.println("====================================");
		
		System.out.println("[1]정보 수정\t[2]계정 삭제\t[0]돌아가기");
		System.out.print("입력 > ");
		int input = 3;
		try {
			input = ScanUtil.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력 해주세요");
		}
		switch (input) {
			case 1: 
				System.out.println("============== 관리자 정보수정 ==============");
				System.out.print("수정할 비밀번호를 입력해주세요 > ");
				String adminpw =ScanUtil.nextLine();	
				
				int a = adminDao.updateAdminInfo(adminpw);
				
				if(0 < a){
					System.out.println("정보수정을 성공하였습니다 ");
					return View.ADMINMENU;
				}else {
					System.out.println("수정이 실패하였습니다 ");
					System.out.println("다시 시도해주세요");
					return View.ADMINMENU;
				}
			case 2: 
				System.out.println("관리자 아이디를 삭제 하시겠습니까?");
				System.out.println("[1]네\t[2]아니요");
			System.out.println("입력 > ");
				int c = ScanUtil.nextInt();
				switch(c){
				case 1:
					int b = adminDao.DeleteAdminInfo();
					if(0<b){
						System.out.println("관리자 삭제가 완료되었습니다");
						System.out.println("로그아웃하였습니다");
						return View.HOME;
					}else{
					System.out.println("삭제가 실패하였습니다");
					System.out.println("다시 시도해주세요");
					return View.ADMINMENU;
				}
			    case 2:
				    return View.ADMINMENU;
			}
			return View.LOGIN;
		case 0:
			return View.ADMINMENU;
		}
		return View.ADMINMENU;
	}

}

