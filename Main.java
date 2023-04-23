import java.util.Scanner;
import Blackjack.Blackjack;
import MineSweeper.Minesweeper;
import connect4.Connect4;
import hangman.Hangman;
import hangman.WordList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continuePlaying = true;
        while (continuePlaying) { // Loop until user chooses to quit
            System.out.println("Welcome to the game hub!");
            System.out.println("Select a game to play:");
            System.out.println("1. Minesweeper");
            System.out.println("2. Blackjack");
            System.out.println("3. Hangman");
            System.out.println("4. Connect4");
            System.out.println("5. Quit"); // Add a quit option

            int choice = scanner.nextInt();
            if (choice == 1) {
                Minesweeper game = new Minesweeper(10, 10, 10);
                game.play();
            } else if (choice == 2) {
                System.out.println("Welcome to Classic Blackjack!");
                Blackjack game = new Blackjack();
                game.play();
            } else if (choice == 3) {
                System.out.println("Welcome to Hangman!");
                System.out.println("Please enter all letters in lowercase!");
                WordList wordList = new WordList();
                Hangman game = new Hangman(wordList);
                game.play();
            } else if (choice == 4) {
                System.out.println("Welcome to Connect4!");
                Connect4 game = new Connect4();
                game.play();
            } else if (choice == 5) { // Exit the loop if user chooses to quit
                continuePlaying = false;
            } else {
                System.out.println("Invalid choice... Please try again");
            }

            if (continuePlaying) { // If user didn't quit, ask to play again
                System.out.println("More fun?");
                System.out.println("1. Yes");
                int option = scanner.nextInt();

                if (option == 1) { // Back to menu
                    continuePlaying = true;
                } else { // Invalid option
                    System.out.println("Invalid option... Back to menu");
                    continuePlaying = true;
                }
            }
        }

        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }
}
