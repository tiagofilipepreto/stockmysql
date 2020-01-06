package io.altar.jseproject.controler;

import javax.ws.rs.Path;

import io.altar.jseproject.Business.BusinessShelf;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.model.ShelfDTO;

@Path("Shelves")
public class ShelfControler extends Controler<BusinessShelf, Shelf> {
	
	public ShelfControler() {
		service = new BusinessShelf();
	}
	
	public ShelfDTO toDTO (Shelf shelf) {
		return new ShelfDTO(
				shelf.getCapacidade(),
				shelf.getProduct().getId(),
				shelf.getDailyPrice()
				);
		
	}
	public Shelf fromDTO (ShelfDTO shelfDTO) {
		Shelf shelf = new Shelf(); 
		shelf.setCapacidade(shelfDTO.getCapacidade());
		shelf.setDailyPrice(shelfDTO.getDailyPrice());
		shelf.setProduct(service.getProductById(shelfDTO.getProductId()
				));
		return shelf;
		
	}
}
