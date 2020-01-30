package com.tang.pan.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tang.pan.like.BoardLikeVO;

@Service
public class BoardService {
	@Inject
	private BoardDAO dao;

	public List<BoardVO> getBoardList(SearchCriteria scri) {
		return dao.getBoardList(scri);
	}

	// 상세보기
	public BoardVO view(BoardVO boardVO) throws Exception {
		return dao.view(boardVO);
	}

	// 쓰기
	public void insertBoard(BoardVO boardVO) throws Exception {
		dao.insertBoard(boardVO);
	}

	public void updateBoard(BoardVO boardVO) throws Exception {
		dao.updateBoard(boardVO);
	}

	public void deleteBoard(BoardVO boardVO) throws Exception {
		dao.deleteBoard(boardVO);
	}

	public int updateViewCnt(int bp_no) throws Exception {
		return dao.updateViewCnt(bp_no);
	}

	public int listCount(SearchCriteria scri) throws Exception {
		return dao.listCount(scri);
	}

	public List<BoardVO> getManagerList(SearchCriteria scri) {
		return dao.getManagerList(scri);
	}

	public int viewCnt(int bp_no) throws Exception {
		return dao.viewCnt(bp_no);
	}

	// 좋아요
	public void insertBoardLike(BoardLikeVO vo) throws Exception {
		dao.insertBoardLike(vo);
		dao.updateBoardLike(vo.getLi_bpno());
	}

	public void deleteBoardLike(BoardLikeVO vo) throws Exception {
		dao.deleteBoardLike(vo);
		dao.updateBoardLike(vo.getLi_bpno());
	}

	public int getBoardLike(BoardVO vo) throws Exception {
		return dao.getBoardLike(vo);
	}

}
