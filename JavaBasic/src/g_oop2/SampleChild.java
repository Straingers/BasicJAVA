package g_oop2;

public class SampleChild extends SampleParent {
	
	void childMethod(){
		//상속받은 변수와 메서드를 사용할 수 있다.
		System.out.println(var); //상속받은 변수
		System.out.println(method(7, 13)); //상속받은 메서드
	}
	
	//오버라이딩
	//super, super()
	//다형성
	
	//오버라이딩 : 상속받은 메서드의 내용을 재정의 하는 것.
	@Override //어노테이션 : 클래스, 변수, 메서드 등에 표시해 놓는 것.
	int method(int a, int b){ //리턴타입 메서드명 피라미터 모두 같아야 한다.
		return a * b;
	}
	
	//super, super()
	int var;
	
	void test(double var){
		System.out.println(var); //지역변수
		System.out.println(this.var); //인스턴스 변수
		System.out.println(super.var); //부모 클래스의 인스턴스 변수
		//super : 부모 클래스의 멤버와 자식 클래스의 멤버가 이름이 중복될 때 둘을 구분하기 위해 사용한다.
		System.out.println(this.method(10, 20));
		System.out.println(super.method(10, 20));
	}
	
	SampleChild(){
		super(); //부모 클래스의 생성자 호출
		//super()를 통해 생성자를 호출하고 부모클래스의 인스턴스 변수도 초기화한다.
		//super()가 없으면 컴파일러가 자동으로 super()를 넣어준다.
	}
	
	//다형성
	public static void main(String[] args) {
		SampleChild sc = new SampleChild();
		SampleParent sp = new SampleChild();
//		SampleParent sp = new SampleChild2();
//		SampleParent sp = new SampleChild3();
		//부모타입의 변수로 자식타입의 객체를 사용하는 것이 다형성이다.
		
		//부모와 자식간에는 서로 형변환이 가능하다.
		sc = (SampleChild)sp;
		sp = (SampleParent)sc; //sp = sc;
		//자식타입 -> 부모타입 형변환은 생략 할 수 있다.  //부모 -> 자식 = 생략 불가
		
	    SampleChild sc2 = (SampleChild)new SampleParent();
	    //SampleParent는 2개의 멤버를 가지고 있다.
		//SampleChild는 5개의 멤버를 가지고 있다.
		//SampleChild 타입의 변수는 5개의 멤버를 사용할 수 있어야 하는데
		//SampleParent 객체는 2개의 멤버만 가지고 있다.
		//그러므로 부모타입의 객체를 자식타입으로 형변환 하는것은 에러를 발생시킨다.
	    
	    //SampleParent 타입의 변수로는
	    //SampleChild 객체를 가지고도 2개의 멤버만 사용할 수 있다.
	    sp = sc; //형변환 생략 가능
	    System.out.println(sp.var);
	    System.out.println(sp.method(10, 20));
//	    sp.childMethod();  //사용불가
//	    sp.test();	//사용불가
	}

}
