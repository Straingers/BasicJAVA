package service;

import java.util.List;
import java.util.Map;

import dao.NoticeDao;
import dao.QnaboardDao;
import util.JDBCUtil;
import util.ScanUtil;
import util.View;

public class NoticeService {
	
	private NoticeService(){}
	private static NoticeService instance;
	public static NoticeService getInstance(){
		if (instance == null){
			instance = new NoticeService();
		}
		return instance;
	}
	
	private NoticeDao noticeDao = NoticeDao.getInstance();
	
	public int selectnotice(){
		System.out.println("====================공지 목록=====================");
		System.out.println("등록번호\t제목");		
		int check = 0;
		List<Map<String,Object>> noticeList = noticeDao.SelectNoticeList();
		for (int i = 0; i < noticeList.size(); i++) {
			Map<String, Object> no = noticeList.get(i);
			System.out.println(no.get("NOTICE_NO") + "\t" + no.get("NOTICE_TITLE"));
		check = 1;
		}	
		if(check == 0){
			System.out.println("----------------------------------------------");
			System.out.println("작성한 글이 없습니다");
		}	
		System.out.println("----------------------------------------------");
		System.out.println("[1]내용확인\t[0]돌아가기");
		System.out.print("입력 > ");
		int input = 2;
		try {
			input = ScanUtil.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력 해주세요");
		}
		switch(input){
			case 1:
				System.out.print("확인할 게시물 번호를 입력하시오 > ");
				String num = ScanUtil.nextLine();
				List<Map<String,Object>> selectnoticeList = noticeDao.selectNoticeContent(num);
				for (int i = 0; i < selectnoticeList.size(); i++) {
					Map<String ,Object> no = selectnoticeList.get(i);
					System.out.println("공지 번호: " + no.get("NOTICE_NO"));
					System.out.println("공지 제목: " + no.get("NOTICE_TITLE"));
					System.out.println("게시물 내용: " + no.get("NOTICE_CONTENT"));		
				}
				System.out.println("----------------------------------------------");
				return View.USERMENU;
			case 0:
				return View.USERMENU;
		}
		return View.USERMENU;
	}
	
}

