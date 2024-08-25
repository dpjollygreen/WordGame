import java.util.Random;
public class Phrases {
    static String gamePhrase;
    String playingPhrase;

    public static void newPhrase(String phrase) {
        gamePhrase = phrase;
       // System.out.print(gamePhrase);
    }

    public void thePhrase() {
        playingPhrase = gamePhrase.replaceAll("\\S", "_");
       // System.out.println(playingPhrase);
    }

    public String getPlayingPhrase() {
        return playingPhrase;
    }


    public boolean findLetters(String letter) throws MultipleLettersException{
        if(letter.length() > 1) {
            throw new MultipleLettersException();
        }
        for(int index = gamePhrase.indexOf(letter); index >= 0; index=gamePhrase.indexOf(letter, index+1)) {
            playingPhrase = playingPhrase.substring(0, index) + letter + playingPhrase.substring(index+1);

        }
        //System.out.println(playingPhrase);
        if(!playingPhrase.contains("_")) {
            //System.out.println("You Win!!");
            Random rand = new Random();
            int num = rand.nextInt(3);
            if(num == 1) {
                //System.out.println("A brand new car!");
            }else if (num == 2) {
                //System.out.println("A new Washer/Dryer!");
            }else if (num ==3) {
                //System.out.println("A vacation to the Bahamas!");

            }
            return true;
        }
        return false;
    }
}

