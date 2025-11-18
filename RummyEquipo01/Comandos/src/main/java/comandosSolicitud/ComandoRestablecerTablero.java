
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * @author pedro
 */
public class ComandoRestablecerTablero implements ICommand{
    private final String type = "ComandoRestablecerTablero";

    public ComandoRestablecerTablero() {

    }

    @Override
    public String getType() {
        return type;
    }
    
}
