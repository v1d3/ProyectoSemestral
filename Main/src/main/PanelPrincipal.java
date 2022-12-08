package main;

import java.awt.*;
import static java.awt.Font.PLAIN;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel implements KeyListener {

    public Botones bo;
    private boolean a, s, w, d;
    float x = 930f; //Coordenada x
    float y = 650f;//Coordenada y

    Map1 map1;
    Map2 map2;

    float angle = 270f; //Angulo
    Polygon p;//Figura
    Ruedas r1, r2, r3, r4;
    float count = 0;

    public PanelPrincipal() {

        bo = new Botones();
        this.setBackground(Color.blue);
        bo.addBotonestoPanel(this);
        bo.ActivateActionListener();
        bo.addButtonsCoordinate();

        map1 = new Map1();
        map2 = new Map2();
        r1 = new Ruedas(20, -15, true); //Adelante
        r2 = new Ruedas(-20, -20, false);
        r3 = new Ruedas(-20, 20, false);
        r4 = new Ruedas(20, 15, true);  //Adelante
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

        if (bo.getpistaP() == true && bo.getcambiopista() == true) {
            x = 240f; //Coordenada x
            y = 535f;//Coordenada y
        }
        if (bo.getpistaG() == true && bo.getcambiopista() == false) {
            x = 140f; //Coordenada x
            y = 535f;//Coordenada y
        }
        // input ----------------------------------------
        if (w) {
            if (count <= 7) {
                x += 0.4f * count * Math.cos(Math.toRadians(angle));
                y += 0.4f * count * Math.sin(Math.toRadians(angle));
                count += 0.0090;
            } else {
                x += 0.4f * count * Math.cos(Math.toRadians(angle));
                y += 0.4f * count * Math.sin(Math.toRadians(angle));
            }
        } else {
            if (count > 0) {
                x += 0.4f * count * Math.cos(Math.toRadians(angle));
                y += 0.4f * count * Math.sin(Math.toRadians(angle));
                count -= 0.01f;
            }
        }
        if (s) {
            x -= 0.3f * Math.cos(Math.toRadians(angle));
            y -= 0.3f * Math.sin(Math.toRadians(angle));
        }
        if (a) {
            angle -= 0.5f;

        }
        if (d) {
            angle += 0.5f;
        }
        if (collision()) {
            if (bo.getpistaP() == true && bo.getcambiopista() == true) { //Mapa 1 (Chico)
                if (getBounds().intersects(map1.getRectanglemaps(0))) {
                    x = 220;
                }
                if (getBounds().intersects(map1.getRectanglemaps(1))) {
                    y = 100;
                }
                if (getBounds().intersects(map1.getRectanglemaps(2))) {
                    x = 800;
                }
                if (getBounds().intersects(map1.getRectanglemaps(3))) {
                    y = 630;
                }
            }
            if (bo.getpistaG() == true && bo.getcambiopista() == false) {

            }

        }

        // update and paint wheels
        r1.paint(g, x, y, angle, a, d); //Rueda
        r2.paint(g, x, y, angle, a, d); //Rueda
        r3.paint(g, x, y, angle, a, d); //Rueda
        r4.paint(g, x, y, angle, a, d); //Rueda
        // update
        update_auto();
        // draw

        g.setColor(bo.getcolorauto());///////////////////////////////////////////////////////////////////////////
        g.fillPolygon(p);   //paint del polygon del auto

        Toolkit.getDefaultToolkit().sync(); //para la inestabilidad del framerate
        g.dispose();

        repaint();
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

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 30, 35);
    }

    public boolean collision() {
        for (int i = 0; i < map1.maps.size(); i++) {
            if (getBounds().intersects(map1.getRectanglemaps(i))) {

                return true;
            }
        }
        return false;
    }

    public void paintMapa(Graphics g) {
        //Lineas del borde
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

        if (w) {
            g.setColor(Color.green);
        } else {
            g.setColor(Color.gray);
        }
        g.fillRect(1100, 500, 70, 70); // vertical ARRIBA

        if (s) {
            g.setColor(Color.green);
        } else {
            g.setColor(Color.gray);
        }
        g.fillRect(1100, 580, 70, 70);// vertical ABAJO

        if (a) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.gray);
        }
        g.fillRect(1020, 580, 70, 70);// izq

        if (d) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.gray);
        }
        g.fillRect(1180, 580, 70, 70);//der

        g.setColor(Color.gray);
        g.fillRect(1100, 300, 75, 150);

        //Condiciones de barra de velocidad
        if (count == 0 || count < 0) {
            g.setColor(Color.gray);
        } else if (count <= 2) {
            g.setColor(Color.red);
        } else if (count <= 5) {
            g.setColor(Color.orange);
        } else if (count >= 7 || count <= 7) {
            g.setColor(Color.green);
        } else {
            g.setColor(Color.gray);
        }
        g.fillRect(1100, 300, 75, 150); // vertical
        g.drawString("Acelerador", 1100, 290);

        g.setColor(Color.BLACK);
        g.setFont(new Font("ARIAL", PLAIN, 32));
        g.drawString(" ►", 1190, 625);
        g.drawString(" ◄", 1025, 625);
        g.drawString("▲", 1120, 545);
        g.drawString("▼", 1120, 628);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(85));

        g.setColor(Color.gray);

        if (bo.getpistaP() == true && bo.getcambiopista() == true) {
            map1.paintMap1(g2d, g);

        }
        g.setColor(Color.gray);
        if (bo.getpistaG() == true && bo.getcambiopista() == false) {
            map2.paintMap2(g2d, g);

        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("ARIAL", PLAIN, 17));
        g.drawString("Pista", 1120, 50);
        g.drawString("Color auto", 1100, 150);

    }

    public void update_auto() {
        float cos = (float) Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));

        p = new Polygon();

        //para los sigueintes puntos se considera que el auto está en horizontal (angulo 0)
        //punto adelante-izquierda del auto
        float px = 20f;
        float py = -7f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        //punto atras-izquierda del auto
        px = -20f; //Mientras mas positivo derechas
        py = -14f; //Mientras mas positivo baja
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        //punto atras-derecha del auto
        px = -20f;
        py = 14f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        //punto adelante-derecha del auto
        px = 20f;
        py = 7f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));
    }
}
