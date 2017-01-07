package gameGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Box implements ActionListener {
    public int      PosX;
    public int      PosY;
    public boolean  isEmpty = true; //is to prevent overriding box with pieces
    private int     Boxwidth;
    private int     Boxheight;
    private Grid    ParentGrid;
    public JButton   box;

    public Box(int x, int y, int width, int height, Grid grid){
        PosX = x;//the x index assigned to the box
        PosY = y; //the y index assigned to the box
        Boxwidth = width;
        Boxheight = height;
        ParentGrid = grid;//the whole grid
        createBox();
    }

    public void     paintComponent(Graphics g){
        g.drawRect(0, 0, Boxwidth, Boxheight);
    }

    private void    createBox(){
        box = new JButton("");
        box.setBounds(PosX * Boxwidth, PosY * Boxheight, Boxwidth, Boxheight);
        box.setLayout(null);
        box.addActionListener(this);
        ParentGrid.add(box);
    }



    public void actionPerformed(ActionEvent event){
        System.out.println("adding piece");
        box.add(new Piece(ParentGrid.currentPlayer.getPlayerColor(),
                Boxwidth, Boxheight));
        box.setEnabled(false);
        isEmpty = false;
        ParentGrid.logicBoard[PosX][PosY] =
                ParentGrid.currentPlayer.getPlayerNumber();
        ParentGrid.changePlayer(PosX, PosY);
    }
}
