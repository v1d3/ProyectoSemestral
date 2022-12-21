package main;

import java.awt.Graphics;
import java.awt.Polygon;

    /** Clase auto para constuirlo y configurarlo
    * @author Matias
    * @author Yulissa
    * @author Cristobal
    */
public class Car {
   
    /** 
    * @param p figura para el auto
    * @param r1,r2,r3,r4 las ruedas
    * @param x,y coordenadas de posiciones del auto
    * @param angle angulo de giro de las ruedas
    * @param instanciaAuto instanciamos un auto
    */
    Polygon p;//Figura
    Ruedas r1, r2, r3, r4;
    float x = 930f; //Coordenada x
    float y = 650f;//Coordenada y
    float angle = 270f; //Angulo
    float count = 0;
   // private boolean a, s, w, d;
    //PanelPrincipal pp;//no estan siendo necesario estas no se pq
    private static Car instanciaAuto = new Car();

    /** Contructor donde inicalizamos las ruedas*/
    public Car(){//aqui cambie el privatte por el public

        r1 = new Ruedas(20, -15, true); //Adelante
        r2 = new Ruedas(-20, -20, false);
        r3 = new Ruedas(-20, 20, false);
        r4 = new Ruedas(20, 15, true);  //Adelante
    }
    
    /** Getter
     * @return instancia de auto*/
    public static Car getInstancia() {
        return instanciaAuto;
    }
    
    /** Metodo donde creamos los eventos del auto, y graficamos las ruedas sus ruedas
     * @param g pintar las ruedas
     * @param w,a,s,d booleans para el movement del auto
     * @param pp Instancia del Panel Principal
     */
    public void paint(Graphics g, boolean w, boolean a, boolean s, boolean d, PanelPrincipal pp) {
        
        /**Movimiento del auto*/
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
        
        /**Colisiones con la barrera del mapa*/
        if (pp.collision()) {
            if (pp.bo.getpistaP() == true && pp.bo.getcambiopista() == true) { //Mapa 1 (Chico)

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

        /**Pintamos y actualizamos las ruedas*/
        r1.paint(g, x, y, angle, a, d); 
        r2.paint(g, x, y, angle, a, d); 
        r3.paint(g, x, y, angle, a, d); 
        r4.paint(g, x, y, angle, a, d); 
      
        update_auto();
        
        /**Pintamos el cuerpo del auto, osea el polygon*/
        g.setColor(pp.bo.getcolorauto());
        g.fillPolygon(p);
    }
    
    /**actualizacion de la posicion del auto*/
    public void update_auto() {
        float cos = (float) Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));

        p = new Polygon();

        
        /**Consideramos que el auto esta en horizontal(Angulo 0)
         * Punto adelante-izquierda del auto
         * Punto atras-izquierda del auto
         * Punto atras-derecha del auto
         * Punto adelante-derecha del auto
         */
        float px = 20f;
        float py = -7f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        px = -20f; 
        py = -14f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        px = -20f;
        py = 14f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));

        px = 20f;
        py = 7f;
        p.addPoint((int) (x + px * cos - py * sin), (int) (y + px * sin + py * cos));
    }
    /**Seteamos la posicion del carro*/
    public void setCarPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
