package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
/** Clase Ventana, configuramos el JFrame
    * @author Matias
    * @author Yulissa
    * @author Cristobal
    * @version 2, 16/12
    */
public class Ventana extends JFrame {

    /**Instanciamos las variables
    
     */
    private PanelPrincipal panel;
    private Dimension WindowSize = new Dimension(1300, 800);

    /**Contructor de la clase, inicializamos nuestro panel y el Listener*/
    public Ventana() {
        this.setLayout(new BorderLayout());

        panel = new PanelPrincipal();
        this.add(panel);
        panel.setLayout(null);
        this.addKeyListener(panel);
        /////////////////////////////////////////////////
        InitWindow();
    }
/**Iniciamos la ventana, le damos el titulo, y toda la respectiva config*/
    private void InitWindow() {
        this.setTitle("CarRace");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WindowSize);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
