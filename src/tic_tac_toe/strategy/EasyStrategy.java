package tic_tac_toe.strategy;

import java.util.Random;

import tic_tac_toe.board.Board;
import tic_tac_toe.board.Symbol;

public class EasyStrategy implements BotStrategy {

	private final Random rand = new Random();

	@Override
	public int[] getNextMove(Board board, Symbol symbol) {
		int row, col;
		do {
			row = rand.nextInt(board.getSize());
			col = rand.nextInt(board.getSize());
		} while (!board.isCellEmpty(row, col));
		return new int[] { row, col };
	}

}
