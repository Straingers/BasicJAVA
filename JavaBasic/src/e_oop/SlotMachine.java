package e_oop;

import java.util.Scanner;

public class SlotMachine {
    //음료 자판기
	
	
	//숫자 입력 메서드//
	int intIn(){
		Scanner sc = new Scanner(System.in);
		int result = Integer.parseInt(sc.nextLine());
		return result;
	}
	
	//금액 투입
	int money = 0;
	
	void start(){
		System.out.println("금액을 투입해주세요.");
		int a = intIn();
		money += a;
		System.out.println("-----------------------------------------------------");
		System.out.println("현재 잔액 : " + money + "원");
		System.out.println("-----------------------------------------------------");
		menu();
	}
	
	//메뉴
	void menu(){
		while(true){
			System.out.println("                [0]금액 투입");
			System.out.println("[1]물-500원\t[2]오렌지주스-700원\t[3]커피-600원");
			System.out.println("[4]콜라-800원\t[5]사이다-800원\t\t[6]EXIT");
			System.out.println("-----------------------------------------------------");
			System.out.print("번호 입력 : ");
			int a = intIn();
			System.out.println("-----------------------------------------------------");
			switch(a){
			case 0:
				start();
			case 1:
				if(money < 500){
					moneyless();
				}else{
					money -= 500;
					System.out.println("'생수' 획득!");
					System.out.println();
					System.out.println("잔액 : " + money + "원");
					System.out.println("-----------------------------------------------------");
					break;
				}
			case 2:
				if(money < 700){
					moneyless();
				}else{
					money -= 700;
					System.out.println("'오렌지주스' 획득!");
					System.out.println();
					System.out.println("잔액 : " + money + "원");
					System.out.println("-----------------------------------------------------");
					break;
				}
			case 3:
				if(money < 600){
					moneyless();
				}else{
					money -= 600;
					System.out.println("'커피' 획득!");
					System.out.println();
					System.out.println("잔액 : " + money + "원");
					System.out.println("-----------------------------------------------------");
					break;	
				}
			case 4:
				if(money < 800){
					moneyless();
				}else{
					money -= 800;
					System.out.println("'콜라' 획득!");
					System.out.println();
					System.out.println("잔액 : " + money + "원");
					System.out.println("-----------------------------------------------------");
					break;
				}
			case 5:
				if(money < 800){
					moneyless();
				}else{
					money -= 800;
					System.out.println("'사이다' 획득!");
					System.out.println();
					System.out.println("잔액 : " + money + "원");
					System.out.println("-----------------------------------------------------");
					break;
				}
			case 6:
				System.out.println("거스름돈 : " + money + "원");
				System.out.println();
				System.out.println("이용해주셔서 감사합니다.");
				System.out.println("-----------------------------------------------------");
				System.exit(0);
			default:
				System.out.println("잘못된 입력입니다.");
				System.out.println("-----------------------------------------------------");
				
			}
			
		}
	}
	
	//잔액 부족
	void moneyless(){
		System.out.println();
		System.out.println("잔액이 부족합니다.");
		System.out.println("-----------------------------------------------------");
		System.out.println("[1]금액 투입\t[2]EXIT");
		System.out.println("-----------------------------------------------------");
		int a = intIn();
		System.out.println("-----------------------------------------------------");
		switch(a){
		case 1:
			start();
		case 2:
			System.out.println("이용해주셔서 감사합니다.");
			System.out.println("-----------------------------------------------------");
			System.exit(0);
		default:
			System.out.println("잘못된 입력입니다.");
			System.out.println("-----------------------------------------------------");
		}
		System.out.println();

	}
	
	//프로그램 시작
	public static void main(String[] args) {
		SlotMachine a = new SlotMachine();
		a.start();
	}

}





