package com.tang.pan.login;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tang.pan.naverlogin.NaverLoginBO;
import com.tang.pan.notice.NoticeService;
import com.tang.pan.signup.UserVO;

@Controller
public class LoginController {

	@Inject
	LoginService service;
	
	private NaverLoginBO naverLoginBO;

	@Inject
	private NoticeService nService;
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	
	// 로그인 페이지 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		// System.out.println("네이버:" + naverAuthUrl);
		//네이버
		model.addAttribute("url", naverAuthUrl);
		return "login/login";
	}

	@RequestMapping(value = "/loginTRY")
	public ModelAndView loginInvalidId(Model model, HttpSession session, HttpServletRequest request,
			@ModelAttribute UserVO uservo) throws Exception {

		ModelAndView mav = new ModelAndView();
		
		UserVO vo2 = service.login(uservo);  // uservo(아이디 비밀번호)를 토대로 사용자 정보 받아서 vo2에 저장
		
		if(vo2 == null) {
			mav.setViewName("login/login_duplicate");
			return mav;
		}
		
		// 이런식으로 세션에 값을 넣어주면 컨트롤러에서 사용가능
		session.setAttribute("mm", vo2);
		session.setAttribute("mm_id", vo2.getMm_id());
		session.setAttribute("mm_lev", vo2.getMm_lev());
		session.setAttribute("mm_name", vo2.getMm_name());
		session.setAttribute("mm_sccode", vo2.getMm_sccode());
		session.setAttribute("mm_code", vo2.getMm_code());
		
		String lev = (String) session.getAttribute("mm_lev");

		if (lev.equals("M ")) {
			mav.setViewName("manager/managerPage");
		} else {
			mav.setViewName("index");
			// 공지사항 정보 받아오기
			mav.addObject("list", nService.getNoticeList("B0000"));
		}
		
		mav.addObject("mm_name", vo2.getMm_name()); // 이름받아오는거
		model.addAttribute("mm_lev", vo2.getMm_lev());

		return mav;
	}

	// 중복 로그인 할 떄
	@RequestMapping(value = "/login_duplicate")
	public String loginDuplicate(Model model, HttpServletRequest request) {

		return "login/loginDuplicate";
	}

	// 로그아웃
	@RequestMapping(value = "/logout")
	public String pageLogin(HttpSession session, HttpServletRequest request) throws Exception {
		
		session.invalidate();
		
		return "login/login";
	}

}
