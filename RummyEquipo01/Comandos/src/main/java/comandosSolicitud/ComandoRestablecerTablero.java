
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * Comando que solicita restablecer el tablero para el jugador indicado.
 * 
 * @author pedro
 */
public class ComandoRestablecerTablero implements ICommand{
    private final String type = "ComandoRestablecerTablero";
    private String nombreJugador;
    
    public ComandoRestablecerTablero(String nombreJugador) {
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
