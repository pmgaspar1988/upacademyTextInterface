package desafio1;

public class Desafio {

	private int input;
	private int big3Count;
	private int big5Count;

	public Desafio(int input) {
		// TODO Auto-generated constructor stub
		this.input= input;
	}

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= input; i++) {
			if (i % 3 == 0) {
				big3Count++;
			}
			if (i % 5 == 0) {
				big5Count++;
			}
		}

	}

	public int getBig3Count() {
		// TODO Auto-generated method stub
		return big3Count;
	}

	public int getBig5Count() {
		// TODO Auto-generated method stub
		return big5Count;
	}

}
