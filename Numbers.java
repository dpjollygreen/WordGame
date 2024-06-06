public class Numbers {

        private static int randomNum;

        public int getRandomNum () {
            return randomNum;
        }

        public void setRandomNum ( int num){
            randomNum = num;
        }

        public void generateNumber () {
            randomNum = (int) (Math.random() * 100);
        }

        public boolean compareNumber ( int guess){
            if (randomNum == guess) {
                System.out.println("Congratulations, you guessed the number!");
                return true;
            } else if (randomNum < guess) {
                System.out.println("I'm sorry.  That guess was too high.");
                return false;
            } else if (randomNum > guess) {
                System.out.println("I'm sorry.  That guess was too low.");
                return false;
            } else {
                System.out.println("I'm sorry.  I didn't quite catch that.");
                return false;
            }
        }

}
