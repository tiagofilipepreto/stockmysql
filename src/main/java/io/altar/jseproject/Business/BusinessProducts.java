package io.altar.jseproject.Business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;

@RequestScoped
public class BusinessProducts extends BusinessEntity <ProductRepository,Product> implements BusinessProductsInterface {

	@Inject
	BusinessShelf BUSINESS_SHELVES;

	
	
	@Override
	public void create(Product t) {
		validEntityProducts(t);
		repository.addEntity(t);
		BUSINESS_SHELVES.updateProductsId(new ArrayList<Shelf>(),t.getShelves(),t.getId());	
	}
	@Override
	public Product read(long id) {
		return getValidEntity(id);
	}

	@Override
	public void delete(long id) {
		getValidEntity(id);
//		 List <Long>shelvesIdAntigos = read(id).getShelvesId();
		repository.removeEntity(id);
//		BUSINESS_SHELVES.updateProductsId(shelvesIdAntigos,new ArrayList<Long>(),id);
		
	}
	
	@Override
	public void update(Product t) {
		getValidEntity(t.getId());
		validEntityProducts(t);
//		List <Long>shelvesIdAntigos = read(t.getId()).getShelvesId();
		repository.editEntity(t);
//		BUSINESS_SHELVES.updateProductsId(shelvesIdAntigos,t.getShelvesId(),t.getId());
		}
	
	@Override
	public boolean isEmpty() {
		return repository.isEmpty();
	}

	@Override
	public Collection<Long> getAllIDs() {
		return null;
	}
	 public Shelf getShelfById(long id){
			return BUSINESS_SHELVES.getId(id);
		}
//	@Override
//	public long[] getAllIdsarray() {
//		return PROD_REP_INSTACE.geAllIdsarray();
//	}
	@Override
	public void updateProductsId(long ShelfeId, long ProductIdNovo, long ProductIdAntigo) {
//		if(ProductIdAntigo >0) {
//		Product productIdRemove=PROD_REP_INSTACE.getEntity(ProductIdAntigo);
//		productIdRemove.removeshelvesId(ShelfeId);
//		PROD_REP_INSTACE.editEntity(productIdRemove);
//		}
//		if (ProductIdNovo >0) {
//			Product productIdedit=PROD_REP_INSTACE.getEntity(ProductIdNovo);
//			productIdedit.addShelvesId(ShelfeId);
//			PROD_REP_INSTACE.editEntity(productIdedit);
//		}
		
	}
//	@Override
//	public ArrayList<Long> getshelvesId() {
//		return BUSINESS_SHELVES.getshelvesId();
//	}
	@Override
	public Collection<Product> getAll() {
		return repository.getAll();
	}
	public String getName() {
		return "O Producto";
	}
	@Override
	public Product getId(long id) {
		return repository.getEntity(id);
	}
	@Override
	public Product validEntityProducts(Product t) {
		String errormsg = "";
		if (t.getNome().trim().isEmpty()) {
			errormsg += "Tem de ter nome. \n";
		}
		if (t.getInitprice()<=0) {
			errormsg += "Preco inicial tem de ser maior que 0. \n";
		}
		if (t.getDiscount()< 0 || t.getDiscount() > 100) {
			errormsg += "Disconto tem de ser maior que 0. \n";
		}
		List<Integer> ivas = Arrays.asList(23, 13, 6);
		Integer i= t.getIva();
			if (!ivas.contains(i)) {
				errormsg += "Iva tem de ser 6, 13 ou 23. \n";
			}
		
		List <Long> avaShelvesId = getshelvesId();
//		if (t.getId() != null) {
//			avaShelvesId.addAll(PROD_REP_INSTACE.getEntity(t.getId()).getShelvesId());
//		}
//		if(!avaShelvesId.containsAll(t.getShelvesId())) {
//			errormsg += "Prateleiras disponiveis: "+ avaShelvesId;
//		}
		if (!errormsg.isEmpty()) {
			throw new IllegalArgumentException(errormsg);
		}
		return t;
	}
	@Override
	public ArrayList<Long> getshelvesId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
