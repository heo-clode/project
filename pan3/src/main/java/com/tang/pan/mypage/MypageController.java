package com.tang.pan.mypage;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tang.pan.signup.UserVO;

@Controller
public class MypageController {
	
	@Inject
	private MypageService service;
	
	// 로그인 페이지 이동
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String Login(@ModelAttribute UserVO vo, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();  // 세션 객체 가져오기
		Object obj = session.getAttribute("mm");  // 사용자 정보가 담긴 객체 오브젝트 obj에 저장
		String mm_name = (String) session.getAttribute("mm_name");
		String mm_lev = (String) session.getAttribute("mm_lev");
		
		if(mm_name != null) {
			model.addAttribute("mm_name", mm_name);
			model.addAttribute("mm_lev", mm_lev);
		}
		
		//System.out.println(obj);
		
		model.addAttribute("List", service.mypage(obj));
		
		return "mypage/myPage";
	}

	
	// 로그인 페이지 이동
	@RequestMapping(value = "/myPage", method = RequestMethod.POST )
	public String myPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return "mypage/myPage";
	}
	
	
	@RequestMapping("/myPageUpdate")
	public String update(Model model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("mm");
		String mm_name = (String) session.getAttribute("mm_name");
		String mm_lev = (String) session.getAttribute("mm_lev");
		
		// 회원 이름/레벨 받아오기
		model.addAttribute("mm_name", mm_name);
		model.addAttribute("mm_lev", mm_lev);
		
		if(obj != null) {
			model.addAttribute("mm", obj);
		}
		
		//System.out.println(obj);
		model.addAttribute("List", service.mypage(obj));

		return "mypage/myPageUpdate";
	}

	@RequestMapping("/myPageUpdateTRY")
	public String update2(@ModelAttribute UserVO vo, Model model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("mm");
		String mm_name = (String) session.getAttribute("mm_name");
		String mm_lev = (String) session.getAttribute("mm_lev");
		
		// 회원 이름/레벨 받아오기
		model.addAttribute("mm_name", mm_name);
		model.addAttribute("mm_lev", mm_lev);
		
		if(obj != null) {
			model.addAttribute("mm", obj);
		}
		
		System.out.println(vo);
		
		vo.setMm_name(request.getParameter("mm_name"));
		vo.setMm_pnum(request.getParameter("mm_pnum"));
		vo.setMm_email(request.getParameter("mm_email"));
		vo.setMm_id((String) session.getAttribute("mm_id"));
		
		session.setAttribute("mm_name", vo.getMm_name());
		
		service.updateMyPage(vo);
		
		model.addAttribute("List", service.mypage(vo));
		//model.addAttribute("List", service.mypage(obj));

		return "mypage/myPage";
	}

	
	@RequestMapping("/myPageDeleteView")
	public String idOverlapCheckView(HttpServletRequest request) {
		return "mypage/myPageDelete";
	}
	
	@RequestMapping(value = "/myPageDelete", method = RequestMethod.POST)
	public void idOverlapCheck(HttpServletRequest request, UserVO vo, Model model) throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("mm");
		UserVO vo2 = (UserVO) session.getAttribute("mm");
		
		model.addAttribute("List", service.mypage(obj));
		vo.setMm_id(vo2.getMm_id());
		//System.out.println((vo2.getMm_id()));
		
		service.deleteMyPage(vo2);
		
		session.invalidate();
	}
	
	
	
	//내가 쓴 글
	@RequestMapping(value = "/writeBoardMyPage", method = RequestMethod.GET)
	public String writeBoardMyPage(@ModelAttribute UserVO vo, Model model,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();  // 세션 객체 가져오기
		Object obj = session.getAttribute("mm");  // 사용자 정보가 담긴 객체 오브젝트 obj에 저장
		
		String mm_name = (String) session.getAttribute("mm_name");
		String mm_lev = (String) session.getAttribute("mm_lev");
		
		if(mm_name != null) {
			model.addAttribute("mm_name", mm_name);
			model.addAttribute("mm_lev", mm_lev);
		}
		
		model.addAttribute("bList",service.writeBoardMyPage(obj));
				
		return "mypage/writeBoardMyPage";
	}	
	
	
	
	//내가 쓴 댓글
	@RequestMapping(value = "/writeReplyMyPage", method = RequestMethod.GET)
	public String writeReplyMyPage(@ModelAttribute UserVO vo, Model model,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();  // 세션 객체 가져오기
		Object obj = session.getAttribute("mm");  // 사용자 정보가 담긴 객체 오브젝트 obj에 저장
		String mm_lev = (String) session.getAttribute("mm_lev");
		
		String mm_name = (String) session.getAttribute("mm_name");
		
		if(mm_name != null) {
			model.addAttribute("mm_name", mm_name);
			model.addAttribute("mm_lev", mm_lev);
		}
		
		model.addAttribute("bList",service.writeReplyMyPage(obj));
				
		return "mypage/writeReplyMyPage";
	}	
	
	
}







