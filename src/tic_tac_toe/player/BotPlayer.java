package tic_tac_toe.player;

import java.util.Scanner;

import tic_tac_toe.board.Board;
import tic_tac_toe.board.Symbol;
import tic_tac_toe.strategy.BotStrategy;
import tic_tac_toe.strategy.DifficultyLevel;
import tic_tac_toe.strategy.EasyStrategy;
import tic_tac_toe.strategy.HardStrategy;
import tic_tac_toe.strategy.MediumStrategy;

public class BotPlayer extends Player {

	private final BotStrategy strategy;

	public BotPlayer(String name, Symbol symbol, DifficultyLevel difficulty) {
		super(name, symbol);
		this.strategy = getStrategyByDifficulty(difficulty);
	}

	private static BotStrategy getStrategyByDifficulty(DifficultyLevel difficulty) {
		return switch (difficulty) {
		case EASY -> new EasyStrategy();
		case MEDIUM -> new MediumStrategy();
		case HARD -> new HardStrategy();
		};
	}

	@Override
	public void play(Board board, Scanner scanner) {
		int[] cell = strategy.getNextMove(board, this.getSymbol());
		board.markCell(cell[0], cell[1], this.getSymbol());
		System.out.println(this.getName() + " placed " + this.getSymbol() + " at " + cell[0] + ", " + cell[1]);
	}
}
