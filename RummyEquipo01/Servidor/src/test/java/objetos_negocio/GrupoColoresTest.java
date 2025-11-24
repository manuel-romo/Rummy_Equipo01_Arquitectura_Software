/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package objetos_negocio;

import enumeradores.ColorFicha;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public class GrupoColoresTest {
    
    public GrupoColoresTest() {
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
     * Test of comprobarValidez method, of class GrupoColores.
     */
    @Test
    public void testComprobarValidez() {
        System.out.println("comprobarValidez");
        List<Ficha> fichas = Arrays.asList(new FichaNormal(1, ColorFicha.COLOR_A, true, false, 1), new FichaNormal(2, ColorFicha.COLOR_B, true, false, 1), 
                new FichaNormal(3, ColorFicha.COLOR_C, true, false, 1), new FichaNormal(4, ColorFicha.COLOR_D, true, false, 1), new FichaNormal(5, ColorFicha.COLOR_COMODIN, true, false, 1));
        GrupoColores instance = new GrupoColores(fichas);
        boolean expResult = false;
        boolean result = instance.comprobarValidez();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of agregarFichas method, of class GrupoColores.
     */
    @Test
    public void testAgregarFichas() throws Exception {
        System.out.println("agregarFichas");
        List<Ficha> fichas = null;
        GrupoColores instance = null;
        instance.agregarFichas(fichas);
    }
    
}
