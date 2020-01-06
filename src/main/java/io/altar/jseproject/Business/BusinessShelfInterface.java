package io.altar.jseproject.Business;

import java.util.List;


import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.shelfRepository;

public interface BusinessShelfInterface extends BusinesssInterface<Shelf> {

		void updateProductsId(List <Long> shelvesIdAntigos, List <Long> shelvesIdNovos, long id);
		Shelf validEntityShelfes(Shelf t);
}
