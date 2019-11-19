package desafio2;

public class Desafio {

	public static String order(String string) {
		// TODO Auto-generated method stub

		String[] arrayStrings = string.split(" ");

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= arrayStrings.length; i++) {
			for (String word : arrayStrings) {
				char[] chars = word.toCharArray();

				for (char c : chars) {
					if (c == i + '0') {
						
						sb.append(word);
						sb.append(" ");
						
					}
				}
			}
		}
		String trimmedStr = sb.toString().trim();
	
	
		
		return trimmedStr;
	}

}
