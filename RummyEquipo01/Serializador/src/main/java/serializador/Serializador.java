
package serializador;

import com.google.gson.Gson;
import interfaces.ICommand;
import interfaces.IFiltro;

/**
 *
 * @author pedro
 */
public class Serializador implements IFiltro {

    private IFiltro filtroSiguiente;
    private final Gson gson = new Gson();
    
    private String serializarAccion(ICommand command) {
        return gson.toJson(command);
    }

    /***
     * Método que envia el comando al componente de conexión, con el comando serializado
     * @param accionSerializada 
     */
    private void enviarAccionSerializada(String accionSerializada) {
        
    }

    /**
     * Método de IFiltro que cuando se le llama, envia la acción al componente de conexión. Si hay un filtro siguiente este se ejecuta.  
     * @param comando 
     */
    @Override
    public void ejecutar(ICommand comando) {
        String accion = this.serializarAccion(comando);
        this.enviarAccionSerializada(accion);

        if (filtroSiguiente != null) {
            filtroSiguiente.ejecutar(comando);
        }
    }
}
