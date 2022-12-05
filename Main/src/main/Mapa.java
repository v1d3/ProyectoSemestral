package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author ccris
 */
public class Mapa {

    private float xr, yr, z, angle, p1, p2, p3, p4, ancho, alto;
    Polygon Rec;

    public Mapa(float angle, float p1, float p2, float p3, float p4, float ancho, float alto) {
        this.angle = angle;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.ancho = ancho;
        this.alto = alto;
    }

    public void paint(Graphics g, float xr, float yr, float z) {    //Xr Yr son relativas
        this.z = z;
        this.xr = xr;
        this.yr = yr;
        
        update_Mapa();
        
        g.setColor(Color.green);
        g.fillPolygon(Rec);
        
        
    }

    public void update_Mapa() {
        float cos = (float) Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));
  
        Rec = new Polygon();
        //Vertice superior izquierdo ----> Estatico
        Rec.addPoint((int) (xr + p1 * cos - p2 * sin), (int) (yr + p1 * sin + p2 * cos));
        //Vertice inferior izquierdo -----> estatico
        Rec.addPoint((int) (xr + p1 * cos - p2 * sin), (int) (yr + p1 * sin + p2 * cos));
        //Vertice superior derecho
        Rec.addPoint((int) (xr + p1 * cos - p2 * sin), (int) (yr + p1 * sin + p2 * cos));
        
        Rec.addPoint((int) (xr + p1 * cos - p2 * sin), (int) (yr + p1 * sin + p2 * cos));
        
    }
}
