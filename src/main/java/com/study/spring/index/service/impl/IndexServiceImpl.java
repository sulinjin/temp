package com.study.spring.index.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.spring.index.service.IndexService;
import com.study.spring.index.service.IndexVO;
import com.study.spring.mapper.IndexMapper;

@Service
public class IndexServiceImpl implements IndexService {

	@Inject
	private IndexMapper indexMapper;
	
	@Override
	@Transactional
	public List<?> selectList(IndexVO indexVO) throws Exception {
		// TODO Auto-generated method stub
		return indexMapper.selectList(indexVO);
	}
	
	
	
	private void test() {
		System.out.println("test");
	}



	@Override
	@Transactional
	public IndexVO selectDetailUser(IndexVO indexVO) throws Exception {
		// TODO Auto-generated method stub
		return indexMapper.selectDetailUser(indexVO);
	}

}
