package io.altar.jseproject.textinterface;

public class editCapacity extends State {

	@Override
	public int on() {
		
		TextInterfaceStateMachine.prateleiraEdit.setRentPrice(sc.getInt("Insira novo preco de aluguer"));
		baseDadosShel.editEntity(TextInterfaceStateMachine.prateleiraEdit);
		
		System.out.println("Prateleira com o id:" + TextInterfaceStateMachine.prateleiraEdit.getId() + " editada:" + TextInterfaceStateMachine.prateleiraEdit);
		
		return 1;
	}

}
