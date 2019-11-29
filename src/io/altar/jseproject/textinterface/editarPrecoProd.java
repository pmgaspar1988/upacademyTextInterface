package io.altar.jseproject.textinterface;

public class editarPrecoProd extends State {

	@Override
	public int on() {
		
		TextInterfaceStateMachine.produtoEdit.setProductIva(sc.getInt("Insira novo IVA"));
		baseDadosProd.editEntity(TextInterfaceStateMachine.produtoEdit);
		
		System.out.println(TextInterfaceStateMachine.produtoEdit);
		
		return 1;
	}

}
