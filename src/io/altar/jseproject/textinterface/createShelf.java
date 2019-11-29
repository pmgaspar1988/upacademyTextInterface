package io.altar.jseproject.textinterface;

import io.altar.jseproject.model.Shelf;

public class createShelf extends State {

	@Override
	public int on() {
		
		Shelf newShelf = new Shelf(sc.getInt("Inserir capacidade"), sc.getInt("Insira o preco de aluguer"));
		baseDadosShel.createEntity(newShelf);
		System.out.println("Prateleira criada com o id: " + newShelf.getId());
		
		return 1;
	}

}
