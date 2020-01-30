package com.tang.pan.login;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tang.pan.signup.UserVO;

@Repository
public class LoginDAO {
	
	@Inject
	private SqlSession session;
	private static final String namespace = "com.tang.pan.mappers.LoginMapper";
	
	// 1. 로그인 체크 - 로그인여부체크
	public boolean loginCheck(UserVO vo) throws Exception{
		String name = session.selectOne(namespace + ".loginCheck", vo);
		
		boolean result = (name == null) ? false : true;
		
		return result;
	}
	
	//3. 로그인 실행
	public UserVO login(UserVO vo) throws Exception {
		
		// System.out.println("3");
		
		return session.selectOne(namespace + ".login", vo);
	}
	
	public UserVO idCheck(UserVO vo) throws Exception {
		return session.selectOne(namespace + ".idCheck", vo);
	}
}
