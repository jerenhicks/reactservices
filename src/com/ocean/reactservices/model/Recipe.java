package com.ocean.reactservices.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Test object.
 * @author arcticrain
 *
 */
@Entity
public class Recipe implements Serializable {
	
	/** serial id.*/
	private static final long serialVersionUID = 6171148542943236344L;
	/** id of this object.*/
	@Id
	@GeneratedValue
	private Integer id;
	/** test string 1.*/
	private String name;
	private float rating;
	private String description;
	private String imageLocation;
	
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
	 * Constructor. Utilized by hibernate.
	 */
	public Recipe() {
		
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
	
		
}
