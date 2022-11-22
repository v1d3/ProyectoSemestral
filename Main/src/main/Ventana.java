
package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Ventana extends JFrame {
    public Dimension d = new Dimension( 1250 , 800);
    public Ventana(){
        this.setLayout(new BorderLayout());
        this.setSize(d);
        this.setVisible(true);
        setLocationRelativeTo(null);
    }
}
