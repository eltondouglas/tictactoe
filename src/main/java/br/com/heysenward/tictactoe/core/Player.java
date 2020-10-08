package br.com.heysenward.tictactoe.core;

import br.com.heysenward.tictactoe.ui.UI;

public class Player {

	private String name;

	private char symbol;

	private Board board;

	public Player() {

	}

	public Player(String name, Board board, char symbol) {
		this.name = name;
		this.symbol = symbol;
		this.board = board;
	}

	private Move inputMove() {
		String moveStr = UI.readInput("JOGADOR '" + name + "' =>");
		return new Move(moveStr);
	}

	public void play() {
		Move move = inputMove();
		board.play(this, move);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
