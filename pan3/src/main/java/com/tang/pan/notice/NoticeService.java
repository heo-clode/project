package com.tang.pan.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tang.pan.board.BoardVO;

@Service
public class NoticeService {
	@Inject
	private NoticeDAO dao;
	
	public List<BoardVO> getNoticeList(String bp_bocode){
		return dao.getNoticeList(bp_bocode);
	}
}
