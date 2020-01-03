package io.altar.jseproject.repositories;

import java.util.ArrayList;
import java.util.Iterator;

import io.altar.jseproject.model.Shelf;

public class shelfRepository extends EntityRepository<Shelf> {

private static final shelfRepository INSTANCE = new shelfRepository();
	
//	public shelfRepository() {}
//	
//	public static shelfRepository getInstance() {
//		return INSTANCE;
//	}

	@Override
	protected Class<Shelf> getEntityClass() {
		return Shelf.class;
	}

	@Override
	protected String getAllEntities() {
		return Shelf.GET_ALL_SHELVES;
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
