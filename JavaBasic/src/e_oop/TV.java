package e_oop;

import java.util.Scanner;

public class TV {

	//과제. TV를 대상으로 클래스를 만들어주세요.
	//숫자 입력 메서드, 전원 메서드, 메뉴, 채널 조절 메서드, 채널 up 메서드, 채널 down 메서드, 볼륨 조절 메서드, 볼륨 up 메서드, 볼륨 down 메서드
	
	//숫자 입력 메서드//
	int intIn(){
		Scanner sc = new Scanner(System.in);
		int result = Integer.parseInt(sc.nextLine());
		return result;
	}
	
	
	//전원 메서드//
	void power(){
		while(true){
			System.out.println("번호를 입력해주세요.");
			System.out.println("[1] 전원 ON");
			System.out.println("[2] 전원 OFF");
			int a = intIn();
			if(a == 1){
				System.out.println("전원이 켜졌습니다.");	
				System.out.println();
				menu();
				break;
			}
			else if(a == 2){
				System.out.println("전원이 꺼졌습니다.");
				System.out.println();
				break;
			}
			else{
				System.out.println("잘못 입력하셨습니다.");
				System.out.println();
			}
			
		}
	}
	

	//메뉴//
	void menu(){
		while(true){
			System.out.println("번호를 입력해주세요.");
			System.out.println("[1] 채널 입력");
			System.out.println("[2] 채널 조절");
			System.out.println("[3] 볼륨 조절");
			System.out.println("[4] 전원 OFF");
			int a = intIn();
			if(a == 1){
				System.out.println("이동할 채널을 입력해주세요.");
				int b = intIn();
				chNumber = b;
				System.out.println(chNumber + "번 채널로 이동하였습니다.");
				System.out.println();
			}else if(a == 2){
				channelCon();
			}else if(a == 3){
				volCon();
			}else if(a == 4){
				System.out.println("전원이 꺼졌습니다.");
				break;
			}
			else{
				System.out.println("잘못 입력하셨습니다.");
				System.out.println();
			}
			
		}
	}
	

	//채널 조절//
	int chNumber;
	
	void channelCon(){
		while(true){
			System.out.println("번호를 입력해주세요.");
			System.out.println("[1] 채널UP");
			System.out.println("[2] 채널DUWN");
			int a = intIn();
			if(a == 1){
				channelUp();
				return;
			}else if(a == 2){
				channelDown();
				return;
			}else{
				System.out.println("잘못 입력하셨습니다.");
				System.out.println();
			}
		}
	}
	
	void channelUp(){
		chNumber++;
		System.out.println(chNumber + "번 채널로 이동하였습니다.");
		System.out.println();
		return;
	}
	void channelDown(){
		chNumber--;
		System.out.println(chNumber + "번 채널로 이동하였습니다.");
		System.out.println();
		return;
	}

	//볼륨 조절//
	int volNumber = 5;
	
	final int MinVol = 0;
	final int MaxVol = 10;
	
	void volCon(){
		while(true){
			System.out.println("번호를 입력해주세요.");
			System.out.println("[1] 볼륨 UP");
			System.out.println("[2] 볼륨 DUWN");
			int a = intIn();
			if(a == 1){
				volUp();	
				break;
			}else if(a == 2){
				volDown();
				break;
			}else{
				System.out.println("잘못 입력하였습니다.");
				System.out.println();
			}
		}
	}
	void volUp(){
		volNumber++;
		System.out.print("음량 : ");
		for(int i = MinVol + 1; i < MaxVol + 1; i++){
			if(i < volNumber){
				System.out.print("■");
			}else{
				System.out.print("□");
			}
		}
		System.out.println();
		System.out.println();
		return;
	}
	void volDown(){
		volNumber--;
		System.out.print("음량  : ");
		for(int i = MinVol + 1; i < MaxVol + 1; i++){
			if(i < volNumber){
				System.out.print("■");
			}else{
				System.out.print("□");
			}
		}
		System.out.println();
		System.out.println();
		return;
	}
	
	public static void main(String[] args) {

		TV tv = new TV();
		tv.power();
		
	}

	
}








