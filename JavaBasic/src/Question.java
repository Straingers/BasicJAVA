
public class Question {

	public static void main(String[] args) {
		//주사위 2개를 던져서 나오는 수의 합을 구하여라
		//만약 같은수가 나오면 한번 더 던진 값까지의 합을 구해라. 
		
		System.out.println(doubleDice());
	}

	static int doubleDice(){
		int firstDice = (int)(Math.random() * 6) + 1;
		int secondDice = (int)(Math.random() * 6) + 1;
		System.out.println("1번주사위 : " + firstDice + " / 2번주사위  : " + secondDice);
		int result = firstDice + secondDice;
		if(firstDice == secondDice){
			result += doubleDice();			
		}
		return result;
	}
}
