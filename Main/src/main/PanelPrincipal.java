package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel implements KeyListener {

    private boolean a, s, w, d, a1, d1;
    float x = 525f; //Coordenada x
    float y = 400f;//Coordenada y
    float angle = 270f; //Angulo
    Polygon p;//Figura
    Ruedas r1, r2, r3, r4;

    public PanelPrincipal() {
        this.setBackground(Color.blue);
        r1 = new Ruedas(45, -30, true); //Adelante
        r2 = new Ruedas(-45, -45, false);
        r3 = new Ruedas(-45, 45, false);
        r4 = new Ruedas(45, 30, true);  //Adelante
    }

    /**
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
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
            g.drawString("▀▄", 30 , 45+i);
            g.drawString("▀▄", 965, 55+i);
        }
        if (w) {
            g.setColor(Color.green);
        } else {
            g.setColor(Color.gray);
        }
        g.fillRect(1090, 500, 70, 70); // vertical ARRIBA

        if (s) {
            g.setColor(Color.green);
        } else {
            g.setColor(Color.gray);
        }
        g.fillRect(1090, 580, 70, 70);// vertical ABAJO

        if (a) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.gray);
        }
        g.fillRect(1010, 580, 70, 70);// izq

        if (d) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.gray);
        }
        g.fillRect(1170, 580, 70, 70);//der

        g.setColor(Color.BLACK);
        g.setFont(new Font("ARIAL", PLAIN, 32));
        g.drawString(" ►", 1185, 625);
        g.drawString(" ◄", 1015, 625);
        g.drawString("▲", 1110, 545);
        g.drawString("▼", 1110, 628);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(80));

        g.setColor(Color.gray);

        for (int i = 0; i < 200; i += 100) {
            g.fillRect(325, 500 - i, 70, 100);// | despues de 1 vuelta
            g.fillRect(440 + i, 280, 100, 70);// _ despues de 2 vuelta
            g.fillRect(945, 185 + i, 70, 100);// |  despues de 5 vuelta
        }
        g.fillRect(800, 65, 100, 70);// - despues de 4 vuelta
        g.fillRect(795, 435, 100, 70);// _ despues de 6 vuelta
        g.fillRect(445, 615, 180, 70);// _ despues de ultima vuelta

        g2d.drawArc(360, 550, 100, 100, 180, 90);//vuelta inicio
        g2d.drawArc(360, 315, 100, 100, 180, -90);// 2 vuelta
        g2d.drawArc(625, 170, 100, 145, 0, -90);// 3 vuelta
        g2d.drawArc(725, 100, 100, 144, 180, -90);// 4 vuelta

        g2d.drawArc(880, 100, 100, 100, 0, 90);// 5 vuelta
        g2d.drawArc(880, 370, 100, 100, 0, -90);// 6 vuelta
        g2d.drawArc(710, 470, 100, 100, 180, -90);//7 vuelta
        g2d.drawArc(610, 530, 100, 120, 0, -90);//ultima vuelta

// input
        if (w) {
            x += 0.4f * Math.cos(Math.toRadians(angle));
            y += 0.4f * Math.sin(Math.toRadians(angle));
        }
        if (s) {
            x -= 0.1f * Math.cos(Math.toRadians(angle));
            y -= 0.1f * Math.sin(Math.toRadians(angle));
        }
        if (a) {
            angle -= 0.3f;

        }
        if (d) {
            angle += 0.3f;

        }
        r1.paint(g, x, y, angle, a, d); //Rueda
        r2.paint(g, x, y, angle, a, d); //Rueda
        r3.paint(g, x, y, angle, a, d); //Rueda
        r4.paint(g, x, y, angle, a, d); //Rueda
        // update
        update_auto();
        // draw

        g.setColor(Color.red);
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
            a1 = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            s = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            d = true;
            d1 = true;
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

    public void update_auto() {
        float cos = (float) Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));

        p = new Polygon();

        // if ((x >= 340 && x <= 930) && (y >= 30 && y <= 670)) {
        //para los sigueintes puntos se considera que el auto está en horizontal (angulo 0)
        //punto adelante-izquierda del auto
        float px = 55f;
        float py = -10f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        //punto atras-izquierda del auto
        px = -55f; //Mientras mas positivo derechas
        py = -30f; //Mientras mas positivo baja
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        //punto atras-derecha del auto
        px = -55f;
        py = 30f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        //punto adelante-derecha del auto
        px = 55f;
        py = 10f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));
        //}
    }
}