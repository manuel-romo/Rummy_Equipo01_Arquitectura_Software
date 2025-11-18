/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * Comando que indica que el turno debe cambiar al jugador especificado.
 * 
 * @author pedro
 */
public class ComandoCambiarTurnoSerializado implements ICommand{
    private String nombreJugador;
    private final String type = "ComandoCambiarTurnoSerializado";

    public ComandoCambiarTurnoSerializado(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    @Override
    public String getType() {
        return type;
    }
    
    
}
