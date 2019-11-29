package io.altar.jseproject.textinterface;

public class editRentPrice extends State {

	@Override
	public int on() {
		
		TextInterfaceStateMachine.prateleiraEdit.setCapacity(sc.getInt("Insira nova capacidade da prateleira"));
		baseDadosShel.editEntity(TextInterfaceStateMachine.prateleiraEdit);
		
		System.out.println("Prateleira com o id:" + TextInterfaceStateMachine.prateleiraEdit.getId() + " editada:" + TextInterfaceStateMachine.prateleiraEdit);
		
		return 1;
	}

}
