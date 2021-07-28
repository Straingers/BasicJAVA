package e_oop;

public class OOP {

	public static void main(String[] args) {
/*
 * 객체지향 프로그래밍(Object Oriented Programming)
 * - 프로그래밍을 단순히 코드의 연속으로 보는것이 아니라 객체간의 상호작용으로 보는 것.
 * - 코드의 재사용성이 높고 유지보수가 용이하다.
 */
		SampleClass sc = new SampleClass();
		
//		System.out.println(sc.field);
		
//		sc.method1();
		
		String returnValue = sc.method2(10);
//		System.out.println(returnValue);
		
//		sc.flowTest1();
		
		//ClassMaker에서 만든 클래스의 객체를 생성하고 변수에 저장해주세요.
		//객체가 저장된 변수를 통해 메서드를 호출 해주세요.
		//피라미터가 있는 메서드는 타입에 맞는 값을 넘겨주시고, 
		//리턴타입이 있는 메서드는 리턴받은 값을 출력해주세요. 
		ClassMaker s = new ClassMaker();
		
//		System.out.println(s.a);
//		s.alpa();
//		s.a();
//		
//		System.out.println(s.alpa2());
//		System.out.println(s.b());
//		
//		s.alpa3(5);
//		s.c(10);
//		
//		System.out.println(s.alpa4(10, 20));
//		System.out.println(s.d(20, 30));
		
		
		
		//다음을 한줄씩 계산해서 최종 결과값을 출력해주세요.
		//1. 123456 + 654321
		//2. 1번의 결과값 * 123456
		//3. 2번의 결과값 / 123456
		//4. 3번의 결과값 - 654321
		//5. 4번의 결과값 % 123456
		
//		Calculator num = new Calculator();
//		
//		System.out.println(num.hap(123456, 654321));
//		double result = num.hap(123456, 654321);
//		
//		System.out.println(num.gob(result, 123456));
//		result = num.gob(result, 123456);
//		
//		System.out.println(num.slash(result, 123456));
//		result = num.slash(result, 123456);
//		
//		System.out.println(num.cha(result, 654321));
//		result = num.cha(result, 654321);
//		
//		System.out.println(num.per(result, 123456));
//		result = num.per(result, 123456);
		
			
	}

}
