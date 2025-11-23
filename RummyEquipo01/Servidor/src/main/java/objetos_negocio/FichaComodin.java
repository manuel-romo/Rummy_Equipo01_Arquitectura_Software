package objetos_negocio;

import enumeradores.ColorFicha;

/**
 *
 * @author 
 */
public class FichaComodin extends Ficha{
    
    private String valor;

    public FichaComodin(Integer id, ColorFicha color, boolean tieneGrupo, String valor) {
        super(id, color, tieneGrupo);
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
    
}
