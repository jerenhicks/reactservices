package com.ocean.reactservices.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * Test object.
 * @author arcticrain
 *
 */
@Entity
@Indexed
public class Recipe implements Serializable {
	
	/** serial id.*/
	private static final long serialVersionUID = 6171148542943236344L;
	/** id of this object.*/
	@Id
	@GeneratedValue
	private Integer id;
	/** test string 1.*/
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String name;
	private float rating;
	private String description;
	private String imageLocation;
	/** list of ingredients this recipe has.*/
	@OneToMany(targetEntity=Ingredient.class, fetch=FetchType.EAGER)
	private List<Ingredient> ingredients;
	
	/**
	 * Constructor. Utilized by hibernate.
	 */
	public Recipe() {
		ingredients = new ArrayList<Ingredient>();
	}
	
	/**
	 * Constructor.
	 * @param test1 - test string 1.
	 * @param test2 - test string 2.
	 */
	public Recipe(String name) {
		this.name = name;
	}

	/**
	 * Returns the test string 1.
	 * @return the test string 1.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns an 
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id to the inputted value.
	 * @param id - what to set the id to.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Sets the test string 1 value to the inputted value.
	 * @param test1 - what to set the test string 1 to.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the ingredients for this recipe.
	 * @return ingredients for this recipe.
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * Sets the ingredients for this recipe to the inputted values.
	 * @param ingredients - what the list of ingredients should be.
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
		
}
