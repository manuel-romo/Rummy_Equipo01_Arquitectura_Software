
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * Comando que agrega las fichas indicadas al tablero para el jugador.
 * 
 * @author pedro
 */
public class ComandoAgregarFichasTablero implements ICommand{
    
    private int[] idsFichas;
    private final String type = "ComandoAgregarFichaTablero";
    private String nombreJugador;

    public ComandoAgregarFichasTablero(int[] idFichas, String nombreJugador) {
        this.idsFichas = idFichas;
        this.nombreJugador = nombreJugador;
    }

    public int[] getIdsFichas() {
        return idsFichas;
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
