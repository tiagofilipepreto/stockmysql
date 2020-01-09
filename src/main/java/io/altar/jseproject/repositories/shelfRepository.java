package io.altar.jseproject.repositories;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import io.altar.jseproject.model.Shelf;

@RequestScoped
public class shelfRepository extends EntityRepository<Shelf> {


	@Override
	protected Class<Shelf> getEntityClass() {
		return Shelf.class;
	}

	@Override
	protected String getAllEntities() {
		return Shelf.GET_ALL_SHELVES;
	}

	@Override
	protected String getAllEntitiesIds() {
		return Shelf.GET_ALL_SHELVES_IDS;
	}
	
	public List<Shelf> getAllEmptyShelves() {
		return em.createNamedQuery(Shelf.GET_EMPTY_SHELVES, getEntityClass()).getResultList();
	}
	
	
	
	
	
	
//	public ArrayList<Long> getShelfCenas() {
//		Iterator<Shelf> prodInterator = getAll().iterator();
//		ArrayList <Long> array = new ArrayList<Long>();
//		while (prodInterator.hasNext()) {
//			Shelf t = prodInterator.next();
//			if (t.getProduct() == 0) {
//				array.add(t.getId());
//			}
//		}
//		return array;
//	}
}
