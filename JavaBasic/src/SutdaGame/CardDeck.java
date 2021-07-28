package SutdaGame;

import e_oop.ScanUtil;

public class CardDeck {
	Jokbo jokbo = new Jokbo(); //족보 클래스 불러오기
	Card[] card = new Card[20];
	Card[] playerDeck = new Card [2];
	Card[] comDeck = new Card [2];
	int userMoney = 1000000;
	int comMoney = 1000000;
	int batMoney;


	//한단어 한단어 출력하는 메서드
    void slowPrint(String a){
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++){
            System.out.print(chars[i]);
            try {
            	Thread.sleep(130);
            }
            catch (InterruptedException e){
            }
        }
    }
    
	//한줄 한줄 출력하는 메서드
    void slowPrint2(String a){
        for (int i = 0; i < 1; i++){
            System.out.println(a);
            try {
            	Thread.sleep(1000);
            }
            catch (InterruptedException e){
            }
        }
    }
    
    //덱
	class Card{
		int num;
		boolean gwang;

		Card(int num, boolean gwang){
			this.num = num;
			this.gwang = gwang;
		}
		public String toString() {
			return num + (gwang ? "광" : "");
			
		}
	}
	//1광, 3광, 8광 생성
	CardDeck(){
		for (int i = 0; i < 20; i++) {
			if (i == 0 || i == 2 || i == 7) {
				card[i] = new Card(i + 1, true);
			}
			else {
				card[i] = new Card(i % 10 + 1, false);
			}
		}
	}
	
	//유저, 컴퓨터 덱
	void userCard(){
		Card a[] = new Card [4];
		for(int i = 0; i < a.length; i++){
			while(a[i] == null){
				int b = (int)(Math.random() * card.length);
				a[i] = card[b];
				card[b] = null;
			}
		}
		playerDeck[0] = a[0];
		playerDeck[1] = a[2];
		comDeck[0] = a[1];
		comDeck[1] = a[3];	
	}
	
	
	//게임 시작
	void start(){
		while(true){
			System.out.println("----------------------------------");		
			System.out.println("\t\t섯다");
			System.out.println("----------------------------------");		
			System.out.println("[1] 게임 시작");
			System.out.println("[2] 게임 설명");
			System.out.println("[3] 게임 종료");
			System.out.println("----------------------------------");		
			
			int input = ScanUtil.nextInt();
			userCard();	//카드 셔플
			switch(input){
			case 1 :
				slowPrint2("게임을 시작합니다!");
				slowPrint2("----------------------------------\n|\tG A M E  S T A R T\t|\n----------------------------------");
				userMoney -= 50000;
				comMoney -= 50000;
				batMoney += 100000;
				firstShuffle();
				return;
			case 2:
				while(true){
					System.out.println("--------------게임설명--------------");
					System.out.println("상대방보다 족보가 높으면 승리하는 게임입니다.");
					System.out.println("시드는 1,000,000원 입니다.");
					System.out.println("시작 배팅금액은 50,000원 입니다");
					System.out.println("꼭 승리하세요~");
					System.out.println("[1] 게임시작");
					System.out.println("[2] 돌아가기");
					System.out.println("----------------------------------");
					int input2 = ScanUtil.nextInt();
					switch(input2){
					case 1:
						userMoney -= 50000;
						comMoney -= 50000;
						batMoney += 100000;
						slowPrint2("----------------------------------\n------------게임 START-------------\n----------------------------------");
						firstShuffle();
						return;
					case 2:
						start();
						return;
					default:
					    System.out.println("잘못된 입력입니다.");
					}
				}
			case 3 :
				System.out.println("이용해주셔서 감사합니다.");
				System.out.println("게임을 종료합니다.");
				System.out.println("----------------------------------");
				System.exit(0);
				return;
			default:
				System.out.println("잘못된 접근입니다.");
				System.out.println("----------------------------------");
			}
		}
		
	}
	
	//재시작 메서드
	void Restart(){
		while(true){
			System.out.println("다시 시작하시겠습니까?");
			System.out.println("[1] 네");
			System.out.println("[2] 아니오");
			System.out.println("----------------------------------");
			int input = ScanUtil.nextInt();
			switch(input){
			case 1:
				userCard(); //재시작시 재 셔플
				slowPrint2("----------------------------------");
				slowPrint2("새로 시작! 50000원 배팅!");
				slowPrint2("----------------------------------");
				userMoney -= 50000;
				comMoney -= 50000;
				batMoney += 100000;
				firstShuffle();
				return;
			case 2:
				start();
				return;
			case 3:
				System.out.println("잘못된 접근입니다.");
			}
		}
	}
	
	//첫번째 셔플
	void firstShuffle(){
		while(true){
			slowPrint2("첫번째 셔플!");
			slowPrint2("나의 패 : " + playerDeck[0]);
			slowPrint2("----------------------------------");
			System.out.println("배팅 하시겠습니까?");
			System.out.println("[1] 배팅");
			System.out.println("[2] 다이");
			System.out.println("잔액 : " + userMoney);
			System.out.println("----------------------------------");
			
			int input = ScanUtil.nextInt();
			switch(input){
			case 1:
				call1();
				return;
			case 2:
				die1();
				return;
			default:
				System.out.println("잘못된 접근입니다.");
				
			}
		}
	}
	
	//첫번째 배팅
	void call1(){
		while(true){
			System.out.println("----------------------------------");
			System.out.println("얼마를 배팅하시겠습니까?");
			System.out.println("[1] 10,000원");
			System.out.println("[2] 50,000원");
			System.out.println("[3] 100,000원");
			System.out.println("[4] Die");
			System.out.println("----------------------------------");
			
			int input = ScanUtil.nextInt();
			switch(input){
			case 1:
				if(userMoney < 10000){
					System.out.println("----------------------------------");
					System.out.println("금액이 부족합니다.");
					System.out.println("잔액 : " + userMoney);
					System.out.println("----------------------------------");
				}
				batMoney += 20000;
				userMoney -= 10000;
				comMoney -= 10000;
				SecondShuffle();
				return;
			case 2:
				if(userMoney < 50000){
					System.out.println("----------------------------------");
					System.out.println("금액이 부족합니다.");
					System.out.println("잔액 : " + userMoney);
					System.out.println("----------------------------------");
				}
				batMoney += 100000;
				userMoney -= 50000;
				comMoney -= 50000;
				SecondShuffle();
				return;
			case 3:
				if(userMoney < 100000){
					System.out.println("----------------------------------");
					System.out.println("금액이 부족합니다.");
					System.out.println("잔액 : " + userMoney);
					System.out.println("----------------------------------");
				}
				batMoney += 200000;
				userMoney -= 100000;
				comMoney -= 100000;
				SecondShuffle();
				return;
			case 4:
				slowPrint2("다이!");
				die1();
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				}
			}
		}
		
	//첫번째 다이
	void die1(){
		slowPrint2("패배하였습니다.ㅠㅠ");
		System.out.println("----------------------------------");
		slowPrint("나의 패 : " + playerDeck[0]);
		System.out.println();
		slowPrint("상대방의 패 : " + comDeck[0]);
		System.out.println();
		comMoney += batMoney;
		batMoney = 0;
		System.out.println("----------------------------------");
		slowPrint("나의 잔액 : " + userMoney + "원");
		System.out.println();
		slowPrint("상대 잔액 : " + comMoney + "원");
		System.out.println();
		System.out.println("----------------------------------");
		if(userMoney < 0){
	    	slowPrint2("파산하였습니다.");
	    	slowPrint2("과도한 도박은 건강에 해롭습니다.");
	    	slowPrint2("게임을 종료합니다.");
	    	slowPrint2("----------------------------------");
			System.exit(0);
	    }
		if(comMoney <= 0){
			slowPrint2("승리하였습니다.");
			slowPrint2("하지만 과도한 도박은 건강에 해롭습니다.");
			slowPrint("인생사 공수레 공수거!");
			System.out.println();
			slowPrint2("게임을 종료합니다.");
			slowPrint2("----------------------------------");
	    	System.exit(0);	    	
	    }
		Restart();
	}
	
	//두번째 셔플
	void SecondShuffle(){
		while(true){
		slowPrint2("두번째 셔플!");
		slowPrint2("두번째 패 : " + playerDeck[1]);
		slowPrint2("나의 패 : "+ playerDeck[0] + ", " +playerDeck[1] + " (" + jokbo.jokboShow(playerDeck[0], playerDeck[1]) + ")");
		slowPrint2("----------------------------------");
		System.out.println("배팅 하시겠습니까?");
		System.out.println("[1] 배팅");
		System.out.println("[2] 다이");
		System.out.println("잔액 : " + userMoney + "원");
		System.out.println("----------------------------------");
		int input = ScanUtil.nextInt();
		switch(input){
		case 1:
			call2();
			return;
		case 2:
			die2();
			return;
		}
		}
	}

	//두번째 배팅
	void call2(){
		while(true){
			System.out.println("----------------------------------");
			System.out.println("얼마를 배팅하시겠습니까?");
			System.out.println("[1] 10,000원");
			System.out.println("[2] 50,000원");
			System.out.println("[3] 100,000원");
			System.out.println("[4] ALL IN");
			System.out.println("[5] Die");
			System.out.println("----------------------------------");
			int input = ScanUtil.nextInt();
			switch(input){
			case 1:
				if(userMoney < 10000){
					System.out.println("----------------------------------");
					System.out.println("금액이 부족합니다.");
					System.out.println("잔액 : " + userMoney + "원");
					System.out.println("----------------------------------");
				}
				batMoney += 20000;
				userMoney -= 10000;
				comMoney -= 10000;
				Result();
				return;
			case 2:
				if(userMoney < 50000){
					System.out.println("----------------------------------");
					System.out.println("금액이 부족합니다.");
					System.out.println("잔액 : " + userMoney + "원");
					System.out.println("----------------------------------");
				}
				batMoney += 100000;
				userMoney -= 50000;
				comMoney -= 50000;
				Result();
				return;
			case 3:
				if(userMoney < 100000){
					System.out.println("----------------------------------");
					System.out.println("금액이 부족합니다.");
					System.out.println("잔액 : " + userMoney + "원");
					System.out.println("----------------------------------");
				}
				batMoney += 200000;
				userMoney -= 100000;
				comMoney -= 100000;
				Result();
				return;
			case 4:
				slowPrint("올  ~ 인 ~ ~ !");
				System.out.println();
				batMoney += userMoney;
				batMoney += comMoney;
				userMoney = 0;
				comMoney  = 0;
				Result();
				return;
			case 5:
				slowPrint2("다이!");
				die2();
				return;
			default:
				System.out.println("잘못입력하였습니다.");
			}
		}
	}
	
	//두번째 다이
	void die2(){
		slowPrint2("패배하였습니다.ㅠㅠ");
		System.out.println("----------------------------------");
		slowPrint("나의 패 : " + playerDeck[0] + ", " + playerDeck[1] + " (" + jokbo.jokboShow(playerDeck[0], playerDeck[1]) + ")");
		System.out.println();
		slowPrint("상대방의 패 : " + comDeck[0] + ", " +comDeck[1] + " (" + jokbo.jokboShow(comDeck[0], comDeck[1]) + ")");
		System.out.println();
		comMoney += batMoney;
		batMoney = 0;
		slowPrint("나의 잔액 : " + userMoney + "원");
		System.out.println();
		slowPrint("상대 잔액 : " + comMoney + "원");
		System.out.println();
		if(userMoney <= 0){
			slowPrint2("파산하였습니다.");
			slowPrint2("과도한 도박은 건강에 해롭습니다.");
			slowPrint2("게임을 종료합니다.");
			slowPrint2("----------------------------------");
			System.exit(0);
	    }
		if(comMoney <= 0){
			slowPrint2("승리하였습니다.");
			slowPrint2("하지만 과도한 도박은 건강에 해롭습니다.");
			slowPrint("인생사 공수레 공수거!");
			System.out.println();
			slowPrint2("게임을 종료합니다.");
			slowPrint2("Bye~ Bye~");
			slowPrint2("----------------------------------");
	    	System.exit(0);	    	
	    }
		Restart();
		return;
	}
	
	//대결 결과
	void Result(){
		int playerScore = jokbo.rank(playerDeck[0], playerDeck[1]);
		int comScore = jokbo.rank(comDeck[0], comDeck[1]);
		
		slowPrint("- - - - 결 과 는 ? - - - -");
		System.out.println();
		slowPrint("- - - 짜 라 란 ~ 짜 라 란 ~ - - -");
		System.out.println();
		slowPrint("- - - 쿵 짝 짝 ~ 쿵 짝 짝 ~ - - -");
		System.out.println();

		//승리!
	    if(playerScore > comScore){
	    	slowPrint("나의 패 : " + playerDeck[0] + ", " + playerDeck[1] + " (" + jokbo.jokboShow(playerDeck[0], playerDeck[1]) + ")");
	    	System.out.println();
			slowPrint("상대방의 패 : " + comDeck[0] + ", " +comDeck[1] + " (" + jokbo.jokboShow(comDeck[0], comDeck[1]) + ")");
			System.out.println();
			slowPrint2("축하합니다! 승리하였습니다!!!");
			userMoney += batMoney;
			batMoney = 0;
			slowPrint2("----------------------------------");
			slowPrint2("나의 잔액 : " + userMoney + "원");
			slowPrint2("상대 잔액 : " + comMoney + "원");
			slowPrint2("----------------------------------");
			if(comMoney <= 0){
				slowPrint2("상대를 파산시켰습니다~");
				slowPrint2("하지만 과도한 도박은 건강에 해롭습니다.");
				slowPrint("인생사 공수레 공수거!");
				System.out.println();
				slowPrint2("게임을 종료합니다.");
				slowPrint2("----------------------------------");
		    	System.exit(0);	    	
		    }
			Restart();
	    }
	    //무승부
	    else if(playerScore == comScore){
	    	slowPrint("나의 패 : " + playerDeck[0] + ", " + playerDeck[1] + " (" + jokbo.jokboShow(playerDeck[0], playerDeck[1]) + ")");
			System.out.println();
	    	slowPrint("상대방의 패 : " + comDeck[0] + ", " +comDeck[1] + " (" + jokbo.jokboShow(comDeck[0], comDeck[1]) + ")");
			System.out.println();
	    	slowPrint("아쉽지만 무승부입니다.");
	    	System.out.println();
	    	slowPrint2("----------------------------------");
			slowPrint2("나의 잔액 : " + userMoney + "원");
			slowPrint2("상대 잔액 : " + comMoney + "원");
			slowPrint2("배팅 금액 : " + batMoney + "원");
			slowPrint2("----------------------------------");
			Restart();
	    }
	    //패배
	    else if(playerScore < comScore){
	    	slowPrint("나의 패 : " + playerDeck[0] + ", " + playerDeck[1] + " (" + jokbo.jokboShow(playerDeck[0], playerDeck[1]) + ")");
			System.out.println();
	    	slowPrint("상대방의 패 : " + comDeck[0] + ", " +comDeck[1] + " (" + jokbo.jokboShow(comDeck[0], comDeck[1]) + ")");
			System.out.println();
	    	slowPrint("아이고...패배하였습니다ㅠㅜ");
			System.out.println();
			comMoney += batMoney;
			batMoney = 0;
			slowPrint2("----------------------------------");
			slowPrint2("나의 잔액 : " + userMoney + "원");
			slowPrint2("상대 잔액 : " + comMoney + "원");
			slowPrint2("----------------------------------");
			if(userMoney <= 0){
				slowPrint2("파산하였습니다.");
				slowPrint2("과도한 도박은 삶에 악영향을 끼칩니다.");
				slowPrint2("게임을 종료합니다.");
				slowPrint2("수고링~");
				slowPrint2("----------------------------------");
				System.exit(0);
			}
			Restart();
		
	    }
		
	}
	
	//족보
	class Jokbo{
		String rank1 = "3 8 광 땡";
		String rank2 = "1 8 광 땡";
		String rank3 = "1 3 광 땡";
		String rank4 = " 땡";
		String rank5 = "알 리";
		String rank6 = "독 사";
		String rank7 = "구 삥";
		String rank8 = "장 삥";
		String rank9 = "장 사";
		String rank10 = "세 륙";
		String rank11 = "갑 오 (9끗)";
		String rank12 = " 끗";
		String rank13 = "망 통 (0끗)";
		
		//승패여부
		int rank(Card a, Card b){
			int rankScore = 0;
			
			if(a.num == 3 && b.num == 8 && a.gwang == true && b.gwang == true) rankScore = 100;
			else if(a.num == 8 && b.num == 3 && a.gwang == true && b.gwang == true) rankScore = 100;
			else if(a.num == 1 && b.num == 8 && a.gwang == true && b.gwang == true) rankScore = 95;
			else if(a.num == 8 && b.num == 1 && a.gwang == true && b.gwang == true) rankScore = 95;
			else if(a.num == 1 && b.num == 3 && a.gwang == true && b.gwang == true) rankScore = 90;
			else if(a.num == 3 && b.num == 1 && a.gwang == true && b.gwang == true) rankScore = 90;
			else if(a.num == b.num){
				if(a.num == 10) rankScore = 87;
				else if(a.num == 9) rankScore = 85;
				else if(a.num == 8) rankScore = 80;
				else if(a.num == 7) rankScore = 79;
				else if(a.num == 6) rankScore = 78;
				else if(a.num == 5) rankScore = 77;
				else if(a.num == 4) rankScore = 76;
				else if(a.num == 3) rankScore = 75;
				else if(a.num == 2) rankScore = 74;
				else if(a.num == 1) rankScore = 73;
			}
			else if(a.num == 1 && b.num == 2 || a.num == 2 && b.num == 1) rankScore = 70;
			else if(a.num == 1 && b.num == 4 || a.num == 4 && b.num == 1) rankScore = 65;
			else if(a.num == 9 && b.num == 1 || a.num == 1 && b.num == 9) rankScore = 60;
			else if(a.num == 10 && b.num == 1 || a.num == 10 && b.num == 1) rankScore = 55;
			else if(a.num == 10 && b.num == 4 || a.num == 4 && b.num == 10) rankScore = 50;
			else if(a.num == 4 && b.num == 6 || a.num == 6 && b.num == 4) rankScore = 45;
			else if(a.num + b.num == 9)  rankScore = 40;
			else if(a.num + b.num > 10){
				if(a.num + b.num - 10 == 9) rankScore = 39;
				else if(a.num + b.num - 10 == 8) rankScore = 38;
				else if(a.num + b.num - 10 == 7) rankScore = 37;
				else if(a.num + b.num - 10 == 6) rankScore = 36;
				else if(a.num + b.num - 10 == 5) rankScore = 35;
				else if(a.num + b.num - 10 == 4) rankScore = 34;
				else if(a.num + b.num - 10 == 3) rankScore = 33;
				else if(a.num + b.num - 10 == 2) rankScore = 32;
				else if(a.num + b.num - 10 == 1) rankScore = 31;
			}
			else if(a.num + b.num < 10){
				if(a.num + b.num == 9) rankScore = 39;
				else if(a.num + b.num == 8) rankScore = 38;
				else if(a.num + b.num == 7) rankScore = 37;
				else if(a.num + b.num == 6) rankScore = 36;
				else if(a.num + b.num == 5) rankScore = 35;
				else if(a.num + b.num == 4) rankScore = 34;
				else if(a.num + b.num == 3) rankScore = 33;
				else if(a.num + b.num == 2) rankScore = 32;
				else if(a.num + b.num == 1) rankScore = 31;
			}
			else if(a.num + b.num == 0) rankScore = 20;
			return rankScore;
		}
		
		//카드패에 족보 입력
		String jokboShow(Card a, Card b){
			String result = null;
			
			if(a.num == 3 && b.num == 8 && a.gwang == true && b.gwang == true) result = rank1;
			else if(a.num == 8 && b.num == 3 && a.gwang == true && b.gwang == true) result = rank1;
			else if(a.num == 1 && b.num == 8 && a.gwang == true && b.gwang == true) result = rank2; 
			else if(a.num == 8 && b.num == 1 && a.gwang == true && b.gwang == true) result = rank2; 
			else if(a.num == 1 && b.num == 3 && a.gwang == true && b.gwang == true) result = rank3; 
			else if(a.num == 3 && b.num == 1 && a.gwang == true && b.gwang == true) result = rank3; 
			else if(a.num == b.num) result = a.num + rank4;
			else if(a.num == 1 && b.num == 2 || a.num == 2 && b.num == 1) result = rank5; 
			else if(a.num == 1 && b.num == 4 || a.num == 4 && b.num == 1) result = rank6; 
			else if(a.num == 9 && b.num == 1 || a.num == 1 && b.num == 9) result = rank7; 
			else if(a.num == 10 && b.num == 1 || a.num == 10 && b.num == 1) result = rank8; 
			else if(a.num == 10 && b.num == 4 || a.num == 4 && b.num == 10) result = rank9;
			else if(a.num == 4 && b.num == 6 || a.num == 6 && b.num == 4) result = rank10; 
			else if(a.num + b.num == 9) result = rank11;
			else if(a.num + b.num > 10) result = (a.num + b.num - 10) + rank12;
			else if(a.num + b.num < 10) result = (a.num + b.num) + rank12;
			else if(a.num + b.num == 0 || a.num + b.num == 10) result = rank13;
			return result;
		}

		}
		
	}





