
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * Comando que agrega fichas al tablero y al grupo del jugador indicado.
 * 
 * @author pedro
 */
public class ComandoAgregarFichasTableroGrupo implements ICommand {
    private int[] idsFichas;
    private int[] idsFichasGrupo;
    private final String type = "ComandoAgregarFichasTableroGrupo";
    private String nombreJugador;

    public ComandoAgregarFichasTableroGrupo(int[] idFichas, int[] idFichasGrupo, String nombreJugador) {
        this.idsFichas = idFichas;
        this.idsFichasGrupo = idFichasGrupo;
        this.nombreJugador = nombreJugador;
    }

    public int[] getIdsFichas() {
        return idsFichas;
    }

    public int[] getIdsFichasGrupo() {
        return idsFichasGrupo;
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
