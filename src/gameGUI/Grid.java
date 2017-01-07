package gameGUI;

import BoardChecks.*;

import javax.swing.*;
import java.awt.*;

/*
 * In this program the 2d array is in the format[x][y]
 */
public class Grid extends JPanel {

    private Game ParentGame;

    public Box[][] Gameboard;
    /*
     * this is the logic board, it contains :
     * 0 to represent empty box
     * 1 to represent occupied player1 piece
     * 2 to represent occupied player2 piece
     */
    public int[][] logicBoard;
    //holds the player whose turn is to play
    public Player currentPlayer;

    public Grid(Game game) {
        ParentGame = game;
        createGrid();
        currentPlayer = ParentGame.PlayerOne;
    }

    private void createGrid() {
        setLayout(null);
        setBackground(Color.GRAY);
        setBounds(120, 70, 760, 760);
        //this is the board for create the box buttons
        Gameboard = new Box[19][19];
        logicBoard = new int[19][19];
        for (int y = 0; y < 19; y++) {
            for (int x = 0; x < 19; x++) {
                logicBoard[x][y] = 0;
                Gameboard[x][y] = new Box(x, y, 40, 40, this);
            }
        }
        ParentGame.boardPanel.add(this);
    }

    public void changePlayer(int x, int y) {
        currentPlayer = (currentPlayer == ParentGame.PlayerOne)
                ? ParentGame.PlayerTwo : ParentGame.PlayerOne;
        printBoard();
        prePareBoardForPlayer();
    }

    private void printBoard() {
        for (int y = 0; y < 19; y++) {
            for (int x = 0; x < 19; x++) {
                System.out.print(logicBoard[x][y] + " ");
            }
            System.out.println();
        }
    }

    public void prePareBoardForPlayer() {
        //Checker checker = new Checker();
        BoardChecker checker = new BoardChecker();

        System.out.println("currentplayer: " + currentPlayer.getPlayerNumber());
        for (int y = 0; y < 19; y++) {
            for (int x = 0; x < 19; x++) {
                Gameboard[x][y].box.setEnabled(checker.isValidMove(logicBoard, currentPlayer.getPlayerNumber(), x, y));
            }
        }
    }

    /*private void    checkCaptures(int PosX, int PosY){
        Checker checker = new Checker();

        String tmp = checker.checkCapture(logicBoard, currentPlayer.getPlayerNumber(),
                PosX, PosY, 19, 19);
        if (tmp != null){
            if (tmp == "west"){
                Gameboard[PosY-1]
            }
        }
    }*/
}
