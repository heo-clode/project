package com.tang.pan.manager;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tang.pan.board.BoardVO;
import com.tang.pan.reply.ReplyVO;
import com.tang.pan.search.SchoolVO;
import com.tang.pan.signup.UserVO;

@Service
public class ManagerService {
	@Inject
	ManagerDAO dao;

	public List<SchoolVO> scList() {
		return dao.scList();
	}

	public List<UserVO> mmList() {
		return dao.mmList();
	}

	public List<BoardVO> BoardAll() {
		return dao.BoardAll();
	}

	public List<ReplyVO> ReplyAll() {
		return dao.ReplyAll();
	}

	// 학교 삭제
	public int scDel(String sc_code) {
		return dao.scDel(sc_code);
	}

	public int sc_mmDel(String sc_code) {
		return dao.scDel(sc_code);
	}

	public int sc_boDel(String sc_code) {
		return dao.scDel(sc_code);
	}

	// 회원 삭제
	public int mmDel(String mm_code) {
		return dao.mmDel(mm_code);
	}

	public int mm_bpDel(String mm_code) {
		return dao.mm_bpDel(mm_code);
	}

	public int mm_reDel(String mm_code) {
		return dao.mm_reDel(mm_code);
	}

	// 게시글 삭제
	public int bpDel(int bp_no) {
		return dao.bpDel(bp_no);
	}
	
	// 댓글 삭제
	public int reDel(int re_no) {
		return dao.reDel(re_no);
	}
	
	// 학교 삭제
	public void scReg(SchoolVO vo) throws Exception {
		dao.scReg(vo);
	}
	
	// 회원 삭제
	public void mmReg(UserVO vo) throws Exception {
		dao.mmReg(vo);
	}
}
