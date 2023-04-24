//FILE WRITTEN BY CARLOS Y. LOPEZ

package MineSweeper;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;


public class Minesweeper {
    private Board board;
    private int numFlags;
    private int numRevealed;
    private boolean flagged; 

    //constructor intalizing the game
    public Minesweeper(int numRows, int numCols, int numMines) {
        board = new Board(numRows, numCols, numMines);
        numFlags = 0;
        numRevealed = 0;
    }

    // Function to play the game and provide brief instructions
    public void play() {
        System.out.println("Starting new game...");
        System.out.println("Example input for reveal r 2 3, will reveal Row 2 Col 3.");
        System.out.println("Example input for reveal f 2 3, will Flag Row 2 Col 3.");
        board.printBoard();
    
        Scanner scanner = new Scanner(System.in);
        while (!board.isGameOver() && numRevealed + board.getMinePositions().size() < board.board.length * board.board[0].length) {
            System.out.print("Enter a command (r/f x y): ");
            String[] input = scanner.nextLine().split(" ");
            
            if (input.length != 3) {
                System.out.println("Invalid input. Please enter a command in the format 'r/f x y'.");
                continue;
            }
            
            try {
                int row = Integer.parseInt(input[1]);
                int col = Integer.parseInt(input[2]);
                int position = row * board.board[0].length + col;
    
                if (input[0].equals("r")) {
                    board.revealCell(position);
                    numRevealed++;
    
                    if (board.isGameOver()) {
                        System.out.println("Game over. You hit a mine!");
                        board.printBoard();
                        return;
                    }
                    //prevent game from crashing on invalid input
                } else if (input[0].equals("f")) {
                    board.flagCell(position);
                    numFlags += flagged ? 1 : -1;
                } else {
                    System.out.println("Invalid input. Please enter a command in the format 'r/f x y'.");
                    continue;
                }
                //prevent game from crashing on invalid input
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a command in the format 'r/f x y'.");
                continue;
            }
    
            board.printBoard();
        }
    
        if (numRevealed + board.getMinePositions().size() == board.board.length * board.board[0].length) {
            System.out.println( "You won the game!");
        }
    }
}