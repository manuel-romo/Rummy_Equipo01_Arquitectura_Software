
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * Comando que solicita quitar fichas del tablero y del grupo indicado para un jugador.
 * 
 * @author pedro
 */
public class ComandoQuitarFichasTablero implements ICommand{
    private int[] idsFichas;
    private final String type = "ComandoQuitarFichaTablero";
    private String nombreJugador;

    public ComandoQuitarFichasTablero(int[] idFichas, String nombreJugador) {
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
