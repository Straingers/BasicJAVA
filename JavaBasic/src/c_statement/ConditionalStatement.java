package c_statement;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
/*
 * 조건문
 * - if문
 * - switch문
 * 
 * if문
 * - if(조건식){} : 조건식의 결과가 true이면 블럭안의 문장을 수행한다.
 * - else if(조건식){} : 다수의 조건이 필요할때 if 뒤에 추가한다.
 * - else{} : 결과가 true인 조건식이 하나도 없는 경우를 위해 추가한다.
 */
		
		int a = 1;
		
		if(a == 1){
//			System.out.println("조건식의 결과가 true이면 수행된다.");
		}		
		
		if(a == 0){
			System.out.println("조건식의 결과가 false이면 수행되지 않는다.");
		}
		
		if(a == 1){
//			System.out.println("a가 1인 경우에 하고싶은 것");
		}else if(a == 2){
			System.out.println("a가 2인 경우에 하고싶은 것");
		}else if(a == 3){
			System.out.println("a가 3인 경우에 하고싶은 것");
		}else{
//			System.out.println("이외의 경우에 하고싶은 것");
		}
		
		//조건을 한묶음으로 사용하기 위해서는 반드시 else if를 사용해야 한다.
		if(a < 10){
//			System.out.println("a는 10보다 작다.");
		}else if(a < 20){
//			System.out.println("a는 20보다 작다.");
		}
		
		//시험점수가 60점 이상이면 합격 그렇지 않으면 불합격
		int score = 70;
		
		if(score >= 60){
//			System.out.println("합격!");
		}else{
//			System.out.println("불합격ㅠ");
		}
		
		//성적에 등급을 부여하는 프로그램을 만들어봅시다.
		score = 80;
		String grade = null;
		
		if(90 <= score && score <= 100){
			grade = "A";
		}else if (80 <= score && score < 90){
			grade = "B";
		}else if (70 <= score){
			grade = "C";
		}else if (60 <= score){
			grade = "D";
		}else{
			grade = "F";
		}
//		System.out.println(score + "점에 해당하는 등급은 " + grade + " 입니다.");
		
		score = 100;
		grade = null;

		if (90 <= score) {
			grade = "A";
			if (97 <= score) {
				grade += "+";
			} else if (score <= 93) {
				grade += "-";
			}
		} else if (80 <= score && score < 90) {
			grade = "B";
			if (87 <= score) {
				grade += "+";
			} else if (score <= 83) {
				grade += "-";
			}
		} else if (70 <= score) {
			grade = "C";
			if (77 <= score) {
				grade += "+";
			} else if (score <= 73) {
				grade += "-";
			}
		} else if (60 <= score) {
			grade = "D";
			if (67 <= score) {
				grade += "+";
			} else if (score <= 63) {
				grade += "-";
			}
		} else {
			grade = "F";
		}
//		System.out.println(score + "점에 해당하는 등급은 " + grade + "입니다.");
		
		
/*
 * switch문
 * - switch(int/String){case 1: break;}
 * - 조건식의 결과는 정수와 문자열만 (JDK1.7부터 문자열 허용) 허용한다.
 * - 조건식과 일치하는 case문 이후의 문장을 수행한다.
 */
		a = 2;
		switch(a){
		case 1:
			System.out.println("a가 1인 경우에 하고싶은 것");
			break;
		case 2:
//			System.out.println("a가 2인 경우에 하고싶은 것");
			break;
		default: //if문의 else와 같은 역할
			System.out.println("이외의 경우에 하고싶은 것");
		}
		
		String b = "a";
		switch(b){
		case "a" :	
//			System.out.println("b가 \"a\"인 경우에 하고싶은 것"); // \" : 문자열 안에 ""를 넣고싶을 때 사용
			break;
		case "b":
//			System.out.println("b가 \"b\"인 경우에 하고싶은 것");
			break;
		default:
//			System.out.println("이외의 경우에 하고싶은것");
		}
		
		//주어진 월에 해당하는 계절을 출력해봅시다.
		int month = 1;
		String season = null;
		switch(month){
		case 3: 
		case 4: 
		case 5:
			season = "봄";
			break;
		case 6: case 7: case 8:
			season = "여름";
			break;
		case 9: case 10: case 11:
			season = "가을";
			break;
		case 12: case 1 : case 2 :
			season = "겨울";
			break;
		}
