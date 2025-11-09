
package entidades;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    /**
     * metedo que regresa si es el primer turno
     * @return regresa true si es el primer turno y false si no lo es
     */
    public boolean isPrimerTurno() {
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
     * elimina las fichas que tengan su id dentro del parametro
     * @param posiciones lista de ids de las fichas a ser eliminadas
     */
    public boolean quitarFichas(int[] idsFichas){
        
        List<Ficha> fichasEliminar = new LinkedList<>();
        
        for (Ficha ficha : fichas) {
            for (int idFicha : idsFichas) {
                if (ficha.getId() == idFicha) {
                    fichasEliminar.add(ficha);
                    break;
                }
            }
        }

        System.out.println("Eliminando fochas de jugador");
        fichas.removeAll(fichasEliminar);
        
        return true;
    }
    /**
     * elimina las fichas en las posiciones del parametro
     * @param posiciones lista de posiciones en las cuales estan las fichas a ser eliminadas2
     */
    public boolean quitarFichasPrimerTurno(){
        throw new UnsupportedOperationException();
    }
}

