package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BotonesTest {
    
    public BotonesTest() {
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
     * Test of ActivateActionListener method, of class Botones.
     */
    @Test
    public void testActivateActionListener() {
        System.out.println("ActivateActionListener");
        Botones instance = null;
        instance.ActivateActionListener();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class Botones.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        Botones instance = null;
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getcolorauto method, of class Botones.
     */
    @Test
    public void testGetcolorauto() {
        System.out.println("getcolorauto");
        Botones instance = null;
        Color expResult = null;
        Color result = instance.getcolorauto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getpistaP method, of class Botones.
     */
    @Test
    public void testGetpistaP() {
        System.out.println("getpistaP");
        Botones instance = null;
        boolean expResult = false;
        boolean result = instance.getpistaP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getpistaG method, of class Botones.
     */
    @Test
    public void testGetpistaG() {
        System.out.println("getpistaG");
        Botones instance = null;
        boolean expResult = false;
        boolean result = instance.getpistaG();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getcambiopista method, of class Botones.
     */
    @Test
    public void testGetcambiopista() {
        System.out.println("getcambiopista");
        Botones instance = null;
        boolean expResult = false;
        boolean result = instance.getcambiopista();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBotonestoPanel method, of class Botones.
     */
    @Test
    public void testAddBotonestoPanel() {
        System.out.println("addBotonestoPanel");
        PanelPrincipal pp = null;
        Botones instance = null;
        instance.addBotonestoPanel(pp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addButtonsCoordinate method, of class Botones.
     */
    @Test
    public void testAddButtonsCoordinate() {
        System.out.println("addButtonsCoordinate");
        Botones instance = null;
        instance.addButtonsCoordinate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
