import javax.swing.*;
import java.awt.*;

public class GUI {
    JFrame frame = new JFrame("Word Game");
    JLabel playerList = new JLabel();


    public GUI() {

        frame.setSize(250, 250);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void playerList(String player) {
        String labelText = playerList.getText();
        labelText += player + " ";
        playerList.setText(labelText);
        //JLabel playerList = new JLabel(players);
        frame.add(playerList);
        frame.repaint();
    }

    public void addPlayer() {
        JLabel newPlayer = new JLabel("New Player");
        frame.add(newPlayer);
        frame.repaint();
    }
}
