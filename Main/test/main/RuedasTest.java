/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package main;

import java.awt.Graphics;
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
public class RuedasTest {
    
    public RuedasTest() {
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
     * Test of paint method, of class Ruedas.
     */
    @Test
    public void testPaint() {
        System.out.println("paint");
        Graphics g = null;
        float x1 = 0.0F;
        float y1 = 0.0F;
        float angle1 = 0.0F;
        boolean a = false;
        boolean d = false;
        Ruedas instance = null;
        instance.paint(g, x1, y1, angle1, a, d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update_ruedas method, of class Ruedas.
     */
    @Test
    public void testUpdate_ruedas() {
        System.out.println("update_ruedas");
        Ruedas instance = null;
        instance.update_ruedas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
