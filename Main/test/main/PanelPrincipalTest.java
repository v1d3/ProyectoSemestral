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
    
}
