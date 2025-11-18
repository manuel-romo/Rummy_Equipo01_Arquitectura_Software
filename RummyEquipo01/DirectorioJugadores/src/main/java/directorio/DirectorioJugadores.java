 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package directorio;

import interfaces.ICommand;
import interfaces.IDirectorio;
import interfaces.IDispatcher;
import interfaces.IFiltro;
import java.util.Map;

/**
 *
 * @author ramon
 */
public class DirectorioJugadores implements IFiltro{
    
    private Map<String, String[]> jugadoresDirecciones;
    private IDispatcher dispatcher;
    
    
    public void agregarJugador(String nombreJugador, String[] direccion) {
        jugadoresDirecciones.put(nombreJugador, direccion);
    }

    
    public void enviarMensajeJugadores(String respuesta) {
//        String direccion = 
        
    }

    @Override
    public void ejecutar(ICommand comando) {
//        enviarMensajeJugadores(respuesta);
    }

}
