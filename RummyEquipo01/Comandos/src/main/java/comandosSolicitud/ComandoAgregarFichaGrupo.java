
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * @author pedro
 */
public class ComandoAgregarFichaGrupo implements ICommand{
    private int[] idFichas;
    private int[] idFichasGrupo;
    private final String type = "ComandoAgregarFichaGrupo";
    private String nombreJugador;

    public ComandoAgregarFichaGrupo(int[] idFichas, int[] idFichasGrupo, String nombreJugador) {
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
