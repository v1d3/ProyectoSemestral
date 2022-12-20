package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Clase Botones para elegir los colores del auto y el tamaño de la pista
 * @author Yulissa
 * @author Cristobal
 * @author matias
 * @version 3, fecha 19/12
 */
public class Botones implements ActionListener {
    
    /** variables JButton para eleccion de colores*/
    public JButton ARojo, ARosado, AAzul;
    
    /** variables JButton para eleccion de tamaños de pistas*/
    public JButton PistaP, PistaG;
    
    /** Utilizamos esto para otorgarles el tipo de color al auto*/
    Color colorauto;
    
    /** Inicializamos las pistas en falsas para que al momento de usarlas cambien a true*/
    boolean pistaP = false;
    boolean pistaG = false;
    boolean cambio = false;
    
    /**Hacemos una instancia del panel principal para manejar los eventos*/
    PanelPrincipal x;
    
    /** Constructor de la clase, donde inicializamos nuestras variabl
     * @param x*/
    public Botones(PanelPrincipal x) {
        this.x = x;
        ARojo = new JButton("Rojo");
        ARosado = new JButton("Rosado");
        AAzul = new JButton("Azul");
        PistaP = new JButton("Pista chica");
        PistaG = new JButton("Pista grande");
    }

    
    /** Metodo que da activacion de botones
     * Ocupamos el Listener del mouse
     */
    public void ActivateActionListener() {
        ARojo.addActionListener(this);
        ARosado.addActionListener(this);
        AAzul.addActionListener(this);

        PistaP.addActionListener(this);
        PistaG.addActionListener(this);
    
     /** Uso del setFocusable para darle una "Desactivasion" a los botones pulsados
     * Esto porque nos surgia un error al pulsar los botones.
     */
        ARojo.setFocusable(false);
        ARosado.setFocusable(false);
        AAzul.setFocusable(false);
        PistaP.setFocusable(false);
        PistaG.setFocusable(false);
    }

    @Override
    /** Otrogamos los colores del auto y tamaños de pista
     * @param colorauto almacena el color elegido
     * @param PistaP tamaño pequeña, y posiciona el carro en coordenadas de inicio
     * @param PistaG tamaño grande, y posiciona el carro en coordenadas de inicio
     
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ARojo) {
            colorauto = Color.red;
        }
        if (e.getSource() == ARosado) {
            colorauto = new Color(255, 0, 128);
        }
        if (e.getSource() == AAzul) {
            colorauto = Color.blue;
        }

        if (e.getSource() == PistaP) {
            pistaP = true;
            cambio = true;
            x.auto.getInstancia().setCarPosition(240, 535);
        }
        if (e.getSource() == PistaG) {
            pistaG = true;
            cambio = false;
            x.auto.getInstancia().setCarPosition(140, 535);

        }
    }
    /** Hacemos los getters */
    
    public Color getcolorauto() {
        return colorauto;
    }

    public boolean getpistaP() {
        return pistaP;
    }

    public boolean getpistaG() {
        return pistaG;
    }

    public boolean getcambiopista() {
        return cambio;
    }
    /** Añadimos los Botones en el Panel*/
    public void addBotonestoPanel(PanelPrincipal pp) {

        pp.add(ARojo);
        pp.add(ARosado);
        pp.add(AAzul);
        pp.add(PistaP);
        pp.add(PistaG);
    }
    /** Posiciones de los botones en el Panel*/
    public void addButtonsCoordinate() {

        ARojo.setBounds(1020, 170, 80, 50);
        ARosado.setBounds(1180, 170, 80, 50);
        AAzul.setBounds(1100, 170, 80, 50);
        PistaP.setBounds(1035, 70, 100, 50);
        PistaG.setBounds(1145, 70, 110, 50);
    }
}
