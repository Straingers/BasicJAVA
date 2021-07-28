package d_array;

import java.util.Arrays;

public class MultiDimensionalArray {
	
	public static void main(String[] args) {
/*
 * 다차원 배열
 *  - 배열안에 배열이 저장되어 있는 형태이다.
 */
		//2차원
		int[][] array2;
		
		//3차원
		int[][][] array3;
		
/*
 * 변수 : 주소1
 * 
 * 주소1 : {주소2, 주소3}
 * 
 * 주소2 : {값1, 값2}
 * 주소3 : {값3, 값4}
 */
		
		int[][] arr = new int[2][3]; //2칸짜리 배열안에 각 칸마다 3칸짜리 배열이 생성된다.
		int arr2[][] = new int[][]{{1, 2, 3}, {4, 5, 6}}; //값의 개수로 배열의 길이가 정해진다.
		int[] arr3[] = { {1, 2, 3}
					   , {4, 5, 6}
					   , {7, 8, 9} }; //선언과 초기화를 동시에한다.
		
		int[][] arr4 = new int[3][]; //가변 배열
		arr4[0] = new int[3];
		arr4[1] = new int[5];
		arr4[2] = new int[10];
		
//		System.out.println(arr[0][1]);
		
//		arr[0] = 10; //값을 저장할 수 없다.
		arr[0] = new int[5];
		arr[0][0] = 10; //2차원에 값을 저장할 수 있다.
		arr[0][1] = 20;
		arr[1][0] = 100;
		
//		System.out.println(arr.length); //1차원 배열의 길이
//		System.out.println(arr[0].length); //2차원 배열의 길이
//		System.out.println(arr[1].length);
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
//				System.out.println(arr[i][j]);
				arr[i][j] = i * j;
			}
		}
		
		
		//합계와 평균을 구해주세요. (평균은 소수점 1자리까지 표현해주세요.)
		int[][] scores = new int[3][5]; //int[학생수][과목수]
		int[] sum = new int[scores.length];
		double[] avg = new double[scores.length];
		
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				scores[i][j] = (int)(Math.random() * 101);
			}
//			System.out.println(Arrays.toString(scores[i]));
		}
		
//		System.out.println();
		
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				sum[i] += scores[i][j];
			}
			avg[i] = Math.round((double)sum[i] / scores[i].length * 10) / 10.0;
//			System.out.println(i+1 + "번 학생 = 합계 : " + sum[i] + " / 평균 : " + avg[i]);
		}
		
	}
}
