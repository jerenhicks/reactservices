package com.ocean.reactservices.dao;

import java.util.List;

public interface Dao<T> {
	
	public T create(T model);
	
	public T read(Integer id);
	
	public List<T> readAll();
	
	public T update(T model);
	
	public void delete(T model);
		
}
