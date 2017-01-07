package gameGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class Game extends JPanel{
    private JPanel  menuPanel;
    public JPanel   boardPanel;
    public Player   PlayerOne;
    public Player   PlayerTwo;
    public Grid     theGrid;

    public Game(){
        //setting a width and heigth for the mainPanel
        //setPreferredSize(new Dimension(1400, 900));
        /*
         * This a frame to handle getting user player number,
         * opponent and maybe {name and color}
         */
        setBounds(0, 0, 1400, 900);
        setLayout(null);
        menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBounds(300, 200, 800, 500);
        add(menuPanel);
        Menu SubMenu = new Menu(menuPanel, this);
    }



    public static void main(String args[]){
        //creating new instance of JFRAME (WINDOW)
        JFrame GameWindow = new JFrame();
        //setting click on Red Close X to quit program
        GameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameWindow.setTitle("GOMOKU"); //setting window title
        //GameWindow.setLayout(new BorderLayout());
        GameWindow.setSize(1400, 900);
        GameWindow.setLayout(null);
        GameWindow.add(new Game()); //adding my main game panel
        //GameWindow.pack(); //automatically gets size from the panels placed in it
        GameWindow.setResizable(false); //setting whether user can resize window(boolean)
        GameWindow.setLocationRelativeTo(null);

        //here we set it to be visible
        GameWindow.setVisible(true);
    }

    public void startGame(int playerNUmber, boolean vsAI){
        menuPanel.setVisible(false);
        System.out.print("Menu said player number is " + playerNUmber + "\n");
        System.out.print("Menu said vs Ai is " + vsAI + "\n");
        System.out.print("Starting Game\n");
        removeAll(); //removes every panel or component in current screen
        revalidate(); //re initialises the panel
        repaint(); //adds its color
        createPlayers(playerNUmber, vsAI);
        createBoardPanel();
        theGrid = new Grid(this);
    }

    //private functions below
    private void createPlayers(int playerNumber, boolean vsAI){
        if (playerNumber == 1){
            PlayerOne = new Player(playerNumber, Color.RED, false);
            if (vsAI)
                PlayerTwo = new Player(2, Color.BLUE, true);
            else
                PlayerTwo = new Player(2, Color.BLUE, false);
        }else{
            PlayerTwo = new Player(playerNumber, Color.BLUE, false);
            if (vsAI)
                PlayerOne = new Player(1, Color.BLUE, true);
            else
                PlayerOne = new Player(1, Color.BLUE, false);
        }
        System.out.println("players created");
    }

    private void createBoardPanel(){
        boardPanel = new JPanel();
        boardPanel.setLayout(null);
        boardPanel.setBackground(Color.BLACK);
        boardPanel.setBounds(0, 0, 1000, 900);
        setLayout(null);
        add(boardPanel);
    }
}
