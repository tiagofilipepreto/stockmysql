package io.altar.jseproject.controler;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.jseproject.Business.BusinessProducts;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.model.ProductDTO;



@Path("products")
public class ProductControler extends Controler<BusinessProducts ,Product>{
	
	public ProductControler() {
		service = new BusinessProducts();
	}
	
	@GET
	@Path("getshelvesIdEmpty")
	@Produces("application/json")
	public ArrayList<Long> getshelvesId() {
		return service.getshelvesId();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductDTO> getAll(){
		return service.getAll().stream()
					.map(product -> new ProductDTO(
							product.getNome(),
							product.getInitprice(),
							product.getDiscount(),
							product.getIva(),
							product.getShelves().stream().map(Shelf::getId).collect(Collectors.toList()),
							product.getPvp()
							)
					)
		.collect(Collectors.toList());
	};
	
}
