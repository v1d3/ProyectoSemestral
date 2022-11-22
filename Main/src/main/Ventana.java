package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Ventana extends JFrame {

    private PanelPrincipal dp;
    public Dimension d = new Dimension(1300, 800);

    public Ventana() {
        dp = new PanelPrincipal();

        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(d);
        dp.setLayout(null);
       

        setLocationRelativeTo(null);
         this.add(dp);
        this.setVisible(true);

    }
}
