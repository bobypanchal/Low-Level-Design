package tic_tac_toe.player;

import java.util.Random;
import java.util.Scanner;

import tic_tac_toe.board.Board;
import tic_tac_toe.board.Symbol;

public class BotPlayer extends Player {

	public BotPlayer(String name, Symbol symbol) {
		super(name, symbol);
	}

	@Override
	public void play(Board board, Scanner scanner) {
		Random rand = new Random();
		int row, col;
		do {
			row = rand.nextInt(board.getSize());
			col = rand.nextInt(board.getSize());
		} while (!board.isCellEmpty(row, col));

		board.markCell(row, col, this.getSymbol());
		System.out.println(this.getName() + " placed " + this.getSymbol() + " at " + row + "," + col);
	}
}
