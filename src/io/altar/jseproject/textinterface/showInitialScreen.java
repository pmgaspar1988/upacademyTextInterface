package io.altar.jseproject.textinterface;

public class showInitialScreen extends State {

	@Override
	public int on() {
	
		String optionsMenuInit = ("Escolha um menu:\n"
								+ "1) Listar produtos\n"
								+ "2) Listar prateleiras\n"
								+ "3) Sair");
		int input = sc.getInt(optionsMenuInit, 1, 3);
	
		return input;
	}

}
