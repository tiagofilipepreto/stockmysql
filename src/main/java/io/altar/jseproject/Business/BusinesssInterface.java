package io.altar.jseproject.Business;


import java.util.Collection;
import java.util.Set;

import io.altar.jseproject.model.Entityy;

public interface BusinesssInterface <T extends Entityy>{
	
	void create(T t);
	
	T read(long id);
	
	T getId(long id);
	
	Collection<Long> getAllIDs();
	
	void delete (long Id);
	
	void update(T t);
	
	boolean isEmpty();
	
	void printaAll();
	
	long[] getAllIdsarray();
	
	Collection<T> getAll();
	
	
}
