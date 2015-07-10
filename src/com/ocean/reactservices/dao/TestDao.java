package com.ocean.reactservices.dao;

import java.util.List;
import java.util.UUID;

import com.ocean.reactservices.model.Recipe;

public class TestDao extends HibernateDaoUtil implements Dao<Recipe> {
	
	@Override
	public Recipe create(Recipe model) {
		openCurrentSessionwithTransaction();
		getCurrentSession().save(model);
		closeCurrentSessionwithTransaction();
		return read(model.getId());
	}

	@Override
	public Recipe read(UUID id) {
		openCurrentSessionwithTransaction();
		Recipe value = (Recipe) getCurrentSession().get(Recipe.class, id);
		closeCurrentSessionwithTransaction();
		return value; 
	}
	
	@Override
	public List<Recipe> readAll() {
		openCurrentSessionwithTransaction();
		List<Recipe> books = (List<Recipe>) getCurrentSession().createQuery("from Recipe").list();
		closeCurrentSessionwithTransaction();
		return books;
	}

	@Override
	public Recipe update(Recipe model) {
		openCurrentSessionwithTransaction();
		getCurrentSession().update(model);
		closeCurrentSessionwithTransaction();
		return read(model.getId());
	}

	@Override
	public void delete(Recipe model) {
		openCurrentSessionwithTransaction();
		getCurrentSession().delete(model);
		closeCurrentSessionwithTransaction();
	}
}
