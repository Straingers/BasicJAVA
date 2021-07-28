package a_variable; //클래스의 위치

//Ctrl + Shift + o
import java.util.Scanner;

public class Variable { //클래스

	public static void main(String[] args) { //메서드 - ()가 붙은것
//메서드 : 명령문의 집합
//main메서드 : 프로그램의 시작과 끝
		
//주석 : 프로그램 코드로 인식하지 않는 문장(주로 코드를 설명하는데 사용한다.)
		
//한줄 주석 : Ctrl + Shift + c
		
/* 범위 주석 : Ctrl + Shift + /(해제 : \) */
		
//변수를 만드는 방법 : 데이터의 형태(데이터 타입) + 이름
/*
 기본형 타입
- 정수 : byte(1), short(2), *int(4), long(8)
- 실수 : float(4), *double(8)
- 문자 : char(2)
- 논리 : boolean(1) 
 */
	
		int x; //정수를 저장할 수 있는 x라는 이름을 가진 그릇을 만들어라.
		//변수를 만드는 것을 변수 선언이라고 표현한다.
		
//		double x; //블럭{}안에서 이름이 중복될 수 없다.
		double y; 
		
//=(대입연산자) : 오른쪽의 값을 왼쪽의 변수에 저장.
		x = 10; //초기화 : 변수에 처음으로 값을 저장하는 것.
		y = 3.14; //변수의 타입에 맞는 값을 저장해야한다.
				
		int abc = 30; //일반적으로 선언과 초기화를 한번에 한다.
		long l = 40L; //접미사 L을 붙여야 long타입이 된다.
		float f = 5.5f; //접미사 f를 붙여아 float타입이 된다.
		char c = '캐'; //따옴표안에 반드시 한글자를 넣어야 한다.
		boolean b = true; //true, false
		
		//8가지 기본형 타입을 사용해서 8개의 변수를 선언 및 초기화 해주세요.
		byte e = 1;
		short s = 2;
		int i = 4;
		long g = 8L;
		float t = 4.4f;
		double d = 8;
		char h = '릭';
		boolean n = false;
		
		x = 20; //기존에 저장되어 있는 10이라는 값은 사라지고 20이라는 값이 저장된다.
		y = 5.5;
		
		//위에서 만든 8개의 변수에 새로운 값을 저장해 주세요.
		e = 10;
		s = 20;
		i = 40;
		g = 80L;
		t = 40.40f;
		d = 80;
		h = '터';
		n = true;
		
		//콘솔창에 출력
		System.out.println(x); 
//실행 단축키 : Ctrl + F11
		System.out.println(100);
		
		//위에서 만든 8개의 변수의 값을 출력해주세요.
		System.out.println(e);
		System.out.println(s);
		System.out.println(i);
		System.out.println(g);
		System.out.println(t);
		System.out.println(d);
		System.out.println(h);
		System.out.println(n);
		
//문자열
		String str = "여러개의 문자..."; //클래스는 참조형 타입 데이터이다.
		System.out.println(str);
		//문자열과 다른 타입의 데이터가 결합되면 문자열의 결과를 얻는다.
		System.out.println(str + 50 + 30);
		System.out.println(50 + 30 + str);
		
//형변환
//다른 타입의 값을 저장하기 위해서는 값의 타입을 변경해 주어야 하는데 이를 형변환(type casting)이라 한다.
		int small = 10;
		long big = 10L;
		
		small = (int)big;
		big = small; //표현범위가 작은쪽에서 큰쪽으로의 형변환은 생략이 가능하다.
		
/*
 * 명명 규칙
 * - 영문자 대소문자, 한글, 숫자, 특수문자('_', '$')를 사용할 수 있다.
 * - 숫자로 시작할 수 없다.
 * - 예약어는 사용할 수 없다.
 * - [낙타식 표기법을 사용한다.(mySampleVariable)]
 * - [클래스명의 첫글자를 대문자로 한다.(MySampleClass)]
 */
		
/*상수
 * - 값을 변경할 수 없는 그릇
 * - 리터럴에 의미를 부여하기 위해 사용한다
 */
		final int MAX_NUMBER = 10;
//		MAX_NUMBER = 100; //컴파일 에러 발생
		
		//출력
		System.out.print("줄바꿈을 하지 않는다.\n"); // \n = 줄바꿈
		System.out.println("줄바꿈을\t한다."); // \t = 한탭을 띄운다
		System.out.printf("문자열 : %s, 숫자 : %d", "안녕", 10); //출력 포맷을 지정한다.
		System.out.println();
		
		//입력
		Scanner sc = new Scanner(System.in); //입력받기 위한 클래스

/*System.out.println("아무거나 입력해주세요 > ");
String str2 = sc.nextLine(); //sc.nextLine() = 문자를 입력할 수 있다.
System.out.println("입력받은 내용 : " + str2);
//입력을 받게되면 사용자가 입력할 때까지 프로그램이 멈추게 된다.
//내용을 입력후 엔터를 치면 입력이 종료되고 프로그램이 다시 진행된다.
*/		

/*System.out.println("int 입력> ");
int nextInt = sc.nextInt(); //sc.nextInt = int타입으로 받을 수 있다. ==> 얘네가 버그가 있어 사용 안하는 것 추천
System.out.println(nextInt); // 그래서 문자열로 받은 다음에 int타입으로 변경.

		System.out.println("문자열 입력> ");
		String nextLine = sc.nextLine();
		System.out.println(nextLine);
		System.out.println("입력 끝!");*/
		
//숫자입력
/*System.out.println("int 입력>");
int number = Integer.parseInt(sc.nextLine());
System.out.println(number);*/
		
		//자신의 이름을 저장할 변수를 선언해 주세요.
		/*String name;
		
		//위에서 선한한 변수를 초기화 하기 위해 이름을 입력받아주세요.
		System.out.println("이름을 입력해 주세요>");
		name = sc.nextLine();
		
		//자신의 나이를 저장할 변수를 선언해주세요.
		int age;
		
		//위에서 선언한 변수를 초기화 하기 위해 나이를 입력받아 주세요
		System.out.println("나이를 입력해 주세요>");
		age = Integer.parseInt(sc.nextLine());
		Double.pareDouble(sc.nextLine());
		
		System.out.println("이름 : " + name + " / 나이 : " + age);*/
		
		
	}

}




















