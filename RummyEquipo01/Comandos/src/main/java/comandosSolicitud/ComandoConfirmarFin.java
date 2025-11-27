
package comandosSolicitud;

import interfaces.ICommand;


public class ComandoConfirmarFin implements ICommand{
    
    private String type = "ComandoConfirmarFin";
    private String nombreJugador;

    public ComandoConfirmarFin(String nombreJugador) {
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
