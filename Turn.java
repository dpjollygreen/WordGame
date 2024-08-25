import java.util.Scanner;

public class Turn {
    public boolean takeTurn(Players player, Hosts host, Phrases phrase, String guess) {

        try {
            return phrase.findLetters(guess);
            //if(phrase.playingPhrase )

        }
        catch (MultipleLettersException mistake) {
            System.out.println(mistake.getMessage());
            return false;
        }
    }
}

