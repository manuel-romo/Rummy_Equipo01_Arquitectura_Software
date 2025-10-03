
package com.equipo01.objetospresentacion;

import com.equipo01.dto.FichaPresentacionDTO;
import com.equipo01.dto.JugadorPrincipalPresentacionDTO;
import java.util.Map;

/**
 *
 * @author Manuel Romo López
 * 
 * ID: 00000253080
 */
public interface IEstadoJugadorPrincipal {
    
    public abstract JugadorPrincipalPresentacionDTO getJugadorPrincipalPresentacionDTO();
    public abstract Map<Integer, FichaPresentacionDTO> getMapaFichasCasillasJugador();

}
