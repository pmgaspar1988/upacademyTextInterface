package io.altar.jseproject.textinterface;

import io.altar.jseproject.model.Product;

public class createProduct extends State {

	@Override
	public int on() {
		Product newProduct = new Product(sc.getInt("Insira preco base"), sc.getInt("Insira iva"));
		
		System.out.println("Produto criado com o id: " + newProduct.getId());
		
		return 1;
	}

}
