
package entidades;

/**
 *
 * @author juanpheras
 */
public class Ficha {
    
    /**
     * Identicador de cada ficha de Rummy(no es el valor solo su identificador).
     */
    private Integer id;
    
    /**
     * Grupo al cual pertenece una ficha
     */
    private Grupo grupo;

    /**
     * Constructor de la clase ficha, donde se inicia su grupo como nulo ya que no pertenece a ninguno.
     * @param id 
     */
    public Ficha(Integer id) {
        this.id = id;
        this.grupo = null;
    }

    /**
     * Getter del id de la ficha.
     * @return id de la ficha.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter del id nuevo de la ficha a ajustar.
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter del grupo de la ficha.
     * @return Grupo al cual pertenece una ficha.
     */
    public Grupo getGrupo() {
        return grupo;
    }

    /**
     * Actualizador del grupo de la ficha.
     * 
     * @param grupo grupo el cual se le asignara la ficha.
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    
    
    
    
    
    
    
}
