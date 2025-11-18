
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

    public ComandoAgregarFichaGrupo(int[] idFichas, int[] idFichasGrupo) {
        this.idFichas = idFichas;
        this.idFichasGrupo = idFichasGrupo;
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
    
    
}
