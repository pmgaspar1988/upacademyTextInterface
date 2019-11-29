package io.altar.jseproject.textinterface;

import java.util.Collection;

import io.altar.jseproject.model.Shelf;

public class editShelf extends State {

	@Override
	public int on() {
		int input2 = 3;
		Collection<Long> allIds = baseDadosShel.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		if (arrayAllIds.length != 0) {
			System.out.println(baseDadosShel.getAllIds());
			long input = sc.getLong("Insira o id da prateleira a editar", arrayAllIds);
			TextInterfaceStateMachine.prateleiraEdit = baseDadosShel.consultEntity(input);

			String optionsMenuEditShel = ("Escolha um menu:\n"
										+ "1) Editar capacidade da prateleira\n"
										+ "2) Editar custo de aluguer\n");
			input2 = sc.getInt(optionsMenuEditShel, 1, 2);

//			int opcao = sc.getInt("Que parametro quer editar?\n1)Capacidade\n2)Preco de aluguer");

//			switch (opcao) {
//			case 1:
//				editCapacity(consultedShelf);
//				break;
//			case 2:
//				editRentPrice(consultedShelf);
//				break;
//			}
//			System.out.println("Prateleira com o id:" + consultedShelf.getId() + " editada:" + consultedShelf);

		} else {
			System.out.println("Nao ha prateleiras a editar!");
		}

		return input2;
	}

}
