import java.util.Scanner;

public class GamePlay {

    private static Person player;

    public static void main(String[] args) {

        Numbers newNum = new Numbers();
        Hosts newHost = new Hosts();
        Turn newTurn = new Turn();
        Players player = new Players();

        int guess = -1;
        int choice = 0;

        Scanner bringItIn = new Scanner(System.in);

        newHost.randomizeNum();

        System.out.print("Please enter your name: ");
        String firstName = bringItIn.nextLine();

        System.out.println("Would you like to enter a last Name? Y or N");
        String selection = bringItIn.nextLine();

        while (!selection.equals("Y") && !selection.equals("N")) {
            System.out.println("You have made an invalid selection.");
            System.out.println("Would you like to enter a last Name? Y or N");
            selection = bringItIn.nextLine();
        }

        if (selection.equals("Y")) {
           System.out.println("Enter your last name: ");
           String lastName = bringItIn.nextLine();
           player = new Players(firstName, lastName);
        } else if (selection.equals("N")) {
           player = new Players(firstName);
        }

        while(choice != 1) {

            while (!newTurn.takeTurn(player, newHost)) {
                if(newTurn.takeTurn(player, newHost)){break;}

            }

            System.out.println("Would you like to play again? 0 for yes, 1 for no: ");
            choice = bringItIn.nextInt();

            if(choice == 0) {
                newHost.randomizeNum();
            }
        }
    }
}//end of class
