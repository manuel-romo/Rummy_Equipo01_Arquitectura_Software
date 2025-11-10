
package objetos_negocio;

import java.util.List;

/**
 * Clase de Negocio para el servidor el cual valida todo el tablero cuando se termina el turno.
 * @author Juan Heras
 */
public class Tablero {
    
    private List<Jugador> jugadores;
    private List<Grupo> grupos;
    
    
    public boolean validarTablero(){
        for (Grupo grupo : grupos) {
            if(!grupo.comprobarValidez()){
                return false;
            }
        }
        return true;
    }
}
