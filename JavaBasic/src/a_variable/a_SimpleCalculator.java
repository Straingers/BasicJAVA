package a_variable;

import java.util.Scanner;

public class a_SimpleCalculator {

	public static void main(String[] args) {
		//다음과 같은 프로그램을 작성해주세요.
				/*
				 * ======== 회원가입 ========
				 * 아이디>admin
				 * 비밀번호(4자리숫자)>1234
				 * 이름>홍길동
				 * 나이>99세
				 * 키>185.5cm
				 * ========================
				 * 아이디 : admin
				 * 비밀번호 : 1234
				 * 이름 : 홍길동
				 * 나이 : 99세
				 * 키 : 185.5cm
				 * ========================
				 */
		
		Scanner sc = new Scanner(System.in);
		
		String id;
		System.out.println("ID >");
		id = sc.nextLine();
		
		int pw;
		System.out.println("PW >");
		pw = Integer.parseInt(sc.nextLine());
		
		String name;
		System.out.println("이름 >");
		name = sc.nextLine();
		
		int age;
		System.out.println("나이 >");
		age = Integer.parseInt(sc.nextLine());
		
		Double height;
		System.out.println("키 >");
		height = Double.parseDouble(sc.nextLine());
		
		System.out.println("======== 회원가입 ========");
		System.out.println("아이디> " + id);
		System.out.println("비밀번호(4자리숫자)> " + pw);
		System.out.println("이름> " + name);
		System.out.println("나이> " + age);
		System.out.println("키> " + height + "cm");
		System.out.println("========================");
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + height + "cm");
		System.out.println("========================");
	}

}
