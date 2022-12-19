package main;

import java.awt.Graphics;
import java.awt.Polygon;

public class Car {

    Polygon p;//Figura
    Ruedas r1, r2, r3, r4;
    float x = 930f; //Coordenada x
    float y = 650f;//Coordenada y
    float angle = 270f; //Angulo
    float count = 0;
    private boolean a, s, w, d;
    PanelPrincipal pp;
    private static Car instanciaAuto = new Car();

    private Car() {

        r1 = new Ruedas(20, -15, true); //Adelante
        r2 = new Ruedas(-20, -20, false);
        r3 = new Ruedas(-20, 20, false);
        r4 = new Ruedas(20, 15, true);  //Adelante
    }

    public static Car getInstancia() {
        return instanciaAuto;
    }

    public void paint(Graphics g, boolean w, boolean a, boolean s, boolean d, PanelPrincipal pp) {
        if (w) {
            if (count <= 7) {
                x += 0.4f * count * Math.cos(Math.toRadians(angle));
                y += 0.4f * count * Math.sin(Math.toRadians(angle));
                count += 0.009;
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
            angle -= 1f;

        }
        if (d) {
            angle += 1f;
        }
        if (pp.collision()) {
            if (pp.selecMap1) { //Mapa 1 (Chico)
                if (pp.PuntoIntersectaRectangulo(pp.map1.getRectanglemaps(0))) {
                    x = 220;
                }
                if (pp.PuntoIntersectaRectangulo(pp.map1.getRectanglemaps(1))) {
                    y = 100;
                }
                if (pp.PuntoIntersectaRectangulo(pp.map1.getRectanglemaps(2))) {
                    x = 850;
                }
                if (pp.PuntoIntersectaRectangulo(pp.map1.getRectanglemaps(3))) {
                    y = 640;
                }
            }
            if (pp.selecMap2) { //Mapa2 (Grande)
                if (pp.PuntoIntersectaRectangulo(pp.map2.getRectanglemaps(0))) {
                    x = 120;
                }
                if (pp.PuntoIntersectaRectangulo(pp.map2.getRectanglemaps(1))) {
                    y = 80;
                }
                if (pp.PuntoIntersectaRectangulo(pp.map2.getRectanglemaps(2))) {
                    x = 900;
                }
                if (pp.PuntoIntersectaRectangulo(pp.map2.getRectanglemaps(3))) {
                    y = 680;
                }
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
        g.setColor(pp.bo.getcolorauto());
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

    public void setCarPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
