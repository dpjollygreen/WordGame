import java.util.Scanner;

public class Turn {
    public boolean takeTurn(Players player, Hosts host) {

        Phrases newPhrase = new Phrases();
        String guess = "";
        Scanner bringItIn = new Scanner(System.in);

        System.out.print(host.getFirstName() + ": guess a letter " + player.getFirstName());
        guess = bringItIn.nextLine();

        try {
            newPhrase.findLetters(guess);

        }
        catch (MultipleLettersException mistake) {
            System.out.println(mistake.getMessage());
            return false;
        }
        return true;
    }
}

