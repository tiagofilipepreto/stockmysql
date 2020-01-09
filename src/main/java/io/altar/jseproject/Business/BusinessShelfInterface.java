package io.altar.jseproject.Business;

import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public interface BusinessShelfInterface extends BusinesssInterface<Shelf> {

		void updateProductsId(List <Shelf> shelvesIdAntigos);
		Shelf validEntityShelfes(Shelf t);
}
