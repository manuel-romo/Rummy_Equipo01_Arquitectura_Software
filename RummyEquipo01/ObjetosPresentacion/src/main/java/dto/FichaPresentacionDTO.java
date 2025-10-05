
package dto;

/**
 *
 * @author romom
 */
public class FichaPresentacionDTO {
    
    private int idFicha;
    private int valor;
    private ColorFicha color;

    public FichaPresentacionDTO(int idFicha, int valor, ColorFicha color) {
        this.idFicha = idFicha;
        this.valor = valor;
        this.color = color;
    }

    public FichaPresentacionDTO() {

    }
    
    
    public int getIdFicha() {
        return idFicha;
    }

    public int getValor() {
        return valor;
    }

    public ColorFicha getColor() {
        return color;
    }
    
    
    
}
