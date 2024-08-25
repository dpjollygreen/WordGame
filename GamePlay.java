import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class GamePlay {

    public static void main(String[] args) {

        GUI gui = new GUI();
        String playerList = "Players: ";
        gui.playerList(playerList);
        gui.hostInfo();
        gui.addPlayerButton();
        gui.addHostButton();
        gui.playingPhrase();
        gui.addStartButton();

    }
}//end of class



