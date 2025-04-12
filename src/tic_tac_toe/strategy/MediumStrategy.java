package tic_tac_toe.strategy;

import tic_tac_toe.board.Board;
import tic_tac_toe.board.Symbol;
import tic_tac_toe.game.WinChecker;

public class MediumStrategy implements BotStrategy {

	@Override
	public int[] getNextMove(Board board, Symbol symbol) {
		WinChecker winChecker = new WinChecker(board);

		for (int[] move : board.getEmptyCells()) {
			board.markCell(move[0], move[1], symbol);
			if (winChecker.checkWinner(symbol)) {
				board.removeCell(move[0], move[1]);
				return move;
			}
			board.removeCell(move[0], move[1]);
		}

		Symbol opponentSymbol = symbol.getOpposite();
		for (int[] move : board.getEmptyCells()) {
			board.markCell(move[0], move[1], opponentSymbol);
			if (winChecker.checkWinner(opponentSymbol)) {
				board.removeCell(move[0], move[1]);
				return move;
			}
			board.removeCell(move[0], move[1]);
		}

		return new EasyStrategy().getNextMove(board, symbol);
	}

}
