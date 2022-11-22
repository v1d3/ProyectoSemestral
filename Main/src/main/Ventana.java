package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Ventana extends JFrame {

    public Dimension d = new Dimension(1250, 800);

    public Ventana() {
        
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Activa cierre x
        this.setSize(d);                                                           //Establece el Tamaño de la Ventana
        this.setVisible(true);                                                  //Visibiliza la ventana
        setLocationRelativeTo(null);                                    //Centra la aparicion de la Ventana
        
    }
}
