/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
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

/**
 *
 * @author USUARIO
 */
public class Map2Test {
    
    public Map2Test() {
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
     * Test of addRectanglemaps method, of class Map2.
     */
    @Test
    public void testAddRectanglemaps() {
        System.out.println("addRectanglemaps");
        Map2 instance = new Map2();
        instance.addRectanglemaps();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRectanglemaps method, of class Map2.
     */
    @Test
    public void testGetRectanglemaps() {
        System.out.println("getRectanglemaps");
        int i = 0;
        Map2 instance = new Map2();
        Rectangle expResult = null;
        Rectangle result = instance.getRectanglemaps(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintMap2 method, of class Map2.
     */
    @Test
    public void testPaintMap2() {
        System.out.println("paintMap2");
        Graphics2D g2d = null;
        Graphics g = null;
        Map2 instance = new Map2();
        instance.paintMap2(g2d, g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
