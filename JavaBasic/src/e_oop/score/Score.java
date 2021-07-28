package e_oop.score;

public class Score {

	public static void main(String[] args) {
		Student[] students = new Student[10];
		
		for(int i = 0; i < students.length; i++){
			Student student = new Student();
			
			student.name = "학생" + (i + 1);
			student.rank = 1;
			student.kor = (int)(Math.random() * 101);
			student.eng = (int)(Math.random() * 101);
			student.math = (int)(Math.random() * 101);
			
			student.sum = student.kor + student.eng + student.math;
			student.avg = Math.round((double)student.sum / 3 * 100) / 100.0;
			 
			students[i] = student;
		}

//성적관리 프로그램을 완성해주세요.
		//등수
		for(int i = 0; i < students.length; i++){
			for(int j = 0; j < students.length; j++){
				if(students[i].sum < students[j].sum){
					students[i].rank++;
				}
			}
		}
		
		//석차 순으로 정렬
		for(int i = 0; i < students.length - 1; i++){
			int min = i;
			for(int j = i + 1; j < students.length; j++){
				if(students[j].rank < students[min].rank){
					min = j;
				}
			}	
			Student temp = students[i];
			students[i] = students[min];
			students[min] = temp;
		}
			
		//출력
	    System.out.println("\t국어\t영어\t수학\t합계\t평균\t석차");
		for(int i = 0; i < students.length; i++){
			System.out.println(students[i].name + "\t" + students[i].kor + "\t" + students[i].eng 
					+ "\t" + students[i].math + "\t" + students[i].sum+ "\t" + students[i].avg + "\t" + students[i].rank);
		}
		
		//과목합계, 평균
		int[] subSum = new int [3];
		double[] subAvg = new double [3];
		
		for(int i = 0; i < students.length; i++){
			subSum[0] += students[i].kor;
			subSum[1] += students[i].eng;
			subSum[2] += students[i].math;
		}
		for(int i = 0; i < subAvg.length; i++){
			subAvg[i] = Math.round((double)subSum[i] / students.length * 100) / 100.0;
		}
		
		//과목합계, 평균 출력
		System.out.print("과목합계\t");
		for(int i = 0; i < subSum.length; i++){
			System.out.print(subSum[i] + "\t");
		}
		System.out.println();
		System.out.print("과목평균\t");
		for(int i = 0; i < subAvg.length; i++){
			System.out.print(subAvg[i] + "\t");
		}
	
	}

}


