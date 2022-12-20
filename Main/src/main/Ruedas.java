package main;

import java.awt.*;
/** Clase Ruedas donde le daremos las posiciones y sus condiciones de giro
    * @author Matias
    * @author Yulissa
    * @author Cristobal
    * @version 2, 17/12
    */
public class Ruedas {

    /** Declaracion de las variables
     * @param x,y las posiciones de las ruedas
     * @param angle para obtener el angulo de giro de las ruedas
     * @param p cuepo del auto donde iran las ruedas
     */
    boolean a, d, t;
    float x, y;
    float ax, ay, aAngle;
    float angle = 0f;
    Polygon p;

    /**Contructor donde definir las ruedas*/
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

        if (a) {
            if (angle > (angle1 - 25)) {
                angle -= 5f;

            }
        }
        if (d) {
            if (angle < (angle1 + 25)) {
                angle += 5f;

            }
        }
        if (!a && !d && Math.abs(angle - aAngle) > 0.8f) { //Si el auto no esta doblando, reposiciona las ruedas
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
        float px = -10f;
        float py = 5f;
        p.addPoint((int) (nx + ax + px * cos - py * sin), (int) (ny + ay + px * sin + py * cos));

        //Rueda, punto atras izquierdo
        px = -10f;
        py = -5f;
        p.addPoint((int) (nx + ax + px * cos - py * sin), (int) (ny + ay + px * sin + py * cos));

        //Rueda, punto delante izquierdo
        px = 10f;
        py = -5f;
        p.addPoint((int) (nx + ax + px * cos - py * sin), (int) (ny + ay + px * sin + py * cos));

        //Rueda, punto delante derecho
        px = 10f;
        py = 5f;
        p.addPoint((int) (nx + ax + px * cos - py * sin), (int) (ny + ay + px * sin + py * cos));
    }

}
