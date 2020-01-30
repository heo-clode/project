package com.tang.pan.notice;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeController {
	@Inject
	private NoticeService service;
	
	@RequestMapping(value = "/")
	public String getNoticeList(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		// 공지사항 정보 보내주기
		model.addAttribute("list", service.getNoticeList("B0000"));
		
		HttpSession session = request.getSession();  // 세션 객체 가져오기
		String mm_name = (String) session.getAttribute("mm_name");  // 사용자 정보가 담긴 객체 오브젝트 obj에 저장
		String mm_lev = (String) session.getAttribute("mm_lev");
		
		// mm_name != null -> 사용자 정보가 있다는것 -> 로그인 되어있음
		if(mm_name != null) {
			// 로그인이 되어있으면 사용자 정보 보내주기 -> 이름 뜨게 하는 용도
			model.addAttribute("mm_name", mm_name);
			model.addAttribute("mm_lev", mm_lev);
			
			if(mm_lev.equals("M ")) {
				return "manager/managerPage";
			}
		}
		
		return "index";
	}
	
}
