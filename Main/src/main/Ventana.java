package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame {

    private PanelPrincipal dp;
    private Dimension d = new Dimension(1300, 800);
    public Ventana() {
        this.setLayout(new BorderLayout());
        dp = new PanelPrincipal();
        dp.setLayout(null);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(d);
        dp.setLayout(null);

        setLocationRelativeTo(null);
        this.add(dp);
        this.setVisible(true);
/////////////////////////////////////////////////////////////

        /*Label l = new Label();
        l.setText("This is a demonstration");
        dp.add(l);*/

        Teclado k = new Teclado();
      this.addKeyListener(k);
/////////////////////////////////////////////////////////////

    }

}
