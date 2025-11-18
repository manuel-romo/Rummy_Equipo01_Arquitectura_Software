
package comandosSolicitud;

import comandoEnvolvente.ComandoEnvolvente;
import comandosRespuesta.*;

/**
 * Clase ENUM que representa el tipo de comando 
 * @author juanpheras
 */
public enum CommandType {
    
    AGREGAR_FICHA_GRUPO("ComandoAgregarFichaGrupo", ComandoAgregarFichaGrupo.class),
    AGREGAR_FICHA_TABLERO("ComandoAgregarFichaTablero", ComandoAgregarFichaTablero.class),
    AGREGAR_FICHAS_TABLERO_GRUPO("ComandoAgregarFichasTableroGrupo",ComandoAgregarFichasTableroGrupo.class),
    CAMBIAR_TURNO_SERIALIZADO("ComandoCambiarTurnoSerializado",ComandoCambiarTurnoSerializado.class),
    QUITAR_FICHAS_TABLERO("ComandoQuitarFichaTablero",ComandoQuitarFichaTablero.class),
    QUITAR_FICHAS_JUGADOR("ComandoQuitarFichasJugador",ComandoQuitarFichasJugador.class),
    RESTABLECER_TABLERO("ComandoRestablecerTablero",ComandoRestablecerTablero.class),
    TERMINAR_TURNO("ComandoTerminarTurno",ComandoTerminarTurno.class),
    CAMBIO_TURNO("ComandoTerminarTurno",ComandoTerminarTurno.class),
    INICIAR_TURNO("ComandoIniciarTurno",ComandoIniciarTurno.class),
    RESPUESTA_MOVIMIENTO("ComandoRespuestaMovimiento",ComandoRespuestaMovimiento.class),
    COMANDO_RESTABLECER_RESPUESTA("ComandoRestablecerRespuesta",ComandoRestablecerRespuesta.class),
    COMANDO_TABLERO_INVALIDO("ComandoTableroInvalido",ComandoTableroInvalido.class),
    COMANDO_ENVOLVENTE("ComandoEnvolvente", ComandoEnvolvente.class);
    
    

    private final String nombre;
    private final Class<?> clazz;

    CommandType(String nombre, Class<?> clazz) {
        this.nombre = nombre;
        this.clazz = clazz;
    }

    public Class<?> getClazz() {
        return clazz;
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
