package com.tang.pan.signup;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class SignupService {
	
	@Inject
	private SignupDAO dao;
	
	public void userInsert(UserVO vo) throws Exception{
		dao.userInsert(vo);
	}
	
	public int idOverlapCheck(String mm_id) throws Exception{
		int idCheck = dao.idOverlapCheck(mm_id);
		
		return idCheck;
	}
	
}
