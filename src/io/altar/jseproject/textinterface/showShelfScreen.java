package io.altar.jseproject.textinterface;

public class showShelfScreen extends State {

	@Override
	public int on() {
		String optionsMenuShel = ("Escolha uma opcao:\n"
				+ "1) Criar uma nova prateleira\n"
				+ "2) Editar uma prateleira existente\n"
				+ "3) Consultar o detalhe de uma prateleira\n"
				+ "4) Remover uma prateleira\n"
				+ "5) Voltar ao ecrã anterior");
		
		int input = sc.getInt(optionsMenuShel, 1, 5);
		
		return input;
	}

}
