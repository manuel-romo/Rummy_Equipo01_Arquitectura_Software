/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package objetos_negocio;

import comandosRespuesta.ComandoTableroInvalido;
import comandosSolicitud.ComandoAgregarFichasTablero;
import comandosSolicitud.ComandoAgregarFichasTableroGrupo;
import comandosSolicitud.ComandoTerminarTurno;
import enumeradores.ColorFicha;
import interfaces.ICommand;
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
public class TableroTest {
    
    public TableroTest() {
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
     * Test of ejecutar method, of class Tablero.
     */
    @Test
    public void testEjecutar() throws Exception {
        System.out.println("ejecutar");
    }

    /**
     * Test of verificarTipoGrupo method, of class Tablero.
     */
    @Test
    public void testVerificarTipoGrupo() {
        System.out.println("verificarTipoGrupo");
        List<Ficha> fichas = Arrays.asList(new FichaNormal(1, ColorFicha.COLOR_A, true, false, 1), new FichaNormal(2, ColorFicha.COLOR_A, true, false, 2), new FichaNormal(3, ColorFicha.COLOR_A, true, false, 3));
        String nombreJugador = "ramoncito";
        Tablero instance = new Tablero();
        instance.setJugadorTurno(new Jugador(nombreJugador, nombreJugador, true, fichas));
        Grupo expResult = new GrupoSecuencia(fichas);
        Grupo result = instance.verificarTipoGrupo(fichas, nombreJugador);
        System.out.println(expResult);
        System.out.println(result);
    }

    /**
     * Test of validarPrimerTurno method, of class Tablero.
     */
    @Test
    public void testValidarPrimerTurno() {
        System.out.println("validarPrimerTurno");
        List<Ficha> fichas = Arrays.asList(new FichaNormal(1, ColorFicha.COLOR_A, true, false, 30), new FichaNormal(2, ColorFicha.COLOR_A, true, false, 2), new FichaNormal(3, ColorFicha.COLOR_A, true, false, 3));
        Tablero instance = new Tablero();
        boolean expResult = true;
        boolean result = instance.validarPrimerTurno(fichas);
        assertEquals(expResult, result);
    }

    /**
     * Test of validarTablero method, of class Tablero.
     */
    @Test
    public void testValidarTablero() {
        System.out.println("validarTablero");
        Tablero instance = new Tablero();
        List<Ficha> fichas = Arrays.asList(new FichaNormal(1, ColorFicha.COLOR_A, true, false, 1), new FichaNormal(2, ColorFicha.COLOR_A, true, false, 2), new FichaNormal(3, ColorFicha.COLOR_A, true, false, 3));        
        Grupo grupo = new GrupoColores(fichas);
        instance.setGrupos(Arrays.asList(grupo));
        boolean expResult = false;
        boolean result = instance.validarTablero();
        assertEquals(expResult, result);
    }
    
}
