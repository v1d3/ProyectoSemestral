package main;

import java.awt.*;
import static java.awt.Font.PLAIN;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel implements KeyListener {

    Botones bo;
    Map1 map1;
    Map2 map2;
    Car auto;
    public boolean w, a, s, d;

    public PanelPrincipal() {

        bo = new Botones(this);
        this.setBackground(Color.blue);
        bo.addBotonestoPanel(this);
        bo.ActivateActionListener();
        bo.addButtonsCoordinate();

        map1 = new Map1();
        map2 = new Map2();
        
        map1.addRectanglemaps();

    }

    /**
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //Paint de mapa
        paintMapa(g);
        // input ----------------------------------------
        
        auto.getInstancia().paint(g, w, a, s, d, this);
        
        g.setColor(bo.getcolorauto());///////////////////////////////////////////////////////////////////////////

        Toolkit.getDefaultToolkit().sync(); //para la inestabilidad del framerate
        g.dispose();

        repaint();
    }
    

    public boolean PuntoIntersectaRectangulo(Rectangle rec) {
        return auto.getInstancia().x > rec.x && auto.getInstancia().x < rec.x + rec.width && auto.getInstancia().y > rec.y && auto.getInstancia().y < rec.y + rec.height;
    }

    public boolean collision() {
        for (int i = 0; i < map1.maps.size(); i++) {
            if (getBounds().intersects(map1.getRectanglemaps(i))) {

                return true;
            }
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

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
        for (int i = 0; i < 875; i += 175) {
            g.drawString("▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀", 30 + i, 45);
            g.drawString("▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀", 30 + i, 725);
        }
        for (int i = 0; i < 670; i += 20) {
            g.drawString("▀▄", 30, 45 + i);
            g.drawString("▀▄", 965, 55 + i);
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(85));

     

        if (bo.getpistaP() == true && bo.getcambiopista() == true) {
            map1.paintMap1(g2d, g, w, a, s, d, auto.getInstancia().count);

        }
        g.setColor(Color.gray);
        if (bo.getpistaG() == true && bo.getcambiopista() == false) {
            map2.paintMap2(g2d, g, w, a, s, d, auto.getInstancia().count);
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("ARIAL", PLAIN, 17));
        g.drawString("Pista", 1120, 50);
        g.drawString("Color auto", 1100, 150);

    }

}
