
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * @author Romo López Manuel
 * ID: 00000253080
 */
public class ComandoSeleccionarFichasTablero implements ICommand{

    private String type = "ComandoSeleccionarFichasTablero";
    
    private String nombreJugador;
    private int[] idFichas;

    public ComandoSeleccionarFichasTablero(int[] idFichas, String nombreJugador) {
        this.idFichas = idFichas;
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
