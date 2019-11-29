package io.altar.jseproject.textinterface;

import java.util.Collection;

import io.altar.jseproject.model.Product;

public class consultProduct extends State {

	@Override
	public int on() {
		
		Collection<Long> allIds = baseDadosProd.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		if (arrayAllIds.length != 0) {
			System.out.println(baseDadosProd.getAllIds());
			long input = sc.getLong("Insira o id do produto a consultar", arrayAllIds);
			Product consultedProduct = baseDadosProd.consultEntity(input);
			System.out.println(consultedProduct);
		} else {
			System.out.println("Nao ha produtos a consultar!");
		}
		
		return 1;
	}

}
