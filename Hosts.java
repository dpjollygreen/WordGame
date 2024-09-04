import java.util.Scanner;

public class Hosts extends Person {
    public Hosts() {
        super("Host");
        Scanner bringItIn = new Scanner(System.in);
        String phrase;

        //System.out.println(getFirstName() + " enter a phrase: ");
        phrase = "test";
        Phrases newPhrase = new Phrases();
        newPhrase.newPhrase(phrase);
        newPhrase.thePhrase();
    }

    public void newGamePhrase() {
        Scanner bringItIn = new Scanner(System.in);
        String phrase;

        System.out.println(getFirstName() + " enter a new phrase: ");
        phrase = "test";
        Phrases newPhrase = new Phrases();
        newPhrase.newPhrase(phrase);
        newPhrase.thePhrase();
    }
}

