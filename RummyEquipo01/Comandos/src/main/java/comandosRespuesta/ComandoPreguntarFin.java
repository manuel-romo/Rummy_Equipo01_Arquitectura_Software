
package comandosRespuesta;

import interfaces.ICommand;


public class ComandoPreguntarFin implements ICommand{
    
    private String type = "ComandoPreguntarFin";
    private String nombreJugador;

    public ComandoPreguntarFin(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getNombreJugador() {
        return nombreJugador;
    }
}
