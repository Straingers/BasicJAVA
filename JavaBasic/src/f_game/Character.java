package f_game;

public class Character {
	
	String name;	//이름
	int maxHp;		//최대 체력
	int maxMp;		//최대 마나
	int hp;			//체력
	int mp;			//마나
	int att;		//공격력
	int def;		//방어력
	int level;		//레벨
	int maxExp;		//최대경험치
	int exp;		//경험치
	Item[] items;	//보유 아이템
	int money;      //돈
	
	//캐릭터 정보 1
	Character(String name, int hp, int mp, int att, int def){
		this.name = name;
		this.maxHp = hp;
		this.maxMp = mp;
		this.hp = this.maxHp;
		this.mp = this.maxMp;
		this.att = att;
		this.def = def;
		this.level = 1;
		this.maxExp = 100;
		this.exp = exp;
		this.items = new Item[20];
		this.money = money;
	}
	
	//캐릭터 정보 2
	void showInfo(){
		System.out.println("===============================");
		System.out.println("------------- 상태 -------------");
		System.out.println("이름 : " + name);
		System.out.println("레벨 : " + level + "(" + exp + "/" + maxExp + ")");
		System.out.println("체력 : " + hp + "/" + maxHp);
		System.out.println("마나 : " + mp + "/" + maxMp);
		System.out.println("공격 : " + att);
		System.out.println("방어 : " + def);
		System.out.println("------------- 돈 -------------");
		System.out.println(money + "원");	
		System.out.println("------------ 아이템 ------------");
		for (int i = 0; i < items.length; i++) {
			if(items[i] != null){
				System.out.println(items[i].itemInfo());
			}	
		}
		System.out.println("===============================");
	}
	
	//공격
	void attack(Monster m){
		int damage = att - m.def;
		damage = damage <= 0 ? 1 : damage;
		m.hp = m.hp < damage ? m.hp - m.hp : m.hp - damage;
		System.out.println(name + "가 공격으로 " + m.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
		System.out.println(m.name + "의 남은 HP : " + m.hp);
	}
	
	//경험치 획득
	void getExp(int exp){
		System.out.println(exp + "의 경험치를 획득하였습니다.");
		this.exp += exp;
		while(maxExp <= this.exp){
			this.exp -= maxExp;
			levelUp();
			
		}
	}
	//돈 획득
	void getMoney(int money){
		System.out.println(money + "원을 획득하였습니다.");
		this.money += money;
	}
	
	//물약 사용
	void useHeal(){
		for(int i = 0; i < items.length; i++){
			if(items[i].name.equals("체력 물약")){
				hp += items[i].heal;
				System.out.println("체력을 " + 50 + " 회복했습니다.");
			}else{
				System.out.println("물약이 없습니다.");
			}
		}
		if(hp > maxHp) hp = maxHp;
		for(int i = 0; i < items.length; i++){
			if(items[i].name.equals("체력 물약")){
				items[i] = null;
				break;
			}
		}
	}
	
	//레벨업
	void levelUp(){
		level++;
		maxHp += 10;
		maxMp += 5;
		maxExp += 100;
		att += 2;
		def += 2;
		hp = maxHp;
		mp = maxMp;
		System.out.println("LEVEL UP!!");
	}
	
	//아이템 획득
	void getItem(Item item){
		System.out.println(item.name + "을 획득하였습니다.");
		for(int i = 0; i < items.length; i++){
			if(items[i] == null){
				items[i] = item;
				break;
			}
		}
		maxHp += item.hp;
		maxMp += item.mp;
		att += item.att;
		def += item.def;
	}
	
}
