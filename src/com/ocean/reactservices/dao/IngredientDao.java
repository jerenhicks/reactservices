package com.ocean.reactservices.dao;

import java.util.List;

import com.ocean.reactservices.model.Ingredient;

/**
 * Handles database operations for ingredients.
 * @author hicksj
 *
 */
public class IngredientDao extends HibernateDaoUtil implements Dao<Ingredient> {
	
    /** {@inheritDoc}.*/
	@Override
	public Ingredient create(Ingredient model) {
		//TODO: this method looks like it's going to match recipe, maybe others as well. If this happens 
		//again, then we'll want to move this to the util. 
		openCurrentSessionwithTransaction();
		getCurrentSession().save(model);
		closeCurrentSessionwithTransaction();
		return read(model.getId());
	}

	/** {@inheritDoc}.*/
	@Override
	public Ingredient read(Integer id) {
		openCurrentSessionwithTransaction();
		Ingredient value = (Ingredient) getCurrentSession().get(Ingredient.class, id);
		closeCurrentSessionwithTransaction();
		return value; 
	}

	/** {@inheritDoc}.*/
	@Override
	public List<Ingredient> readAll() {
		openCurrentSessionwithTransaction();
		List<Ingredient> ingredients = (List<Ingredient>) getCurrentSession().createQuery("from Ingredient").list();
		closeCurrentSessionwithTransaction();
		return ingredients;
	}

	/** {@inheritDoc}.*/
	@Override
	public Ingredient update(Ingredient model) {
		//TODO: same as recipe, investigate down teh road about pulling this out.
		openCurrentSessionwithTransaction();
		getCurrentSession().update(model);
		closeCurrentSessionwithTransaction();
		return read(model.getId());
	}

	/** {@inheritDoc}.*/
	@Override
	public void delete(Ingredient model) {
		//TODO: same as recipe, investigate down the road about pulling this out.
		openCurrentSessionwithTransaction();
		getCurrentSession().delete(model);
		closeCurrentSessionwithTransaction();
	}

}
