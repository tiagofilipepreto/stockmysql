package io.altar.jseproject.Business;

import java.util.ArrayList;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

public interface BusinessProductsInterface extends BusinesssInterface<Product> {
	ProductRepository PROD_REP_INSTACE = ProductRepository.getInstance();
	void updateProductsId(long ShelfeId, long ProductIdNovo, long ProductIdAntigo);
	ArrayList<Long> getshelvesId();
	Product validEntityProducts(Product t);
}