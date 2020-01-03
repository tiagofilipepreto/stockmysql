package io.altar.jseproject.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = Shelf.GET_ALL_SHELVES, query = "SELECT s FROM Shelf s")
})
public class Shelf extends Entityy implements Serializable {
	
	public static final String GET_ALL_SHELVES = "getAllShelves";
	
	private static final long serialVersionUID = 1L;
	
	private int capacidade;
	@ManyToOne
	private Product product;
	private float dailyPrice;
	
	
	
	public Shelf() {
		super();
	}

	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public float getDailyPrice() {
		return dailyPrice;
	}
	public void setDailyPrice(float dailyPrice) {
		this.dailyPrice = dailyPrice;
	}


	@Override
	public String toString() {
		return "Shelfes [ID ="+ getId() +", capacidade=" + capacidade + ", productId=" + product + ", dailyPrice="
				+ dailyPrice + "]";
	}
	
	
	
	
}
