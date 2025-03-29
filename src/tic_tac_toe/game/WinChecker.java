package tic_tac_toe.game;

import tic_tac_toe.board.Board;
import tic_tac_toe.board.Symbol;

public class WinChecker {

	private final Board board;

	public WinChecker(Board board) {
		this.board = board;
	}

	boolean hasWinner() {
		for (int i = 0; i < board.getSize(); i++) {
			if (checkRow(i) || checkColumn(i)) {
				return true;
			}
		}
		return checkMainDiagonal() || checkAntiDiagonal();
	}

	private boolean checkRow(int row) {
		Symbol symbol = board.getCell(row, 0);
		if (symbol == null)
			return false;

		for (int i = 1; i < board.getSize(); i++) {
			if (board.getCell(row, i) != symbol) {
				return false;
			}
		}
		return true;
	}

	private boolean checkColumn(int col) {
		Symbol symbol = board.getCell(0, col);
		if (symbol == null)
			return false;

		for (int i = 1; i < board.getSize(); i++) {
			if (board.getCell(i, col) != symbol) {
				return false;
			}
		}
		return true;
	}

	private boolean checkMainDiagonal() {
		Symbol symbol = board.getCell(0, 0);
		if (symbol == null)
			return false;

		for (int i = 1; i < board.getSize(); i++) {
			if (board.getCell(i, i) != symbol) {
				return false;
			}
		}
		return true;
	}

	private boolean checkAntiDiagonal() {
		int size = board.getSize();
		Symbol symbol = board.getCell(0, size - 1);
		if (symbol == null)
			return false;

		for (int i = 1; i < size; i++) {
			if (board.getCell(i, size - 1 - i) != symbol) {
				return false;
			}
		}
		return true;
	}
}
