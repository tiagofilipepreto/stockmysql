package io.altar.jseproject.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.altar.jseproject.model.Entityy;

public abstract class EntityRepository<T extends Entityy> {
	
	@PersistenceContext(unitName ="database")
	protected EntityManager em;

	
	protected abstract Class<T> getEntityClass();
	protected abstract String getAllEntitiesIds();
	protected abstract String getAllEntities();
	
	public List<T> getAll(){
		return em.createNamedQuery(getAllEntities(), getEntityClass()).getResultList();
	}
	

	public void addEntity(T t) {
		em.merge(t);
	};
	
	public void removeEntity(long Id) {
		T entity = getEntity(Id);
		if(entity != null) {
			em.remove(entity);
		}
	}; 

	public T getEntity(long Id) {
		T entity = em.find(getEntityClass(), Id);
		return  entity ;
	}
	

	public void editEntity( T entity) {
		em.merge(entity);
	}
	

//	public long[] geAllIdsarray(){
//		return getAllEntitiesIds().split(" ");
//	}
	
	public boolean isEmpty() {
		return getAll().isEmpty();
	}
//	
//	public Collection<T> getAll(){
//		return myMap.values();
//	}
//	
//	
//	public Collection<Long> getAllIDs(){
//		return myMap.keySet();
//	}
//	
//	public long[] geAllIdsarray(){
//		return myMap.keySet().stream().mapToLong(l -> l).toArray();
//	}
//	
//
//	
//	
//	
//	public void printAll() {
//		Iterator<T> prodInterator = getAll().iterator();
//		while (prodInterator.hasNext()) {
//			T t = (T) prodInterator.next();
//			System.out.println(t);
//		}
//	}
	

	
//	public ArrayList<Long> getShelfCenas() {
//		Iterator<T> prodInterator = getAll().iterator();
//		ArrayList <Long> array = new ArrayList<Long>();
//		while (prodInterator.hasNext()) {
//			T t = (T) prodInterator.next();
//			Shelfes cenas = (Shelfes)t;
//			if (cenas.getProductId() == 0) {
//				array.add(cenas.getId());
//			}
//		}
//		return array;
//	}
	
	
}
