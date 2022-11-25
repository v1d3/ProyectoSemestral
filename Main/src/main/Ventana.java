package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame {

    private PanelPrincipal dp;
    private Dimension d = new Dimension(1300, 800);
    private JLabel JL = new JLabel();

    public Ventana() {
        this.setLayout(new BorderLayout());
        dp = new PanelPrincipal();
        dp.setLayout(null);

        JL.setIcon(new ImageIcon("C:\\Users\\ccris\\OneDrive\\Escritorio\\pictures-steam profile\\a4.jpg"));
        JL.setBounds(290, 0, 750, 800);
        dp.add(JL);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(d);

        this.add(dp);
        this.setVisible(true);
        setLocationRelativeTo(null);
    }
}
