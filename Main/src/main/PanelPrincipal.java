package main;

import java.awt.*;
import static java.awt.Font.PLAIN;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel implements KeyListener {

    public Botones bo;
    private boolean a, s, w, d;

    ///////PISTA LARGA//////////
    //float x =140f; //Coordenada x
    //float y = 535f;//Coordenada y

    ////////PISTA CORTA///////////
    float x = 240f; //Coordenada x
    float y = 535f;//Coordenada y


    Map1 map1;

    
    float angle = 270f; //Angulo
    Polygon p, linea;//Figura
    Ruedas r1, r2, r3, r4;
    float count = 0;

    public PanelPrincipal() {

        bo = new Botones();

        this.setBackground(Color.blue);

        this.setBackground(Color.blue);
        map1 = new Map1();
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
        // input
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
        if (collision()) { //---------------------------Falta ver donde poner las coordenadas despues de la colision
            
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

    public void paintMapa(Graphics g) {

        g.setColor(Color.green);//0,128,0

  
    }
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
   @Override
    public void paintMapa(Graphics g) { //_____Mapa 1
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

       

        if (bo.getpistaP() == true &&bo.getcambiopista()==true) {
            g2d.drawArc(240, 530, 100, 100, 180, 90);//vuelta inicio
            g.fillRect(198, 438, 85, 100);// | despues de 1 vuelta
            g2d.drawArc(240, 345, 100, 100, 180, -90);// 2 vuelta
            g.fillRect(333, 303, 100, 85);// _ despues de 2 vuelta
            g2d.drawArc(425, 200, 100, 145, 0, -90);// 3 vuelta
            g2d.drawArc(525, 115, 100, 144, 180, -90);// 4 vuelta
            g.fillRect(618, 73, 100, 85);// - despues de 4 vuelta
            g2d.drawArc(710, 115, 100, 100, 0, 90);// 5 vuelta
            g.fillRect(768, 205, 85, 145);// |  despues de 5 vuelta
            g2d.drawArc(710, 340, 100, 100, 0, -90);// 6 vuelta
            g.fillRect(610, 398, 110, 85);// _ despues de 6 vuelta
            g2d.drawArc(520, 440, 100, 100, 180, -90);//7 vuelta
            g2d.drawArc(420, 510, 100, 120, 0, -90);//ultima vuelta
            g.fillRect(333, 588, 100, 85);// _ despues de ultima vuelta

            g.setColor(Color.white);
            g.fillRect(198, 455, 85, 40);//linea de partida
            g.setFont(new Font("ARIAL", PLAIN, 17));
            g.setColor(Color.BLACK);
            g.drawString("▀▄▀▄▀▄▀", 198, 470);
            g.drawString("▀▄▀▄▀▄▀", 198, 490);

        }
        g.setColor(Color.gray);
        if (bo.getpistaG() == true && bo.getcambiopista()==false) {
            g2d.drawArc(140, 560, 100, 100, 180, 90);//vuelta inicio
            g.fillRect(98, 415, 85, 155);// | despues de 1 vuelta
            g2d.drawArc(140, 325, 100, 100, 180, -90);// 2 vuelta
            g.fillRect(233, 283, 200, 85);// _ despues de 2 vuelta
            g2d.drawArc(425, 180, 100, 145, 0, -90);// 3 vuelta
            g2d.drawArc(525, 100, 100, 144, 180, -90);// 4 vuelta
            g.fillRect(618, 58, 165, 85);// - despues de 4 vuelta
            g2d.drawArc(775, 100, 100, 100, 0, 90);// 5 vuelta
            g.fillRect(833, 185, 85, 200);// |  despues de 5 vuelta
            g2d.drawArc(775, 370, 100, 100, 0, -90);// 6 vuelta
            g.fillRect(593, 428, 190, 85);// _ despues de 6 vuelta
            g2d.drawArc(500, 470, 100, 100, 180, -90);//7 vuelta
            g2d.drawArc(400, 540, 100, 120, 0, -90);//ultima vuelta
            g.fillRect(230, 618, 180, 85);// _ despues de ultima vuelta
            g.setColor(Color.white);
            g.fillRect(98, 455, 85, 40);//linea de partida

            g.setFont(new Font("ARIAL", PLAIN, 17));
            g.setColor(Color.BLACK);
            g.drawString("▀▄▀▄▀▄▀", 98, 470);
            g.drawString("▀▄▀▄▀▄▀", 98, 490);

        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("ARIAL", PLAIN, 17));
        g.drawString("Pista", 1120, 50);
        g.drawString("Color auto", 1100, 150);
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

        g.setColor(bo.getcolorauto());
        g.fillPolygon(p);   //paint del polygon del auto

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

    public Botones getBoton() {
        return bo;
    }

    public void addBotonestoPanel(PanelPrincipal pp) {

        pp.add(getBoton().ARojo);
        pp.add(getBoton().ARosado);
        pp.add(getBoton().AAzul);
        pp.add(getBoton().PistaP);
        pp.add(getBoton().PistaG);

    }

    public void addButtonsCoordinate() {

        getBoton().ARojo.setBounds(1020, 170, 80, 50);
        getBoton().ARosado.setBounds(1180, 170, 80, 50);
        getBoton().AAzul.setBounds(1100, 170, 80, 50);
        getBoton().PistaP.setBounds(1045, 70, 80, 50);
        getBoton().PistaG.setBounds(1155, 70, 80, 50);

    }

}
