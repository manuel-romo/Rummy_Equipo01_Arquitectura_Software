
package objetosPresentacion;

import dto.FichaPresentacionDTO;
import dto.JugadorExternoPresentacionDTO;
import dto.JugadorPrincipalPresentacionDTO;
import dto.MontonPresentacionDTO;
import java.util.Map;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */
public class EstadoActual implements IEstadoMonton, IEstadoJugadorPrincipal, IEstadoJugadorExterno, IEstadoTablero, IEstadoMesaJuego{
    
    private JugadorExternoInformacionPanel[] jugadoresExternos;
    private JugadorPrincipalInformacionPanel jugadorPrincipal;
    private MontonInformacionPanel monton;
    private TableroInformacionPanel tablero;
    private String mensajeMovimientoInvalido;
    private String mensajeTableroInvalido;

    public EstadoActual(
            JugadorExternoInformacionPanel[] jugadoresExternos, 
            JugadorPrincipalInformacionPanel jugadorPrincipal, 
            MontonInformacionPanel monton, 
            TableroInformacionPanel tablero, 
            String mensajeMovimientoInvalido,
            String mensajeTableroInvalido) {
        
        this.jugadoresExternos = jugadoresExternos;
        this.jugadorPrincipal = jugadorPrincipal;
        this.monton = monton;
        this.tablero = tablero;
        this.mensajeMovimientoInvalido = mensajeMovimientoInvalido;
        this.mensajeTableroInvalido = mensajeTableroInvalido;
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
    public String getMensajeMovimientoInvalido() {
        return mensajeMovimientoInvalido;
    }

    @Override
    public String getMensajeTableroInvalido() {
        return mensajeTableroInvalido;
    }

    
    
    
}
