
package objetos_negocio;

import enumeradores.ColorFicha;
import excepciones.GrupoExcedeLimiteException;
import excepciones.RummyException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author juanpheras
 */
public class GrupoColores extends Grupo {

    /**
     * Constructor de el grupo de colores.
     *
     * @param numero numero identificador del grupo.
     * @param fichas Fichas con las que se iniciara en el grupo.
     */
    public GrupoColores(Integer numero, List<Ficha> fichas) {
        super(numero, fichas);
    }
    

    @Override
    public boolean comprobarValidez() {
        
        // 3 fichas mínimo
        if (this.fichas.size() < 3) {
            return false;
        }

        try {

            determinarValidezFichas(this.fichas);

        } catch (RummyException ex) {
            
            return false;
        }
        
        return true;
    }
    

    @Override
    protected void determinarValidezFichas(List<Ficha> fichas) throws RummyException{
        
        if (fichas.size() > 4) {
            throw new RummyException("El grupo que quieres formar no puede ser de más de 4 fichas.");
        }
        
        Grupo.validarGrupoColores(fichas);
        
    }

}
