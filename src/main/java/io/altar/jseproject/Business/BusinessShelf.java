package io.altar.jseproject.Business;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.shelfRepository;

@RequestScoped
public class BusinessShelf extends BusinessEntity<shelfRepository,Shelf> implements BusinessShelfInterface {

	@Inject
	BusinessProducts BUSINESS_PRODUCTS;
	
    
    
	@Override
	public void create(Shelf t) {
		repository.addEntity(t);
		
	}
	@Override
	public Shelf read(long id) {
		return getValidEntity(id);
	}

	@Override
	public void delete(long id) {
		getValidEntity(id);
		if (read(id).getProduct() != null) {
			throw new IllegalArgumentException("Nao pode eliminar porque a prateleiraa ainda tem producto.");
		}
		repository.removeEntity(id);
		
		
	}
	@Override
	public void update(Shelf t) {
		getValidEntity(t.getId());
		repository.editEntity(t);
		
	}
	@Override
	public boolean isEmpty() {
		return repository.isEmpty();
	}
	
	@Override
	public Collection<Long> getAllIDs() {
		return null;
		
      
	}
	 public Product getProductById(long id){
			return BUSINESS_PRODUCTS.getId(id);
		}
//	@Override
//	public long[] getAllIdsarray() {
//		return SHELF_REP_INSTACE.geAllIdsarray();
//	}
	@Override
	public void updateProductsId(List<Shelf> shelvesAntigos) {
		for(Shelf did : shelvesAntigos){
			Shelf shelvesIdDelete=repository.getEntity(did.getId());
			shelvesIdDelete.setProduct(null);
		}
//		for(Shelf sid : shelvesNovos){
//			Shelf shelvesIdAdd=repository.getEntity(sid.getId());
//			shelvesIdAdd.setProduct(product);
//
//		}
	}
	
	public List<Shelf> getshelvesEmpty() {
		return  repository.getAllEmptyShelves();
		
	}
	public String getName() {
		return "A Prateleira";
	}
	
	@Override
	public Collection<Shelf> getAll() {
		return repository.getAll();
	}
	@Override
	public Shelf getId(long id) {
		
		return repository.getEntity(id);
	}
	@Override
	public Shelf validEntityShelfes(Shelf t) {
		String errormsg = "";
		if (t.getCapacidade()<=0) {
			errormsg += "A capacidade tem de ser maios que 0. \n";
		}
		if (t.getDailyPrice()<0) {
			errormsg += "O preco diario tem de ser maios que 0. \n";
		}
//		Long[] inputBoxed = ArrayUtils.toObject(BUSINESS_PRODUCTS.getAllIdsarray());
//		List<Long> productsId =Arrays.asList(inputBoxed);
//		if (!productsId.contains(t.getProductId())) {
//			errormsg += "Productos disponiveis" + productsId;
//		}
		if(!errormsg.isEmpty()) {
			throw new IllegalArgumentException(errormsg);
		}
		return t;
	}
}
