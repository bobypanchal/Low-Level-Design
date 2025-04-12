package tic_tac_toe.game;

import tic_tac_toe.board.Board;
import tic_tac_toe.board.Symbol;

public class WinChecker {

	private final Board board;

	public WinChecker(Board board) {
		this.board = board;
	}

	public boolean checkWinner(Symbol symbol) {
		if (symbol == null)
			return false;

		for (int i = 0; i < board.getSize(); i++) {
			if (checkRow(i, symbol) || checkColumn(i, symbol)) {
				return true;
			}
		}
		return checkMainDiagonal(symbol) || checkAntiDiagonal(symbol);
	}

	private boolean checkRow(int row, Symbol symbol) {
		for (int col = 0; col < board.getSize(); col++) {
			if (board.getCell(row, col) != symbol) {
				return false;
			}
		}
		return true;
	}

	private boolean checkColumn(int col, Symbol symbol) {
		for (int row = 0; row < board.getSize(); row++) {
			if (board.getCell(row, col) != symbol) {
				return false;
			}
		}
		return true;
	}

	private boolean checkMainDiagonal(Symbol symbol) {
		for (int i = 0; i < board.getSize(); i++) {
			if (board.getCell(i, i) != symbol) {
				return false;
			}
		}
		return true;
	}

	private boolean checkAntiDiagonal(Symbol symbol) {
		int size = board.getSize();
		for (int i = 0; i < size; i++) {
			if (board.getCell(i, size - 1 - i) != symbol) {
				return false;
			}
		}
		return true;
	}
}
