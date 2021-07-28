package service;

import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.View;
import dao.BackpackDao;
import dao.ReservationDao;
import dao.SeatDao;

public class SeatService {
	private SeatService() {}
	private static SeatService instance;
	public static SeatService getInstance() {
		if (instance == null) {
			instance = new SeatService();
		}
		return instance;
	}

	private SeatDao seatDao = SeatDao.getInstance();
	private BackpackDao backpackDao = BackpackDao.getInstance();
	private ReservationDao resveration = ReservationDao.getInstance();
	
	public int selectSeat (Object flight_code, String check){
			
		List<Map<String, Object>> selectseat = seatDao.selectSeatList(flight_code, check);
		int chec = 0;
		for(int j = 1; j < 8; j++){
			System.out.print(j + "\t");
		}
		System.out.println();
		System.out.println("--------------------------------------------------");
		Map<String ,Object> sseat = selectseat.get(0);
		List<Map<String,Object >> seatview = seatDao.reseatcheck(sseat.get("비행기"), check);
		for (int i = 0; i < seatview.size(); i++) {
			Map<String,Object> realview = seatview.get(i);
			if(check.equals("E")){
				if(i == 7){
					System.out.println();
					System.out.println();
					System.out.println("8\t9\t10\t11\t12\t13\t14");
					System.out.println("--------------------------------------------------");
				} else if(i == 14){
					System.out.println();
					System.out.println();
					System.out.println("15\t16\t17\t18\t19\t20\t21");
					System.out.println("--------------------------------------------------");
				}
				if(Integer.parseInt(String.valueOf(realview.get("확인"))) >= 1){
					System.out.print("●\t");
				}else if(Integer.parseInt(String.valueOf(realview.get("확인"))) == 0){
					System.out.print("○\t");
				}
			}
			else{
				if(Integer.parseInt(String.valueOf(realview.get("확인"))) >= 1){
					System.out.print("●\t");
				}else if(Integer.parseInt(String.valueOf(realview.get("확인"))) == 0){
					System.out.print("○\t");
				}
			}
		}
		chec=1;
		System.out.println();
		System.out.println("원하시는 자리를 선택해 주세요");
		System.out.print("입력 > ");
		int a = 0;
		try {
			a = ScanUtil.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력 해주세요");
		}
		Map<String,Object> realview = seatview.get(a - 1);
		if(Integer.parseInt(String.valueOf(realview.get("확인"))) >= 1){
			System.out.println("이미 예매된 좌석입니다.");
			System.out.println("다시 시도해 주세요");
			return selectSeat(flight_code, check);
		}
		
		if(chec == 0){
			System.out.println("자리를 잘못 입력하셨습니다");
			System.out.println("다시 예매해 주세요");
			return View.USERMENU;
		} else {
			seatDao.InsertSeatList(selectseat.get(a - 1).get("SEAT_REAL"), flight_code);
			System.out.println("수하물이 있으십니까?");
			System.out.println("[1]YES\t[2]NO");
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
					System.out.println("===============================");
					System.out.println("무게\t\t가격");
					System.out.println("-------------------------------");
					System.out.println("[1]30Kg 이하 / 50,000원");
					System.out.println("[2]20Kg 이하 / 30,000원");
					System.out.println("[3]10Kg 이하 / 무료");
					System.out.println("[0]돌아가기");
					System.out.println("===============================");
					System.out.print("입력 > ");
				    int bagKg = 8;
				    try {
						bagKg = ScanUtil.nextInt();
					} catch (Exception e) {
						System.out.println("잘못된 입력입니다.");
						System.out.println("다시 입력 해주세요");
					}
				    int view = View.USERMENU;
				    switch (bagKg) {
						case 1: 
							Map<String, Object> rs = resveration.resMoneyCheck();
							resveration.getMemMileage(Integer.valueOf((String) rs.get("RES_COST")) * 0.1);
							resveration.insertResMoney(50000, rs.get("RES_NO"));
							Map<String, Object> rsm = resveration.resMoneyCheck();
							resveration.moneyDelete(Integer.valueOf((String) rsm.get("RES_COST")));
							backpackDao.backpackInsert(rs.get("RES_NO"), "30kg 이하", 50000);
							System.out.println("예매가 완료되었습니다.");
							return view;
						case 2:
							Map<String, Object> rs2 = resveration.resMoneyCheck();
							resveration.getMemMileage(Integer.valueOf((String) rs2.get("RES_COST")) * 0.1);
							resveration.insertResMoney(30000, rs2.get("RES_NO"));
							Map<String, Object> rsm2 = resveration.resMoneyCheck();
							resveration.moneyDelete(Integer.valueOf((String) rsm2.get("RES_COST")));
							backpackDao.backpackInsert(rs2.get("RES_NO"), "20kg 이하", 30000);
							System.out.println("예매가 완료되었습니다.");
							return view;
						case 3:
							Map<String, Object> rs3 = resveration.resMoneyCheck();
							resveration.getMemMileage(Integer.valueOf((String) rs3.get("RES_COST")) * 0.1);
							resveration.insertResMoney(0, rs3.get("RES_NO"));
							Map<String, Object> rsm3 = resveration.resMoneyCheck();
							resveration.moneyDelete(Integer.valueOf((String) rsm3.get("RES_COST")));
							backpackDao.backpackInsert(rs3.get("RES_NO"), "10kg 이하", 0);
							System.out.println("예매가 완료되었습니다.");
							return view;
					}
				case 2:
					Map<String, Object> rsm = resveration.resMoneyCheck();
					resveration.getMemMileage(Integer.valueOf((String) rsm.get("RES_COST")) * 0.1);
					resveration.moneyDelete(Integer.valueOf((String) rsm.get("RES_COST")));
					backpackDao.backpackInsert(rsm.get("RES_NO"), 0, 0);
					System.out.println("예매가 완료되었습니다."); 
					return View.USERMENU;
			}
			return View.USERMENU;
		}
		
	}	

}
