
package comandosRespuesta;

import comandosSolicitud.CommandType;
import interfaces.ICommand;


/**
 *
 * @author pedro
 */
public class ComandoCambioTurno implements ICommand {
    private int numeroJugador;
    private CommandType type;

    public ComandoCambioTurno(int numeroJugador,  CommandType type) {
        this.numeroJugador = numeroJugador;
        this.type = type;
    }

    public int getNumeroJugador() {
        return numeroJugador;
    }
    
    
}
