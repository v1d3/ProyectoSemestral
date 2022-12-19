package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Map1Test {
    
    public Map1Test() {
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
     * Test of addRectanglemaps method, of class Map1.
     */
    @Test
    public void testAddRectanglemaps() {
        System.out.println("addRectanglemaps");
        Map1 instance = new Map1();
        instance.addRectanglemaps();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRectanglemaps method, of class Map1.
     */
    @Test
    public void testGetRectanglemaps() {
        System.out.println("getRectanglemaps");
        int i = 0;
        Map1 instance = new Map1();
        Rectangle expResult = null;
        Rectangle result = instance.getRectanglemaps(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintMap1 method, of class Map1.
     */
    @Test
    public void testPaintMap1() {
        System.out.println("paintMap1");
        Graphics2D g2d = null;
        Graphics g = null;
        boolean w = false;
        boolean a = false;
        boolean s = false;
        boolean d = false;
        float count = 0.0F;
        Map1 instance = new Map1();
        instance.paintMap1(g2d, g, w, a, s, d, count);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
