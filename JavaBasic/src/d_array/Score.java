package d_array;

import java.util.Arrays;

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
		String[] cls = {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java"};
		String[] stu = {"강건우", "공슬기", "김두환", "김민지", "김이현", "김현슬", "김현태", "명민호"
						, "박상영", "박예진", "변형균", "서주형", "유은지", "이광렬", "이휘로", "전윤주"
						, "전재수", "정유진", "조용오", "최영준", "최윤성", "현우진"};
		
//랜덤 점수 부여
		int[][] score = new int [stu.length][cls.length]; 	//arr[[학생],[수업]]
		for(int i = 0; i < score.length; i++){				
			for(int j = 0; j < score[i].length; j++){
				score[i][j] = (int)(Math.random() * 101);
			}
		}
		
		
//합계, 평균, 석차
		int[] sum = new int[score.length];		//학생마다 점수 합계
		double[] avg = new double[score.length];	//학생마다 점수 평균
		int[] rank = new int[stu.length];

		for(int i = 0; i < score.length; i++){
			for(int j = 0; j < score[i].length; j++){
				sum[i] += score[i][j];
			}			
			avg[i] = Math.round((double)sum[i] / score[i].length * 100) / 100.0;
		}
		
		for(int i = 0; i < score.length; i++){
			rank[i] = 1;
			for(int j = 0; j < score.length; j++){
				if(sum[i] < sum[j]){
					rank[i]++;
				}				
			}		
		}
		
//석차순으로 정렬
		for(int i = 0; i < sum.length - 1; i++){
			int min = i;
			for(int j = i + 1; j < sum.length; j++){
				if(sum[j] > sum[min]){
					min = j;
				}
			}
			int[] temp = score[i];
			score[i] = score[min];
			score[min] = temp;
			
			int temp2 = sum[i];
			sum[i] = sum[min];
			sum[min] = temp2;
			
			double temp3 = avg[i];
			avg[i] = avg[min];
			avg[min] = temp3;
			
			int temp4 = rank[i];
			rank[i] = rank[min];
			rank[min] = temp4;
			
			String temp5 = stu[i];
			stu[i] = stu[min];
			stu[min] = temp5;
		}
		
//프린트
		for(int i = 0; i < cls.length; i++){
			System.out.print("\t" + cls[i]);			
		}
		System.out.println("\t합계\t평균\t석차");

		for(int i = 0; i < score.length; i++){
			System.out.print(stu[i]);
			for(int j = 0; j < score[i].length; j++){
				System.out.print("\t" + score[i][j]);
			}
			System.out.println("\t" + sum[i] + "\t" + avg[i] + "\t" + rank[i]);
			}	
		System.out.println("-----------------------------------------------------------------------------------");


//과목 합계, 과목 평균
		int[] clssum = new int[cls.length];			//과목 합계
		double[] clsavg = new double[cls.length];	//과목 평균
		
		System.out.print("과목합계\t");
		for(int i = 0; i < clssum.length; i++){
			for(int j = 0; j < score.length; j++){		
				clssum[i] += score[j][i];
			}
			System.out.print(clssum[i] + "\t");
		}
		System.out.println();
		
		System.out.print("과목평균\t");
		for(int i = 0; i < clsavg.length; i++){
				clsavg[i] += Math.round((double)clssum[i] / score.length * 100) / 100.0;
				System.out.print(clsavg[i] + "\t");
		}
		System.out.println();
		
	}

}
