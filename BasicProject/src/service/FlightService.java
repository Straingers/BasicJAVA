package service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.View;
import dao.FlightDao;
import dao.ReservationDao;

public class FlightService {
	
	private FlightService(){}
	private static FlightService instance;
	public static FlightService getInstance(){
		if(instance == null){
			instance = new FlightService();
		}
		return instance;
	}
	
	private FlightDao flightDao = FlightDao.getInstance();
	private ReservationDao reservationDao = ReservationDao.getInstance();
	private SeatService seatService = SeatService.getInstance();
	
	public int ResFlight(){
		List<Map<String,Object>> flightList = flightDao.FlightList();
		for(int i = 0; i < flightList.size(); i++){
			Map<String,Object> flight = flightList.get(i);
			System.out.println("[" + (i + 1) + "] " + flight.get("PORT_NAME"));
		}
		System.out.println("=============================");
		System.out.print("출발공항을 입력하시오 > ");
		int dept = 0;
		try {
			dept = ScanUtil.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력 해주세요");
		}
		System.out.println("=============================");
		System.out.print("도착공항을 입력하시오 > ");
		int arri = 0;
		try {
			arri = ScanUtil.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력 해주세요");
		}
		
		System.out.println("==================================== 항공편 LIST ========================================");
		System.out.println("항공편번호\t비행기번호\t출발공항\t도착공항\t퍼스트\t비즈니스"
				+ "\t이코노미\t출발시간\t도착시간");
		System.out.println("----------------------------------------------------------------------------------");
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
			return View.USERMENU;
		}else{
			System.out.println("----------------------------------------------------------------------------------");
			System.out.print("예약하실 항공편 번호를 입력하시오 > ");
			int input = 0;
			try {
				input = ScanUtil.nextInt();
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력 해주세요");
			}
			Map<String, Object> restemp = selectflightList.get(input - 1);
			System.out.println("출발시간\t : " + restemp.get("DEPT_TIME")
					+ "\n도착시간\t : " + restemp.get("ARRI_TIME")
					+ "\n퍼스트\t : " + restemp.get("FLIGHT_COST1")
					+ "\n비즈니스\t : " + restemp.get("FLIGHT_COST2")
					+ "\n이코노미\t : " + restemp.get("FLIGHT_COST3"));
			System.out.println("----------------------------------------------");
			System.out.println("[1]금액선택\t[0]돌아가기");
			System.out.print("입력 > ");
			int input2 = 0;
			try {
				input2 = ScanUtil.nextInt();
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력 해주세요");
			}
			switch (input2) {
				case 1: 
					System.out.println("==================== 금액선택 =====================");
					System.out.println("[1]퍼스트 :" + restemp.get("FLIGHT_COST1"));
					System.out.println("[2]비즈니스 :" + restemp.get("FLIGHT_COST2"));
					System.out.println("[3]이코노미 :" + restemp.get("FLIGHT_COST3"));
					System.out.println("=================================================");
					System.out.print("입력 > ");
					int money = 0;
					try {
						money = ScanUtil.nextInt();
					} catch (Exception e) {
						System.out.println("잘못된 입력입니다.");
						System.out.println("다시 입력 해주세요");
					}
					Map<String, Object> tempmoney = reservationDao.moneyCheck();
					switch (money) {
						case 1: if (((BigDecimal)tempmoney.get("MEM_MONEY")).intValue() < ((BigDecimal)restemp.get("FLIGHT_COST1")).intValue()){
									System.out.println("잔액이 부족합니다."); break;
								} else {
									reservationDao.insertReservatioin(restemp.get("FLIGHT_CODE")
											, restemp.get("FLIGHT_COST1"));
									return seatService.selectSeat(restemp.get("FLIGHT_CODE"), "F"); 
								}
						case 2: if (((BigDecimal)tempmoney.get("MEM_MONEY")).intValue() < ((BigDecimal)restemp.get("FLIGHT_COST2")).intValue()){
									System.out.println("잔액이 부족합니다."); break;
								} else {
									reservationDao.insertReservatioin(restemp.get("FLIGHT_CODE")
											, restemp.get("FLIGHT_COST2")); 
									return seatService.selectSeat(restemp.get("FLIGHT_CODE"), "B");
								}
						case 3: if (((BigDecimal)tempmoney.get("MEM_MONEY")).intValue() < ((BigDecimal)restemp.get("FLIGHT_COST3")).intValue()){
									System.out.println("잔액이 부족합니다."); break;
								} else {
									reservationDao.insertReservatioin(restemp.get("FLIGHT_CODE")
											, restemp.get("FLIGHT_COST3")); 
									return seatService.selectSeat(restemp.get("FLIGHT_CODE"), "E");
								}
					}
				case 0: 
					return View.USERMENU;
			}	
		}	
		return View.USERMENU;
	}
	
}
