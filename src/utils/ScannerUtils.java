package utils;

import java.util.Scanner;

public class ScannerUtils {
	private Scanner sc = new Scanner(System.in);

	public int getInt(String msg) {
		System.out.println(msg);

		while (sc.hasNextInt() == false) {// verifica se a string pode ser int
			System.out.println("Tem de ser um numero!\n" + msg);
			sc.nextLine();// se for texto volta-se a inserir um numero
		}
		int input = sc.nextInt();
		sc.nextLine();
		return input;
	}
	
//	public long getLong(String msg) {
//		System.out.println(msg);
//
//		while (sc.hasNextLong() == false) {// verifica se a string pode ser int
//			System.out.println("Tem de ser um numero!\n" + msg);
//			sc.nextLine();// se for texto volta-se a inserir um numero
//		}
//		long input = sc.nextLong();
//		sc.nextLine();
//		return input;
//	}

	public int getInt(String msg, int min, int max) {
		int input = 0;
		
		input = getInt(msg);
		
		while (input > max || input < min) {
			
			input = getInt("O numero tem de ser entre " + min + " e " + max + "!\n" + msg);
		}
		return input;
	}

	public int getInt(String msg, int[] value) {
		int input = getInt(msg);
		boolean existe = false;
		while (existe == false) {			
			for (int i = 0; i < value.length; i++) {
				if (input == value[i]) {
					existe = true;
				}
			}
			if (existe== false) {
				input = getInt("Tem de ser uma das opcoes!");
			}
		}
		return input;
	}
	
	public long getLong(String msg, long[] value) {
		int input = getInt(msg);
		boolean existe = false;
		while (existe == false) {			
			for (int i = 0; i < value.length; i++) {
				if ((long)input == value[i]) {
					existe = true;
				}
			}
			if (existe== false) {
				input = getInt("Tem de inserir uma das opcoes existentes!");
			}
		}
		return (long)input;
	}
	
	public String getStr(String msg) {
		System.out.println(msg);
		String input = sc.nextLine();
		return input;
	}
}
