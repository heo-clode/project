package com.tang.pan.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.tang.pan.signup.UserVO;

public class AuthenticationProvider {
	@Autowired
	LoginService loginService;

	public Authentication authenticate(Authentication authentication, HttpServletRequest request) throws AuthenticationException{
    	
    	HttpSession session = request.getSession();
    	String user_id = (String)authentication.getPrincipal(); //아이디 받기
    	String user_pw = (String)authentication.getCredentials(); //비밀번호 받기
    	String lev = (String) session.getAttribute("mm_lev");
      
    	UserVO vo = new UserVO(); //     

    	//권한 설정하기 해당 사항에 맞는 권한을 선택하여 이용한다.
    	List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
    	if(lev.equals("M ")){ 
    		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
    	} else {
    		roles.add(new SimpleGrantedAuthority("IS_AUTHENTICATED_ANONYMOUSLY"));
    	}
        
    	//아이디, 비밀번호, 권한, customUserDetail 값 세팅
    	UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user_id, user_pw, roles);
    	result.setDetails(vo);
    	return result;
    }

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
