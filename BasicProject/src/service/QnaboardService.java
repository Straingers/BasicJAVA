package service;

import java.util.List;
import java.util.Map;

import dao.QnaboardDao;
import util.JDBCUtil;
import util.ScanUtil;
import util.View;

public class QnaboardService {
	private QnaboardService(){}
	private static QnaboardService instance;
	public static QnaboardService getInstance(){
		if (instance == null){
			instance = new QnaboardService();
		}
		return instance;
	}
	
	private QnaboardDao qnaboardDao = QnaboardDao.getInstance();
	
	public int qna(){
		System.out.println("====================QNA 목록=====================");
		System.out.println("등록번호\t제목\t회원아이디\t등록날짜");	
		int check = 0;
		List<Map<String,Object>> qnaList = qnaboardDao.qnaboardList();
		for (int i = 0; i < qnaList.size(); i++) {
			Map<String ,Object> qna = qnaList.get(i);
			System.out.println(qna.get("QNA_NO")+"\t"+qna.get("QNA_TITLE")
					+"\t"+qna.get("MEM_ID")+"\t"+qna.get("QNA_DATE"));
			check =1;
		}		
		if(check == 0){
			System.out.println("----------------------------------------------");
			System.out.println("작성한 글이 없습니다");
		}	
		System.out.println("----------------------------------------------");
		System.out.println("[1]작성\t[2]내용확인\t[0]돌아가기");
		System.out.print("입력 > ");
		int input = 0;
		try {
			input = ScanUtil.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력 해주세요");
		}
		switch(input){
			case 1:
				System.out.print("제목을 입력하시오 > ");
				String title = ScanUtil.nextLine();
				System.out.print("내용을 입력하시오 > ");
				String content = ScanUtil.nextLine();
				int a = qnaboardDao.InsertQnaboard(title, content);
			
				if(0<a){
					System.out.println("입력성공하였습니다 ");
					return View.USERMENU;
					
				}else {
					System.out.println("입력이 실패하였습니다 ");
					System.out.println("다시 시도해주세요");
				}
			case 2:
				System.out.print("확인할 게시물 번호를 입력하시오 > ");
				String num = ScanUtil.nextLine();
				List<Map<String,Object>> selectQnaBoardList = qnaboardDao.SelectQnaBoardList(num);
				for (int i = 0; i < selectQnaBoardList.size(); i++) {
					Map<String ,Object> qna = selectQnaBoardList.get(i);
					System.out.println("게시물 번호: "+qna.get("QNA_NO"));
					System.out.println("게시물 제목: "+qna.get("QNA_TITLE"));
					System.out.println("회원 아이디: "+qna.get("MEM_ID"));
					System.out.println("게시물 내용: "+qna.get("QNA_CONTENT"));
					System.out.println("등록 날짜 :"+qna.get("QNA_DATE"));	
				}
				System.out.println("----------------------------------------------");
				System.out.println("메뉴를 선택하시오 > ");
				System.out.print("[1]내용수정\t[2]게시물삭제\t[0]돌아가기");
				System.out.println("입력 > ");
				int b = 3;
				try {
					b = ScanUtil.nextInt();
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					System.out.println("다시 입력 해주세요");
				}
				switch(b){
					case 1:
						System.out.println("----------------------------------------------");
						System.out.print("내용을 입력하시오 > ");
						String content2 =ScanUtil.nextLine();
						int c = qnaboardDao.updateQnaBoardList(content2, num);
						
						if(0 < c){
							System.out.println("수정 완료 ");
							return View.USERMENU;
							
						}else {
							System.out.println("수정이 실패하였습니다 ");
							System.out.println("다시 시도해주세요");
						}
					case 2:
						System.out.println("----------------------------------------------");
						int d=qnaboardDao.deleteQnaBoardList(num);
						
						if(0 < d){
							System.out.println("삭제 완료");
							return View.USERMENU;	
						} else {
							System.out.println("삭제가 실패하였습니다 ");
							System.out.println("다시 시도해주세요");
						}
					case 0:
						return View.USERMENU;
					}
					break;
			case 0:
				return View.USERMENU;
		}
		return View.USERMENU;
	}	
	
}
