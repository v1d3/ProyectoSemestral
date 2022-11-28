package main;

import java.awt.*;

public class Ruedas {

    boolean a, d, t;
    float x;
    float y;
    float ax, ay, aAngle;
    float angle = 0f;
    float altura;
    float distancia;
    Polygon p;

    public Ruedas(float x, float y, boolean t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }

    public void paint(Graphics g, float x1, float y1, float angle1, boolean a, boolean d) {
        ax = x1;
        ay = y1;
        this.a = a;
        this.d = d;
        aAngle = angle1; //Guardamos la variable del padre para calcular la posicion real de la rueda
        /*if (w) {
        
            x += 0.1f * Math.cos(Math.toRadians(angle));
            y += 0.1f * Math.sin(Math.toRadians(angle));
        }
        if (s) {
            x -= 0.1f * Math.cos(Math.toRadians(angle));
            y -= 0.1f * Math.sin(Math.toRadians(angle));
        }*/
        if (a) {
            if (angle > (angle1 - 45)) {
                angle -= 0.8f;

            }
        }
        if (d) {
            if (angle < (angle1 + 45)) {
                angle += 0.8f;

            }
        }
        if (!a && !d && Math.abs(angle - aAngle) > 0.8f) { //Si el auto no esta doblando
            if (angle > aAngle) {
                angle -= 2f;
            } else {
                angle += 2f;
            }
        }
        update_ruedas();

        g.setColor(Color.BLACK);
        g.fillPolygon(p);

    }

    public void update_ruedas() {
        //Angulo respecto el auto
        float cos = (float) Math.cos(Math.toRadians(aAngle));
        float sin = (float) Math.sin(Math.toRadians(aAngle));

        float nx = x * cos - y * sin;
        float ny = x * sin + y * cos;

        if (t) { //Si no son ruedas delantereas entonces ==>
            cos = (float) Math.cos(Math.toRadians(angle));
            sin = (float) Math.sin(Math.toRadians(angle));
        }
        p = new Polygon();

        //Rueda, punto atras derecho 
        float px = -20f;
        float py = 10f;
        p.addPoint((int) (nx + ax + px * cos - py * sin), (int) (ny + ay + px * sin + py * cos));

        //Rueda, punto atras izquierdo
        px = -20f;
        py = -10f;
        p.addPoint((int) (nx + ax + px * cos - py * sin), (int) (ny + ay + px * sin + py * cos));

        //Rueda, punto delante izquierdo
        px = 20f;
        py = -10f;
        p.addPoint((int) (nx + ax + px * cos - py * sin), (int) (ny + ay + px * sin + py * cos));

        //Rueda, punto delante derecho
        px = 20f;
        py = 10f;
        p.addPoint((int) (nx + ax + px * cos - py * sin), (int) (ny + ay + px * sin + py * cos));
    }

}
