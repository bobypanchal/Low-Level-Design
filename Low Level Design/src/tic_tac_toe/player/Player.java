package tic_tac_toe.player;

import java.util.Scanner;

import tic_tac_toe.board.Board;
import tic_tac_toe.board.Symbol;

public abstract class Player {

	private final String name;
	private final Symbol symbol;

	public Player(String name, Symbol symbol) {
		this.name = name;
		this.symbol = symbol;
	}

	public String getName() {
		return this.name;
	}

	public Symbol getSymbol() {
		return this.symbol;
	}

	public abstract void play(Board board, Scanner scanner);
}
