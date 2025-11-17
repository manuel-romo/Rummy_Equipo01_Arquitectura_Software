
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * @author pedro
 */
public class ComandoRestablecerTablero implements ICommand{
    private CommandType type;

    public ComandoRestablecerTablero(CommandType type) {
        this.type = type;
    }
    
}
