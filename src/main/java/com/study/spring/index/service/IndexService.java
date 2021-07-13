package com.study.spring.index.service;

import java.util.List;


public interface IndexService {
	
	public List<?> selectList(IndexVO indexVO) throws Exception;
	
	public IndexVO selectDetailUser(IndexVO indexVO) throws Exception;
}
