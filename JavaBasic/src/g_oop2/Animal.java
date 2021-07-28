package g_oop2;

public abstract class Animal {
	
	void run(){
		System.out.println("달려간다~~");
	}
	
	abstract void sound();
	
	
}




class Dog extends Animal{

	@Override
	void sound() {
		System.out.println("멍멍");
	}
	
}

class Pig extends Animal{

	@Override
	void sound() {
		System.out.println("꾸에에에엑");
	}
	
}

class Monkey extends Animal{

	@Override
	void sound() {
		System.out.println("우끼끼우끼끼");
	}

	
}








