package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import io.altar.jseproject.model.Shelf;

public class addRemovePrat extends State {

	@Override
	public int on() {

		String optionsMenuInit = ("Escolha um menu:\n"
								+ "1) Adicionar produto a uma prateleira\n"
								+ "2) Remover produto de uma prateleira");
		int input = sc.getInt(optionsMenuInit, 1, 2);

		return input;
	}
}
//		int option = sc.getInt(
//				"O que pretende fazer?\n"
//				+ "1)Adicionar produto a uma prateleira\n"
//				+ "2)Remover produto de uma prateleira");

//		switch (opcao) {
//		case 1:
//			Collection<Long> allEmptyIds = new ArrayList<Long>();
//			Collection<Shelf> allshelves = baseDadosShel.consultEntity();			
//			Stream<Shelf> emptyShelves = allshelves.stream().filter(shelf -> shelf.getProductId() == 0);
//			emptyShelves.forEach(shelf -> { 
//				System.out.print(shelf.getId() + " ");
//				allEmptyIds.add(shelf.getId());
//			});
//			System.out.println();
//			
//			long[] arrayAllEmptyIds = allEmptyIds.stream().mapToLong(l -> l).toArray();
//			
//			if (arrayAllEmptyIds.length != 0) {
//				long idShelf = sc.getLong("Insira o id da prateleira", arrayAllEmptyIds);
//				produto.addShelf(idShelf);
//				Shelf shelf = baseDadosShel.consultEntity(idShelf);
//				shelf.setProductId(produto.getId());
//			} else {
//				System.out.println("Ainda nao foram criadas prateleiras ou estao todas cheias!");
//			}
//			break;
//		case 2:
//			System.out.println(produto.getShelves());
//			if (produto.getShelves().toArray().length != 0) {
//				Collection<Long> pratIds = produto.getShelves();
//				long[] arrayPratIds = pratIds.stream().mapToLong(l -> l).toArray();
//				long input = sc.getLong("Insira o id da prateleira de onde quer remover o produto", arrayPratIds);
//				produto.removeShelf(input);
//				Shelf shelf = baseDadosShel.consultEntity(input);
//				shelf.setProductId(0);
//				baseDadosShel.editEntity(shelf);	
//				System.out.println("Produto com o id:" + produto.getId() + " removido da prateleira com o id:" + input);
//			} else {
//				System.out.println("O produto ainda nao foi adicionado a nenhuma prateleira!");
//			}
//			break;
//		}
//		
//		return 1;
//	}
//
//}
