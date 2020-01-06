package io.altar.jseproject.Business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.lang3.ArrayUtils;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.shelfRepository;


public class BusinessShelf extends BusinessEntity<Shelf> implements BusinessShelfInterface {

	public static final BusinessProducts BUSINESS_PRODUCTS = new BusinessProducts();
	
    @Inject
    protected shelfRepository SHELF_REP_INSTACE;
    
	@Override
	public void create(Shelf t) {
		SHELF_REP_INSTACE.addEntity(t);
		
	}
	@Override
	public Shelf read(long id) {
		return getValidEntity(id);
	}

	@Override
	public void delete(long id) {
//		getValidEntity(id);
//		long idProduct =read(id).getProductId();
//		BUSINESS_PRODUCTS.updateProductsId(id,0,idProduct);
		SHELF_REP_INSTACE.removeEntity(id);
		
		
	}
	@Override
	public void update(Shelf t) {
		getValidEntity(t.getId());
//		 long ProductIdAntigo = read(t.getId()).getProductId();
//		BUSINESS_PRODUCTS.updateProductsId(t.getId(),t.getProductId(),ProductIdAntigo);
		SHELF_REP_INSTACE.editEntity(t);
		
	}
	@Override
	public boolean isEmpty() {
		return SHELF_REP_INSTACE.isEmpty();
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
	public void updateProductsId(List<Long> shelvesIdAntigos, List<Long> shelvesIdNovos, long id) {
//		for(long did : shelvesIdAntigos){
//			Shelf shelvesIdDelete=SHELF_REP_INSTACE.getEntity(did);
//			shelvesIdDelete.setProductId(0);
//			SHELF_REP_INSTACE.editEntity(shelvesIdDelete);
//		
//		}
//		for(long sid : shelvesIdNovos){
//			Shelf shelvesIdAdd=SHELF_REP_INSTACE.getEntity(sid);
//			shelvesIdAdd.setProductId(id);
//			SHELF_REP_INSTACE.editEntity(shelvesIdAdd);
//		}

	
	}
	
//	public ArrayList<Long> getshelvesId() {
//		return  SHELF_REP_INSTACE.getShelfCenas();
//		
//	}
	public String getName() {
		return "A Prateleira";
	}
	
	@Override
	public Collection<Shelf> getAll() {
		return SHELF_REP_INSTACE.getAll();
	}
	@Override
	public Shelf getId(long id) {
		
		return SHELF_REP_INSTACE.getEntity(id);
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
