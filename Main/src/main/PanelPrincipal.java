package main;

import java.awt.*;
import static java.awt.Font.PLAIN;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
/** Clase Panel Principal para constuir el panel Y importar todo lo grafico
    * @author Matias
    * @author Yulissa
    * @author Cristobal
    * @version 4, 18/12
    */
public class PanelPrincipal extends JPanel implements KeyListener {
    
    /** Instanciamos las clases*/
    Botones bo;
    Map1 map1;
    Map2 map2;
    Car auto;
    
    /** variables para controlar los eventos
     * Control del auto
     * Seleccion del mapa a utilizar
     */
    public boolean w, a, s, d, selecMap1, selecMap2;

    /** Constructor donde inicializamos nuestro parametros*/
    public PanelPrincipal() {

        bo = new Botones(this);
        /** Fondo azul y activacion de los metodos de los botones*/
        this.setBackground(Color.blue);
        bo.addBotonestoPanel(this);
        bo.ActivateActionListener();
        bo.addButtonsCoordinate();

        map1 = new Map1();
        map2 = new Map2();

        map1.addRectanglemaps();
        map2.addRectanglemaps();
    }

    /** Graficamos y pintamos el Panel
     * @param g pinta el mapa
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        /**Paint de mapa*/
        paintMapa(g);
        
        /** Obtenemos la instancia de nuestro auto y lo pintamos*/
        auto.getInstancia().paint(g, w, a, s, d, this);

        /** Aqui evitamos la inestabilidad del framerate*/
        Toolkit.getDefaultToolkit().sync(); 
        g.dispose();

        repaint();
    }
    
    /** Metodo donde se da la interseccion del auto con nuestra barrera del mapa
     * @return el punto o coordenada de colision 
     */
    public boolean PuntoIntersectaRectangulo(Rectangle rec) {
        return auto.getInstancia().x > rec.x && auto.getInstancia().x < rec.x + rec.width && auto.getInstancia().y > rec.y && auto.getInstancia().y < rec.y + rec.height;
    }
    
    /**Cargamos los rectangulos dependendiendo del tamaño de la pista
     * sujeto a los posibles cambios de mapa
     * primero pista Pequeña
     * segundo pista Grande
     */
    public boolean collision() {
        if (bo.getpistaP() == true && bo.getcambiopista() == true) { 
            selecMap1 = true;
            selecMap2 = false;
            for (int i = 0; i < map1.maps.size(); i++) {
                if (getBounds().intersects(map1.getRectanglemaps(i))) {
                    return selecMap1;
                }
            }
        }
        if (bo.getpistaG() == true && bo.getcambiopista() == false) { 
            selecMap2 = true;
            selecMap1 = false;
            for (int i = 0; i < map2.maps.size(); i++) {
                if (getBounds().intersects(map2.getRectanglemaps(i))) {
                    return selecMap2;
                }
            }
        }
        return false;
    }
    /**Ejecutamos esto para cuando se presiona una tecla*/
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**Metodo que toma el evento del teclado al presionar las WASD */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            w = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            a = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            s = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            d = true;
        }

    }
    /** cambiamos a false nuestras teclas wasd en caso de no estar apretadas*/
    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            w = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            a = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            s = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            d = false;
        }
    }
    
    /**Graficamos nustro fondo ddel mapa
     * Verde
     * Blanco por los bordes
     * Diseño sobre el blanco de nuestros bordes
     * 
     */
    public void paintMapa(Graphics g) {

        g.setColor(Color.green);
        g.fillRect(30, 30, 950, 700);
        g.setColor(Color.white);
        g.fillRect(30, 30, 950, 20);//v
        g.fillRect(30, 710, 950, 20);//v
        g.fillRect(30, 30, 23, 700);//h
        g.fillRect(965, 30, 23, 700);//h
        g.setColor(Color.BLACK);
        g.setFont(new Font("ARIAL", PLAIN, 16));
       
        /**Pintamos diseño sobre la horizontal*/
        for (int i = 0; i < 875; i += 175) {
            g.drawString("▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀", 30 + i, 45);
            g.drawString("▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀", 30 + i, 725);
        }
        
        /**Pintamos diseño sobre la vertical*/
        for (int i = 0; i < 670; i += 20) {
            g.drawString("▀▄", 30, 45 + i);
            g.drawString("▀▄", 965, 55 + i);
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(85));

        /**Cambios de pista graficados*/
        if (bo.getpistaP() == true && bo.getcambiopista() == true) { //Para pista Pequeña

            map1.paintMap1(g2d, g, w, a, s, d, auto.getInstancia().count);

        }
        g.setColor(Color.gray);

        if (bo.getpistaG() == true && bo.getcambiopista() == false) { //Para pista Grande

            map2.paintMap2(g2d, g, w, a, s, d, auto.getInstancia().count);
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("ARIAL", PLAIN, 17));
        g.drawString("Pista", 1120, 50);
        g.drawString("Color auto", 1100, 150);

    }

}
