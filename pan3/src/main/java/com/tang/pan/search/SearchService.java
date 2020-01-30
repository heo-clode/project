package com.tang.pan.search;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.tang.pan.signup.UserVO;

@Service
public class SearchService {
	@Inject
	private SearchDAO dao;

	// 아이디 찾기
	public UserVO idSearch(UserVO vo) throws Exception {
		return dao.idSearch(vo);
	}

	// 비밀번호 찾기
	public UserVO pwSearch(UserVO vo) throws Exception {
		return dao.pwSearch(vo);
	}

	public List<SchoolVO> schoolSearch(SchoolVO vo) throws Exception {
		return dao.schoolSearch(vo);
	}
	
	public List<SchoolVO> scSearch(SchoolVO vo) throws Exception {
		return dao.scSearch(vo);
	}
}
