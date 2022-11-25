package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("acelero");
        }
        
        if (e.getKeyCode() == KeyEvent.VK_F) {
            System.out.println("freno");
        }
        
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
         System.out.println("derecha");
        }
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
         System.out.println("izquierda");
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
