package io.altar.jseproject.controler;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;

import io.altar.jseproject.Business.BusinessShelf;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.model.ShelfDTO;
import io.altar.jseproject.repositories.shelfRepository;

@RequestScoped
@Path("Shelves")
public class ShelfControler extends Controler<BusinessShelf,shelfRepository, Shelf,ShelfDTO> {
	
	
	@Override
	public ShelfDTO toDTO (Shelf shelf) {
		return new ShelfDTO(
				shelf.getId(),
				shelf.getCapacidade(),
				(shelf.getProduct()== null) ? 0:shelf.getProduct().getId(),
				shelf.getDailyPrice()
				);
		
	}
	@Override
	public Shelf fromDTO (ShelfDTO shelfDTO) {
		Shelf shelf = new Shelf(); 
		shelf.setId(shelfDTO.getId());
		shelf.setCapacidade(shelfDTO.getCapacidade());
		shelf.setDailyPrice(shelfDTO.getDailyPrice());
		shelf.setProduct(service.getProductById(shelfDTO.getProductId()
				));
		return shelf;
		
	}
}
