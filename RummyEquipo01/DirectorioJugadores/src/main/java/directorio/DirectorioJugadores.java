/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package directorio;

import comandoEnvolvente.ComandoEnvolvente;
import interfaces.ICommand;
import interfaces.IDirectorio;
import interfaces.IDispatcher;
import interfaces.IFiltro;
import java.util.Map;

/**
 *
 * @author ramon
 */
public class DirectorioJugadores implements IFiltro {

    private Map<String, String[]> jugadoresDirecciones;
    private IDispatcher dispatcher;

    public void agregarJugador(String nombreJugador, String[] direccion) {
        jugadoresDirecciones.put(nombreJugador, direccion);
    }


    @Override
    public void ejecutar(ICommand comando) {
        ComandoEnvolvente envolvente = (ComandoEnvolvente) comando;

        dispatcher.agregarMensaje(envolvente.getMensajeSerializado(), jugadoresDirecciones.get(comando.getNombreJugador()));
    }

}
