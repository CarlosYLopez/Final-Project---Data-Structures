// Aldo Vega
// Functions Used  2D array and Memory Stack

package connect4;

import java.util.Scanner;

public class Connect4 {
    private Connect4Board board;
    private char currentPlayer;

    public Connect4() {
        board = new Connect4Board();
        currentPlayer = 'R';
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;
        int totalMoves = 0;

        while (!gameOver && totalMoves < Connect4Board.ROWS * Connect4Board.COLUMNS) {
            board.displayBoard();
            System.out.println("Player " + currentPlayer + ", enter column (1-7) or 'u' to undo last move:");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("u")) {
                if (board.undoLastMove()) {
                    currentPlayer = (currentPlayer == 'R') ? 'Y' : 'R';
                } else {
                    System.out.println("No moves to undo.");
                }
            } else {
                try {
                    int column = Integer.parseInt(input) - 1;
                    int row = board.placePiece(column, currentPlayer);
                    if (row != -1) {
                        if (board.isWin(row, column)) {
                            gameOver = true;
                        } else {
                            currentPlayer = (currentPlayer == 'R') ? 'Y' : 'R';
                            totalMoves++;
                        }
                    } else {
                        System.out.println("Invalid move. Column is full.");
                    }
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("Invalid input. Please enter a valid column number (1-7).");
                }
            }
        }

        board.displayBoard();

        if (gameOver) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
