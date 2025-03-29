package tic_tac_toe.game;

import java.util.Scanner;

import tic_tac_toe.board.Board;
import tic_tac_toe.player.Player;

public class Game {

	private final Board board;
	private final Player[] players;
	private final WinChecker winChecker;
	private final Scanner scanner;
	private int currentPlayerIndex;

	public Game(int boardSize, Player[] players, Scanner scanner) {
		this.board = new Board(boardSize);
		this.players = players;
		this.winChecker = new WinChecker(board);
		this.scanner = scanner;
		this.currentPlayerIndex = 0;
	}

	public void start() {
		board.print();

		while (true) {
			Player currentPlayer = players[currentPlayerIndex];
			currentPlayer.play(board, scanner);
			board.print();

			if (winChecker.hasWinner()) {
				System.out.println(currentPlayer.getName() + " Wins!");
				return;
			}

			if (board.isFull()) {
				System.out.println("It's a draw!");
				return;
			}

			currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
		}
	}
}
