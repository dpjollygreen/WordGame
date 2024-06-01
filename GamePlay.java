import java.util.Scanner;

public class GamePlay {

    private static Person player;

    public static void main(String[] args) {

        Numbers newNum = new Numbers();

        int guess = -1;

        Scanner bringItIn = new Scanner(System.in);

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
           player = new Person(firstName, lastName);
        } else if (selection.equals("N")) {
           player = new Person(firstName);
        }

        newNum.generateNumber();

        while (guess != newNum.getRandomNum()) {

            System.out.print(player.getFirstName() + " take a guess at the random number 0-100 ");
            guess = bringItIn.nextInt();
            if(newNum.compareNumber(guess)) {
                break;
            }

        }
    }
}//end of class
