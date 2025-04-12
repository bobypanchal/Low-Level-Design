package tic_tac_toe.strategy;

import tic_tac_toe.board.Board;
import tic_tac_toe.board.Symbol;
import tic_tac_toe.game.WinChecker;

public class HardStrategy implements BotStrategy {

	@Override
	public int[] getNextMove(Board board, Symbol bot) {
		int[] result = minimax(board, bot, true);
		return new int[] { result[1], result[2] };
	}

	private int[] minimax(Board board, Symbol symbol, boolean isMaximizing) {
		WinChecker winChecker = new WinChecker(board);
		Symbol opponentSymbol = symbol.getOpposite();

		if (winChecker.checkWinner(symbol))
			return new int[] { 1, -1, -1 };
		if (winChecker.checkWinner(opponentSymbol))
			return new int[] { -1, -1, -1 };
		if (board.getEmptyCells().isEmpty())
			return new int[] { 0, -1, -1 };

		int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		int[] bestMove = { -1, -1 };

		for (int[] move : board.getEmptyCells()) {
			board.markCell(move[0], move[1], isMaximizing ? symbol : opponentSymbol);
			int score = minimax(board, symbol, !isMaximizing)[0];
			board.removeCell(move[0], move[1]);

			if ((isMaximizing && score > bestScore) || (!isMaximizing && score < bestScore)) {
				bestScore = score;
				bestMove = move;
			}
		}

		return new int[] { bestScore, bestMove[0], bestMove[1] };
	}

}
