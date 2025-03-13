# TicTacToe
🎮 Implementation of the classic TicTacToe game in Java by Tetiana Vashchenko and Eva Sisalli

## Project Description
This project implements the TicTacToe game where two players (X and O) compete on a 3x3 board. The game allows playing against the computer, with move validation and error handling.

## Main Features
- 3x3 board implemented with multidimensional arrays
- Turn-based system
- Move validation
- Error handling for invalid input
- Console interface
- Computer opponent

## System Requirements
- Java 21
- Terminal or console for execution

## Usage Instructions
1. Compile the `TicTacToe.java` file
2. Run the program
3. Follow the on-screen instructions:
   - For X: Enter row and column (0-2)
   - For O (Computer): Move is made automatically
4. Game ends when there's a winner or draw

## Code Structure
- `board`: Two-dimensional array for the game board
- `currentPlayer`: Variable to control turns
- `gameOver`: Flag for game state
- `initializeGame()`: Initializes the board
- `displayBoard()`: Shows current state
- `makeMove()`: Handles player moves
- `getValidInput()`: Validates user input
- `makeComputerMove()`: Generates computer moves
- `isValidMove()`: Verifies move validity
- `checkGameState()`: Evaluates win/draw conditions

## Technical Topics Implemented
- Multidimensional arrays
- Object-oriented programming
- Error handling with try-catch
- Loops and conditionals
- Scanner for user input

## Methodology
- Pair programming
- Agile methodology
- One development sprint
- Git version control
