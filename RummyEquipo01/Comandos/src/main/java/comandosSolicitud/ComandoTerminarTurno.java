
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * @author pedro
 */
public class ComandoTerminarTurno implements ICommand{
    private CommandType type;

    public ComandoTerminarTurno(CommandType type) {
        this.type = type;
    }
    
    
}
