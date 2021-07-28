package e_oop;

public class ClassMaker2 {

	//초기화 순서 : 명시적 초기화 -> 초기화블럭 -> 생성자
	
	//인스턴스변수 하나를 선언하고 명시적으로 초기화 해주세요.
	int a = 10;
	String name = "홍길동";
	
	//위에서 선언한 인스턴스변수를 초기화 블럭을 사용해 초기화 해주세요.
	{
		a = 20;
	}
	{
		name = "전재수";
	}
	//위에서 선언한 인스턴스변수를 생성자의 피라미터를 사용해 초기화 해주세요.
	ClassMaker2(int a){
		this.a = a;
	}
	ClassMaker2(String name){
		this.name = name;
	}
	//위에서 선언한 인스턴스변수를 생성자를 하나 더 만들어서 초기화 해주세요.
//	ClassMaker2(){
//		this(30);
//	}
	ClassMaker2(){
		this("생성자");
	}
	
	public static void main(String[] args) {
		ClassMaker2 cm = new ClassMaker2();
		System.out.println(cm.name);
		
		ClassMaker2 cm2 = new ClassMaker2("전재수");
		System.out.println(cm2.name);
	}
}
