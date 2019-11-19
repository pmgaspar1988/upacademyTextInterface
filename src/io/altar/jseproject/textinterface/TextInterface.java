package io.altar.jseproject.textinterface;

import java.util.Collection;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repository.ProductRepository;
import io.altar.jseproject.repository.ShelfRepository;
import utils.ScannerUtils;

public class TextInterface {

	public static ScannerUtils sc = new ScannerUtils();
	static ProductRepository baseDadosProd = ProductRepository.getInstance();
	static ShelfRepository baseDadosShel = ShelfRepository.getInstance();

	private static String optionsMenuInit = ("Escolha um menu:\n1) Listar produtos\n2) Listar prateleiras\n3) Sair");
	private static String optionsMenuProd = ("Escolha uma opcao:\n1) Criar um novo produto\n2) Editar um produto existente\n3) Consultar o detalhe de um produto\n4) Remover um produto\n5) Voltar ao ecrã anterior");
	private static String optionsMenuShel = ("Escolha uma opcao:\n1) Criar uma nova prateleira\n2) Editar uma prateleira existente\n3) Consultar o detalhe de uma prateleira\n4) Remover uma prateleira\n5) Voltar ao ecrã anterior");

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

	static void showShelfScreen() {

		int input = sc.getInt(optionsMenuShel, 1, 5);

		switch (input) {
		case 1:
			createShelf();
			break;

		case 2:

			break;

		case 3:

			break;

		case 4:
removeShelf(); 
			break;

		case 5:
			showInitialScreen();
			break;
		}
	}

	private static void removeShelf() {
		// TODO Auto-generated method stub
		
	}

	private static void createShelf() {
		Shelf newShelf = new Shelf(sc.getInt("Inserir capacidade"), sc.getInt("Insira o id do produto a colocar"), sc.getInt("Insira o preco de aluguer"), sc.getInt("Insira contagem"));
		baseDadosShel.createEntity(newShelf);
		System.out.println("Prateleira criada com o id: " + newShelf.id);
	}

	// metodos para produtos
	private static void createProduct() {
		Product newProduct = new Product(sc.getInt("Insira preco base"), sc.getInt("Insira iva"));
		baseDadosProd.createEntity(newProduct);
		System.out.println("Produto criado com o id: " + newProduct.id);
	}

	private static void removeProduct() {
//		System.out.println(baseDadosProd.getAllIds());
		Collection<Long> allIds = baseDadosProd.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		if (arrayAllIds.length != 0) {
			System.out.println(baseDadosProd.getAllIds());
			long input = sc.getLong("Insira o id do produto que quer remover", arrayAllIds);
			baseDadosProd.removeEntity(input);
			System.out.println("Produto com o id:" + input + " removido!");
		} else {
			System.out.println("Nao ha produtos a remover!");
		}
	}

	private static void consultProduct() {
//		System.out.println(baseDadosProd.getAllIds());
		Collection<Long> allIds = baseDadosProd.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		if (arrayAllIds.length != 0) {
			System.out.println(baseDadosProd.getAllIds());
			long input = sc.getLong("Insira o id do produto a consultar", arrayAllIds);
			Product consultedProduct = baseDadosProd.consultEntity(input);
			System.out.println(consultedProduct);
		} else {
			System.out.println("Nao ha produtos a consultar!");
		}

	}

	private static void editProduct() {
//		System.out.println(baseDadosProd.getAllIds());
		Collection<Long> allIds = baseDadosProd.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		if (arrayAllIds.length != 0) {
			System.out.println(baseDadosProd.getAllIds());
			long input = sc.getLong("Insira o id do produto a editar", arrayAllIds);
			Product consultedProduct = baseDadosProd.consultEntity(input);
			int opcao = sc.getInt("Que parametro quer editar?\n1)Preco\n2)Iva");

			switch (opcao) {
			case 1:
				editarPrecoProd(consultedProduct);
				break;
			case 2:
				editarIvaProd(consultedProduct);
				break;
			}
			System.out.println(consultedProduct);

		} else {
			System.out.println("Nao ha produtos a editar!");
		}
	}

	private static void editarIvaProd(Product produto) {
		produto.setProductIva(sc.getInt("Insira novo IVA"));
		baseDadosProd.editEntity(produto);
	}

	private static void editarPrecoProd(Product produto) {

		produto.setPrice(sc.getInt("Insira novo preco"));
		baseDadosProd.editEntity(produto);
	}

}
