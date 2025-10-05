
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
        IComponente panelJugadorExterno1 = new PanelJugadorExterno();
        IComponente panelJugadorExterno2 = new PanelJugadorExterno();
        IComponente panelJugadorExterno3 = new PanelJugadorExterno();
        
        IComponente panelMesaJuego = new PanelMesaJuego();
        
        panelMesaJuego.agregarComponente(panelMonton);
        panelMesaJuego.agregarComponente(panelTablero);
        panelMesaJuego.agregarComponente(panelJugadorPrincipal);
        panelMesaJuego.agregarComponente(panelJugadorExterno1);
        panelMesaJuego.agregarComponente(panelJugadorExterno2);
        panelMesaJuego.agregarComponente(panelJugadorExterno3);

        
        VistaMesaJuego vistaMesaJuego = new VistaMesaJuego(panelMesaJuego);
        
        
    }
}
