package com.ocean.reactservices.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ocean.reactservices.dao.TestDao;
import com.ocean.reactservices.model.Recipe;

@Controller
public class SearchController {
	
	private TestDao testDao = new TestDao();
	
	@RequestMapping(method=RequestMethod.GET, value ="/test")  
	public @ResponseBody List<Recipe> getTest(){
	    return testDao.readAll();
	}
	
//	@RequestMapping(method=RequestMethod.GET, value ="/test/{id}")  
//	public @ResponseBody String getById(String id) {
//		return testDao.read(UUID.fromString(id)).toString();
//	}
//	
//
//	@RequestMapping(method=RequestMethod.POST, value ="/test")  
//	public @ResponseBody Test createTest(@ModelAttribute("test")Test test) {
//		return testDao.create(test);
//	}

}
