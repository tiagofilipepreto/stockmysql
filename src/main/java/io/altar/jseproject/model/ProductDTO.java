package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO extends Entityy {
		private String nome;
		private float initprice;
		private int discount;
		private int iva;
		private float pvp;
		private List <Long> shelvesId = new ArrayList<Long>();
		
		
		
		
		public ProductDTO() {}


		public ProductDTO(int discount, int iva, float pvp) {
			super();
			this.discount = discount;
			this.iva =  iva;
			this.pvp = pvp;
		}


		public ProductDTO(String nome,float initprice,int discount, int iva, List<Long> shelvesId, float pvp) {
			this.nome= nome;
			this.initprice= initprice;
			this.discount = discount;
			this.iva = iva;
			this.shelvesId = shelvesId;
			this.pvp=pvp;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
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


		public List<Long> getShelvesId() {
			return shelvesId;
		}


		public void setShelvesId(List<Long> shelvesId) {
			this.shelvesId = shelvesId;
		}
		
		public void addShelvesId(long shelvesId) {
			this.shelvesId.add(shelvesId);
		}
		
		public void removeshelvesId(long shelvesId) {
			this.shelvesId.remove(shelvesId);
		}

		@Override
		public String toString() {
			return "Products [ID ="+getId()+",nome=" + nome + ", initprice=" + initprice + ", discount=" + discount + ", iva=" + iva
					+ ", pvp=" + pvp + ", shelvesId=" + shelvesId + "]";
		}
		private void calcoloPvp () {
			float pv = getInitprice()*(1 + (float) getIva()/100);
			float discount1 = pv*(1* (float)getDiscount()/100);
			float pvp =pv - discount1;
			setPvp(pvp);
		}

		
		
	}