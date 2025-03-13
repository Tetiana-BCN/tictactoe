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