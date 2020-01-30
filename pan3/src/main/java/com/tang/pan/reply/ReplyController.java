package com.tang.pan.reply;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tang.pan.board.BoardService;
import com.tang.pan.board.BoardVO;

@Controller
public class ReplyController {
	@Inject
	ReplyService service;
	
	@Inject
	BoardService bService;
	
	@RequestMapping("/replyList")
	@ResponseBody
	private List<ReplyVO> replyList(@RequestParam int re_bpno, HttpServletRequest request, Model model) throws Exception{
		return service.getReplyList(re_bpno);
	}

	@RequestMapping("/replyInsert")
	@ResponseBody
	private int replyInsert(@RequestParam int re_bpno, @RequestParam String re_content, HttpServletRequest request, Model model) throws Exception{
		HttpSession session = request.getSession();
		ReplyVO replyvo = new ReplyVO();
		
		replyvo.setRe_bpbocode((String) session.getAttribute("bo_code"));
		replyvo.setRe_bpno(re_bpno);
		replyvo.setRe_content(re_content);
		replyvo.setRe_writer((String) session.getAttribute("mm_name"));
		replyvo.setRe_mmcode((String) session.getAttribute("mm_code"));
		
		// System.out.println(replyvo);
		
		model.addAttribute("re_bpno", re_bpno);
		
		return service.replyInsert(replyvo);
	}
	
	
	@RequestMapping("/replyDelete")
	private String replyDelete(HttpServletRequest request, Model model, @RequestParam int re_no) throws Exception{
		HttpSession session = request.getSession();
		String mm_name = (String) session.getAttribute("mm_name");
		String mm_lev = (String) session.getAttribute("mm_lev");
		String mm_code = (String) session.getAttribute("mm_code");
		ReplyVO vo = new ReplyVO();
		
		vo.setRe_no(Integer.parseInt(request.getParameter("re_no")));
		
		service.replyDelete(vo);
		
		// 회원 이름 받아오기
		model.addAttribute("mm_name", mm_name);
		model.addAttribute("mm_lev", mm_lev);

		// 게시글 정보 가져오기
		model.addAttribute("view", bService.view((BoardVO) session.getAttribute("view")));
		model.addAttribute("bo_num", session.getAttribute("bo_num"));
		model.addAttribute("mm_code", mm_code);
		
		return "board/view";
		
	}
	 
}
