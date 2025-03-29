package tic_tac_toe.player;

import java.util.Scanner;

import tic_tac_toe.board.Board;
import tic_tac_toe.board.Symbol;

public class HumanPlayer extends Player {

	public HumanPlayer(String name, Symbol symbol) {
		super(name, symbol);
	}

	@Override
	public void play(Board board, Scanner scanner) {
		int row, col;
		int maxColumnIndex = board.getSize() - 1;

		while (true) {
			System.out.print(this.getName() + ", enter your move (row [0-" + maxColumnIndex + "] and column [0-" + maxColumnIndex + "]), e.g., 0 1): ");
			row = scanner.nextInt();
			col = scanner.nextInt();
			scanner.nextLine();

			if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
				System.out.println("Invalid move! Please enter values within the board range.");
				continue;
			}

			if (board.isCellEmpty(row, col)) {
				break;
			} else {
				System.out.println("Cell already occupied! Choose another cell.");
			}
		}

		board.markCell(row, col, this.getSymbol());
	}
}
