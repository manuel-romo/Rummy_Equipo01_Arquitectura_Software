
package objetosPresentacion;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */
public class EstadoActual implements IEstadoMonton, IEstadoJugadorPrincipal, IEstadoJugadorExterno, IEstadoTablero, IEstadoMesaJuego, IEstadoPanelMovimiento{
    
    private JugadorExternoInformacionPanel[] jugadoresExternos;
    private JugadorPrincipalInformacionPanel jugadorPrincipal;
    private MontonInformacionPanel monton;
    private TableroInformacionPanel tablero;
    private String mensaje;
    private boolean movimientoValido;

    public EstadoActual(
            JugadorExternoInformacionPanel[] jugadoresExternos, 
            JugadorPrincipalInformacionPanel jugadorPrincipal, 
            MontonInformacionPanel monton, 
            TableroInformacionPanel tablero, 
            String mensaje,
            boolean movimientoValido) {
        
        this.jugadoresExternos = jugadoresExternos;
        this.jugadorPrincipal = jugadorPrincipal;
        this.monton = monton;
        this.tablero = tablero;
        this.mensaje = mensaje;
        this.movimientoValido = movimientoValido;
    }

    
    @Override
    public MontonInformacionPanel getMonton() {
        return monton;
    }

    @Override
    public JugadorPrincipalInformacionPanel getJugadorPrincipal() {
        return jugadorPrincipal;
    }

    @Override
    public JugadorExternoInformacionPanel[] getJugadoresExternos() {
        return jugadoresExternos;
    }
    
    @Override
    public TableroInformacionPanel getTablero() {
        return tablero;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean getMovimientoValido() {
        return movimientoValido;
    }
    
}
