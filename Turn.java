import java.util.Scanner;

public class Turn {
    public boolean takeTurn(Players player, Hosts host) {

        Numbers newNum = new Numbers();

        int guess = -1;
        double winAmount = 500;
        double loseAmount = 25;

        Scanner bringItIn = new Scanner(System.in);

        System.out.print(host.getFirstName() + ": take a guess at the random number 0-100 " + player.getFirstName());
        guess = bringItIn.nextInt();
        if(newNum.compareNumber(guess)) {
            player.setMoney(player.getMoney() + winAmount);
            System.out.println("You win!!");
            System.out.println(player.toString());
            return true;
        } else {
            System.out.println("You did not guess the number.");
            player.setMoney(player.getMoney() - loseAmount);
            System.out.println(player.toString());
            return false;
        }


    }
}
