package io.altar.jseproject.textinterface;

import java.util.Collection;

import io.altar.jseproject.model.Shelf;

public class consultShelf extends State {

	@Override
	public int on() {
		Collection<Long> allIds = baseDadosShel.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		if (arrayAllIds.length != 0) {
			System.out.println(baseDadosShel.getAllIds());
			long input = sc.getLong("Insira o id da prateleira", arrayAllIds);
			Shelf consultedShelf = baseDadosShel.consultEntity(input);
			System.out.println(consultedShelf);
		} else {
			System.out.println("Ainda nao foram criadas prateleiras!");
		}
		return 1;
	}

}
