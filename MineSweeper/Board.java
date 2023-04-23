package MineSweeper;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class Board {
    int[][] board;
    private boolean[][] flagged;
    private boolean[][] revealed;
    private boolean gameOver;
    private Set<Integer> minePositions;
    private int numMines;

    //initalize the game board

    public Board(int numRows, int numCols, int numMines)
    {
        board = new int [numRows][numCols];
        revealed = new boolean[numRows][numCols];
        flagged = new boolean[numRows][numCols];

        this.numMines = numMines;
        gameOver = false;

        minePositions = new HashSet<Integer>();
        generateBoard();
    }

    //Function to generate the game board
    private void generateBoard() {
        //randomly palce the mines on the board

        Random random = new Random();
        int numMinesPlaced = 0;

        while (numMinesPlaced < numMines) {
            int position = random.nextInt(board.length * board[0].length);
            int row = position / board[0].length;
            int col = position % board[0].length;

            if (board[row][col] != -1) {
                board[row][col] = -1;
                minePositions.add(position);
                numMinesPlaced++;
            }
        }



        //calc the number of mines adjacent for each non-mine cell

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != -1) {
                    int numAdjacentMines = 0;
                    for (int x = i - 1; x <= i + 1; x++) {
                        for (int y = j - 1; y <= j + 1; y++) {
                            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == -1) {
                                numAdjacentMines++;
                            }
                        }
                    }
                    board[i][j] = numAdjacentMines;
                }
            }
        }
    }


    //Function to print the text-based game board

    public void printBoard() {
        System.out.print("  ");

        for (int j = 0; j < board[0].length; j++) {
            System.out.print(j + " ");
        }

        System.out.println();

        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board[0].length; j++) {
                if (!revealed[i][j] && !flagged[i][j]) {
                    System.out.print(". ");
                } else if (flagged[i][j]) {
                    System.out.print("F ");
                } else if (board[i][j] == -1) {
                    System.out.print("* ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Reveal Cells on game board
   public void revealCell(int position) {
    int row = position / board[0].length;
    int col = position % board[0].length;

    if (board[row][col] == -1) {
        gameOver = true;
        return;
    }

    revealed[row][col] = true;
    if (board[row][col] == 0) {
        // stack to process adjacent cells
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(position);

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            int currRow = curr / board[0].length;
            int currCol = curr % board[0].length;

            for (int x = currRow - 1; x <= currRow + 1; x++) {
                for (int y = currCol - 1; y <= currCol + 1; y++) {
                    if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !revealed[x][y] && !flagged[x][y]) {
                        revealed[x][y] = true;
                        if (board[x][y] == 0) {
                            stack.push(x * board[0].length + y);
                        }
                    }
                }
            }
        }
    }
}

//function to flag a cell on the gameboard

public void flagCell (int position)
{
    int row = position / board[0].length;
    int col = position % board[0].length;

    flagged[row][col] = !flagged[row][col];
}

//check if game is over

public boolean isGameOver() {
    return gameOver;
}

//get the position of the mines

public Set<Integer> getMinePositions() {
    return minePositions;
}






}
