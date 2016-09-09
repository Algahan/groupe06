package com.adaming.myapp.dao;

import java.util.List;

public interface IGenericDao<T> {

	List<T> getAll();
	
	T add(T t);
	
	T update(T t);
	
	T delete(long pId);
	
	T getById(long pId);

}
