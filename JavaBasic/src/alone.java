import java.util.Arrays;



public class alone {

	public static void main(String[] args) {
		
		
		
//4-14
		/*int answer = (int)(Math.random() * 100) + 1;
		int input = 0;
		int count = 0;
		System.out.println(answer);
		
		Scanner s = new Scanner(System.in);
		do{
			count++;
			System.out.print("1과 100사이의 값을 입력하세요 : ");
			input = Integer.parseInt(s.nextLine());
			if(input < answer){
				System.out.println("더 큰수를 입력하세요.");
			}else if(input > answer){
				System.out.println("더 작은 수를 입력하세요.");
			}else{
				System.out.println(count + "번 만의 정답!");
				break;
			}
		}while(true);*/
		
//4-15
		/*int number = 12321;
		int tmp = number;
		
		int result = 0;
		
		while(tmp != 0){
			result = result * 10 + tmp % 10;
			
			tmp /= 10;
			
		}
		if(number == result)
			System.out.println(number + "는 회문수입니다.");
		else
			System.out.println(number + "는 회문수가 아닙니다.");*/
		
//5-3
		/*int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
		}
		
		System.out.println("sum = " + sum);*/
		
//5-4
		/*int[][]arr = {
				{5, 5, 5, 5, 5},
				{10, 10, 10, 10, 10},
				{20, 20, 20, 20, 20},
				{30, 30, 30, 30, 30}
		};
		int total = 0;
		float average = 0;
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				total += arr[i][j];
			}
		}average = (float)total / (arr.length * arr[0].length);
		
		System.out.println("total = " + total);
		System.out.println("average = " + average);*/

//5-5
		/*int[] ballArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] ball3 = new int[3];
		for(int i = 0; i < ballArr.length; i++){
			int j = (int)(Math.random() * ballArr.length);
			int tmp = 0;
			tmp = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = tmp;
		}
		System.arraycopy(ballArr, 0,  ball3, 0, 3);
		
		for(int i = 0; i < ball3.length; i++){
			System.out.print(ball3[i]);
		}
	}*/
		
		
//4-5
		/*for(int x = 0; x <= 10; x++){
			for(int y = 0; y <= 10; y++){
				if(2 * x + 4 * y == 10){
					System.out.println("x = " + x + " y = " + y);
				}
			}
		}*/
		
//4-6
		/*int x = 1;
		int y = 20;
		long z = 1L;
		for(int i = x; i < y+1; i++){
			z *= i;
		}
		System.out.println(z);*/
		
		
//4-7 
		/*int hap = 0;
		for(int i = 1; i <= 10; i++){
			for(int j = 0; j < i+1; j++){
				hap += j;
			}
		}
		System.out.println(hap);	*/
		
//4-8
		/*int hap = 0;
		int x = 1;
		int num = 0;
		for(int i = 1; hap < 100; i++, x = -x){
			num = i * x;
			hap += num;
		}
		System.out.println(num);*/

//4-9
		/*int input = 53263;
		int num = 0;
		while(input > 0){
			num += input % 10;
			input /= 10;
		}System.out.println(num);*/
		
//4-10
		/*int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		int cnt = 2;
		for(int i = 1; cnt < 10; i++){
			num3 = num1 + num2;
			num2 = num1;
			num1 = num3;
			cnt++;
		}
		System.out.print(cnt + "번째 수는 " + num3);*/
		
//4-11
		/*String value = "12o34";
		char ch = ' ';
		boolean isNumber = true;
		
		for(int i = 0; i < value.length(); i++){
			ch = value.charAt(i);
			
			if(!('0' <= ch && ch <= '9')){
				isNumber = false;
				break;
			}
		}
		if(isNumber){
			System.out.println(value + "는 숫자입니다.");
		}else{
			System.out.println(value + "는 숫자가 아닙니다.");
		}*/
		
//배열 2-25
		/*int[] score = new int[5];
		for(int i = 0; i < score.length; i++){
			for(int j = 0; j < i; j++){
				score[i] += 10;
			}
			System.out.println(score[i]);
		}*/
		
//배열 2-26
		/*int[] score = new int[7];
		int sum = 0;
		int len = score.length;
		int max = score[0];
		int min = score[0];
		
		for(int i = 0; i < score.length; i++){
			score[i] = (int)(Math.random() * 101);
			sum += score[i];

			if(max < score[i]){
				max = score[i];
			}
			if(min > score[i]){
				min = score[i];
			}
		}
		System.out.println(Arrays.toString(score));
		System.out.println(sum);
		System.out.println(Math.round(sum / len * 100 + 0.5) / 100.0);
		System.out.println("최댓값 : " + max + " / 최솟값 : " + min);*/
		
//정렬 2-27
		/*int[] arr = new int[]{5, 2, 3, 1, 4};
		
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < arr.length - i; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					System.out.println(Arrays.toString(arr));
				}
			}
		}*/
	
		
//프로그래머스 같은 숫자는 싫어
//		int[] arr = {1,1,3,3,0,1,1};
//		int cnt = 0;
//		int[] temp = new int[arr.length];
//		for(int i = 0; i < arr.length - 1; i++){
//			for(int j = i; j < i+2; j++){
//				if(arr[i] != arr[j]){
//					temp[cnt++] = arr[i];
//				}
//			}temp[cnt] = arr[arr.length-1];
//			
//		}
//		int[] result = new int[cnt+1];
//		for(int i = 0; i < result.length; i++){
//			result[i] = temp[i];
//		}
//		System.out.println(Arrays.toString(result));
		
//프로그래머스 두개 뽑아서 더하기		
//		int[] numbers = {2, 1, 3, 4, 1};
//		int[] numbers = {5, 0, 2, 7, 0};
//		
//        int[] temp = new int[numbers.length * (numbers.length - 1)];
//        int cnt = 0;
//        for(int i = 0; i < temp.length - 1; i++){
//            for(int j = i+1; j < numbers.length; j++){
//            	temp[cnt++] = numbers[i] + numbers[j];
//            }
//        }
//        System.out.println(Arrays.toString(temp));
//        
//        int[] temp2 = new int[temp.length];
//		  int cnt2 = 0;
//        for(int i = 0; i < temp.length; i++){
//        	boolean flag = false;
//        	for(int j = 0; j < temp2.length; j++){
//        		if(temp[i] == temp2[j]){
//        			flag = true;
//        		}
//        	}if(!flag){
//        		temp2[cnt2++] = temp[i];
//        	}
//        }
//        System.out.println(Arrays.toString(temp2));
//        Arrays.sort(numbers);
//        if(numbers[0] == 0 && numbers[1] == 0){
//        	cnt2++;
//        }
//        int[] result = new int[cnt2];
//        
//        for(int i = 0; i < result.length; i++){
//        	result[i] = temp2[i];
//        }
//        System.out.println(Arrays.toString(result));
//        Arrays.sort(result);
//        System.out.println(Arrays.toString(result));  
		
		
//프로그래머스 k번째수
//		int[] arrays = {1, 5, 2, 6, 3, 7, 4};
//		int[][] commands = { {2, 5, 3}, {4, 4, 1}, {1, 7, 3} };
//				
//		for(int i = 0; i < commands.length; i++){
//			int[] temp = new int [commands[i][2]];
//			for(int j = 0; j < commands[i].length; j++){
//				temp[i] = arrays[commands[i][j]];
//			}
//		}
//		System.out.println(Arrays.toString(temp));
		
		
//프로그래머스 두 정수 사이의 합
//		int a = -3;
//		int b = 2;
//		long answer = 0;
//		if(a > b){
//			int temp = a;
//			a = b;
//			b = temp;
//		}
//		for(int i = a; i <= b; i++){
//			answer += i;
//			if(a == b){
//				answer = a;
//			}		
//		}
//		System.out.println(answer);
		
		
//프로그래머스 2016년
//		int a = 5;
//		int b = 24;
//		int sum = 0;
//		
//		String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", 
//						"THU"};
//		int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//		
//		int c = month[a-1] - b;
//		
//		for(int i = 0; i < a; i++){
//			 sum += month[i];
//		}
//		
//		String result = week[(sum-c) % 7 - 1];
//		System.out.println(result);
		
		
		
//		int[] arr = {4, 3, 2, 1};
//		int cnt = 0;
//        if(arr.length == 1){
//            int[] result = {-1};
//        }
//        int[] temp = new int [arr.length * (arr.length - 1)];
//        for(int i = 0; i < arr.length ; i++){
//            boolean flag = false;
//            for(int j = 0; j < arr.length; j++){
//                if(arr[i] == temp[j])
//                    flag = true;
//            }
//            if(!flag){
//                temp[cnt++] = arr[i];
//            }
//        }
//        int[] result = new int [cnt];
//        for(int i = 0; i < result.length; i++){
//            result[i] = temp[i];
//        }
//		System.out.println(Arrays.toString(result));


//프로그래머스 체육복
//		int n = 5;
//		int[] lost = {2, 4};
//		int[] reserve = {1, 3, 5}; //return = 5;
		
//		int[] lost = {2, 4};
//		int[] reserve = {3}; //return = 4;
		
//		int[] lost = {3};
//		int[] reserve = {1}; //return = 2;
		
//		int answer = 0;
//		int[] stu = new int [n];
//		for(int j = 0; j < reserve.length; j++){
//			stu[reserve[j] - 1] += 1;
//			}
//		for(int k = 0; k < lost.length; k++){
//			stu[lost[k] - 1] -= 1;
//			}
//		for(int i = 0; i < n; i++){
//			stu[i]++;
//		}
//		for(int i = 0; i < n-1; i++){
//			for(int j = i+1; j < i + 2; j++){
//				if(stu[i] == 2 && stu[j] == 0){
//					stu[i] -= 1;
//					stu[j] += 1;
//				}
//				
//				else if(stu[i] == 0 && stu[j] == 2){
//					stu[i] += 1;
//					stu[j] -= 1;
//				}
//			}
//		}
//		for(int i = 0; i < n; i++){
//			if(stu[i] >= 1){
//				answer++;
//			}
//		}
//		System.out.println(answer);
		
		
// 교재 연습문제 5-9
//		char[][] star = {
//				{'*', '*', ' ', ' ', ' '},
//				{'*', '*', ' ', ' ', ' '},
//				{'*', '*', '*', '*', '*'},
//				{'*', '*', '*', '*', '*'}
//		};
//		char[][] result = new char[star[0].length][star.length];
//		
//		for(int i = 0; i < star.length; i++){
//			for(int j = 0; j < star[i].length; j++){
//				System.out.print(star[i][j]);
//			}System.out.println();
//		}
//
//		for(int i = 0; i < star.length; i++){
//			for(int j = 0; j < star[i].length; j++){
//				result[j][i] = star[3 - i][j];
//			}
//		}
//		
//		for(int i = 0; i < result.length; i++){
//			for(int j = 0; j < result[i].length; j++){
//				System.out.print(result[i][j]);
//			}System.out.println();
//		}
	
	

		
		
	}
}




