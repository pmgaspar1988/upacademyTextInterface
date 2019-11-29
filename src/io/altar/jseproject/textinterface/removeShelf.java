package io.altar.jseproject.textinterface;

import java.util.Collection;

public class removeShelf extends State {

	@Override
	public int on() {
		Collection<Long> allIds = baseDadosShel.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		if (arrayAllIds.length != 0) {
			System.out.println(baseDadosShel.getAllIds());
			long input = sc.getLong("Insira o id da prateleira que quer remover", arrayAllIds);
			baseDadosShel.removeEntity(input);
			System.out.println("Prateleira com o id:" + input + " removido!");
		} else {
			System.out.println("Nao ha prateleiras a remover!");
		}
		return 1;
	}

}
