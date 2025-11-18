
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * @author pedro
 */
public class ComandoTerminarTurno implements ICommand{
    private final String type = "ComandoTerminarTurno";

    public ComandoTerminarTurno() {
        
    }

    

    @Override
    public String getType() {
        return type;
    }
    
    
}