//		System.out.println(month + "월은 " + season + "입니다.");
		
		
		score = 100;
		grade = null;
		switch(score / 10){
		case 9 : case 10 : grade = "A"; break;
		case 8 : grade = "B"; break;
		case 7 : grade = "C"; break;
		case 6 : grade = "D"; break;
		default: grade = "F";
		}
//		System.out.println(score + "점에 해당하는 등급은 " + grade + " 입니다.");
		
		
		//숫자를 입력받아 그 숫자가 0인지 0이 아닌지 출력해주세요.
		Scanner s = new Scanner(System.in);
		
//		System.out.println("숫자를 입력해주세요>");
//		int num = Integer.parseInt(s.nextLine());
//		
//		if(num == 0){
//			grade = "입력하신 숫자는 0 입니다.";
//		}
//		else{
//			grade = "입력하신 숫자는 0이 아닙니다.";
//		}
//		System.out.println(grade);
//		
//		switch(num){
//		case 0 : grade = "0 입니다.";
//		default: grade = "0 아닙니다.";
//		}
//		System.out.println(grade);
		
		
		//숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력해주세요.
//		System.out.println("숫자를 입력해주세요 >");
//		int num1 = Integer.parseInt(s.nextLine());
//		String good = null;
//		
//		if(num1 % 2 == 1){
//			good = "홀수";
//		}else{
//			good = "짝수";
//		}
//		System.out.println("입력한 숫자는 " + good + "입니다.");
		
		
		//점수 3개를 입력받아 총점, 평균, 등급을 출력해주세요.
		//평균은 소수점 1자리까지
//		System.out.println("점수 1>");
//		int num1 = Integer.parseInt(s.nextLine());
//		System.out.println("점수 2>");
//		int num2 = Integer.parseInt(s.nextLine());
//		System.out.println("점수 3>");
//		int num3 = Integer.parseInt(s.nextLine());
//		
//		int sum = num1 + num2 + num3;
//		float avg = (int)((sum / 3F) * 10 + 0.5) / 10F ; //double avg = Math.round(sum / 3.0 * 10) / 10.0;
//		grade = null;
//		
//		if(avg >= 90 && avg <= 100){
//			grade = "A";
//		}else if(avg >= 80 && avg < 90){
//			grade = "B";
//		}else if(avg >= 70){
//			grade = "C";
//		}else if(avg >= 60){
//			grade = "D";
//		}else{
//			grade = "F";
//		}
//		
//		System.out.println("총점 : " + sum + " / 평균 : " + avg + " / 등급 : " + grade);
		
		
		//랜덤 발생
		//Math.round() : 0.0 ~ 1.0미만의 랜덤수 발생
//		int random = (int)(Math.random() * 100) + 1; //0과 100 사이의 임의의 정수 == 1 ~ 100
//		System.out.println(random);
		
		
		//1 ~ 100사이의 랜덤한 수를 3개 발생시키고 오름차순으로 출력해주세요.
		int num1 = (int)(Math.random() * 100) + 1;
		int num2 = (int)(Math.random() * 100) + 1;
		int num3 = (int)(Math.random() * 100) + 1;
		System.out.println("1번숫자 : " + num1 + " / 2번숫자 : " + num2 + " / 3번숫자 : " + num3);
		
//		int fst = 0;
//		int sec = 0;
//		int thr = 0;
//		
//		if(num1 < num2 && num1 < num3){
//			fst += num1;
//			if(num2 < num3){
//				sec = num2;
//				thr = num3;
//			}else{
//				sec = num3;
//				thr = num2;
//			}
//		}else if(num2 < num1 && num2 < num3){
//			fst += num2;
//			if (num1 < num3){
//				sec = num1;
//				thr = num3;
//			}else{
//				sec = num3;
//				thr = num1;
//			}
//			
//		}else if(num3 < num1 && num3 < num2){
//			fst = num3;
//			if(num1 < num2){
//				sec = num1;
//				thr = num2;
//			}else{
//				sec = num2;
//				thr = num1;
//			}
//		}
//		
//		System.out.println(fst + " / " + sec + " / " + thr);
		
		//선생님 답
//		if (num1 > num2){
//			int temp = num1;
//			num1 = num2;
//			num2 = temp;
//		}
//		if(num1 > num3){
//			int temp = num2;
//			num1 = num3;
//			num3 = temp;
//		}
//		if(num2 > num3){
//			int temp = num1;
//			num2 = num3;
//			num3 = temp;
//		}
//		System.out.println(num1 + " < " + num2 + " < " + num3);
		
	}
		
}
