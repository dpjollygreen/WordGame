import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Word Game");
    JLabel playerList = new JLabel();
    JTextArea playerGame = new JTextArea(4,75);
    JScrollPane playerGameScroll = new JScrollPane(playerGame);
    //playerGameScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    String playIt = "";
    JLabel hostData = new JLabel();
    JLabel playingPhrase = new JLabel();
    JCheckBox save = new JCheckBox("Save Messages");
    int MAX = 12;
    int players = -1;
    Hosts newHost = new Hosts();
    Turn newTurn = new Turn();
    Phrases newPhrase = new Phrases();
    Players[] currentPlayers = new Players[MAX];
    JMenuBar menuBar = new JMenuBar();


    public GUI() {

        frame.setSize(250, 300);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void addSave() {
        JPanel savePanel = new JPanel();
        save.setToolTipText("Selecting this box will save the play data");
        savePanel.add(save);
        frame.add(savePanel);
        frame.repaint();
        save.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("selected");
                }
                else{
                    System.out.println("not selected");
                    playIt = "";
                }
            }
        });
    }
    public void playerList(String player) {
        String gamePlay = playerList.getText();
        gamePlay += player + " ";
        playerList.setText(gamePlay);
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

    public void gamePlayData(String play) {
        //String labelText = playerGame.getText();
        JTextArea newTextArea = new JTextArea(playIt + "\n" + play);
        playIt += play + "\n";
        //newTextArea.setText(labelText);
        playerGameScroll.setViewportView(newTextArea);
        frame.add(playerGameScroll);
        frame.repaint();
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
                        gamePlayData(currentPlayers[i].getFirstName() + " you win!!\nBrand New Car and $500\nTotal Winnings: $" + currentPlayers[i].getMoney());
                        //JOptionPane.showMessageDialog(null, currentPlayers[i].getFirstName() + " you win!!\nBrand New Car and $500\nTotal Winnings: $" + currentPlayers[i].getMoney());
                        playingPhrase();
                        break;}
                    else{
                        gamePlayData(currentPlayers[i].getFirstName() + " you did not win.");
                        //JOptionPane.showMessageDialog(null, currentPlayers[i].getFirstName() +" you guessed didn't win.");
                    }
                    if (i == players) {i = -1;}
                    playingPhrase();
                }
                int response = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(response == JOptionPane.YES_OPTION){
                    playIt = "";
                    JTextArea newTextArea = new JTextArea(playIt);
                    playerGameScroll.setViewportView(newTextArea);
                    frame.add(playerGameScroll);
                    frame.repaint();
                }

            }
        });
    }

    public void playingPhrase() {
        String LabelText = "Phrase: " + newPhrase.getPlayingPhrase();
        playingPhrase.setText(LabelText);
        frame.add(playingPhrase);
        frame.repaint();


    }
    public void addAboutMenu() {
        JMenu aboutMenu = new JMenu("About");
        aboutMenu.setMnemonic(KeyEvent.VK_A);
        JMenuItem aboutMenuItem = new JMenuItem("Layout");
        aboutMenu.add(aboutMenuItem);
        menuBar.add(aboutMenu);
        frame.setJMenuBar(menuBar);
        aboutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "I chose this layout because it was the easiest to implement and keeps everything organized.", "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public void addMenu() {

        JMenu gameMenu = new JMenu("Game");
        gameMenu.setMnemonic(KeyEvent.VK_G);
        JMenuItem newGameMenuItem = new JMenuItem("Add Player");
        JMenuItem newGameMenuItem2 = new JMenuItem("Add Host");
        gameMenu.add(newGameMenuItem);
        gameMenu.add(newGameMenuItem2);
        menuBar.add(gameMenu);
        frame.setJMenuBar(menuBar);

        newGameMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                players += 1;
                String name = JOptionPane.showInputDialog("Enter your Name:");
                playerList(name);
                currentPlayers[players] = new Players(name);

            }
        });
        newGameMenuItem2.addActionListener(new ActionListener() {
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


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
