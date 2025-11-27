
package comandosRespuesta;

import interfaces.ICommand;


public class ComandoRespuestaConfirmacionAbandonar implements ICommand{
    
    private String type = "ComandoRespuestaConfirmacionAbandonar";
    private String nombreJugador;

    public ComandoRespuestaConfirmacionAbandonar(String nombreJugador) {
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
