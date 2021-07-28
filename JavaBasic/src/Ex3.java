
public class Ex3 {
	public static void main(String[] args) {
		Child ci = new Child();
		
		ci.volume = 15;
		ci.volumeUp();
		System.out.println(ci.volume);
		
		ci.channel = 3;
		ci.channelUp();
		System.out.println(ci.channel);
		
		}
	}
	class Child extends Parent{
		int volume;
		void volumeUp(){
			volume++;
		}
	}
	class Parent{
		int channel;
		void channelUp(){
			channel++;
		}
	}

