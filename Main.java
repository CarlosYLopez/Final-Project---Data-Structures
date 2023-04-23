import java.util.Scanner;
import Blackjack.Blackjack;
import MineSweeper.Minesweeper;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the game hub!");
        System.out.println("Select a game to play:");
        System.out.println("1. Minesweeper");
        System.out.println("2. Blackjack");

        int choice = scanner.nextInt();
        if (choice == 1) {

            Minesweeper game = new Minesweeper(10, 10, 10);
            game.play();

        } else if (choice == 2) {

            System.out.println("Welcome to Classic Blackjack!");

            Blackjack game = new Blackjack();
            game.play();
            
        } else {
            
            System.out.println("Invalid choice... Exiting...");
        }

        scanner.close();
    }
}