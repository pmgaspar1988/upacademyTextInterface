package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
			editShelf();
			break;

		case 3:
			consultShelf();
			break;

		case 4:
			removeShelf();
			break;

		case 5:
			showInitialScreen();
			break;
		}
	}

	// metodos para prateleiras
	private static void editShelf() {
		Collection<Long> allIds = baseDadosShel.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		if (arrayAllIds.length != 0) {
			System.out.println(baseDadosShel.getAllIds());
			long input = sc.getLong("Insira o id da prateleira a editar", arrayAllIds);
			Shelf consultedShelf = baseDadosShel.consultEntity(input);
			int opcao = sc.getInt("Que parametro quer editar?\n1)Capacidade\n2)Preco de aluguer");

			switch (opcao) {
			case 1:
				editarCapacidade(consultedShelf);
				break;
			case 2:
				editarPrecoAluguer(consultedShelf);
				break;
			}
			System.out.println("Prateleira com o id:" + consultedShelf.getId() + " editada:" + consultedShelf);

		} else {
			System.out.println("Nao ha prateleiras a editar!");
		}
	}

	private static void editarPrecoAluguer(Shelf shelf) {
		shelf.setRentPrice(sc.getInt("Insira novo preco de aluguer"));
		baseDadosShel.editEntity(shelf);
	}

	private static void editarCapacidade(Shelf shelf) {
		shelf.setCapacity(sc.getInt("Insira nova capacidade da prateleira"));
		baseDadosShel.editEntity(shelf);
	}

	private static void consultShelf() {
		Collection<Long> allIds = baseDadosShel.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		if (arrayAllIds.length != 0) {
			System.out.println(baseDadosShel.getAllIds());
			long input = sc.getLong("Insira o id da prateleira", arrayAllIds);
			Shelf consultedShelf = baseDadosShel.consultEntity(input);
			System.out.println(consultedShelf);
		} else {
			System.out.println("Ainda nao foram criadas prateleiras!");
		}

	}

	private static void removeShelf() {
		Collection<Long> allIds = baseDadosShel.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		if (arrayAllIds.length != 0) {
			System.out.println(baseDadosShel.getAllIds());
			long input = sc.getLong("Insira o id da prateleira que quer remover", arrayAllIds);
			baseDadosShel.removeEntity(input);
			System.out.println("Prateleira com o id:" + input + " removido!");
		} else {
			System.out.println("Nao ha prateleiras a remover!");
		}
	}

	private static void createShelf() {
		Shelf newShelf = new Shelf(sc.getInt("Inserir capacidade"), sc.getInt("Insira o preco de aluguer"));
		baseDadosShel.createEntity(newShelf);
		System.out.println("Prateleira criada com o id: " + newShelf.getId());
	}

	// metodos para produtos
	private static void createProduct() {
		Product newProduct = new Product(sc.getInt("Insira preco base"), sc.getInt("Insira iva"));
		baseDadosProd.createEntity(newProduct);
		System.out.println("Produto criado com o id: " + newProduct.getId());
	}

	private static void removeProduct() {
//		System.out.println(baseDadosProd.getAllIds());
		Collection<Long> allIds = baseDadosProd.getAllIds();
		long[] arrayAllIds = allIds.stream().mapToLong(l -> l).toArray();
		if (arrayAllIds.length != 0) {
			System.out.println(baseDadosProd.getAllIds());
			long input = sc.getLong("Insira o id do produto que quer remover", arrayAllIds);
			removeProdFromShelves(input);
			baseDadosProd.removeEntity(input);
			System.out.println("Produto com o id:" + input + " removido!");
		} else {
			System.out.println("Nao ha produtos a remover!");
		}
	}

	private static void removeProdFromShelves(long input) {
		Product produto = baseDadosProd.consultEntity(input);
		ArrayList<Long> shelfList = produto.getShelves();
		for (Long maria : shelfList) {
			Shelf shelf = baseDadosShel.consultEntity(maria);
			shelf.setProductId(0);			
			baseDadosShel.editEntity(shelf);
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
			int opcao = sc.getInt("O que quer editar?\n1)Preco\n2)Iva\n3)Adicionar/Remover de uma prateleira", 1, 3);

			switch (opcao) {
			case 1:
				editarPrecoProd(consultedProduct);
				break;
			case 2:
				editarIvaProd(consultedProduct);
				break;
			case 3:
				addRemovePrat(consultedProduct);
					
			}
			System.out.println(consultedProduct);

		} else {
			System.out.println("Nao ha produtos a editar!");
		}
	}

	private static void addRemovePrat(Product produto) {
		int opcao = sc.getInt(
				"O que pretende fazer?\n1)Adicionar produto a uma prateleira\n2)Remover produto de uma prateleira");

		switch (opcao) {
		case 1:
			Collection<Long> allEmptyIds = new ArrayList<Long>();
			Collection<Shelf> allshelves = baseDadosShel.consultEntity();			
			Stream<Shelf> emptyShelves = allshelves.stream().filter(shelf -> shelf.getProductId() == 0);
			emptyShelves.forEach(shelf -> { 
				System.out.print(shelf.getId() + " ");
				allEmptyIds.add(shelf.getId());
			});
			System.out.println();
			
			long[] arrayAllEmptyIds = allEmptyIds.stream().mapToLong(l -> l).toArray();
			
			if (arrayAllEmptyIds.length != 0) {
				long idShelf = sc.getLong("Insira o id da prateleira", arrayAllEmptyIds);
				produto.addShelf(idShelf);
				Shelf shelf = baseDadosShel.consultEntity(idShelf);
				shelf.setProductId(produto.getId());
			} else {
				System.out.println("Ainda nao foram criadas prateleiras ou estao todas cheias!");
			}
			break;
		case 2:
			System.out.println(produto.getShelves());
			if (produto.getShelves().toArray().length != 0) {
				Collection<Long> pratIds = produto.getShelves();
				long[] arrayPratIds = pratIds.stream().mapToLong(l -> l).toArray();
				long input = sc.getLong("Insira o id da prateleira de onde quer remover o produto", arrayPratIds);
				produto.removeShelf(input);
				Shelf shelf = baseDadosShel.consultEntity(input);
				shelf.setProductId(0);
				baseDadosShel.editEntity(shelf);	
				System.out.println("Produto com o id:" + produto.getId() + " removido da prateleira com o id:" + input);
			} else {
				System.out.println("O produto ainda nao foi adicionado a nenhuma prateleira!");
			}
			break;
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
