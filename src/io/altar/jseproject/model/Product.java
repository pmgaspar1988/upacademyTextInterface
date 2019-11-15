package io.altar.jseproject.model;

import java.util.ArrayList;


public class Product extends Entity {
	
	private ArrayList<Integer> shelves;
	private int price;
	private float productIva;
	private int productPvp;
	
	public Product(int price, float productIva) {
		
		
		this.price = price;
		this.productIva = productIva;
		this.productPvp = (int) (price+price*(productIva/100));
	}

	public ArrayList<Integer> getShelves() {
		return shelves;
	}

	public void setShelves(ArrayList<Integer> shelves) {
		this.shelves = shelves;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public float getProductIva() {
		return productIva;
	}

	public void setProductIva(float productIva) {
		this.productIva = productIva;
	}

	public int getProductPvp() {
		return productPvp;
	}

	public void setProductPvp(int productPvp) {
		this.productPvp = productPvp;
	}

	@Override
	public String toString() {
		return "Product [shelves=" + shelves + ", price=" + price + ", productIva=" + productIva + ", productPvp="
				+ productPvp + ", id=" + id + "]";
	}

	
	
	

	

}
