package com.tang.pan.category;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	@Inject
	private CategoryDAO dao;
	
	public String getBocode(CategoryVO vo) {
		return dao.getBocode(vo);
	} 
}
