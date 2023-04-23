// Aldo Vega
// Functions used Array List / Linked List


package hangman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class HangmanWord {
    private final LinkedList<Character> secretWord;
    private final List<Character> guessedLetters;

    public HangmanWord(List<String> wordList) {
        String secretWord = wordList.get(new Random().nextInt(wordList.size()));
        this.secretWord = new LinkedList<>();
        for (char c : secretWord.toCharArray()) {
            this.secretWord.add(c);
        }
        this.guessedLetters = new ArrayList<>();
    }

    public boolean guessLetter(char letter) {
        if (guessedLetters.contains(letter)) {
            return false;
        }

        guessedLetters.add(letter);
        return secretWord.contains(letter);
    }

    public boolean isSolved() {
        for (char c : secretWord) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public String getSecretWord() {
        StringBuilder sb = new StringBuilder();
        for (char c : secretWord) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String getMaskedWord() {
        StringBuilder sb = new StringBuilder();
        for (char c : secretWord) {
            if (guessedLetters.contains(c)) {
                sb.append(c);
            } else {
                sb.append('_');
            }
        }
        return sb.toString();
    }

    public String getGuessedLetters() {
        StringBuilder sb = new StringBuilder();
        for (char c : guessedLetters) {
            sb.append(c).append(' ');
        }
        return sb.toString();
    }
}
