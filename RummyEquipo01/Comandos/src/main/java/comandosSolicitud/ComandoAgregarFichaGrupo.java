
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * @author pedro
 */
public class ComandoAgregarFichaGrupo implements ICommand{
    private int[] idFichas;
    private int[] idFichasGrupo;
    private CommandType type;

    public ComandoAgregarFichaGrupo(int[] idFichas, int[] idFichasGrupo, CommandType type) {
        this.idFichas = idFichas;
        this.idFichasGrupo = idFichasGrupo;
        this.type = type;
    }

    public int[] getIdFichas() {
        return idFichas;
    }

    public int[] getIdFichasGrupo() {
        return idFichasGrupo;
    }
    
    
}
