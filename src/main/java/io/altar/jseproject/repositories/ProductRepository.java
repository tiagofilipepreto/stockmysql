package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Product;

public class ProductRepository extends EntityRepository<Product> {

	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}

	@Override
	protected String getAllEntities() {
		return Product.GET_ALL_PRODUCTS;
	}

	@Override
	protected String getAllEntitiesIds() {
		return Product.GET_ALL_PRODUCTS_IDS;
	}
	
	
//	private static final ProductRepository INSTANCE = new ProductRepository();
//	
//	public ProductRepository() {}
//	
//	public static ProductRepository getInstance() {
//		return INSTANCE;
//	}
	
}