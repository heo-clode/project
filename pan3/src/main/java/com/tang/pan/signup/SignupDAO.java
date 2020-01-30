package com.tang.pan.signup;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class SignupDAO {
	
	@Inject
	private SqlSession session;
	private String namespace="com.tang.pan.mappers.SignupMapper";
	
	public void userInsert(UserVO vo) throws Exception{
		session.insert(namespace + ".UserInsert", vo);
	}
	
	public int idOverlapCheck(String mm_id) throws Exception{
		int idCheck = session.selectOne(namespace + ".idOverlapCheck", mm_id);
		
		return idCheck;
	}
}
