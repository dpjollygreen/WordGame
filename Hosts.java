import java.util.Scanner;

public class Hosts extends Person {
    public Hosts() {
        super("Host");
        Scanner bringItIn = new Scanner(System.in);
        String phrase;

        System.out.println(getFirstName() + " enter a phrase: ");
        phrase = bringItIn.nextLine();
        Phrases newPhrase = new Phrases();
        newPhrase.newPhrase(phrase);
        newPhrase.thePhrase();
    }

    public void newGamePhrase() {
        Scanner bringItIn = new Scanner(System.in);
        String phrase;

        System.out.println(getFirstName() + " enter a new phrase: ");
        phrase = bringItIn.nextLine();
        Phrases newPhrase = new Phrases();
        newPhrase.newPhrase(phrase);
        newPhrase.thePhrase();
    }
}

