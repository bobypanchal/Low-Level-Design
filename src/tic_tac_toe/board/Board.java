package tic_tac_toe.board;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private final Symbol[][] cells;

	public Board(int size) {
		this.cells = new Symbol[size][size];
	}

	public List<int[]> getEmptyCells() {
		List<int[]> moves = new ArrayList<>();
		int size = cells.length;
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (isCellEmpty(row, col)) {
					moves.add(new int[] { row, col });
				}
			}
		}
		return moves;
	}

	public boolean isCellEmpty(int row, int col) {
		return cells[row][col] == null;
	}

	public void markCell(int row, int col, Symbol symbol) {
		cells[row][col] = symbol;
	}

	public void removeCell(int row, int col) {
		cells[row][col] = null;
	}

	public Symbol getCell(int row, int col) {
		return cells[row][col];
	}

	public int getSize() {
		return cells.length;
	}

	public boolean isFull() {
		for (Symbol[] row : cells) {
			for (Symbol cell : row) {
				if (cell == null) {
					return false;
				}
			}
		}
		return true;
	}

	public void print() {
		int size = cells.length;

		StringBuilder strRow = new StringBuilder("    ");
		StringBuilder strRowSeperator = new StringBuilder("  -");

		for (int col = 0; col < size; col++) {
			strRow.append(col).append("   ");
			strRowSeperator.append("----");
		}
		System.out.println(strRow.toString());
		System.out.println(strRowSeperator.toString());

		for (int row = 0; row < size; row++) {
			strRow = new StringBuilder(row + " ");
			strRowSeperator = new StringBuilder("  -");
			for (int col = 0; col < size; col++) {
				strRow.append("| ").append(cells[row][col] == null ? " " : cells[row][col]).append(" ")
						.append(col == size - 1 ? "|" : "");
				strRowSeperator.append("----");
			}

			System.out.println(strRow.toString());
			System.out.println(strRowSeperator.toString());
		}
		System.out.println();
	}
}