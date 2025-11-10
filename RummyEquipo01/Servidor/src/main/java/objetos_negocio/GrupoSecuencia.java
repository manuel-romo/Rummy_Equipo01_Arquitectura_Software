
package objetos_negocio;

import java.util.List;

/**
 *
 * @author juanpheras
 */
public class GrupoSecuencia extends Grupo{

    public GrupoSecuencia(Integer numero, List<Ficha> fichas) {
        super(numero, fichas);
    }

    
    /**
     * Método que regresa true si el grupo es valido, es decir que cumpla con la secuencia de que sean del mismo color 
     * @return true si es válido, falso de lo contario.
     */
    @Override
    public boolean comprobarValidez() {
        return true;
    }
    
}
