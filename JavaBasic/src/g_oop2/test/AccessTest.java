package g_oop2.test;

import g_oop2.AccessModifier;

public class AccessTest extends AccessModifier {

	public static void main(String[] args) {
		
		AccessModifier am = new AccessModifier();
		
		System.out.println(am.publicVar);
		am.publicMethod();
		
//		System.out.println(am.protectedVar); //다른 패키지에서는 사용 불가
//		am.protectedMethod();				 
//		
		AccessTest at = new AccessTest();
		
		System.out.println(at.protectedVar);  //상속 받고 그 클래스변수로 만들어서 사용
		at.protectedMethod();					
		
//		System.out.println(am.defaultVar);	//다른 패키지에서는 사용 불가
//		am.defaultMethod();
//		
//		System.out.println(am.privateVar);  //다른 클래스에서는 사용 불가
//		am.privateMethod();
		
		
		
	}

}
