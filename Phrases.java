public class Phrases {
    static String gamePhrase;
    String playingPhrase;

    public void newPhrase(String phrase) {
        gamePhrase = phrase;
        playingPhrase = phrase.replaceAll("\\S", "_");
    }

    public void findLetters(String letter) {
        if(letter.length() > 1) {
            throw new MultipleLettersException();
        }
        for(int index = gamePhrase.indexOf(letter); index >= 0; index=gamePhrase.indexOf(letter, index+1)) {
            playingPhrase = playingPhrase.substring(0, index) + letter + playingPhrase.substring(index+1);
        }
        if(!playingPhrase.contains("_")) {

        }
    }
}
