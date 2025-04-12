# 🎮 Tic Tac Toe Game

## 📌 Overview

The **Tic Tac Toe** game is a simple console-based implementation of the classic Tic Tac Toe game. It allows players to play in both **single-player (vs AI)** and **multiplayer** modes with customizable board sizes. The game includes AI that can play at varying levels of difficulty, and it automatically detects wins or draws.

## ✅ Features
- 🏆 **Single-player (vs AI) & Multiplayer modes**
- 🔄 **Customizable board size** (minimum 3x3, maximum 7x7)
- 🎯 **Turn-based gameplay** ensuring fair play
- 🔍 **Move validation** to prevent invalid inputs
- 🏁 **Automatic win/draw detection**
- 🧠 **AI Difficulty Levels** (Easy, Medium, Hard)
- ✨ **Bot plays using strategy patterns** for each difficulty level
---

## 📂 Package Structure
```
src/
│── tic_tac_toe/
│   ├── board/         # Board management and game grid logic
│   ├── game/          # Game mechanics and logic
│   ├── player/        # Player interactions (human & AI)
│   ├── strategy/      # Bot strategies and difficulty levels
│   ├── TicTacToe.java # Main entry point
│   ├── README.md      # Documentation (this file)
```

## 🏛️ Class Structure
```
│── TicTacToe (Main Class) 🚀
│   ├── Entry point of the application
│   ├── Accepts user input for board size, player mode, and AI difficulty level
│   ├── Initializes players and starts the game
│   ├── Supports replay functionality (Y/N)
│
📦 board/
│── Board (Class) 📋
│   ├── Handles move placements on the board grid
│   ├── Checks if a cell is empty or occupied
│   ├── Displays the board in a structured format for player interaction
│   ├── Detects if the board is full, indicating a draw
│── Symbol (Enum) 🔠
│   ├── Defines the symbols (X and O) used in the game
│   ├── Provides a method to get the opposite symbol for alternating turns
│
📦 game/
│── Game (Class) 🎮
│   ├── Manages the game loop and player interactions
│   ├── Handles turn management, alternating between players
│   ├── Validates moves, ensures fairness, and detects win/draw
│   ├── Uses WinChecker to determine the game outcome based on rows, columns, or diagonals
│── WinChecker (Class) 🏅
│   ├── Checks for a winner based on:
│       ├── Row match
│       ├── Column match
│       ├── Diagonal match
│
📦 player/
│── Player (Abstract Class)
│   ├── Represents a player with a name and symbol (X or O)
│   ├── Defines the abstract play() method, which is implemented by subclasses (Human or Bot)
├── BotPlayer (Extends Player) 🤖
│   ├── AI-controlled player that makes strategic or random valid moves
│   ├── Uses different strategies based on selected difficulty (Easy, Medium, Hard)
├── HumanPlayer (Extends Player) 👤
│   ├── Allows a human player to input their move manually (row and column)
│   ├── Ensures move is within board range and not already occupied
│
📦 strategy/
│── DifficultyLevel (Enum) 🎮
│   ├── Defines the difficulty levels for BotPlayer (Easy, Medium, Hard)
│── BotStrategy (Interface) 🤖
│   ├── Provides a method for BotPlayer to determine its next move based on difficulty
├── EasyStrategy (Class) 🧠
│   ├── Implements a simple random move strategy for the bot
├── MediumStrategy (Class) 🧠
│   ├── Implements a strategy that blocks opponent's winning moves and makes random moves if no immediate threat
├── HardStrategy (Class) 🧠
│   ├── Implements the minimax algorithm for optimal play, considering future game outcomes
```

## ▶️ How to Run
```sh
# Compile the Java files
$ javac tic_tac_toe/*.java tic_tac_toe/board/*.java tic_tac_toe/game/*.java tic_tac_toe/player/*.java tic_tac_toe/strategy/*.java

# Run the game
$ java tic_tac_toe.TicTacToe
```

## 🎮 Gameplay Instructions
1. **Start the game** by selecting a board size (between **3x3** and **7x7**).
2. Choose between **Player vs Player** or **Player vs AI** mode.
3. If playing vs AI, select a **difficulty level** for the bot: **Easy**, **Medium**, or **Hard**.
4. Players take turns placing their symbols (X or O) on the board.
5. The game announces the winner or declares a draw if the board is full.
6. You can choose to play again after a game ends by answering **Y/N**.
---

© 2025 Tic Tac Toe Project 🚀
