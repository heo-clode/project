package com.tang.pan.reply;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAO {
	@Inject
	SqlSession session;
	private String namespace = "com.tang.pan.mappers.ReplyMapper";
	
	public List<ReplyVO> getReplyList(int re_bpno){
		return session.selectList(namespace + ".getReplyList", re_bpno);
	}
	
	public int replyInsert(ReplyVO replyvo){
		return session.insert(namespace + ".replyInsert", replyvo);
	}
	
	public int replyDelete(int re_no){
		return session.delete(namespace + ".replyDelete", re_no);
	}
	
	public int replyAllDelete(int re_bpno){
		return session.delete(namespace + ".replyAllDelete", re_bpno);
	}
}
