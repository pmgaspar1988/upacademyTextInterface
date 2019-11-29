package io.altar.jseproject.textinterface;

public class showProductScreen extends State {

	@Override
	public int on() {
		
		String optionsMenuProd = ("Escolha uma opcao:\n"
								+ "1) Criar um novo produto\n"
								+ "2) Editar um produto existente\n"
								+ "3) Consultar o detalhe de um produto\n"
								+ "4) Remover um produto\n"
								+ "5) Voltar ao ecrã anterior");
		int input = sc.getInt(optionsMenuProd,1,5);

	
		return input;
	}

}
