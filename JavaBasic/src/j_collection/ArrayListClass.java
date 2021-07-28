package j_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListClass {

	public static void main(String[] args) {
		//List, Map, Set
		
		/*
		 * boolean add(Object obj) : 마지막 위치에 객체를 추가 후 성공여부를 반환한다.
		 * void add(int index, Object obj) : 지정된 위치에 객체를 추가한다.
		 * Object set(int index, Object obj) : 지정된 위치에 객체를 저장 후 기존 객체를 반환한다.
		 * Object get(int index) : 지정된 위치의 객체를 반환한다,
		 * int size() :  저장된 객체의 수를 반환한다.
		 * boolean remove(int index) : 지정된 위치의 객체를 제거한다.
		 */
		
		ArrayList sample = new ArrayList();		
		
		sample.add("abc");
		sample.add(100);
		sample.add(new Scanner(System.in));
		
		//제네릭을 지정하지 않으면 넣을때는 편하나 꺼낼때는 타입을 예측하기 힘들다.
		//따라서 제네릭의 사용이 권장된다.
		ArrayList<Integer> list = new ArrayList<>();  //Integer타입만 저장 가능
		list.add(10);
//		list.add("abc"); //Error
		list.add(20);
		System.out.println(list.add(30));
		System.out.println(list);
		
		list.add(1, 40);  //1번 인덱스부터 뒤로 밀고 값을 저장한다.
		System.out.println(list);
		
//		list.add(7, 50);  //Error : 리스트 길이 안에서 가능
		
		Integer before = list.set(2, 50);  //2번 인덱스에 값을 저장하고 기존 값을 반환한다.
		System.out.println("before : " + before);
		System.out.println("after : " + list.get(2));
		System.out.println(list);
		
		Integer integer = list.get(2);
		System.out.println(integer);
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(i + " : " + list.get(i));
//			list.remove(i);
//		}
//		System.out.println(list);
		
		//값을 제거할 때에는 뒤에서부터 제거해야 한다.
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.println(i + " : " + list.get(i));
			list.remove(i);
		}
		System.out.println(list);
		
		
		
		//list에 1부터 100까지 랜덤값을 10개 저장해주세요.
		for (int i = 0; i < 10; i++) {
			list.add((int)(Math.random() * 100) + 1);
		}
		System.out.println(list);
		
		//list에 저장된 값을 합계와 평균을 구해주세요.
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		avg = Math.round((double)sum / list.size() * 100) / 100.0;
		System.out.println("합계 : " + sum + " / 평균 : " + avg);
		
		//list에서 최솟값과 최댓값을 구해주세요
		int min = list.get(0);
		int max = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if(min > list.get(i)) min = list.get(i);
			if(max < list.get(i)) max = list.get(i);
		}
		System.out.println("최솟값 : " + min + " / 최댓값 : " + max);
		
		//list를 오름차순으로 정렬해주세요.
		for (int i = 0; i < list.size() - 1; i++) {
			int m = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j) < list.get(m)){
					m = j;
				}
			}
			int temp = list.get(i);
			list.set(i, list.get(m));
			list.set(m, temp);
		}
		System.out.println(list);
		
		//ArrayList 정렬 메서드
		Collections.sort(list);
		
		//2차원
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
		
		list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		list2.add(list);
		
		list = new ArrayList<>();
		list2.add(list);
		list.add(40);
		list.add(50);
		
		System.out.println(list2);
		
		for (int i = 0; i < list2.size(); i++) {
			ArrayList<Integer> li = list2.get(i);
			for (int j = 0; j < li.size(); j++) {
				System.out.print(li.get(j) + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 0; i < list2.size(); i++) {
			for (int j = 0; j < list2.get(i).size(); j++) {
				System.out.println(list2.get(i).get(j));
			}
		}
		
		
		
	}

}



























