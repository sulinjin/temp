package com.study.spring.index.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.study.spring.index.service.IndexService;
import com.study.spring.index.service.IndexVO;


@Controller
public class IndexController {

	@Inject
	private IndexService indexService;
	

	@RequestMapping(value="/test",method=RequestMethod.GET, produces="application/json",  consumes = MediaType.ALL_VALUE)
	public String indexMain(IndexVO indexVO, Model model) throws Exception{
		//List<IndexVO> userList = (List<IndexVO>)indexService.selectList();
		//String json = new Gson().toJson(userList);
//		System.out.println(json);
//		for(IndexVO user : userList)
//			System.out.println(user.getUsername());
		//model.addAttribute("all", json);
		return "test";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.GET, produces="application/json",  consumes = MediaType.ALL_VALUE)
	@ResponseBody
	public String indexUser(IndexVO indexVO, Model model, @RequestParam Map<String,String> param,
	        HttpServletResponse response) throws Exception{
		System.out.println(param.get("index"));
		indexVO.setIndex(Integer.parseInt(param.get("index")));
		List<IndexVO> userList = (List<IndexVO>)indexService.selectList(indexVO);
		String json = new Gson().toJson(userList);
		System.out.println(json);
		return json;
	}
	
	@RequestMapping(value="/detail/user",method=RequestMethod.GET, produces="application/json",  consumes = MediaType.ALL_VALUE)
	@ResponseBody
	public String detailUser(IndexVO indexVO, Model model, @RequestParam Map<String,String> param,
	        HttpServletResponse response) throws Exception{
		System.out.println(param.get("id"));
		indexVO.setId(Integer.parseInt(param.get("id")));
		IndexVO userData = indexService.selectDetailUser(indexVO);
		String json = new Gson().toJson(userData);
		System.out.println(json);
		return json;
	}
}
