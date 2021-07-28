package f_game;

public class Item {

	String name;	//이름
	int hp;			//체력
	int mp;			//마나
	int att;		//공격력
	int def;		//방어력
	int heal;		//체력회복
	int price;      //아이템 가격
	
	//아이템 정보
	Item(String name, int hp, int mp, int att, int def, int heal, int price){
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.att = att;
		this.def = def;
		this.heal = heal;
		this.price = price;
	}
	
	//아이템 정보 상세
	String itemInfo(){
		String info = name + " :";
		if(0 < hp) info += " 체력+" + hp + " / 가격 : " + price;
		if(0 < mp) info += " 마나+" + mp + " / 가격 : " + price;
		if(0 < att) info += " 공격+" + att + " / 가격 : " + price;
		if(0 < def) info += " 방어+" + def + " / 가격 : " + price;
		if(0 < heal) info += " HP " + heal + "만큼 회복" + "/ 가격 : " + price;
		return info;
	}
	
	
	
	
	
}
