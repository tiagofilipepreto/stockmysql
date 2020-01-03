package io.altar.jseproject.Business;

import java.util.Collection;

import io.altar.jseproject.model.Entityy;

public abstract class BusinessEntity <T extends Entityy> {
	
	

	public void create(T t) {
		// TODO Auto-generated method stub
		
	}

	public void update(T t) {
		// TODO Auto-generated method stub
		
	}

	public T read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}


	public Collection<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	protected abstract T getId(long id);
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public long[] getAllIdsarray() {
		// TODO Auto-generated method stub
		return null;
	}
	public T getValidEntity( long id) {
		T entity = getId(id);
		if (entity == null) {
			throw new IllegalArgumentException(String.format("%s com o id = %d nao existe",getName() , id));
		}
		return entity;
	}
	

	protected abstract String getName();
	
	
	

}
