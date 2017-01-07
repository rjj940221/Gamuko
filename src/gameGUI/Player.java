package gameGUI;

import java.awt.*;

public class Player {
    private int      playerNo;
    private Color    playerColor;
    private boolean  isPlayerAI;
    private int      catches;

    public Player(int No, Color color, boolean isAI){
        playerNo = No;
        playerColor = color;
        isPlayerAI = isAI;
        catches = 0;
    }

    public int getPlayerNumber(){
        return playerNo;
    }

    public Color getPlayerColor(){
        return playerColor;
    }

    public boolean getIsPlayerAI(){
        return isPlayerAI;
    }

    public void addToCatch(int number){
        catches += number;
    }

    public int getCatches(){
        return catches;
    }
}
