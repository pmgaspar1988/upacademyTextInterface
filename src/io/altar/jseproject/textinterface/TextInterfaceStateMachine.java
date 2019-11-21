package io.altar.jseproject.textinterface;

public class TextInterfaceStateMachine {

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
	};

	private int[][] transition = {
			{ 1, 6 }, 
			{ 0, 2, 3, 4, 5 },
			{ 1 }, //createproduct estado2
			{ 1 },
			{ 1 },
			{ 1 },
			{ 0, 7, 8, 9, 10 }, 
			{ 6 }, 
			{ 6 },
			{ 6 },
			{ 6 }
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
