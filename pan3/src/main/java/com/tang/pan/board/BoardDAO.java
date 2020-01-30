package com.tang.pan.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tang.pan.like.BoardLikeVO;

@Repository
public class BoardDAO {
	@Inject
	private SqlSession session;
	private String namespace = "com.tang.pan.mappers.BoardMapper";
	private String namespace2 = "com.tang.pan.mappers.BoardLikeMapper";

	public List<BoardVO> getBoardList(SearchCriteria scri) {
		return session.selectList(namespace + ".getBoardList", scri);
	}

	// 상세보기
	public BoardVO view(BoardVO boardVO) throws Exception {
		return session.selectOne(namespace + ".view", boardVO);
	}

	public int insertBoard(BoardVO boardVO) throws Exception {
		return session.insert(namespace + ".write", boardVO);
	}

	public int updateBoard(BoardVO boardVO) throws Exception {
		return session.update(namespace + ".update", boardVO);
	}

	public void deleteBoard(BoardVO boardVO) throws Exception {
		session.delete(namespace + ".delete", boardVO);
	}

	public int updateViewCnt(int bp_bo) throws Exception {
		return session.update(namespace + ".updateViewCnt", bp_bo);
	}

	public int listCount(SearchCriteria scri) throws Exception {
		return session.selectOne(namespace + ".listCount", scri);
	}

	public List<BoardVO> getManagerList(SearchCriteria scri) {
		return session.selectList(namespace + ".getBoardList", scri);
	}

	public int viewCnt(int bp_no) throws Exception {
		return session.update(namespace + ".viewCnt", bp_no);
	}

	// 좋아요
	public int getBoardLike(BoardVO vo) throws Exception {
		return session.selectOne(namespace2 + ".getBoardLike", vo);
	}

	public void insertBoardLike(BoardLikeVO vo) throws Exception {
		session.insert(namespace2 + ".createBoardLike", vo);
	}

	public void deleteBoardLike(BoardLikeVO vo) throws Exception {
		session.delete(namespace2 + ".deleteBoardLike", vo);
	}

	public void updateBoardLike(int li_bpno) throws Exception {
		session.update(namespace2 + ".updateBoardLike", li_bpno);
	}

}
