
package comandosRespuesta;

import comandosSolicitud.CommandType;
import interfaces.ICommand;


/**
 *
 * @author pedro
 */
public class ComandoCambioTurno implements ICommand {
    private int numeroJugador;
    private final String type = "ComandoCambioTurno";

    public ComandoCambioTurno(int numeroJugador) {
        this.numeroJugador = numeroJugador;
    }

    public int getNumeroJugador() {
        return numeroJugador;
    }

    @Override
    public String getType() {
        return type;
    }
    
    
}
