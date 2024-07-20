public class Money implements Award {
    int winAmount = 500;
    int loseAmount = -25;

    public int displayWinnings(Players player, boolean isWin) {
        if(isWin) {
            System.out.println(player.toString() + " you win!!");
            return winAmount;
        } else {
            System.out.println("You did not guess the number " + player.toString() + ".");
            return loseAmount;
        }
    }
}

