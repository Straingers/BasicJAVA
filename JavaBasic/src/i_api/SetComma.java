package i_api;

import java.util.Scanner;

import e_oop.ScanUtil;

public class SetComma {

	public static void main(String[] args) {
		//숫자를 입력받아 입력받은 숫자에 3자리마다 콤마(,)를 붙여 입력해주세요
		//1,234,567
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요>");
		String input = sc.nextLine();
		
		String str = "";
		for (int i = input.length() - 1 ; i >= 0; i--) {
			str += input.charAt(input.length() - i - 1);
			if(i % 3 == 0){
				str += ",";
			}
		}
		System.out.println(str.substring(0, str.length() - 1));
		
		
		//선생님답
		String number = ScanUtil.nextLine();
		String number2 = "";
		
		int count = 0;
		for (int i = number.length() - 1; i >=  0; i--) {
			number2 = number.charAt(i) + number2;
			count++;
			if(count % 3 == 0 && count != number.length()){
				number2 = "," + number2;
			}
		}
		System.out.println(number2);
		
	}

}









