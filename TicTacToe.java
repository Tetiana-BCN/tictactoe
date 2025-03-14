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

    private static void initializeGame() {
        System.out.println("\t\nWelcome to the game Tic Tac Toe");
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

    private static void makeMove() {
        int row, col;
        boolean validMove = false;

        while (!validMove) {
            if (currentPlayer == 'X') {

                row = getValidInput("Player X - Choose and enter row (0-2):");
                col = getValidInput("Player X - Choose and enter column (0-2):");

                if (isValidMove(row, col)) {
                    board[row][col] = 'X';
                    validMove = true;
                } else {
                    System.out.println(
                            "Invalid move. That position is either out of bounds or already taken. Try again.");
                }
            } else {
                makeComputerMove();
                validMove = true;
            }
        }
    }

    private static int getValidInput(String prompt) {
        int number;
        while (true) {
            System.out.println(prompt);
            try {
                number = scanner.nextInt();
                if (number >= 0 && number <= 2) {
                    return number;
                } else {
                    System.out.println("Invalid input. Choose and enter a number(0-2) Try again.");
                    scanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Choose and enter a number(0-2) Try again.");
                scanner.next();
                scanner.nextLine();
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

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        return board[row][col] == '-';
    }

    private static void checkGameState() {
        if (isWinner()) {
            displayBoard();
            System.out.println("Congratulations! " + (currentPlayer == 'X' ? "Player X" : "Computer") + " wins!");
            gameOver = true;
            return;
        }

        if (isDraw()) {
            displayBoard();
            System.out.println("It's a draw!");
            gameOver = true;
            return;
        }

        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean isWinner() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) ||
                    (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i])) {
                return true;
            }
        }

        if ((board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
            return true;
        }

        return false;
    }

    private static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void displayFinalResult() {
        System.out.println("End of the game.");
    }
}
