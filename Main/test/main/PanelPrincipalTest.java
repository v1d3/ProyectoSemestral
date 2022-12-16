/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author USUARIO
 */
public class PanelPrincipalTest {
    
    public PanelPrincipalTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of paint method, of class PanelPrincipal.
     */
    @Test
    public void testPaint() {
        System.out.println("paint");
        Graphics g = null;
        PanelPrincipal instance = new PanelPrincipal();
        instance.paint(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyTyped method, of class PanelPrincipal.
     */
    @Test
    public void testKeyTyped() {
        System.out.println("keyTyped");
        KeyEvent e = null;
        PanelPrincipal instance = new PanelPrincipal();
        instance.keyTyped(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyPressed method, of class PanelPrincipal.
     */
    @Test
    public void testKeyPressed() {
        System.out.println("keyPressed");
        KeyEvent e = null;
        PanelPrincipal instance = new PanelPrincipal();
        instance.keyPressed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyReleased method, of class PanelPrincipal.
     */
    @Test
    public void testKeyReleased() {
        System.out.println("keyReleased");
        KeyEvent e = null;
        PanelPrincipal instance = new PanelPrincipal();
        instance.keyReleased(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PuntoIntersectaRectangulo method, of class PanelPrincipal.
     */
    @Test
    public void testPuntoIntersectaRectangulo() {
        System.out.println("PuntoIntersectaRectangulo");
        Rectangle rec = null;
        PanelPrincipal instance = new PanelPrincipal();
        boolean expResult = false;
        boolean result = instance.PuntoIntersectaRectangulo(rec);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of collision method, of class PanelPrincipal.
     */
    @Test
    public void testCollision() {
        System.out.println("collision");
        PanelPrincipal instance = new PanelPrincipal();
        boolean expResult = false;
        boolean result = instance.collision();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCarPosition method, of class PanelPrincipal.
     */
    @Test
    public void testSetCarPosition() {
        System.out.println("setCarPosition");
        int x = 0;
        int y = 0;
        PanelPrincipal instance = new PanelPrincipal();
        instance.setCarPosition(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintMapa method, of class PanelPrincipal.
     */
    @Test
    public void testPaintMapa() {
        System.out.println("paintMapa");
        Graphics g = null;
        PanelPrincipal instance = new PanelPrincipal();
        instance.paintMapa(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update_auto method, of class PanelPrincipal.
     */
    @Test
    public void testUpdate_auto() {
        System.out.println("update_auto");
        PanelPrincipal instance = new PanelPrincipal();
        instance.update_auto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
