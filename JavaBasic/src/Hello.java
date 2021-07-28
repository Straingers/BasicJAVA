import java.util.Scanner;


public class Hello {
	public static void main(String[] args) {
			
		//반올림
		/*double a = 3.141592;
		double result = (int)(a * 1000 + 0.5) / (double)1000;
		
		System.out.println(result);*/
	
	
		//임의의 정수 뽑기
		/*int random = (int)(Math.random() * 10 + 1); // 0 ~ 10 사이의 임의의 값
		
		System.out.println(random);*/
		
		
		/*Scanner sc = new Scanner(System.in);
		String word = sc.nextLine(); //sc.next()
		int number = Integer.parseInt(sc.nextLine()); //sc.nextInt()*/
		
		
		//교재 46p 3-4 연습문제
		/*int apples = 121;
		int bucket = 10;
		int numOfBucket = (apples + 9) / bucket;
		System.out.println("필요한 바구니의 수 : " + numOfBucket);*/
		
		
		//교재 46p 3-5 연습문제
		/*int num = 111;
		int result = (num / 100) * 100;
		System.out.println(result);*/
		
		
		//교재 47p 3-7 연습문제
		/*int num = 1;
		int result = (num + 10) / 10 * 10 - num;
		System.out.println("result = " + result);*/
		
		
		//교재 47p 3-8 연습문제
		//'C = 5 / 9 * (F - 32)
		/*int fahrenheit = 100;
		float formula = 5f / 9f * (fahrenheit - 32f);
		float celcius = (int)(formula * 1000 + 0.5) / 1000F;
		System.out.println("Fahrenheit : " + fahrenheit);
		System.out.println("Celcius : " + celcius);*/
		
		
		//7초과 57미만에서 2 또는 3의 배수인 정수의 합을 구하여라.
		/*int res1 = 0;
		int res2 = 0;
		
		for(int i = 8 ; i < 57 ; i++){
			if(i % 2 == 0 || i % 3 == 0){
			res1 += i;
			}
		}
		System.out.println(res1);*/
		
		//구구단
//		for(int i = 2 ; i < 10 ; i++){
//			for(int j = 1 ; j < 10 ; j++){
//				System.out.println(i + " X " + j + " = " + i*j);
//			}
//		}
		
//		for(int i = 0 ; i < 8 ; i++){
//			for(int j = 0 ; j < 7-i ; j++){
//				System.out.print(" ");
//			}
//			for(int j = 0 ; j < 2*i-1 ; j++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		

	
	}
	
	
	

}