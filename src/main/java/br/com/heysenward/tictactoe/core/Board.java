package br.com.heysenward.tictactoe.core;

import br.com.heysenward.tictactoe.Constants;
import br.com.heysenward.tictactoe.ui.UI;

public class Board {

	private char[][] matrix;

	public Board() {
		matrix = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		clear();
	}

	public void clear() {
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {

				matrix[i][j] = ' ';
			}
		}
	}

	public void print() {
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {

				if (j < matrix[i].length - 1) {

					UI.printTextWithNoNewLine(matrix[i][j] + "  |");
				} else {

					UI.printTextWithNoNewLine(String.valueOf(matrix[i][j]));
				}
			}
			UI.printNewLine();

			if (i < matrix.length - 1) {
				for (int l = 0; l < matrix.length; l++) {

					UI.printTextWithNoNewLine("----");
				}
				UI.printNewLine();
			}
		}

	}

	public boolean play(Player player, Move move) {
		int r = move.getI();
		int c = move.getJ();

		// TODO validar os movimentos

		this.matrix[r][c] = player.getSymbol();

		return checkRows(player) || checkColumns(player) || checkDiagonal1(player) || checkDiagonal2(player);
	}

	public boolean isFull() {
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	private boolean checkRow(int row, Player p) {
		char symbol = p.getSymbol();

		for (int column = 0; column < Constants.BOARD_SIZE; column++) {
			if (matrix[row][column] != symbol) {
				return false;
			}
		}
		return false;
	}

	private boolean checkRows(Player p) {
		for (int row = 0; row < Constants.BOARD_SIZE; row++) {
			if (checkRow(row, p)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkColumns(Player p) {
		for (int column = 0; column < Constants.BOARD_SIZE; column++) {
			if (checkColumn(column, p)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkColumn(int column, Player p) {
		char symbol = p.getSymbol();

		for (int row = 0; row < Constants.BOARD_SIZE; row++) {
			if (matrix[row][column] != symbol) {
				return false;
			}
		}
		return true;
	}

	private boolean checkDiagonal1(Player p) {
		char symbol = p.getSymbol();

		for (int i = 0; i < Constants.BOARD_SIZE; i++) {

			if (matrix[i][i] != symbol) {
				return false;
			}
		}
		return true;
	}

	private boolean checkDiagonal2(Player p) {
		char symbol = p.getSymbol();
		int col = Constants.BOARD_SIZE - 1;
		for (int row = 0; row < Constants.BOARD_SIZE; row++) {
			if (matrix[row][col] != symbol) {
				return false;
			}
			col -= 1;
		}
		return true;
	}
}
