
package comandosRespuesta;

import comandosSolicitud.CommandType;
import interfaces.ICommand;


/**
 *
 * Comando de respuesta que notifica el cambio de turno hacia el jugador indicado.
 * 
 * @author pedro
 */
public class ComandoCambioTurno implements ICommand {
    private String nombreJugador;
    private final String type = "ComandoCambioTurno";

    public ComandoCambioTurno(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    @Override
    public String getType() {
        return type;
    }
    
    
}
