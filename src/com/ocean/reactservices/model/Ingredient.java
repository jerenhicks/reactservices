package com.ocean.reactservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * Defines an ingredient.
 * @author hicksj
 *
 */
@Entity
@Indexed
public class Ingredient implements ValidModel {
	
	/** id of this object.*/
	@Id
	@GeneratedValue
	private Integer id;
	/** name of this ingredient.*/
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String name;
	/** description of what this ingredient is and does.*/
	private String description;
	
	/**
	 * Constructor.
	 */
	public Ingredient() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	/** {@inheritDoc.}.*/
	@Override
	public boolean checkIfValid() {
		return (this.name != null && this.name != "");
	}
}
