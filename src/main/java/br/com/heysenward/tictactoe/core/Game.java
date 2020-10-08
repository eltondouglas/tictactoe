package br.com.heysenward.tictactoe.core;

import br.com.heysenward.tictactoe.Constants;
import br.com.heysenward.tictactoe.ui.UI;

public class Game {

	private Board board = new Board();
	private Player[] players = new Player[Constants.SYMBOL_PLAYER.length];
	private int currentPlayerIndex = 0;

	public void play() {

		UI.printGameTitle();
		for (int i = 0; i < players.length; i++) {
			players[i] = createPlayer(i);
		}
	}

	private Player createPlayer(int index) {
		String nome = UI.readInput("Jogador " + (index + 1) + " =>");
		char symbol = Constants.SYMBOL_PLAYER[index];
		Player player = new Player(nome, board, symbol);

		UI.printText("o jogador " + nome + " vai usar o simbolo '" + symbol + "'");
		return player;
	}

	private Player nextPlayer() {
		currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
		return players[currentPlayerIndex];
	}

}
