package f_game;

import e_oop.ScanUtil;

public class Store {
	
	String[] weaponItem = {};
	String[] healItem = {"체력 물약", "마나 물약"};
	
	void buy(){
		System.out.println("1.장비 상점\t2.물약 상점");
		int input = ScanUtil.nextInt();
		switch(input){
		case 1 :
			for(int i = 0; i < weaponItem.length; i++){
				System.out.println(i + ". " + weaponItem[i]);
			}
		}
		
	}
	
	void sell(){
		
	}
}
