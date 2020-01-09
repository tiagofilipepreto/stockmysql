package io.altar.jseproject.Business;

import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;


public interface BusinessProductsInterface extends BusinesssInterface<Product> {
	
	void updateProductsId(long ShelfeId, long ProductIdNovo, long ProductIdAntigo);
	List<Shelf> getAllEmptyShelves();
	Product validEntityProducts(Product t);
}
