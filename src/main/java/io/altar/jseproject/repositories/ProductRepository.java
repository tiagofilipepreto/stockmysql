package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Product;

public class ProductRepository extends EntityRepository<Product> {

	@Override
	protected Class<Product> getEntityClass() {
		// TODO Auto-generated method stub
		return Product.class;
	}

	@Override
	protected String getAllEntities() {
		// TODO Auto-generated method stub
		return Product.GET_ALL_PRODUCTS;
	}
	
	
//	private static final ProductRepository INSTANCE = new ProductRepository();
//	
//	public ProductRepository() {}
//	
//	public static ProductRepository getInstance() {
//		return INSTANCE;
//	}
	
}