package com.tang.pan.notice;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tang.pan.board.BoardVO;

@Repository
public class NoticeDAO {
	@Inject
	private SqlSession session;
	private static String namespace = "com.tang.pan.mappers.NoticeMapper";
	
	public List<BoardVO> getNoticeList(String bp_bocode){
		return session.selectList(namespace + ".notice", bp_bocode);
	}
	
}
