
package dto;


/**
 *
 * @author 
 */
public abstract class FichaNegocioDTO {
    
    private int id;
    private int numeroGrupo;

    public FichaNegocioDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }
}
