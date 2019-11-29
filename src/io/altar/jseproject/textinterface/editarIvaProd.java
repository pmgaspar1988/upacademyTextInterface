package io.altar.jseproject.textinterface;

public class editarIvaProd extends State {

	@Override
	public int on() {
		
		TextInterfaceStateMachine.produtoEdit.setPrice(sc.getInt("Insira novo preco"));
		baseDadosProd.editEntity(TextInterfaceStateMachine.produtoEdit);
				
		System.out.println(TextInterfaceStateMachine.produtoEdit);
		
		return 1;
	}

}
