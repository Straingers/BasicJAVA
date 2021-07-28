package c_statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		/*
		 * 숫자 야구 프로그램을 작성하시오.
		 * 1 3 5
		 * 1 2 3 : 1S 1B 1O
		 * 5 3 1 : 1S 2B 0O
		 * 3 2 1 : 0S 2B 1O
		 */
		
		Scanner s = new Scanner(System.in);	
        
		int a = 0;                                                                          
		int b = 0;                                                                          
		int c = 0;                                                                          
		
		int num1 = (int)(Math.random() * 9) + 1;
		int num2 = (int)(Math.random() * 9) + 1;
		while(num2 == num1){num2 = (int)(Math.random() * 9) + 1;}
		int num3 = (int)(Math.random() * 9) + 1;
		while(num3 == num1 || num3 == num2){num3 = (int)(Math.random() * 9) + 1;}
		System.out.println(num1 + "번 / " + num2 + "번 / " + num3 + "번");	
		                                                                                    
		boolean start = true;
		
		while(start){
			System.out.println("첫번째 숫자>");
			int ans1 = Integer.parseInt(s.nextLine());
			System.out.println("두번째 숫자>");
			int ans2 = Integer.parseInt(s.nextLine());
			System.out.println("세번째 숫자>");
			int ans3 = Integer.parseInt(s.nextLine());
			
			if(ans1 == num1){a++;}
			else if (ans1 == num2 || ans1 == num3){b++;}
			else{c++;}
			
			if(ans2 == num2){a++;}
			else if(ans2 == num1 || ans2 == num3){b++;}
			else{c++;}
			
			if(ans3 == num3){a++;}
			else if(ans3 == num1 || ans3 == num2){b++;}
			else{c++;}
			
			if(ans1 == num1 && ans2 == num2 && ans3 == num3){start = false;}
			System.out.println(a + "S " + b + "B " + c + "O");
			a = 0;
			b = 0;
			c = 0;
		}System.out.println("정답입니다!");
		
		//선생님 답
		int a1 = 0;
		int a2 = 0;
		int a3 = 0;
		
		do{
			a1 = (int)(Math.random()* 9) + 1;
			a2 = (int)(Math.random()* 9) + 1;
			a3 = (int)(Math.random()* 9) + 1;
		}while(a1 == a2 || a1 == a3 || a2 == a3);
		
		int count = 0;
		while(true){
			System.out.print("3자리 숫자>");
			int input = Integer.parseInt(s.nextLine());
			int i3 = input % 10;
			input /= 10;
			int i2 = input % 10;
			input /= 10;
			int i1 = input % 10;
			
			int strike = 0;
			int ball = 0;
			int out = 0;
			
			if(a1 == i1) strike++;
			if(a2 == i2) strike++;
			if(a3 == i3) strike++;
			
			if(a1 == i2 || a1 == i3) ball++;
			if(a2 == i1 || a2 == i3) ball++;
			if(a3 == i1 || a3 == i2) ball++;
			
			out = 3 - strike - ball;
			
			System.out.println(++count + "차 시도(" + i1 + i2 + i3 + ") : " 
					+ strike + "S " + ball + "B " + out + "O");
			System.out.println("--------------------");
			if(strike == 3){
				System.out.println("정답입니다!");
				break;
			}
		}
	}
}