import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Word Game");
    JLabel playerList = new JLabel();
    JLabel hostData = new JLabel();
    JLabel playingPhrase = new JLabel();
    int MAX = 12;
    int players = -1;
    Hosts newHost = new Hosts();
    Turn newTurn = new Turn();
    Phrases newPhrase = new Phrases();
    Players[] currentPlayers = new Players[MAX];

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

    public void hostInfo() {
        String LabelText = "Host: " + newHost.getFirstName();
        hostData.setText(LabelText);
        frame.add(hostData);
        frame.repaint();
    }

    public void addPlayerButton() {
        JButton addPlayerButton = new JButton("Add Player");
        frame.add(addPlayerButton);
        addPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                players += 1;
                String name = JOptionPane.showInputDialog("Enter your Name:");
                playerList(name);
                currentPlayers[players] = new Players(name);
            }
        });
    }

    public void addHostButton() {
        JButton addHostButton = new JButton("Host");
        frame.add(addHostButton);
        addHostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = JOptionPane.showInputDialog("Enter your Name:");
                newHost.setFirstName(name);
                String phrase = JOptionPane.showInputDialog(newHost.getFirstName() + " enter a phrase:");
                newPhrase.newPhrase(phrase);
                newPhrase.thePhrase();
                hostInfo();
                playingPhrase();
            }
        });
    }

    public void addStartButton() {
        JButton addStartButton = new JButton("Start game!!");
        frame.add(addStartButton);
        addStartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < players + 1; i++) {
                    String guess = JOptionPane.showInputDialog(currentPlayers[i].getFirstName() + " enter a letter:");;
                    if(newTurn.takeTurn(currentPlayers[i], newHost, newPhrase, guess)){
                        currentPlayers[i].addMoney(500);
                        JOptionPane.showMessageDialog(null, currentPlayers[i].getFirstName() + " you win!!\nBrand New Car and $500\nTotal Winnings: $" + currentPlayers[i].getMoney());
                        playingPhrase();
                        break;}
                    if (i == players) {i = -1;}
                    playingPhrase();
                }
                JOptionPane.showConfirmDialog(null, "Would you like to play again?");
            }
        });
    }

    public void playingPhrase() {
        String LabelText = "Phrase: " + newPhrase.getPlayingPhrase();
        playingPhrase.setText(LabelText);
        frame.add(playingPhrase);
        frame.repaint();


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
