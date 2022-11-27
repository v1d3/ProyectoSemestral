package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel implements KeyListener {

    private boolean a, s, w, d;
    float x = 525f; //Coordenada x
    float y = 400f;//Coordenada y
    float angle = 270f; //Angulo
    Polygon p;//Figura

    public PanelPrincipal() {
        this.setBackground(Color.blue);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        
        g.fillRect(280, 30, 750, 700);
        
        
        g.fillRect(190, 500, 70, 150); // vertical
        
       
        g.fillRect(30, 580, 150, 70);
        
       
        g.fillRect(1060, 580, 70, 70);// izq
        
       
        g.fillRect(1170, 580, 70, 70);//der

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(70));

        g.setColor(Color.green);
        
        for (int i = 0; i < 200; i += 100) {
            g.fillRect(325, 500 - i, 70, 100);// | despues de 1 vuelta
            g.fillRect(440 + i, 280, 100, 70);// _ despues de 2 vuelta
            g.fillRect(945, 185 + i, 70, 100);// |  despues de 5 vuelta
        }
        g.fillRect(800, 65, 100, 70);// - despues de 4 vuelta
        g.fillRect(795 , 435, 100, 70);// _ despues de 6 vuelta
        g.fillRect(445 , 615, 180, 70);// _ despues de ultima vuelta
        
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
            angle -= 0.1f;
        }
        if (d) {
            angle += 0.1f;
        }

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
        if (e.getKeyCode() == KeyEvent.VK_W) {
            w = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            a = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            s = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            d = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            w = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            a = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            s = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
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
        float px = 100f;
        float py = -20f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        //punto atras-izquierda del auto
        px = -60f;//-60
        py = -60f;//-60
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        //punto atras-derecha del auto
        px = -60f;//-60
        py = 60f;//60
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        //punto adelante-derecha del auto
        px = 100f;
        py = 20f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));
        //}
    }
}
