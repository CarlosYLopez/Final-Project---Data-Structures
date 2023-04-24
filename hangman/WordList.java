// Aldo Vega
// Functions used Array List / Linked List

package hangman;

import java.util.Arrays;
import java.util.List;

public class WordList {
    
    private final List<String> words;

    //word bank
    public WordList() {
        words = Arrays.asList("elephant", "ambiguity", "multimedia", "hippopotamus", "crocodile", "sherlockholmes", "spongebob");
    }

    public List<String> getWords() {
        return words;
    }
}


