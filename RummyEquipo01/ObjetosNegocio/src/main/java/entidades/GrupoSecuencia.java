
package entidades;

import java.util.List;

/**
 *
 * @author Juan Heras
 */
public class GrupoSecuencia extends Grupo {

    /**
     * Constructor de el grupo de colores.
     * @param numero numero identificador del grupo.
     * @param fichas  Fichas con las que se iniciara en el grupo.
     */
    public GrupoSecuencia(List<Ficha> fichas) {
        super(fichas);
    }

    /**
     * Se comprueba la validez al momento de que se agregaron ficha(s).
     * @return verdadero si el grupo si es valido, falso si no.
     */
    @Override
    public boolean comprobarValidez() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void agregarFichas(List<Ficha> fichas) {
        
        for(Ficha ficha: fichas){
            ficha.setGrupo(this);
        }
        
        this.fichas.addAll(fichas);
        
    }
    
}
