
package objetosPresentacion;

import ejercerTurno.VistaMesaJuego;

/**
 *
 * @author romom
 */
public class ObjetosPresentacion {

    public static void main(String[] args) {
        
        IComponente panelMonton = new PanelMonton();
        IComponente panelTablero = new PanelTablero();
        IComponente panelJugadorPrincipal = new PanelJugadorPrincipal();
        IComponente panelJugadorExterno = new PanelJugadorExterno();
        
        IComponente panelMesaJuego = new PanelMesaJuego();
        
        panelMesaJuego.agregarComponente(panelMonton);
        panelMesaJuego.agregarComponente(panelTablero);
        panelMesaJuego.agregarComponente(panelJugadorPrincipal);
        panelMesaJuego.agregarComponente(panelJugadorExterno);

        
        VistaMesaJuego vistaMesaJuego = new VistaMesaJuego(panelMesaJuego);
        
        
    }
}
