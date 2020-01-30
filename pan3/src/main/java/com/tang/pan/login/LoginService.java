package com.tang.pan.login;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import com.tang.pan.signup.UserVO;

@Service
public class LoginService {
	
	@Inject
	private LoginDAO dao;
	
	// 로그인 체크
	public boolean loginCheck(UserVO vo, HttpSession session) throws Exception{
		boolean result = dao.loginCheck(vo);
		
		// System.out.println(result);
		
		if(result) {
			UserVO vo2 = login(vo);
			
			session.setAttribute("mm_id", vo2.getMm_id());
			session.setAttribute("mm_pw", vo2.getMm_pw());
		}
		
		return result;
	}
	
	// 로그인 처리
	public UserVO login(UserVO vo) throws Exception {
		return dao.login(vo);
	}
}
