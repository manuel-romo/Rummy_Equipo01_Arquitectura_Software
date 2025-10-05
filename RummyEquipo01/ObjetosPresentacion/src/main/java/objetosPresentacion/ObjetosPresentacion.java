
package objetosPresentacion;

import ejercerTurno.VistaMesaJuego;

/**
 *
 * @author romom
 */
public class ObjetosPresentacion {

    public static void main(String[] args) {
        
        IComponente panelMonton = new PanelMonton();
        
        PanelCasilla[] panelesCasillaTablero = {
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), 
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), 
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), 
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), 
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(),
            new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla(), new PanelCasilla()
        };
        
        IComponente panelTablero = new PanelTablero(panelesCasillaTablero);
        
        PanelCasilla[] panelesCasillaJugador = {
            new PanelCasilla(),
            new PanelCasilla(), 
            new PanelCasilla(), 
            new PanelCasilla(), 
            new PanelCasilla(), 
            new PanelCasilla(), 
            new PanelCasilla(),
            new PanelCasilla(),
            new PanelCasilla(),
            new PanelCasilla(),
            new PanelCasilla(),
            new PanelCasilla(),
            new PanelCasilla(),
            new PanelCasilla()
        };
        
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

        
        VistaMesaJuego vistaMesaJuego = new VistaMesaJuego(panelMesaJuego);
        
        
    }
}
