package com.adaming.myapp.service;

import java.util.List;

public interface IGenericService<T> {
	
	List<T> getAll();
	
	T add(T t);
	
	T update(T t);
	
	T delete(long pId);
	
	T getById(long pId);

}
