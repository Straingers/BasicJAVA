package e_oop;

public class ClassMaker {
	
//전역변수 하나를 선언 및 초기화 해주세요.
	int a;
	String str = "ABC";
	
//리턴타입과 피라미터가 없는 메서드 하나를 만들어주세요.
//메서드 안에서 전역변수를 출력해주세요.
	void alpa(){
		System.out.println(a);
	}
	void a(){
		System.out.println(str);
	}
	
//전역변수와 동일한 타입의 리턴타입이 있고 피라미터는 없는 메서드 하나를 만들어주세요.
//메서드 안에서 전역변수를 리턴해주세요.
	int alpa2(){
		return a;	//return : 메서드를 종료시키는 역할, 값을 넘겨주는 역할을 한다.
	}
	String b(){
		return str;
	}
	
//리턴타입은 없고 피라미터가 있는 메서드 하나를 만들어주세요.
//메서드 안에서 피라미터를 출력해주세요.
	void alpa3(int b){
		System.out.println(b);
	}
	void c(int a){
		System.out.println(a);
		return;
	}
		
//int타입의 리턴타입과 int타입의 피라미터 두개가 있는 메서드 하나를 만들어주세요.
//메서드 안에서 두 피라미터를 곱한 결과를 리턴해주세요.
	int alpa4(int c, int d){
		return c * d;
	}
	int d(int a, int b){
		return a * b;
	}
	
}











