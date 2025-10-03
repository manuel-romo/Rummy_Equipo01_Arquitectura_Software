
package objetosPresentacion;

import dto.FichaPresentacionDTO;
import dto.JugadorPrincipalPresentacionDTO;
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
