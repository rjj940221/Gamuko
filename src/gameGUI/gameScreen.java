package gameGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rojones on 2017/01/04.
 */
public class gameScreen extends JFrame {
    private int player = 1;
    private JPanel mainPanel = new JPanel();
    private JPanel infoPanel = new JPanel();
    private JButton[][] gameGrid = new JButton[19][19];
    private ImageIcon redIcon = new ImageIcon(getClass().getResource("gameTokenRed.jpg"));
    private ImageIcon blueIcon = new ImageIcon(getClass().getResource("gameTokenBlue.jpg"));

    public gameScreen(String name) {
        super(name);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        mainPanel.setSize(600, 600);
        mainPanel.setLocation(0, 0);
        mainPanel.setVisible(true);
        mainPanel.setLayout(new GridLayout());
        //mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        infoPanel.setSize(200, 600);
        infoPanel.setLocation(600, 0);
        this.add(mainPanel);
        int size = 600 / 19;
        Image temp = redIcon.getImage();
        temp = temp.getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH);
        redIcon = new ImageIcon(temp);
        temp = blueIcon.getImage();
        temp = temp.getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH);
        blueIcon = new ImageIcon(temp);
        for (int y = 0; y < 19; y++) {
            for (int x = 0; x < 19; x++) {
                gameGrid[x][y] = new JButton();
                String command = x + " " + y + " " + 0;
                this.gameGrid[x][y].setActionCommand(command);
                this.mainPanel.add(this.gameGrid[x][y]);
                gameGrid[x][y].setSize(size, size);
                gameGrid[x][y].setLocation(x * size, y * size);
                gameGrid[x][y].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int size = 600 / 19;
                        String action = e.getActionCommand();
                        String splitAction[] = action.split(" ");
                        int x = Integer.parseInt(splitAction[0]);
                        int y = Integer.parseInt(splitAction[1]);
                        gameGrid[x][y].setEnabled(false);
                        if (player == 1)  {
                           // gameGrid[x][y].setIcon(blueIcon);
                            gameGrid[x][y].setActionCommand(x + " " + y + " " + player);
                            player = 2;
                        } else{
                            //gameGrid[x][y].setIcon(redIcon);
                            gameGrid[x][y].setActionCommand(x + " " + y + " " + player);
                            player = 1;
                        }
                        //gameGrid[x][y].setSize(size, size);
                    }
                });
                gameGrid[x][y].setVisible(true);
            }
        }
    }

    public static void main(String[] args) {

        gameScreen game = new gameScreen("Gamuko");
    }

}
