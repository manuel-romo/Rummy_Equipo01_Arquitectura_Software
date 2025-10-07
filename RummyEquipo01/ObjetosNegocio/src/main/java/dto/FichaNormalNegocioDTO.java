 
package dto;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */
public class FichaNormalNegocioDTO extends FichaNegocioDTO{
    
    private ColorFichaNegocioDTO color;
    private int numero;

    public FichaNormalNegocioDTO(int numero, int id, ColorFichaNegocioDTO color) {
        super(id);
        this.color = color;
        this.numero = numero;
    }

    public ColorFichaNegocioDTO getColor() {
        return color;
    }

    public int getNumero() {
        return numero;
    }
    
    
}
