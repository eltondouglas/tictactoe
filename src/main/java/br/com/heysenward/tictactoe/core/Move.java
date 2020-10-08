package br.com.heysenward.tictactoe.core;

public class Move {

	private int i;

	private int j;

	public Move() {

	}

	public Move(String moveStr) {
		String[] tokens = moveStr.split(",");
		this.i = Integer.parseInt(tokens[0]);
		this.j = Integer.parseInt(tokens[1]);

		// TODO VALIDAR SE A ESTRUTURA DO MOVESTR ESTÁ CORRETA
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

}
