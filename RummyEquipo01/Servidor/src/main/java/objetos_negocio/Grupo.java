
package objetos_negocio;

import java.util.List;

/**
 * Clase que representa un conjunto de fichas
 * @author juanpheras
 */
public abstract class Grupo {
    
    /**
     * Número identificador del grupo.
     */
    private Integer numero;
    
    /**
     * Lista de fichas pertenecientes al grupo.
     */
    protected List<Ficha> fichas;

    /**
     * Crea un nuevo grupo con un número identificador y 
     * una lista inicial de fichas.
     * 
     * @param numero identificador del grupo.
     * @param fichas lista de fichas que forman parte del grupo.
     */
    public Grupo(Integer numero, List<Ficha> fichas) {
        this.numero = numero;
        this.fichas = fichas;
        
        for(Ficha ficha: fichas){
            ficha.setGrupo(this);
        }
    }

    /**
     * Getter de la lista de fichas del grupo.
     * @return lista de ntidades Fichas que pertenecen al grupo.
     */
    public List<Ficha> getFichas() {
        return fichas;
    }

    /***
     * Setter de la lista de fichas.
     * @param fichas lista de fichas a actualizar el grupo.  
     */
    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }
    
    
    /**
     * Comprueba si el grupo es válido de acuerdo a las reglas del juego.
     * La validación específica será implementada por las subclases.
     * 
     * @return true si el grupo cumple con las reglas; false en caso contrario.
     */
    public abstract boolean comprobarValidez();
    

    /**
     * Devuelve el número identificador del grupo.
     * 
     * @return el número de grupo.
     */
    public Integer getNumero() {
        return numero;
    }
   
    
    
}
