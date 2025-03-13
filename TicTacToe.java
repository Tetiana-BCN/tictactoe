import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static char[][] board;
    private static char currentPlayer;
    private static boolean gameOver;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeGame();

        while (!gameOver) {
            displayBoard();
            makeMove();
            checkGameState();
        }

        displayFinalResult();
        scanner.close();
    }
}

private static void initializeGame() {
    board = new char[3][3];
    currentPlayer = 'X';
    gameOver = false;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            board[i][j] = '-';
        }
    }
}

private static void displayBoard() {
    System.out.println("\n-------------");
    for (int i = 0; i < 3; i++) {
        System.out.print("| ");
        for (int j = 0; j < 3; j++) {
            System.out.print(board[i][j] + " | ");
        }
        System.out.println("\n-------------");
    }
    System.out.println();
}