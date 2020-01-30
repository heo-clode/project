package com.tang.pan.mypage;

import java.util.ArrayList;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.tang.pan.board.BoardVO;
import com.tang.pan.signup.UserVO;


@Service
public class MypageService {
	@Inject
	private MypageDAO dao;
	
	//마이페이지 정보 리스트
	public ArrayList<UserVO> mypage(Object obj){
		return dao.mypage(obj);
	}
	
	//정보수정
	public void updateMyPage(UserVO vo) throws Exception {	
		dao.updateMyPage(vo);
	}
	
	//회원탈퇴
	public void deleteMyPage(UserVO vo) throws Exception {
		dao.deleteMyPage(vo);
	}
	
	// 내가 쓴 글
	public ArrayList<BoardVO> writeBoardMyPage(Object obj){
		return dao.writeBoardMyPage(obj);
	}
	
	//내가 쓴 댓글
	public ArrayList<BoardVO> writeReplyMyPage(Object obj){
		return dao.writeReplyMyPage(obj);
	}
	
	
	
}



