# 🎮 Tic Tac Toe Game

## 📌 Overview

The **Tic Tac Toe** module is a part of the **LLM Project** and implements the classic Tic Tac Toe game with customizable board sizes and AI player support. The game is designed with modular architecture, making it easy to extend and integrate with other projects.

## ✅ Features
- 🏆 **Single-player (vs AI) & Multiplayer modes**
- 🔄 **Customizable board size** (minimum 3x3, maximum 7x7)
- 🎯 **Turn-based gameplay** ensuring fair play
- 🔍 **Move validation** to prevent invalid inputs
- 🏁 **Automatic win/draw detection**
- 📊 **Visually structured board display**
---

## 📂 Package Structure
```
src/
│── tic_tac_toe/
│   ├── board/         # Board management and game grid logic
│   ├── game/          # Game mechanics and logic
│   ├── player/        # Player interactions (human & AI)
│   ├── TicTacToe.java # Main entry point
│   ├── README.md      # Documentation (this file)
```

## 🏛️ Class Structure
```
│── TicTacToe (Main Class) 🚀
│   ├── Entry point of the application
│   ├── Accepts user input for board size and player mode
│   ├── Initializes players and starts the game
│
📦 board/
│── Board (Class) 📋
│   ├── Handles move placements
│   ├── Checks if a cell is empty
│   ├── Displays the board in a structured format
│   ├── Detects if the board is full (leading to a draw)
│── Symbol (Enum) 🔠
│   ├── Defines the symbols (X and O) used in the game
│   ├── Provides a method to get the opposite symbol
│
📦 game/
│── Game (Class) 🎮
│   ├── Manages the game loop and player interactions
│   ├── Handles turn management
│   ├── Validates moves and ensures fairness
│   ├── Uses WinChecker to determine the game outcome│
│── WinChecker (Class) 🏅
│   ├── Checks for a winner based on:
│       ├── Row match
│       ├── Column match
│       ├── Diagonal match
│
📦 player/
│── Player (Abstract Class)
│   ├── Represents a player with a name and symbol (X or O)
│   ├── Defines the abstract play() method for move-making
├── BotPlayer (Extends Player) 🤖
│   ├── AI-controlled player that makes strategic or random valid moves
├── HumanPlayer (Extends Player) 👤
│   ├── Allows a human player to input their move manually
```

## ▶️ How to Run
```sh
# Navigate to the TicTacToe directory
$ cd Low-Level-Design/src

# Compile the Java files
$ javac tic_tac_toe/*.java tic_tac_toe/board/*.java tic_tac_toe/game/*.java tic_tac_toe/player/*.java

# Run the game
$ java tic_tac_toe.TicTacToe
```

## 🎮 Gameplay Instructions
1. **Start the game** and select board size (**3 to 7**).
2. Choose between **Player vs Player** or **Player vs AI** mode.
3. Players take turns placing their symbols (X or O) on the board.
4. The game announces the winner or declares a draw if the board is full.
---

© 2025 Tic Tac Toe Project 🚀
