package main;

import java.awt.Graphics;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CarTest {
    
    public CarTest() {
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
     * Test of getInstancia method, of class Car.
     */
    @Test
    public void testGetInstancia() {
        System.out.println("getInstancia");
        Car expResult = null;
        Car result = Car.getInstancia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paint method, of class Car.
     */
    @Test
    public void testPaint() {
        System.out.println("paint");
        Graphics g = null;
        boolean w = false;
        boolean a = false;
        boolean s = false;
        boolean d = false;
        PanelPrincipal pp = null;
        Car instance = null;
        instance.paint(g, w, a, s, d, pp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update_auto method, of class Car.
     */
    @Test
    public void testUpdate_auto() {
        System.out.println("update_auto");
        Car instance = null;
        instance.update_auto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCarPosition method, of class Car.
     */
    @Test
    public void testSetCarPosition() {
        System.out.println("setCarPosition");
        int x = 0;
        int y = 0;
        Car instance = null;
        instance.setCarPosition(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
