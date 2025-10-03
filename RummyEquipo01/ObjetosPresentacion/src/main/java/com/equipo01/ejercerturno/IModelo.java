
package com.equipo01.ejercerturno;

import com.equipo01.dto.JugadorExternoPresentacionDTO;
import com.equipo01.dto.JugadorPrincipalPresentacionDTO;
import com.equipo01.dto.MontonPresentacionDTO;


public interface IModelo {
    
    public abstract JugadorPrincipalPresentacionDTO obtenerJugadorPrincipal();
    
    public abstract JugadorExternoPresentacionDTO[] obtenerJugadoresExternos();
    
    public abstract MontonPresentacionDTO[] obtenerMontonPresentacionDTO();
    
    public abstract String obtenerMensajeMovimientoInvalido();
    
    public abstract String obtenerMensajeTableroInvalido();
    
    public abstract boolean isVistaHabilitada();
    
}
