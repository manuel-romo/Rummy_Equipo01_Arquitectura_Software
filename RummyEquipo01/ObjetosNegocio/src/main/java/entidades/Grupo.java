
package entidades;

import java.util.List;

/**
 *
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
    private List<Ficha> fichas;

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
     * Agrega una o más fichas al grupo.
     * 
     * @param fichas arreglo de fichas a agregar al grupo.
     */
    public void agregarFichas(List<Ficha> fichas) { }
    
    /**
     * Remueve una o más fichas del grupo.
     * 
     * @param fichas arreglo de fichas a eliminar del grupo.
     */
    public void removerFichas(List<Ficha> fichas) { }

    /**
     * Devuelve el número identificador del grupo.
     * 
     * @return el número de grupo.
     */
    public Integer getNumero() {
        return numero;
    }
    
    /**
     * Obtiene una ficha en la posición indicada dentro de la lista del grupo.
     * 
     * @param numeroPosicion índice de la ficha a obtener (comenzando en 0).
     * @return la ficha en la posición solicitada.
     * @throws UnsupportedOperationException si la operación no está implementada.
     */
    public Ficha obtenerFichaPosicion(int numeroPosicion) {
        throw new UnsupportedOperationException();
    }
    
    
    
    
    
}
