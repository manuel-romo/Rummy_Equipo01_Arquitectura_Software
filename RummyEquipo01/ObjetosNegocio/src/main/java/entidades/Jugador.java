
package entidades;

import java.util.List;

/**
 *
 * @author pedro
 */
public class Jugador {
    private String avatar;
    private String nombre;
    private boolean esPrimerTurno;
    private List<Ficha> fichas;

    public Jugador(String avatar, String nombre, boolean esPrimerTurno, List<Ficha> fichas) {
        this.avatar = avatar;
        this.nombre = nombre;
        this.esPrimerTurno = esPrimerTurno;
        this.fichas = fichas;
    }
    
    /**
     * metedo que regresa si es el primer turno
     * @return regresa true si es el primer turno y false si no lo es
     */
    public boolean isEsPrimerTurno() {
        return esPrimerTurno;
    }
    /**
     * metodo que regresa la lista de fichas  en la mano de jugador
     * @return regresa la lista de fichas en la mano de jugador
     */
    public List<Ficha> getFichas() {
        return fichas;
    }
    /**
     * elimina las fichas en las posiciones del parametro
     * @param posiciones lista de posiciones en las cuales estan las fichas a ser eliminadas
     */
    public void quitarFichas(List<Integer> posiciones){
        
    }
    /**
     * elimina las fichas en las posiciones del parametro
     * @param posiciones lista de posiciones en las cuales estan las fichas a ser eliminadas2
     */
    public boolean quitarFichasPrimerTurno(){
        throw new UnsupportedOperationException();
    }

}

