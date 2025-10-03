
package ejercerTurno;

import dto.JugadorExternoPresentacionDTO;
import dto.JugadorPrincipalPresentacionDTO;
import dto.MontonPresentacionDTO;


public interface IModelo {
    
    public abstract JugadorPrincipalPresentacionDTO obtenerJugadorPrincipal();
    
    public abstract JugadorExternoPresentacionDTO[] obtenerJugadoresExternos();
    
    public abstract MontonPresentacionDTO[] obtenerMontonPresentacionDTO();
    
    public abstract String obtenerMensajeMovimientoInvalido();
    
    public abstract String obtenerMensajeTableroInvalido();
    
    public abstract boolean isVistaHabilitada();
    
}
