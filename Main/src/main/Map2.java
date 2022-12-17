package main;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Map2 {

    ArrayList<Rectangle> maps;
    Rectangle rec1;
    Rectangle rec2;
    Rectangle rec3;
    Rectangle rec4;

    public Map2() {
        maps = new ArrayList();
        rec1 = new Rectangle(0, 0, 220, 800);//left rectangle---- (x,y,ancho,alto)
        rec2 = new Rectangle(0, 0, 1300, 100);//Upper rectangle
        rec3 = new Rectangle(850, 0, 300, 800);// rigth rectangle
        rec4 = new Rectangle(0, 680, 1300, 10);//Down rectangle

    }

    public void addRectanglemaps() {
        maps.add(rec1);
        maps.add(rec2);
        maps.add(rec3);
        maps.add(rec4);

    }

    public Rectangle getRectanglemaps(int i) {

        Rectangle c = (Rectangle) maps.get(i);
        return c;

    }

    public void paintMap2(Graphics2D g2d, Graphics g, boolean w, boolean a, boolean s, boolean d, float count) {
        //Lineas del borde
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
        
        g.setColor(Color.gray);
        
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

}
