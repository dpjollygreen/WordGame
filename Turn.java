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
        }


        boolean numbersCompared = newPhrase.compareNumber(guess);
        if(numbersCompared) {
            Money win = new Money();
            if((int) (Math.random() * 6) <= 3) {
                player.setMoney(player.getMoney() + win.displayWinnings(player, numbersCompared));
                System.out.println("You win!!");
                System.out.println(player.toString());
                return true;
            } else {
                Physical thing = new Physical();
                player.setMoney(player.getMoney() + thing.displayWinnings(player, numbersCompared));
                return true;
            }
        } else {
            Money lose = new Money();
            if((int) (Math.random() * 6) <= 3) {
                player.setMoney(player.getMoney() + lose.displayWinnings(player, numbersCompared));
                System.out.println("You lost");
                System.out.println(player.toString());
                return false;
            } else {
                Physical thing = new Physical();
                player.setMoney(player.getMoney() + thing.displayWinnings(player, numbersCompared));
                return false;
            }

        }


    }
}
