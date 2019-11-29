package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import io.altar.jseproject.model.Shelf;

public class addProdToShelf extends State {

	@Override
	public int on() {
		Collection<Long> allEmptyIds = new ArrayList<Long>();
		Collection<Shelf> allshelves = baseDadosShel.consultEntity();			
		Stream<Shelf> emptyShelves = allshelves.stream().filter(shelf -> shelf.getProductId() == 0);
		emptyShelves.forEach(shelf -> { 
			System.out.print(shelf.getId() + " ");
			allEmptyIds.add(shelf.getId());
		});
		System.out.println();
		
		long[] arrayAllEmptyIds = allEmptyIds.stream().mapToLong(l -> l).toArray();
		
		if (arrayAllEmptyIds.length != 0) {
			long idShelf = sc.getLong("Insira o id da prateleira", arrayAllEmptyIds);
			TextInterfaceStateMachine.produtoEdit.addShelf(idShelf);
			Shelf shelf = baseDadosShel.consultEntity(idShelf);
			shelf.setProductId(TextInterfaceStateMachine.produtoEdit.getId());
		} else {
			System.out.println("Ainda nao foram criadas prateleiras ou estao todas cheias!");
		}
		
		return 1;
	}

}