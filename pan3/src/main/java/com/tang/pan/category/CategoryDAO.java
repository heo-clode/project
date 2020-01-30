package com.tang.pan.category;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO {
	@Inject
	SqlSession session;
	private String namespace = "com.tang.pan.mappers.CategoryMapper";
	
	public String getBocode(CategoryVO vo) {
		return session.selectOne(namespace + ".getBoCode", vo);
	} 
}
