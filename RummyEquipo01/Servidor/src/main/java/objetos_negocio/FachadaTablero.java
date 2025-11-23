
package objetos_negocio;

import comandosSolicitud.CommandType;
import excepciones.RummyException;
import interfaces.ICommand;
import interfaces.IFiltro;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Romo López Manuel
 * ID: 00000253080
 */
public class FachadaTablero implements IFiltro{

    private IFiltro filtroSiguiente;
    private Tablero tablero;
    
    @Override
    public void ejecutar(ICommand comando)  {
        try {
            tablero.ejecutar(comando);
        } catch (RummyException ex) {
            Logger.getLogger(FachadaTablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setFiltroSiguiente(IFiltro filtroSiguiente) {
        this.filtroSiguiente = filtroSiguiente;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    
    public void enviarComando(ICommand comando){
        
        filtroSiguiente.ejecutar(comando);
        
    }
    
}
