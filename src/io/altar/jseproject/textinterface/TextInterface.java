package io.altar.jseproject.textinterface;

import java.util.Collection;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repository.ProductRepository;
import io.altar.jseproject.repository.ShelfRepository;
import utils.ScannerUtils;

public class TextInterface {

	public static ScannerUtils sc = new ScannerUtils();
	static ProductRepository baseDadosProd = ProductRepository.getInstance();
	static ShelfRepository baseDadosShel = ShelfRepository.getInstance();

	private static String optionsMenuInit = ("Escolha um menu:\n1) Listar produtos\n2) Listar prateleiras\n3) Sair");
	private static String optionsMenuProd = ("Escolha uma opcao:\n1) Criar um novo produto\n2) Editar um produto existente\n3) Consultar o detalhe de um produto\n4) Remover um produto\n5) Voltar ao ecrã anterior");
	private static String optionsMenuShel = ("Escolha uma opcao:\n1) Criar uma nova prateleira\n2) Editar um produto existente\n3) Consultar o detalhe de um produto\n4) Remover um produto\n5) Voltar ao ecrã anterior");

	public static void main(String[] args) {
		showInitialScreen();
	}

	static void showInitialScreen() {

		int input = sc.getInt(optionsMenuInit, 1, 3);

		do {
			switch (input) {
			case 1:
				showProductScreen();
				break;

			case 2:
				showShelfScreen();
				break;

			case 3:
				System.out.println("Saida");
				System.exit(0);
				;
			}

		} while (input != 3);

	}

	static void showProductScreen() {

		int input = 0;

		do {
			input = sc.getInt(optionsMenuProd, 1, 5);

			switch (input) {
			case 1:
				createProduct();
				break;
			case 2:
editProduct();
				break;
			case 3:
				consultProduct();
				break;
			case 4:
				removeProduct();
				break;
			case 5:
				showInitialScreen();
				break;
			}
		} while (input != 5);
	}

	// metodos para produtos
	private static void createProduct() {
		// TODO Auto-generated method stub
		Product newProduct = new Product(sc.getInt("Insira preco base"), sc.getInt("Insira iva"));
		baseDadosProd.createEntity(newProduct);
		System.out.println("Produto criado com o id: " + newProduct.id);
	}

	private static void removeProduct() {
		// TODO Auto-generated method stub
		System.out.println(baseDadosProd.getAllIds());
		Collection<Long> allIds = baseDadosProd.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		long input = sc.getLong("Insira o id do produto que quer remover", arrayAllIds);
		baseDadosProd.removeEntity(input);
		System.out.println("Produto com o id:" + input + " removido!");
	}

	private static void consultProduct() {
		// TODO Auto-generated method stub
		System.out.println(baseDadosProd.getAllIds());
		Collection<Long> allIds = baseDadosProd.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		long input = sc.getLong("Insira o id do produto a consultar", arrayAllIds);
		Product consultedProduct = baseDadosProd.consultEntity(input);
		System.out.println(consultedProduct);
	}
	
	private static void editProduct() {
		// TODO Auto-generated method stub
		System.out.println(baseDadosProd.getAllIds());
		Collection<Long> allIds = baseDadosProd.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		long input = sc.getLong("Insira o id do produto a consultar", arrayAllIds);
	}

	static void showShelfScreen() {

		int input = sc.getInt(optionsMenuShel, 1, 5);

		switch (input) {
		case 1:

			break;

		case 2:

			break;

		case 3:

			break;

		case 4:

			break;

		case 5:
			showInitialScreen();
			break;
		}
	}

}
