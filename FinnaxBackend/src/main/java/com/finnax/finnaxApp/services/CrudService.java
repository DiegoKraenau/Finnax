package com.finnax.finnaxApp.services;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

	T save(T t) throws Exception;
	void deleteById(int id)throws Exception;
	Optional<T> findById(int id)throws Exception;
	List<T> findAll()throws Exception;
}
