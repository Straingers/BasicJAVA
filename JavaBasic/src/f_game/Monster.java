package f_game;

public class Monster {
	
	//몬스터 정보 1
	String name;	//이름
	int maxHp;		//최대 체력
	int maxMp;		//최대 마나
	int hp;			//체력
	int mp;			//마나
	int att;		//공격력
	int def;		//방어력
	int exp;		//몬스터가 주는 경험치
	Item[] items;	//보유 아이템
	int money;      //주는 돈
	
	//몬스터 정보 2
	Monster(String name, int hp, int mp, int att, int def, int exp, Item[] items, int money){
		this.name = name;
		this.maxHp = hp;
		this.maxMp = mp;
		this.hp = this.maxHp;
		this.mp = this.maxMp;
		this.att = att;
		this.def = def;
		this.exp = exp;
		this.items = items;
		this.money = money;
	}
	
	//공격
	void attack(Character c){
		int damage = att - c.def;
		damage = damage <= 0 ? 1 : damage;
		c.hp = c.hp < damage ? c.hp - c.hp : c.hp - damage;
		System.out.println(name + "가 공격으로 " + c.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
		System.out.println(c.name + "의 남은 HP : " + c.hp);
	}
	
	//몬스터가 떨어뜨리는 아이템
	Item itemDrop(){
		return items[(int)(Math.random() * items.length)];
		
	}
	
	
	
}
