package desafio4;

import java.util.ArrayList;

public class Desafio {

	public static int[] ints(String string) {
		// TODO Auto-generated method stub

		String[] arrayStrings = string.split(" ");
		ArrayList<Integer> resultArray = new ArrayList<Integer>();

		for (int i = 0; i < arrayStrings.length; i++) {
			String element = arrayStrings[i];
			if (isNumeric(element) == true) {
				int num = Integer.parseInt(element);
				resultArray.add(num);
			}
		}

		int[] result = resultArray.stream().mapToInt(i -> i).toArray();
		
		return result;
	}

	public static boolean isNumeric(String str) {
	    return str.matches("-?\\d+(\\.\\d+)?");
	}

}
