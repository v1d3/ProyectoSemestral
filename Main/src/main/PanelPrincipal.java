package main;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {

    public PanelPrincipal() {
        this.setBackground(Color.blue);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(280, 30, 750, 700);
        g.setColor(Color.gray);
        g.fillRect(190, 500, 70, 150); // vertical
        g.fillRect(30, 580, 150, 70);
        g.setColor(Color.red);
        g.fillRect(1060, 580, 70, 70);// izq
        g.fillRect(1170, 580, 70, 70);//der
    }

}
