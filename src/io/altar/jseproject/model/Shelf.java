package io.altar.jseproject.model;

public class Shelf extends Entity {

	private int capacity;
	private Long productId=(long) 0;
	private int rentPrice;

	
	public Shelf(int capacity, int rentPrice) {
		
		this.capacity = capacity;
		this.rentPrice = rentPrice;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	@Override
	public String toString() {
		return "Shelf [capacity=" + capacity + ", rentPrice=" + rentPrice + ", productId=" + this.getProductId() + "]";
	}
	
	

	
	
	
	
}
