
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * @author pedro
 */
public class ComandoTerminarTurno implements ICommand{
    private final String type = "ComandoTerminarTurno";
    private String nombreJugador;

    public ComandoTerminarTurno(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getNombreJugador() {
        return nombreJugador;
    }
    
    
}
