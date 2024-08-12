import java.util.Scanner;

public class Turn {
    public boolean takeTurn(Players player, Hosts host, Phrases phrase) {

        //Phrases newPhrase = new Phrases();
        String guess = "";
        Scanner bringItIn = new Scanner(System.in);

        System.out.println(host.getFirstName() + ": guess a letter " + player.getFirstName());
        guess = bringItIn.nextLine();

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

