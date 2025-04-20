package tic_tac_toe;

import java.util.Scanner;

import tic_tac_toe.board.Symbol;
import tic_tac_toe.game.Game;
import tic_tac_toe.player.BotPlayer;
import tic_tac_toe.player.HumanPlayer;
import tic_tac_toe.player.Player;
import tic_tac_toe.strategy.DifficultyLevel;

public class TicTacToe {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int boardSize;
		while (true) {
			System.out.print("Enter Board Size (minimum 3, maximum 7): ");
			boardSize = scanner.nextInt();
			scanner.nextLine();

			if (boardSize >= 3 && boardSize <= 7)
				break;
			System.out.println("Invalid board size! Please enter a number between 3 and 7.");
		}

		int playerCount;
		while (true) {
			System.out.print("Enter the number of players (must be 1 or 2): ");
			playerCount = scanner.nextInt();
			scanner.nextLine();

			if (playerCount == 1 || playerCount == 2)
				break;
			System.out.println("Invalid player count! Please enter 1 or 2 players.");
		}

		Player[] players = initializePlayers(scanner, playerCount);

		boolean playAgain;
		do {
			new Game(boardSize, players, scanner).start();

			System.out.print("Do you want to play again? (Y/N): ");
			String response = scanner.nextLine().trim().toUpperCase();
			playAgain = response.equals("Y");
		} while (playAgain);

		System.out.println("Thank you for playing Tic-Tac-Toe! Have a great day!");
		scanner.close();
	}

	private static Player[] initializePlayers(Scanner scanner, int playerCount) {
		Player[] players = new Player[2];

		System.out.print("Enter Player 1 Name: ");
		String player1Name = scanner.nextLine();

		Symbol player1Symbol;
		while (true) {
			System.out.print("Choose Symbol for Player 1 (X or O): ");
			player1Symbol = Symbol.fromString(scanner.next());
			scanner.nextLine();

			if (player1Symbol != null)
				break;
			System.out.println("Invalid Symbol! Choose either X or O.");
		}

		players[0] = new HumanPlayer(player1Name, player1Symbol);

		if (playerCount == 2) {
			System.out.print("Enter Player 2 Name: ");
			String player2Name = scanner.nextLine();
			players[1] = new HumanPlayer(player2Name, player1Symbol.getOpposite());
		} else {
			DifficultyLevel difficulty = null;
			do {
				System.out.print("Choose difficulty: 1. Easy  2. Medium  3. Hard: ");
				int choice = scanner.nextInt();
				scanner.nextLine();

				if (choice == 1) {
					difficulty = DifficultyLevel.EASY;
				} else if (choice == 2) {
					difficulty = DifficultyLevel.MEDIUM;
				} else if (choice == 3) {
					difficulty = DifficultyLevel.HARD;
				} else {
					System.out.println("Invalid choice. Please enter 1, 2, or 3.");
				}
			} while (difficulty == null);
			players[1] = new BotPlayer("Bot", player1Symbol.getOpposite(), difficulty);
		}

		return players;
	}
}