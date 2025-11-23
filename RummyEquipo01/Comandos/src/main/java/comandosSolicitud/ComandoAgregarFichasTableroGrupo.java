
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * Comando que agrega fichas al tablero y al grupo del jugador indicado.
 * 
 * @author pedro
 */
public class ComandoAgregarFichasTableroGrupo implements ICommand {
    private int[] idFichas;
    private int[] idFichasGrupo;
    private final String type = "ComandoAgregarFichasTableroGrupo";
    private String nombreJugador;

    public ComandoAgregarFichasTableroGrupo(int[] idFichas, int[] idFichasGrupo, String nombreJugador) {
        this.idFichas = idFichas;
        this.idFichasGrupo = idFichasGrupo;
        this.nombreJugador = nombreJugador;
    }

    public int[] getIdFichas() {
        return idFichas;
    }

    public int[] getIdFichasGrupo() {
        return idFichasGrupo;
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
