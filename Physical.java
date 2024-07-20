public class Physical implements Award {
    String[] prizes = new String[] {
            "Car",
            "Blender",
            "Motorcycle",
            "Washer/Dryer",
            "Vacation"
    };
    public int displayWinnings(Players player, boolean isWin){
        if(isWin) {
            System.out.println(player.toString() + " you won a " + prizes[getRandomPrize()]);
            return 0;
        } else {
            System.out.println(player.toString() + " you almost won a " + prizes[getRandomPrize()]);
            return 0;
        }
    }
    public int getRandomPrize() {
        int prize = (int) (Math.random() * 5);
        prize = prize - 1;
        return prize;
    }
}

