package com.ocean.reactservices.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ocean.reactservices.dao.IngredientDao;
import com.ocean.reactservices.model.Ingredient;

@Controller
public class IngredientController {
	
	/** recipe dao.*/
	private IngredientDao ingredientDao = new IngredientDao();
	
	//search ingredient
	
	//get ingredient
	
	/**
	 * Creates an ingredient from the information passed in.
	 * @param ingredient - the ingredient will add to the system.
	 * @return the created ingredient.
	 */
	@RequestMapping(method=RequestMethod.POST, value ="/ingredient")  
	public ResponseEntity<?> createIngredient(@ModelAttribute("ingredient")Ingredient ingredient) {
		if (ingredient.checkIfValid()) {
			return new ResponseEntity<>(ingredient, HttpStatus.OK);
		} else {
			String errorMessage = "ingrediant name should not be blank or null";
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Returns all the ingredients currently stored in the db.
	 * @return a list of ingredients.
	 */
	@RequestMapping(method=RequestMethod.GET, value ="/ingredient")  
	public @ResponseBody List<Ingredient> getAllIngredients(){
	    return ingredientDao.readAll();
	}
	
}
