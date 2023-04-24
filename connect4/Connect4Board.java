// Aldo Vega
// Functions Used  2D array and Memory Stack

package connect4;

import java.util.*;

public class Connect4Board {
    public static final int ROWS = 6;
    public static final int COLUMNS = 7;
    private static final int CONNECT = 4;
    private char[][] board;
    private Stack<int[]> lastMoves;

    public Connect4Board() {
        board = new char[ROWS][COLUMNS];
        lastMoves = new Stack<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = '-';
            }
        }
    }

    //print the board
    public void displayBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    //replace valid empty square with piece
    public int placePiece(int column, char player) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == '-') {
                board[i][column] = player;
                lastMoves.push(new int[]{i, column});
                return i;
            }
        }
        return -1;
    }

    public boolean isWin(int row, int col) {
        char player = board[row][col];
        int count;
    
        // Check horizontally
        count = 0;
        for (int j = 0; j < COLUMNS; j++) {
            if (board[row][j] == player) {
                count++;
                if (count == CONNECT) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
    
        // Check vertically
        count = 0;
        for (int i = 0; i < ROWS; i++) {
            if (board[i][col] == player) {
                count++;
                if (count == CONNECT) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
    
        // Check diagonally (top-left to bottom-right)
        count = 0;
        int i = row - Math.min(row, col);
        int j = col - Math.min(row, col);
        while (i < ROWS && j < COLUMNS) {
            if (board[i][j] == player) {
                count++;
                if (count == CONNECT) {
                    return true;
                }
            } else {
                count = 0;
            }
            i++;
            j++;
        }
    
        // Check diagonally (bottom-left to top-right)
        count = 0;
        i = row + Math.min(ROWS - row - 1, col);
        j = col - Math.min(ROWS - row - 1, col);
        while (i >= 0 && j < COLUMNS) {
            if (board[i][j] == player) {
                count++;
                if (count == CONNECT) {
                    return true;
                }
            } else {
                count = 0;
            }
            i--;
            j++;
        }
    
        return false;
    }

    //undo button
    public boolean undoLastMove() {
        if (!lastMoves.isEmpty()) {
            int[] lastMove = lastMoves.pop();
            board[lastMove[0]][lastMove[1]] = '-';
            return true;
        }
        return false;
    }
}
