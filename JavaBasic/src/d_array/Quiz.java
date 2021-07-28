package d_array;

import java.util.Arrays;

public class Quiz {

	public static void main(String[] args) {
		
/*
 * 거스름돈에 동전의 단위마다 몇개의 동전이 필요한지 출력해주세요.
 * 
 * ex) 거스름돈 : 2800원
 * 		500원 : 5개
 * 		100원 : 3개
 * 		50원 : 1개
 * 		10원 : 1개
 */
//		int money = (int)(Math.random() * 500) * 10;
//		int[] coin = {500, 100, 50, 10};
//		
//		System.out.println("거스름돈 : " + money);
		
//		int[] coin2 = new int[5];
//		
//		for(int i = 0; i < coin.length; i++){
//			coin2[i] = money / coin[i];
//			money -= coin[i] * coin2[i];
//			System.out.println(coin[i] + "원 : " + coin2[i] + "개");
//		}
		
//		for(int i = 0; i < coin.length; i++){
//			int cnt = money / coin[i];
//			money = money % coin[i];
//			System.out.println(coin[i] + "원 : " + cnt + "개");
//		}
		
		
/*
 * 1 ~ 5의 숫자가 발생된 만큼 *을 사용해 그래프를 그려주세요.
 * 
 * 1 : *** 3
 * 2 : **** 4
 * 3 : ** 2
 * 4 : ***** 5
 * 5 : * 1
 */
//		int[] arr = new int[20];
//		for(int i = 0; i < arr.length; i++){
//			arr[i] = (int)(Math.random() * 5) + 1;
//		}
//		System.out.println(Arrays.toString(arr));
//		
//		int[] arr2 = new int[5];
//		for(int i = 0; i < arr.length; i++){
//			arr2[arr[i] - 1]++;
//		}
//		
//		for(int i = 0; i < arr2.length; i++){
//			System.out.print(i+1 + " : ");
//			for(int j = 0; j < arr2[i]; j++){
//				System.out.print("*");
//			}System.out.println(" " + arr2[i]);
//		}
		
		
		/*
		 * 1 ~ 5사이의 값이 10개 저장된 배열에서 중복된 값이 제거된 배열을 만들어 주세요.
		 * [5, 5, 3, 5, 2, 2, 5, 5, 5]
		 * [5, 3, 2]
		 */
//		int[] arr = new int[10];
//		for(int i = 0; i < arr.length; i++){
//			arr[i] = (int)(Math.random() * 5) + 1;
//		}
//		System.out.println(Arrays.toString(arr));
//		
//		int temp[] = new int[10];
//		int count = 0;
//		for(int i = 0; i < arr.length; i++){
//			int flag = 0;
//			for(int j = 0; j < temp.length; j++){
//				if(arr[i] == temp[j]){
//					flag = 1;
//				}
//			}
//			if(flag == 0){
//				temp[count++] = arr[i];
//			}
//		}
//		System.out.println(Arrays.toString(temp));
//		
//		int[] result = new int[count];
//		for(int i = 0; i < result.length; i++){
//			result[i] = temp[i];
//		}
//		System.out.println(Arrays.toString(result));
		
			int[] numbers = {5, 0, 2, 7, 0};

	        int[] temp = new int[numbers.length * numbers.length];
	        int count = 0;
	        for(int i = 0; i < numbers.length; i++){
	            for(int j = 0; j < numbers.length; j++){
	                if(i != j){
	                    temp[count++] = numbers[i] + numbers[j];
	                }
	            }
	        }

	        int[] temp2 = new int[count];
	        int count2 = 0;
	        for(int i = 0; i < temp.length; i++){
	            boolean flag = true;
	            for(int j = 0; j < temp2.length; j++){
	                if(temp[i] == temp2[j]){
	                    flag = false;
	                }
	            }
	            if(flag){
	                temp2[count2++] = temp[i];
	            }
	        }
	        
	        int[] answer = new int[count2];
	        for(int i = 0; i < answer.length; i++){
	            answer[i] = temp2[i];
	        }
	        
	        Arrays.sort(answer);
	        
	        System.out.println(Arrays.toString(answer));
	        
	    
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
        
        }
	



	
	
	}
		










