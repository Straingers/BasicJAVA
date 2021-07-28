package j_collection;

import java.util.ArrayList;
import java.util.HashMap;

import e_oop.ScanUtil;

public class Board {
	
	public static void main(String[] args) {
/*
 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
 * 조회, 등록, 수정 , 삭제가 가능한 게시판을 만들어주세요.
 * 
 * 번호(PK), 제목, 내용, 작성자, 작성일
 * 
 * -------------------------------
 * 번호		제목		작성자	작성일
 * -------------------------------
 * 1.	안녕하세요		홍길동	2/9
 * 1.	안녕하세요		홍길동	2/9
 * 1.	안녕하세요		홍길동	2/9
 * 1.	안녕하세요		홍길동	2/9
 * -------------------------------
 * 1.조회	2.등록	3.종료
 * 
 * 조회 후 수정, 삭제 가능
 */
		ArrayList<HashMap<String, Object>> board = new ArrayList<>();
		
		HashMap<String, Object> main = new HashMap<>();
		main.put("번호", "번호");
		main.put("제목", "제목");
		main.put("작성자", "작성자");
		main.put("작성일", "작성일");
		board.add(main);
		
		HashMap<String, Object> list1 = new HashMap<>();
		list1.put("번호", 1);
		list1.put("제목", "안녕하세요");
		list1.put("작성자", "홍길동");
		list1.put("작성일", "2/9");
		list1.put("내용", "저는 홍길동 입니다.");
		board.add(list1);
		
		HashMap<String, Object> list2 = new HashMap<>();
		list2.put("번호", 2);
		list2.put("제목", "안녕하세요");
		list2.put("작성자", "홍길동");
		list2.put("작성일", "2/9");
		list2.put("내용", "저는 홍길동 입니다.");
		board.add(list2);
		
		HashMap<String, Object> list3 = new HashMap<>();
		list3.put("번호", 3);
		list3.put("제목", "안녕하세요");
		list3.put("작성자", "홍길동");
		list3.put("작성일", "2/9");
		list3.put("내용", "저는 홍길동 입니다.");
		board.add(list3);
		
		HashMap<String, Object> list4 = new HashMap<>();
		list4.put("번호", 4);
		list4.put("제목", "안녕하세요");
		list4.put("작성자", "홍길동");
		list4.put("작성일", "2/9");
		list1.put("내용", "저는 홍길동 입니다.");
		board.add(list4);
	
		//메인화면 출력
		
		while(true){
			System.out.println("-------------------------------");
			HashMap<String, Object> a = board.get(0);
			System.out.print(a.get("번호") + "\t" + a.get("제목") + "\t" + a.get("작성자") + "\t" + a.get("작성일") + "\t");
			System.out.println();
			System.out.println("-------------------------------");
			
			
			for(int i = 1; i < board.size(); i++){
				HashMap<String, Object> b = board.get(i);
				System.out.print(b.get("번호") + "\t" + b.get("제목") + "\t" + b.get("작성자") + "\t" + b.get("작성일") + "\t");
				System.out.println();
			}
			System.out.println("-------------------------------");
			
			System.out.println("[1]조회\t[2]등록\t[3]종료");
			int input = ScanUtil.nextInt();
			
			switch(input){
			
			//조회
			case 1:
				while(true){
					System.out.println("[1]수정\t[2]삭제\t[3]돌아가기");
					int input2 = ScanUtil.nextInt();
					switch(input2){
					
					//수정
					case 1:
						System.out.println("-------------------------------");
						for(int i = 1; i < board.size(); i++){
							HashMap<String, Object> b = board.get(i);
							System.out.print(b.get("번호") + "\t" + b.get("제목") + "\t" + b.get("작성자") + "\t" + b.get("작성일") + "\t");
							System.out.println();
						}
						System.out.println("-------------------------------");
						System.out.println("조회할 글 번호를 입력해주세요.");
						int input3 = ScanUtil.nextInt();
						if(input3 > board.size() - 1){
							System.out.println("잘못입력하였습니다.");
						}
						else{
							while(true){
								System.out.println("제목 : " + board.get(input3).get("제목"));
								System.out.println("-------------------------------");
								System.out.println(board.get(input3).get("내용"));
								System.out.println("-------------------------------");
								System.out.println("수정할 항목을 입력해주세요.");
								System.out.println("[1]제목\t[2]내용\t[3]작성일");
								int input4 = ScanUtil.nextInt();
								switch(input4){
								case 1:
									System.out.println("바꿀 제목을 입력해주세요.");
									String input5 = ScanUtil.nextLine();
									board.get(input3).put("제목", input5);
									System.out.println("수정이 완료되었습니다.");
									break;
								case 2:
									System.out.println("바꿀 제목을 입력해주세요.");
									String input7 = ScanUtil.nextLine();
									board.get(input3).put("내용", input7);
									System.out.println("수정이 완료되었습니다.");
									break;	
								case 3:
									System.out.println("작성일을 입력해주세요.");
									String input6 = ScanUtil.nextLine();
									board.get(input3).put("작성일", input6);
									System.out.println("수정이 완료되었습니다.");
									break;
								default:
									System.out.println("잘못입력하였습니다.");
								}
								break;
							}
						}	
						break;
					
					//삭제
					case 2:
						while(true){
							System.out.println("-------------------------------");
							for(int i = 1; i < board.size(); i++){
								HashMap<String, Object> b = board.get(i);
								System.out.print(b.get("번호") + "\t" + b.get("제목") + "\t" + b.get("작성자") + "\t" + b.get("작성일") + "\t");
								System.out.println();
							}
							System.out.println("-------------------------------");
							System.out.println("삭제할 글 번호를 입력해주세요.");
							int input4 = ScanUtil.nextInt();
							System.out.println("정말 삭제하시겠습니까?");
							System.out.println("[1]네\t[2]아니오");
							int input5 = ScanUtil.nextInt();
							switch(input5){
							case 1:
								if(input4 < board.size() - 1){
									for(int j = input4; j < board.size(); j++){									
										board.get(j).put("번호", (int)board.get(j).get("번호") - 1);
									}
									board.remove(board.get(input4));
									System.out.println("삭제되었습니다.");
									break;
								}
								else{
									System.out.println("잘못입력하였습니다.");
								}
							case 2:
								System.out.println("취소되었습니다.");
								break;
							}
							break;
						}
						break;
				
					
					//돌아가기
					case 3:
						break;
					
					default:
						System.out.println("잘못 입력하였습니다.");
						continue;
					}
					break;
				}
				break;
			
			//등록
			case 2:
				HashMap<String, Object> newlist = new HashMap<>();
				newlist.put("번호", board.size());
				System.out.println("제목을 입력해주세요.");
				String input3 = ScanUtil.nextLine();
				newlist.put("제목", input3);
				System.out.println("작성자를 입력해주세요.");
				String input4 = ScanUtil.nextLine();
				newlist.put("작성자", input4);
				System.out.println("작성일을 입력해주세요.(월/일)");
				String input5 = ScanUtil.nextLine();
				newlist.put("작성일", input5);
				board.add(newlist);
				break;
			
			//종료
			case 3:
				System.out.println("이용해주셔서 감사합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("잘못 입력하였습니다.");
			}
		}			
		
		

		
	}

}

















