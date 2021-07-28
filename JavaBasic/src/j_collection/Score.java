package j_collection;

import java.util.ArrayList;

public class Score {

	public static void main(String[] args) {
/*
 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를
 * 0 ~ 100까지 랜덤을 생성하고, 아래와 같이 출력해주세요.
 * 
 * 			국어		영어		수학		사회		과학		Oracle	Java	합계		평균		석차
 * 홍길동		90		90		90		90		90		90		90		630		90.0	1
 * 홍길동		90		90		90		90		90		90		90		630		90.0	1
 * 홍길동		90		90		90		90		90		90		90		630		90.0	1
 * 홍길동		90		90		90		90		90		90		90		630		90.0	1
 * 홍길동		90		90		90		90		90		90		90		630		90.0	1
 * 과목합계	450		450		450		450		450		450		450		
 * 과목평균	90.00	90.00	90.00	90.00	90.00	90.00	90.00		
 */
		
		ArrayList<String> names = new ArrayList<>();
		names.add("강건우"); names.add("공슬기"); names.add("김두환"); names.add("김민지"); names.add("김이현"); names.add("김현슬");
		names.add("김현태"); names.add("명민호"); names.add("박상영"); names.add("박예진"); names.add("변형균"); names.add("서주형");
		names.add("유은지"); names.add("이광렬"); names.add("이휘로"); names.add("전윤주"); names.add("전재수"); names.add("정유진");
		names.add("조용오"); names.add("최영준"); names.add("최윤성"); names.add("현우진");
		
		ArrayList<String> subjects = new ArrayList<>();
		subjects.add("국어"); subjects.add("영어"); subjects.add("수학"); subjects.add("사회"); subjects.add("과학"); 
		subjects.add("Oracle"); subjects.add("Java");
		
		ArrayList<ArrayList<Integer>> score = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			ArrayList<Integer> a = new ArrayList<>();
			for (int j = 0; j < subjects.size(); j++) {
				a.add((int)(Math.random() * 101));
			}
			score.add(a);
		}
		
		ArrayList<Integer> nameSum = new ArrayList<>();
		ArrayList<Double> nameAvg = new ArrayList<>();	
		for (int i = 0; i < score.size(); i++) {
			int sum = 0;
			for(int j = 0; j < subjects.size(); j++){
				sum += score.get(i).get(j);
			}
			double avg = Math.round((double)sum / subjects.size() * 100) / 100.0;
			nameSum.add(sum);
			nameAvg.add(avg);
		}
		
		
		ArrayList<Integer> subSum = new ArrayList<>();
		ArrayList<Double> subAvg = new ArrayList<>();
		for (int i = 0; i < subjects.size(); i++) {
			int sum = 0;
			for(int j = 0; j < names.size(); j++){
				sum += score.get(j).get(i);				
			}
			double avg = Math.round((double)sum / names.size() * 100) / 100.0;
			subSum.add(sum);
			subAvg.add(avg);
		}
			
		ArrayList<Integer> rank = new ArrayList<>();
		for(int i = 0; i < nameSum.size(); i++){
			rank.add(1);
			for(int j = 0; j < nameSum.size(); j++){
				if(nameSum.get(i) < nameSum.get(j)){
					rank.set(i, rank.get(i) + 1);			
				}
			}
		}
		
		for (int i = 0; i < rank.size() - 1; i++) {
			int min = i;
			for (int j = i + 1; j < rank.size(); j++) {
				if(rank.get(j) < rank.get(min)){
					min = j;
				}
			}
			ArrayList<Integer> temp = score.get(i);
			score.set(i, score.get(min));
			score.set(min, temp);
			
			int temp2 = nameSum.get(i);
			nameSum.set(i, nameSum.get(min));
			nameSum.set(min, temp2);
			
			double temp3 = nameAvg.get(i);
			nameAvg.set(i, nameAvg.get(min));
			nameAvg.set(min, temp3);
			
			int temp4 = rank.get(i);
			rank.set(i, rank.get(min));
			rank.set(min, temp4);
			
			String temp5 = names.get(i);
			names.set(i, names.get(min));
			names.set(min, temp5);
		}
		
		for (int i = 0; i < subjects.size(); i++) {
			System.out.print("\t" + subjects.get(i));
		}
		
		System.out.println("\t합계\t평균\t석차\t");
		for (int i = 0; i < names.size(); i++) {
			System.out.print(names.get(i) + "\t");
			for (int j = 0; j < subjects.size(); j++) {
				System.out.print(score.get(i).get(j) + "\t");
			}
			System.out.println(nameSum.get(i) + "\t" + nameAvg.get(i) + "\t" + rank.get(i));
		}
		
		System.out.print("과목합계\t");
		for (int i = 0; i < subSum.size(); i++) {
			System.out.print(subSum.get(i) + "\t");
		}
		System.out.println();
		
		System.out.print("과목평균\t");
		for (int i = 0; i < subAvg.size(); i++) {
			System.out.print(subAvg.get(i) + "\t");
		}
			
	}

}


