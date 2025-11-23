
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
    
    @Override
    public void ejecutar(ICommand comando) {
        
        CommandType tipoComando = CommandType.fromNombre(comando.getType());
        
        switch (tipoComando) {
            case CommandType.AGREGAR_FICHAS_TABLERO_GRUPO:
                
                System.out.println("Agregando Fichas A Grupo");
                break;
            case CommandType.AGREGAR_FICHAS_TABLERO:
                
                System.out.println("Agregando Fichas Solas");
                break;
                
            case CommandType.QUITAR_FICHAS_JUGADOR:
                
                System.out.println("Quitando Fichas Jugador");
                break;
                
            case CommandType.QUITAR_FICHAS_TABLERO:
                
                System.out.println("Quitando Fichas Tablero");
                break;
                
            case CommandType.TERMINAR_TURNO:
                
                System.out.println("Terminando Turno");
                break;
                
            default:
                throw new AssertionError();
        }
        
    }

    public void setFiltroSiguiente(IFiltro filtroSiguiente) {
        this.filtroSiguiente = filtroSiguiente;
    }
    
    
}
