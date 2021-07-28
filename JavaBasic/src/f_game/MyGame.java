package f_game;

import e_oop.ScanUtil;

public class MyGame {
	
	//캐릭터와 아이템 설정
	Character c;
	Item[] items;
	
	MyGame(){
		c = new Character("가렌", 100, 50, 20, 10);
		
		items = new Item[10];
		items[0] = new Item("롱소드", 0, 0, 10, 0, 0, 300);
		items[1] = new Item("무한의대검", 0, 0, 20, 0, 0, 1000);
		items[2] = new Item("천갑옷", 0, 0, 0, 10, 0, 300);
		items[3] = new Item("가시갑옷", 0, 0, 0, 20, 0, 1000);
		items[4] = new Item("체력 물약", 0, 0, 0, 0, 50, 500);
	}
	
	//프로그램 시작
	public static void main(String[] args) {
		new MyGame().start();
	}
	
	//게임 시작 메서드
	void start(){
		int input = 0;
		while(true){
			System.out.println("1.내정보\t2.사냥\t3.종료");
			input = ScanUtil.nextInt();
			
			switch(input){
			case 1:
				c.showInfo();
				break;
			
			case 2:
				hunt();
				break;
			
			case 3:
				System.out.println("종료되었습니다.");
				System.exit(0);
			}
		}
	}
	
	//사냥 메서드
	void hunt(){
		Monster monster;
		Monster m = new Monster("고블린", 20, 10, 15, 10, 50, new Item[]{items[0], items[2], items[4]}, 300);
		Monster m2 = new Monster("고블린왕", 100, 30, 30, 40, 300, new Item[]{items[1], items[4], items[3]}, 1000);
		
		int a = (int)(Math.random() * 2) + 1;
		if(a == 1) monster = m;
		else monster = m2;	
		
		System.out.println(monster.name + "을(를) 만났습니다. 전투를 시작합니다.");
		
		int input = 0;
		battle : while(true){
			System.out.println("1.공격\t2.도망\t3.물약사용");
			input = ScanUtil.nextInt();
			switch(input){
			case 1:
				c.attack(monster);
				if(monster.hp <= 0){
					System.out.println(monster.name + "을(를) 처치하였습니다.");
					System.out.println();
					c.getExp(monster.exp);
					c.getMoney(monster.money);
					c.getItem(monster.itemDrop());
					System.out.println();
					break battle;
				}
				monster.attack(c);
				break;
			
			case 2:
				System.out.println(monster.name + "로부터 도망쳤습니다.");
				break battle;
			case 3:
				if(c.hp == c.maxHp){ System.out.println("체력이 가득 차있습니다."); break; }
				else{ c.useHeal(); }
			}
		}
	}

	
	
}














