 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package directorio;

import interfaces.IDirectorio;
import interfaces.IDispatcher;
import java.util.Map;

/**
 *
 * @author ramon
 */
public class DirectorioJugadores implements IDirectorio{
    
    private Map<String, String[]> jugadoresDirecciones;
    private IDispatcher dispatcher;
    
    @Override
    public void agregarJugador(String nombreJugador, String[] direccion) {
        jugadoresDirecciones.put(nombreJugador, direccion);
    }

    @Override
    public void enviarMensajeJugadores(String respuesta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
