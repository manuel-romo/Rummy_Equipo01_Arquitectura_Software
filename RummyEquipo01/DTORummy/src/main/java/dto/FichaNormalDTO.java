

package dto;

import enumeradores.ColorFichaDTO;

/**
 *
 * @author 
 */
public class FichaNormalDTO extends FichaDTO{
    
    private int numero;

    public FichaNormalDTO(ColorFichaDTO color, int id, int numero) {
        super(color, id);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    
}
