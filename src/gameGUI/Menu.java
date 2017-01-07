package gameGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {

    private JButton P1;
    private JButton P2;
    private JLabel  SubText;
    private JPanel  ParentMenu;
    private Game    ParentGame;
    private int playerNumber;
    private JButton AI;
    private JButton HUMAN;

    public Menu(JPanel menu, Game game){
        ParentMenu = menu;
        //I brought the Game class in, so the menu can
        //make a callback to it when its done with the menu part
        ParentGame = game;
        //creating the select your player number menu
        createMenu1(menu);
    }

    public void actionPerformed(ActionEvent event){
        //checking mouse click on Player one button
        if (event.getSource() == P1){
            playerNumber = 1;
            System.out.print("player1 press\n");
            //I couldn't remove the button, so I decided to hide it
            P1.setVisible(false);
            P2.setVisible(false);
            //creating the select your opponent menu
            createMenu2(ParentMenu);
        }
        //checking mouse click on Player two button
        if (event.getSource() == P2){
            playerNumber = 2;
            System.out.print("player2 press\n");
            P1.setVisible(false);
            P2.setVisible(false);
            createMenu2(ParentMenu);
        }
        if (event.getSource() == AI){
            System.out.print("VS AI\n");
            ParentGame.startGame(playerNumber, true);
        }
        if(event.getSource() == HUMAN){
            System.out.print("VS HUMAN\n");
            //this is the callback to Game Class telling it menu is done
            ParentGame.startGame(playerNumber, false);
        }
    }

    private void createMenu1(JPanel menu){
        //creating a label
        JLabel title = new JLabel("GOMOKU");
        title.setForeground(Color.blue); //setting label font color
        title.setFont(new Font("Serif", Font.BOLD, 70));//setting label font options
        //setting where to place the label RELATIVE TO ITS PARENT PANEL
        title.setBounds(200, 10, 400, 100);
        SubText = new JLabel("Select Your Player Number");
        SubText.setFont(new Font("Serif", Font.BOLD, 30));
        SubText.setBounds(200, 200, 400, 50);
        menu.add(title);
        menu.add(SubText);
        //creating buttons below
        P1 = new JButton("PLAYER ONE");
        P2 = new JButton("PLAYER TWO");
        P1.setFont(new Font("Verdana", Font.BOLD, 30));
        P2.setFont(new Font("Verdana", Font.BOLD, 30));
        P1.setBounds(0, 300, 300, 90);
        //add listener to the button, which will call the listener in this class
        P1.addActionListener(this);
        P2.setBounds(450, 300, 300, 90);
        P2.addActionListener(this);
        //I add my buttons to my menu PANEL to display them
        menu.add(P1);
        menu.add(P2);
    }

    private void createMenu2(JPanel menu){
        //changing text of a JLabel
        SubText.setText("Select Your Opponent");
        //creating buttons below
        AI = new JButton("VS. AI");
        HUMAN = new JButton("VS. HUMAN");
        AI.setFont(new Font("Verdana", Font.BOLD, 30));
        HUMAN.setFont(new Font("Verdana", Font.BOLD, 30));
        AI.setBounds(0, 300, 300, 90);
        AI.addActionListener(this);
        HUMAN.setBounds(450, 300, 300, 90);
        HUMAN.addActionListener(this);
        menu.add(AI);
        menu.add(HUMAN);
    }
}
