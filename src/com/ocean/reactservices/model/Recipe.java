package com.ocean.reactservices.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
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
	private UUID id;
	/** test string 1.*/
	private String name;
	
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
	public Recipe(String test1) {
		this.id = UUID.randomUUID();
		this.name = test1;
	}

	/**
	 * Returns the test string 1.
	 * @return the test string 1.
	 */
	public String getTest1() {
		return name;
	}

	/**
	 * Returns an 
	 * @return
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Sets the id to the inputted value.
	 * @param id - what to set the id to.
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * Sets the test string 1 value to the inputted value.
	 * @param test1 - what to set the test string 1 to.
	 */
	public void setTest1(String test1) {
		this.name = test1;
	}
		
}
