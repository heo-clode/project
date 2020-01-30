package com.tang.pan.manager;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tang.pan.board.BoardVO;
import com.tang.pan.reply.ReplyVO;
import com.tang.pan.search.SchoolVO;
import com.tang.pan.signup.UserVO;

@Repository
public class ManagerDAO {
	@Inject
	SqlSession session;
	String namespace = "com.tang.pan.mappers.ManagerMapper";

	public List<SchoolVO> scList() {
		return session.selectList(namespace + ".scList");
	}

	public List<UserVO> mmList() {
		return session.selectList(namespace + ".mmList");
	}

	public List<BoardVO> BoardAll() {
		return session.selectList(namespace + ".BoardAll");
	}

	public List<ReplyVO> ReplyAll() {
		return session.selectList(namespace + ".ReplyAll");
	}

	// 학교 삭제
	public int scDel(String sc_code) {
		return session.delete(namespace + ".scDel", sc_code);
	}

	public int sc_mmDel(String sc_code) {
		return session.delete(namespace + ".sc_mmDel", sc_code);
	}

	public int sc_boDel(String sc_code) {
		return session.delete(namespace + ".sc_boDel", sc_code);
	}

	// 회원 삭제
	public int mmDel(String mm_code) {
		return session.delete(namespace + ".mmDel", mm_code);
	}

	public int mm_bpDel(String mm_code) {
		return session.delete(namespace + ".mm_bpDel", mm_code);
	}

	public int mm_reDel(String mm_code) {
		return session.delete(namespace + ".mm_reDel", mm_code);
	}

	// 게시글 삭제
	public int bpDel(int bp_no) {
		return session.delete(namespace + ".bpDel", bp_no);
	}

	// 댓글 삭제
	public int reDel(int re_no) {
		return session.delete(namespace + ".reDel", re_no);
	}
	
	// 학교 등록
	public int scReg(SchoolVO vo) {
		return session.insert(namespace + ".scReg", vo);
	}
	
	// 회원 등록
	public int mmReg(UserVO vo) {
		return session.insert(namespace + ".mmReg", vo);
	}
}
