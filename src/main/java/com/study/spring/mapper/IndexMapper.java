package com.study.spring.mapper;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.spring.index.service.IndexVO;

@Repository
public class IndexMapper {

	@Inject
    private SqlSession sqlSession;
   
    private static final String namespace = "com.study.spring.index";
    
	public List<?> selectList(IndexVO vo) throws Exception{
		return (List<?>) sqlSession.selectList(namespace+".selectList", vo);
	}
	
	public IndexVO selectDetailUser(IndexVO vo) throws Exception{
		return (IndexVO) sqlSession.selectOne(namespace+".selectDetailUser", vo);
	}
}
