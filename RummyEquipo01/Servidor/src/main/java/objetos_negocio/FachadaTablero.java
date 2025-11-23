
package objetos_negocio;

import comandosSolicitud.CommandType;
import interfaces.ICommand;
import interfaces.IFiltro;

/**
 *
 * @author Romo López Manuel
 * ID: 00000253080
 */
public class FachadaTablero implements IFiltro{

    private IFiltro filtroSiguiente;
    private Tablero tablero;
    
    @Override
    public void ejecutar(ICommand comando) {
        
        tablero.ejecutar(comando);
        
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
