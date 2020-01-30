package com.tang.pan.signup;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController {
	@Inject
	private SignupService signupService;
	
	@RequestMapping("/signup")
	public String signup(HttpServletRequest request) {
		
		return "signup";
	}
	
	@RequestMapping("/signupTRY")
	public String signupTRY(@ModelAttribute UserVO vo, HttpServletRequest request) throws Exception {
		
		signupService.userInsert(vo);
		
		return "login/login";
	}
	
	@RequestMapping("/idOverlapCheckView")
	public String idOverlapCheckView(HttpServletRequest request) {
		return "idOverlapCheck";
	}
	
	@RequestMapping(value = "/idOverlapCheck", method = RequestMethod.POST)
	public @ResponseBody ModelAndView idOverlapCheck(HttpServletRequest request, UserVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int idCheck = signupService.idOverlapCheck(vo.getMm_id());
		
		// System.out.println(vo.getMm_id());
		
		if(idCheck == 1) {
			mav.setViewName("idOverlapCheck");
			mav.addObject("msg", "이미 사용중인 아이디입니다.");
		} else {
			mav.setViewName("idOverlapCheck");
			mav.addObject("msg", "사용가능한 아이디입니다.");
		}
		
		return mav;
		
	}
}
