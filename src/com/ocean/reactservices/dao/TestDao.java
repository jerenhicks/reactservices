package com.ocean.reactservices.dao;

import java.util.List;

import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

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
	public Recipe read(Integer id) {
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
	
	public List<Recipe> search(String searchString) {
		openCurrentSessionwithTransaction();
		FullTextSession fullTextSession = Search.getFullTextSession(getCurrentSession());
		
        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Recipe.class).get();
        org.apache.lucene.search.Query luceneQuery = queryBuilder.keyword().onFields("name").matching(searchString).createQuery();
        org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, Recipe.class);
        List<Recipe> contactList = fullTextQuery.list();
		
		return contactList;
	}
}
