package io.altar.jseproject.model;

public class Shelf extends Entity {

	private int capacity;
	private int productId;
	private int rentPrice;
	private int count=0;
	
	public Shelf(int capacity, int productId, int rentPrice, int count) {
		
		this.capacity = capacity;
		this.productId = productId;
		this.rentPrice = rentPrice;
		this.count = count;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
}
