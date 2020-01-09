package io.altar.jseproject.controler;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.jseproject.Business.BusinessProducts;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.model.ShelfDTO;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.model.ProductDTO;


@RequestScoped
@Path("products")
public class ProductControler extends Controler<BusinessProducts, ProductRepository ,Product, ProductDTO>{
	
	
	
	@GET
	@Path("getshelvesEmpty")
	@Produces("application/json")
	public List<Shelf> getshelvesId() {
		return service.getAllEmptyShelves();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductDTO> getAll(){
		return service.getAll().stream()
					.map(product -> new ProductDTO(
							product.getId(),
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
	@Override
	public ProductDTO toDTO (Product product) {
		return new ProductDTO(
				product.getId(),
				product.getNome(),
				product.getInitprice(),
				product.getDiscount(),
				product.getIva(),
				product.getShelves().stream().map(Shelf::getId).collect(Collectors.toList()),
				product.getPvp()
				);
		
	}
	@Override
	public Product fromDTO (ProductDTO productDTO) {
		Product product = new Product(); 
		product.setNome(productDTO.getNome());
		product.setId(productDTO.getId());
		product.setInitprice(productDTO.getInitprice());
		product.setDiscount(productDTO.getDiscount());
		product.setIva(productDTO.getIva());
		product.setShelves(productDTO.getShelvesId().stream().map(id -> service.getShelfById(id)).collect(Collectors.toList()))
				;
		return product;
		
	}
	
}
