
package dto;

import entidades.ColorFicha;

/**
 *
 * @author 
 */
public abstract class FichaNegocioDTO {
    
    private int id;
    private int numeroGrupo;

    public FichaNegocioDTO(int id, int numeroGrupo) {
        this.id = id;
        this.numeroGrupo = numeroGrupo;
    }

    public int getId() {
        return id;
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }
    
}
