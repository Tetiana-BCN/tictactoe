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


private static void makeMove() {
    int row, col;
    boolean validMove = false;

    while (!validMove) {
        if (currentPlayer == 'X') {
            System.out.println("Player X - Enter row (0-2):");
            row = scanner.nextInt();
            System.out.println("Player X - Enter column (0-2):");
            col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = 'X';
                validMove = true;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        } else {
            makeComputerMove();
            validMove = true;
        }
    }
}

private static void makeComputerMove() {
    Random random = new Random();
    int row, col;
    do {
        row = random.nextInt(3);
        col = random.nextInt(3);
    } while (!isValidMove(row, col));

    board[row][col] = 'O';
    System.out.println("Computer played at Row: " + row + " Column: " + col);
}


