package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class editProduct extends State {

	@Override
	public int on() {
		int input2 = 4;
		Collection<Long> allIds = baseDadosProd.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		if (arrayAllIds.length != 0) {
			System.out.println(baseDadosProd.getAllIds());
			long input = sc.getLong("Insira o id do produto a editar", arrayAllIds);
			TextInterfaceStateMachine.produtoEdit = baseDadosProd.consultEntity(input);
			
			String optionsMenuEditProd = ("Escolha um menu:\n"
									+ "1) Editar preço do produto\n"
									+ "2) Editar iva do produto\n"
									+ "3) Adicionar/Remover produto de uma prateleira");
			input2 = sc.getInt(optionsMenuEditProd, 1, 3);

//			switch (opcao) {
//			case 1:
//				editarPrecoProd(TextInterfaceStateMachine.produtoEdit);
//				break;
//			case 2:
//				editarIvaProd(TextInterfaceStateMachine.produtoEdit);
//				break;
//			case 3:
//				addRemovePrat(TextInterfaceStateMachine.produtoEdit);

//		}
//		System.out.println(TextInterfaceStateMachine.produtoEdit);

		} else {
			System.out.println("Nao ha produtos a editar!");
		}

		return input2;
	}

}
