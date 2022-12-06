package main;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Map1 {

    ArrayList<Rectangle> maps;
    Rectangle rec1;
    Rectangle rec2;
    Rectangle rec3;
    Rectangle rec4;
    Rectangle rec5;
    Rectangle rec6;
    Rectangle rec7;
    Rectangle rec8;

    public Map1() {
        maps = new ArrayList();
        rec1 = new Rectangle(0,0,220,800);//left rectangle---- (x,y,ancho,alto)
        rec2 = new Rectangle(0,0,1300,100);//Upper rectangle
        rec3 = new Rectangle(850,0,300,800);// rigth rectangle
        rec4 = new Rectangle(0,680,1300,10);//Down rectangle
        rec5 = new Rectangle();
        rec6 = new Rectangle();
        rec7 = new Rectangle();
        rec8 = new Rectangle();
    }

    
    public void addRectanglemaps(){
        maps.add(rec1);
        maps.add(rec2);
        maps.add(rec3);
        maps.add(rec4);
        
    }
    
    public Rectangle getRectanglemaps(int i){
        
            Rectangle c = (Rectangle)maps.get(i);
            return c;
        
    }
    
}
