package io.altar.jseproject.model;

import java.util.ArrayList;


public class Product extends Entity {
	
	private ArrayList<Long> shelves = new ArrayList<Long>();
	private int price;
	private float productIva;
	private int productPvp;
	
	public Product(int price, float productIva) {
		
		this.price = price;
		this.productIva = productIva;
		this.productPvp = (int) (price+price*(productIva/100));
	}

	public ArrayList<Long> getShelves() {
		return shelves;
	}

	public void setShelves(ArrayList<Long> shelves) {
		this.shelves = shelves;
	}
	
	public void addShelf(long input) {
		this.shelves.add(input); 
	}
	
	public void removeShelf(long input) {
		this.shelves.remove(input);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		updatePvp();
	}

	public float getProductIva() {
		return productIva;
	}

	public void setProductIva(float productIva) {
		this.productIva = productIva;
		updatePvp();
	}

	public int getProductPvp() {
		return productPvp;
	}
	 
	public void updatePvp() {
		this.productPvp = (int) (this.price+this.price*(this.productIva/100));
	}
	
	@Override
	public String toString() {
		return "Product [shelves=" + shelves + ", price=" + price + ", productIva=" + productIva + ", productPvp="
				+ productPvp + ", id=" + this.getId() + "]";
	}

	
	
	

	

}
