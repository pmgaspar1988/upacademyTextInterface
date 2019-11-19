package desafio3;

public class Desafio {

	public static int points(String[] strings) {
		// TODO Auto-generated method stub

		int result = 0;
		
		for (int i = 0; i < strings.length; i++) {
			String match = strings[i];
			String[] arrayMatch = match.split(":");
			if (Integer.parseInt(arrayMatch[0]) == Integer.parseInt(arrayMatch[1])) {
				result ++;
			}
			else if (Integer.parseInt(arrayMatch[0]) > Integer.parseInt(arrayMatch[1])) {
				result += 3;
			}
			
		}

		return result;

	}
}