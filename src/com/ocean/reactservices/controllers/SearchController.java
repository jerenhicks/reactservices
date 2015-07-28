package com.ocean.reactservices.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ocean.reactservices.dao.TestDao;
import com.ocean.reactservices.model.Recipe;

@Controller
public class SearchController {
	
	private TestDao testDao = new TestDao();
	
	@RequestMapping(method=RequestMethod.GET, value ="/recipe")  
	public @ResponseBody List<Recipe> getTest(){
	    return testDao.readAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value ="/recipe/{id}")  
	public @ResponseBody Recipe getById(@PathVariable Integer id) {
		return testDao.read(id);
	}

	@RequestMapping(method=RequestMethod.POST, value ="/recipe")  
	public @ResponseBody Recipe createTest(@ModelAttribute("recipe")Recipe recipe) {
		return testDao.create(recipe);
	}

}
