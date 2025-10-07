
package dto;

/**
 *
 * @author 
 */
public class ComodinNegocioDTO extends FichaNegocioDTO{

    
    private String valor;

    public ComodinNegocioDTO(int id) {
        super(id);
        this.valor = "*";
    }

    public String getValor() {
        return valor;
    }

}
