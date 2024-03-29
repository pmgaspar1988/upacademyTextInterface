package io.altar.jseproject.repository;

import io.altar.jseproject.model.Product;

public class ProductRepository extends EntityRepository<Product> {

	private static final ProductRepository INSTANCE = new ProductRepository();

	private ProductRepository() {
	}

	public static ProductRepository getInstance() {
		return INSTANCE;
	}
}
