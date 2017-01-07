package gameGUI;

import javax.swing.*;
import java.awt.*;

public class Piece extends JLabel {
    public Color    PieceColor;
    public int      width;
    public int      height;

    public Piece(Color c, int w, int h){
        PieceColor = c;
        width = w;
        height = h;
        setBackground(PieceColor);
        setBounds(5, 5, width - 10, height - 10);
    }

    public void     paintComponent(Graphics g){
        //g.drawOval(0, 0, width, height);
        g.setColor(PieceColor);
        g.fillOval(0, 0, width - 10, height - 10);
    }
}
