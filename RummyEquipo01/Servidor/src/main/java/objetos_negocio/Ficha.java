
package objetos_negocio;

import enumeradores.ColorFicha;


/**
 * Clase que representa una ficha del juego rummy.
 * @author juanpheras
 */
public abstract class Ficha {
        
    /**
     * Identicador de cada ficha de Rummy(no es el valor solo su identificador).
     */
    private Integer id;
    
    /**
     * Determina si esta ficha pertenece a un grupo o no.
     */
    private boolean tieneGrupo;
    
    private ColorFicha color;
    
    private boolean esComodin;
    
    private Grupo grupo;


    /**
     * Constructor de la clase ficha, donde se inicia su grupo como nulo ya que no pertenece a ninguno.
     * @param id 
     */
    public Ficha(Integer id, ColorFicha color, boolean tieneGrupo, boolean esComodin) {
        this.id = id;
        this.color = color;
        this.tieneGrupo = tieneGrupo;
        this.esComodin = esComodin;
    }

    public Ficha(Integer id, boolean tieneGrupo, ColorFicha color, boolean esComodin, Grupo grupo) {
        this.id = id;
        this.tieneGrupo = tieneGrupo;
        this.color = color;
        this.esComodin = esComodin;
        this.grupo = grupo;
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
     * Getter del valor que determina si la ficha tiene grupo.
     * @return Valor booleano que determina si la ficha tiene grupo.
     */
    public boolean isTieneGrupo() {
        return tieneGrupo;
    }

    /**
     * Setter del valor que determina si la ficha tiene grupo-
     * @param tieneGrupo Valor booleano que determina si la ficha tiene grupo.
     */
    public void setTieneGrupo(boolean tieneGrupo) {
        this.tieneGrupo = tieneGrupo;
    }

    public ColorFicha getColor() {
        return color;
    }

    public void setColor(ColorFicha color) {
        this.color = color;
    }

    public boolean isEsComodin() {
        return esComodin;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    
    
    
}
