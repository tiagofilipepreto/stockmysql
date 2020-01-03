package io.altar.jseproject.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = Product.GET_ALL_PRODUCTS, query = "SELECT p FROM Product p")
})
public class Product extends Entityy implements Serializable{
	
	public static final String GET_ALL_PRODUCTS = "getAllProducts";
	
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	
	private String nome;
	private float initprice;
	private int discount;
	private int iva;
	private float pvp;
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private List <Shelf> shelves;
	
	
	
	
	public Product() {}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Shelf> getShelves() {
		return shelves;
	}


	public void setShelves(List<Shelf> shelves) {
		this.shelves = shelves;
	}



	public float getInitprice() {
		return initprice;
	}


	public void setInitprice(float initprice) {
		this.initprice = initprice;
		calcoloPvp ();
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
		calcoloPvp ();
	}


	public int getIva() {
		return iva;
	}


	public void setIva(int iva) {
		this.iva = iva;
		calcoloPvp ();
	}


	public float getPvp() {
		return pvp;
	}


	public void setPvp(float pvp) {
		this.pvp = pvp;
	}


//	public List<Long> getShelvesId() {
//		return shelvesId;
//	}
//
//
//	public void setShelvesId(List<Long> shelvesId) {
//		this.shelvesId = shelvesId;
//	}
//	
//	public void addShelvesId(long shelvesId) {
//		this.shelvesId.add(shelvesId);
//	}
//	
//	public void removeshelvesId(long shelvesId) {
//		this.shelvesId.remove(shelvesId);
//	}

	@Override
	public String toString() {
		return "Products [ID ="+getId()+",nome=" + nome + ", initprice=" + initprice + ", discount=" + discount + ", iva=" + iva
				+ ", pvp=" + pvp + ", shelvesId=" + shelves + "]";
	}
	private void calcoloPvp () {
		float pv = getInitprice()*(1 + (float) getIva()/100);
		float discount1 = pv*(1* (float)getDiscount()/100);
		float pvp =pv - discount1;
		setPvp(pvp);
	}
	
	
}
