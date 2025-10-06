
package objetosPresentacion;

import ejercerTurno.VistaMesaJuego;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author romom
 */
public class ObjetosPresentacion {

    private static int TOTAL_CASILLAS_TABLERO =500;
    private static int TOTAL_CASILLAS_MANO = 14;
    
    public static void main(String[] args) {
        
        IComponente panelMonton = new PanelMonton();
        
        PanelCasilla[] panelesCasillaTablero = new PanelCasilla[TOTAL_CASILLAS_TABLERO];

        for (int i = 0; i < TOTAL_CASILLAS_TABLERO; i++) {
            panelesCasillaTablero[i] = new PanelCasilla(i + 1);
        }
        
        
        IComponente panelTablero = new PanelTablero(panelesCasillaTablero);
        
        PanelCasilla[] panelesCasillaJugador = new PanelCasilla[TOTAL_CASILLAS_MANO];
         
        for (int i = 0; i < TOTAL_CASILLAS_MANO; i++) {
            panelesCasillaJugador[i] = new PanelCasilla(i + 1);
        }
        
        IComponente panelJugadorPrincipal = new PanelJugadorPrincipal(panelesCasillaJugador);
        IComponente panelJugadorExterno1 = new PanelJugadorExterno(PosicionPanel.CENTRO_ARRIBA);
        IComponente panelJugadorExterno2 = new PanelJugadorExterno(PosicionPanel.DERECHA_CENTRO);
        IComponente panelJugadorExterno3 = new PanelJugadorExterno(PosicionPanel.IZQUIERDA_CENTRO);
        
        IComponente panelMesaJuego = new PanelMesaJuego();
        
        panelMesaJuego.agregarComponente(panelMonton);
        panelMesaJuego.agregarComponente(panelTablero);
        panelMesaJuego.agregarComponente(panelJugadorPrincipal);
        panelMesaJuego.agregarComponente(panelJugadorExterno1);
        panelMesaJuego.agregarComponente(panelJugadorExterno2);
        panelMesaJuego.agregarComponente(panelJugadorExterno3);

        Map<Integer, Color> mapaColoresSeleccionados = Map.of(
            1, Color.RED,
            2, Color.BLUE,
            3, Color.GREEN
        );      
        
        Map<Integer,Integer> mapaIdsCasillasPanelesMano = new HashMap<>();
        
        int idFichaActual = 1;
        
        for(int i = 0; i < 14; i++){

            mapaIdsCasillasPanelesMano.put(i + 1, idFichaActual);
            
            idFichaActual++;
            
        }

        
        Map<Integer,Integer> mapaIdsCasillasPanelesTablero = new HashMap<>();
        
        for(int i = 0; i < 20; i++){

            mapaIdsCasillasPanelesTablero.put(i + 1, idFichaActual);
            idFichaActual++;
            
        }
        
        VistaMesaJuego vistaMesaJuego = new VistaMesaJuego(
                panelMesaJuego, 
                mapaColoresSeleccionados,
                mapaIdsCasillasPanelesTablero,
                mapaIdsCasillasPanelesMano);
        
        ((PanelTablero) panelTablero).setActionListener(vistaMesaJuego);
        ((PanelJugadorPrincipal) panelJugadorPrincipal).setActionListener(vistaMesaJuego);
        
        vistaMesaJuego.actualizar(null);
        
        
    }
}
