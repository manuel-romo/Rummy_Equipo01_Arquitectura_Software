
package entidades;

import java.util.List;

/**
 *
 * @author juanpheras
 */
public class GrupoColores extends Grupo {

    /**
     * Constructor de el grupo de colores.
     * @param numero numero identificador del grupo.
     * @param fichas  Fichas con las que se iniciara en el grupo.
     */
    public GrupoColores(Integer numero, List<Ficha> fichas) {
        super(numero, fichas);
    }

    /**
     * Se comprueba la validez al momento de que se agregaron ficha(s).
     * @return verdadero si el grupo si es valido, falso si no.
     */
    @Override
    public boolean comprobarValidez() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
