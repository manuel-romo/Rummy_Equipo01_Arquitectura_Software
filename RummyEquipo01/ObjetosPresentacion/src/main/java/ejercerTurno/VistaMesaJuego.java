
package ejercerTurno;

import dto.FichaPresentacionDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;
import objetosPresentacion.IComponente;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import objetosPresentacion.IVisitor;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */
public class VistaMesaJuego extends JFrame implements ISuscriptor{
    
    private Dimension tamanioVentanaVista = new Dimension(1000, 700);
    private Controlador controlador;
    
    private Map<Integer, FichaPresentacionDTO> mapaFichasCasillasTablero;
    private Map<Integer, FichaPresentacionDTO> mapaFichasCasillasJugador;
    
    public VistaMesaJuego(IComponente componente){
        
        setSize(tamanioVentanaVista);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        agregarPanelComponente(componente);
        setVisible(true);
        
    }
    
    public void agregarPanelComponente(IComponente componente){

        add((JPanel)componente);
 
    }
    
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

    @Override
    public void actualizar(IPublicador publicador) {
        System.out.println("Actualizando vista");
    }
    
    
}
