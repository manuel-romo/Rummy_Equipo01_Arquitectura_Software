
package dto;

/**
 *
 * @author 
 */
public class ComodinNegocioDTO extends FichaNegocioDTO{

    
    private String valor;

    public ComodinNegocioDTO(int id, int numeroGrupo) {
        super(id, numeroGrupo);
    }

    public String getValor() {
        return valor;
    }

}
