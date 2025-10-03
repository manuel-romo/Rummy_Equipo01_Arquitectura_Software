
package com.equipo01.ejercerturno;

import com.equipo01.dto.FichaPresentacionDTO;
import com.equipo01.objetospresentacion.IComponente;
import java.util.Map;
import javax.swing.JFrame;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */
public class VistaMesaJuego extends JFrame{
    
    private Controlador controlador;
    private IComponente panelMesaJuego;
    private Map<Integer, FichaPresentacionDTO> mapaFichasCasillasTablero;
    private Map<Integer, FichaPresentacionDTO> mapaFichasCasillasJugador;
    
    public void seleccionarFichasTablero(int[] idsFichas){
        controlador.seleccionarFichasTablero(idsFichas);
    }
    
    public void quitarFichasJugador(int[] posicionesFichas){
        controlador.quitarFichasJugador(posicionesFichas);
    }
    
    public void quitarFichasTablero(int[] idsFichas){
        controlador.quitarFichasTablero(idsFichas);
    }
    
    public void agregarFichasTablero(int[] idsFichas, int numeroGrupo){
        controlador.agregarFichasTablero(idsFichas, numeroGrupo);
    }
    
    public void agregarFichasTablero(int[] idsFichas){
        controlador.agregarFichasTablero(idsFichas);
    }
    
    public void terminarTurno(){
        controlador.terminarTurno();
    }
    
    private void habilitarVista(boolean vistaHabilitada){
        
    }
    
    
}
