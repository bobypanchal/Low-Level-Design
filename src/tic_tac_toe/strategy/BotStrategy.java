package tic_tac_toe.strategy;

import tic_tac_toe.board.Board;
import tic_tac_toe.board.Symbol;

public interface BotStrategy {

	int[] getNextMove(Board board, Symbol bot);

}
