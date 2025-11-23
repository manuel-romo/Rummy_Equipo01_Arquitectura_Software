package directorio;

import comandoEnvolvente.ComandoEnvolvente;
import interfaces.ICommand;
import interfaces.IDirectorio;
import interfaces.IDispatcher;
import interfaces.IFiltro;
import java.util.Map;

/**
 *
 * Filtro encargado de enviar el mensaje de un comando envolvente a la
 * dirección del jugador correspondiente. 
 * 
 * 
 * 
 * @author ramon
 */
public class DirectorioJugadores implements IFiltro {

    private Map<String, String[]> jugadoresDirecciones;
    private IDispatcher dispatcher;

    public void agregarJugador(String nombreJugador, String[] direccion) {
        jugadoresDirecciones.put(nombreJugador, direccion);
    }

    public void setDispatcher(IDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void ejecutar(ICommand comando) {
        ComandoEnvolvente envolvente = (ComandoEnvolvente) comando;

        dispatcher.agregarMensaje(envolvente.getMensajeSerializado(), jugadoresDirecciones.get(comando.getNombreJugador()));
    }

}
