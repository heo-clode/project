package com.tang.pan.mypage;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.tang.pan.board.BoardVO;
import com.tang.pan.signup.UserVO;

@Repository
public class MypageDAO {
	
	@Inject
	private SqlSession sqlSession;
	private String namespace = "com.tang.pan.mappers.MypageMapper";
	
	public ArrayList<UserVO> mypage(Object obj){
		List<UserVO> list = sqlSession.selectList((namespace+".mypage"), obj);
		
		return (ArrayList<UserVO>)list;
	}
	
	//수정
	public int updateMyPage(UserVO vo) throws Exception {
		return sqlSession.update(namespace+".updateMyPage", vo);
	}

	//회원탈퇴
	public int deleteMyPage(UserVO vo) throws Exception {
		return sqlSession.delete(namespace+".deleteMyPage", vo);
	}
	
	//내가 쓴 글
	public ArrayList<BoardVO> writeBoardMyPage(Object obj){
		List<BoardVO> list = sqlSession.selectList((namespace+".writeBoardMyPage"), obj);
		return (ArrayList<BoardVO>)list;
	}
	
	//내가 쓴 댓글
	public ArrayList<BoardVO> writeReplyMyPage(Object obj){
		List<BoardVO> list = sqlSession.selectList((namespace+".writeReplyMyPage"), obj);
		return (ArrayList<BoardVO>)list;
	}
	
	
}







