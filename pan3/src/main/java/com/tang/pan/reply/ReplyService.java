package com.tang.pan.reply;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class ReplyService {
	@Inject
	ReplyDAO dao;
	
	public List<ReplyVO> getReplyList(int re_bpno){
		return dao.getReplyList(re_bpno);
	}
	
	public int replyInsert(ReplyVO replyvo){
		return dao.replyInsert(replyvo);
	}
	
	public int replyDelete(ReplyVO vo){
		return dao.replyDelete(vo.getRe_no());
	}
	
	public int replyAllDelete(int re_bpno){
		return dao.replyAllDelete(re_bpno);
	}
}
