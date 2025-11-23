
package dto;

import enumeradores.ColorFichaDTO;

/**
 *
 * @author 
 */
public class FichaComodinDTO extends FichaDTO{

    private String valor;
    
    public FichaComodinDTO(ColorFichaDTO color, int id, String valor) {
        super(color, id);
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
}
