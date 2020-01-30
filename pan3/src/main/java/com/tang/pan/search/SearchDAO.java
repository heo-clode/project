package com.tang.pan.search;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.tang.pan.signup.UserVO;

@Repository
public class SearchDAO {
	@Inject
	private SqlSession session;
	private String namespace = "com.tang.pan.mappers.SearchMapper";

	public UserVO idSearch(UserVO vo) throws Exception {
		return session.selectOne(namespace + ".idSearch", vo);
	}

	public UserVO pwSearch(UserVO vo) throws Exception {
		return session.selectOne(namespace + ".pwSearch", vo);
	}

	public List<SchoolVO> schoolSearch(SchoolVO vo) throws Exception {
		return session.selectList(namespace + ".schoolSearch", vo);
	}
	
	public List<SchoolVO> scSearch(SchoolVO vo) throws Exception {
		return session.selectList(namespace + ".scSearch", vo);
	}

}
