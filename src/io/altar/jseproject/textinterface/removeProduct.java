package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import java.util.Collection;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class removeProduct extends State {

	@Override
	public int on() {
		
		Collection<Long> allIds = baseDadosProd.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		if (arrayAllIds.length != 0) {
			System.out.println(baseDadosProd.getAllIds());
			long input = sc.getLong("Insira o id do produto que quer remover", arrayAllIds);
			Product produto = baseDadosProd.consultEntity(input);
			ArrayList<Long> shelfList = produto.getShelves();
			for (Long maria : shelfList) {
				Shelf shelf = baseDadosShel.consultEntity(maria);
				shelf.setProductId(0);			
				baseDadosShel.editEntity(shelf);
			}
			baseDadosProd.removeEntity(input);
			System.out.println("Produto com o id:" + input + " removido!");
		} else {
			System.out.println("Nao ha produtos a remover!");
		}
		
		return 0;
	}

}
