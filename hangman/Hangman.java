// Aldo Vega
// Functions used Array List / Linked List

package hangman;

import java.util.Scanner;

public class Hangman {
    private final HangmanWord hangmanWord;
    private int remainingAttempts;

    public Hangman(WordList wordList) {
        this.hangmanWord = new HangmanWord(wordList.getWords());
        this.remainingAttempts = 7;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        
        while (remainingAttempts > 0 && !hangmanWord.isSolved()) {
            System.out.println("Remaining attempts: " + remainingAttempts);
            System.out.println("Guessed letters: " + hangmanWord.getGuessedLetters());
            System.out.println("Current state: " + hangmanWord.getMaskedWord());
            System.out.print("Enter a letter: ");
            char guessedLetter = scanner.next().charAt(0);

            if (!hangmanWord.guessLetter(guessedLetter)) {
                remainingAttempts--;
            }
        }

        if (hangmanWord.isSolved()) {
            System.out.println("Congratulations! You guessed the word: " + hangmanWord.getSecretWord());
        } else {
            System.out.println("Game over! The word was: " + hangmanWord.getSecretWord());
        }
    }
}
