
package comandosSolicitud;

import comandoEnvolvente.ComandoEnvolvente;
import comandosRespuesta.*;

/**
 * Clase ENUM que representa el tipo de comando 
 * @author juanpheras
 */
public enum CommandType {
          
    SELECCIONAR_FICHAS_TABLERO("ComandoSeleccionarFichasTablero"),
    AGREGAR_FICHAS_TABLERO("ComandoAgregarFichasTablero"),
    AGREGAR_FICHAS_TABLERO_GRUPO("ComandoAgregarFichasTableroGrupo"),
    CAMBIAR_TURNO_SERIALIZADO("ComandoCambiarTurnoSerializado"),
    QUITAR_FICHAS_TABLERO("ComandoQuitarFichaTablero"),
    QUITAR_FICHAS_JUGADOR("ComandoQuitarFichasJugador"),
    AGREGAR_FICHAS_JUGADOR("ComandoAgregarFichasJugador"),
    RESTABLECER_TABLERO("ComandoRestablecerTablero"),
    TERMINAR_TURNO("ComandoTerminarTurno"),
    CAMBIO_TURNO("ComandoCambioTurno"),
    INICIAR_TURNO("ComandoIniciarTurno"),
    RESPUESTA_MOVIMIENTO("ComandoRespuestaMovimiento"),
    COMANDO_RESTABLECER_RESPUESTA("ComandoRestablecerRespuesta"),
    COMANDO_TABLERO_INVALIDO("ComandoTableroInvalido"),
    COMANDO_ENVOLVENTE("ComandoEnvolvente"),
    
    COMANDO_AGREGAR_DIRECCION_JUGADOR("ComandoAgregarDireccionJugador");

    private final String nombre;

    CommandType(String nombre) {
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }
    
    /**
     * Método que devuelve el nombre del comando en String para poder instanciarlo despues de que se convierta en JSON.
     * @param nombre nombre del command
     * @return 
     */
    public static CommandType fromNombre(String nombre) {
        for (CommandType t : values()) {
            if (t.nombre.equals(nombre)) {
                return t;
            }
        }
        throw new IllegalArgumentException("No existe CommandType con nombre: " + nombre);
    }
    
}
