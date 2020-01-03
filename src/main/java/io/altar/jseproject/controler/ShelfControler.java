package io.altar.jseproject.controler;

import javax.ws.rs.Path;

import io.altar.jseproject.Business.BusinessShelf;
import io.altar.jseproject.model.Shelf;

@Path("Shelves")
public class ShelfControler extends Controler<BusinessShelf, Shelf> {
	
	public ShelfControler() {
		service = new BusinessShelf();
	}
	
}
