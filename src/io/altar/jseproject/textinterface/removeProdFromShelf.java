package io.altar.jseproject.textinterface;

import java.util.Collection;

import io.altar.jseproject.model.Shelf;

public class removeProdFromShelf extends State {

	@Override
	public int on() {
		
		System.out.println(TextInterfaceStateMachine.produtoEdit.getShelves());
		if (TextInterfaceStateMachine.produtoEdit.getShelves().toArray().length != 0) {
			Collection<Long> pratIds = TextInterfaceStateMachine.produtoEdit.getShelves();
			long[] arrayPratIds = pratIds.stream().mapToLong(l -> l).toArray();
			long input = sc.getLong("Insira o id da prateleira de onde quer remover o produto", arrayPratIds);
			TextInterfaceStateMachine.produtoEdit.removeShelf(input);
			Shelf shelf = baseDadosShel.consultEntity(input);
			shelf.setProductId(0);
			baseDadosShel.editEntity(shelf);	
			System.out.println("Produto com o id:" + TextInterfaceStateMachine.produtoEdit.getId() + " removido da prateleira com o id:" + input);
		} else {
			System.out.println("O produto ainda nao foi adicionado a nenhuma prateleira!");
		}
		
		return 1;
	}

}
