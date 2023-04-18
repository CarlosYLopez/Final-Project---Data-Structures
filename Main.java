import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Classic Blackjack!");

        Blackjack game = new Blackjack();
        game.play();

        scanner.close();
    }
}