package main;

import java.awt.Rectangle;

public class Colisiones {

    Rectangle rec1;
    int x = 0;
    int y = 0;
    int HEIGHT = 98;
    int WIDTH = 800;

    public Colisiones() {
        rec1 = new Rectangle();
        rec1.x = 0;
        rec1.y = 0;
        rec1.height = 98;
        rec1.width = 800;
    }
    private boolean collision(){
        return false;
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,HEIGHT, WIDTH);
    }
    
}
