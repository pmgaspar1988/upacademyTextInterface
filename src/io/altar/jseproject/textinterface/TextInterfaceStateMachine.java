package io.altar.jseproject.textinterface;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class TextInterfaceStateMachine {

	public static Product produtoEdit;
	public static Shelf prateleiraEdit;
	
	public State[] states = { 
			new showInitialScreen(), // 0
			new showProductScreen(), // 1
			new createProduct(), // 2
			new editProduct(), // 3
			new consultProduct(), // 4
			new removeProduct(), // 5
			new showShelfScreen(), // 6
			new createShelf(), // 7
			new editShelf(), // 8
			new consultShelf(), // 9
			new removeShelf(), // 10
			new editarPrecoProd(), //11
			new editarIvaProd(), //12
			new addRemovePrat(), //13
			new addProdToShelf(), //14
			new removeProdFromShelf(), //15
			new editCapacity(),
			new editRentPrice(),
			
			
	};

	private int[][] transition = {
			{ 1, 6 }, //showInitialScreen estado 0
			{ 2, 3, 4, 5, 0 }, //showProductScreen estado 1
			{ 1 }, //createproduct estado 2
			{ 11, 12, 13, 1 }, //editProduct estado 3
			{ 1 }, //consultProduct estado 4
			{ 1 }, //removeProduct estado 5
			{ 7, 8, 9, 10, 0 }, //showShelfScreen estado 6 
			{ 6 }, //createShelf estado 7
			{ 16, 17, 6 }, //editShelf estado 8
			{ 6 }, //consultShelf estado 9
			{ 6 }, //removeShelf estado 10	
			{ 3 }, //editarPrecoProd estado 11
			{ 3 }, //editarIvaProd estado 12
			{ 14, 15 }, //addRemovePrat estado 13
			{ 3 }, //addProdToShelf estado 14
			{ 3 }, //removeProdFromShelf estado 15
			{ 6 }, //editCapacity estado 16
			{ 6 }, //editRentPrice estado 17
			
	};

	private int current = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextInterfaceStateMachine fsm = new TextInterfaceStateMachine();
		int option;

		while (true) {
			option = fsm.states[fsm.current].on();
			
			if (fsm.current == 0 && option == 3) {
				System.out.println("Exit");
				break;
			}

			fsm.current = fsm.transition[fsm.current][option - 1];
		}
	}

}
