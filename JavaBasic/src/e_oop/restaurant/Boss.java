package e_oop.restaurant;

import java.util.Arrays;

public class Boss {

	public static void main(String[] args) {
		Alba alba = new Alba();
		
		String[] order = alba.order();
		System.out.println(Arrays.toString(order));
		
		System.out.println("요리 만드는중 ... 완성!!");
		String[] foods = {"완성된 짜장면", "완성된 탕수육"};
		
		for(int i = 0; i < foods.length; i++){
			System.out.println(foods[i] + "이 나왔습니다.");
		}
		
		alba.serve(foods);
		
		alba.pay(order);
		
	}

}
