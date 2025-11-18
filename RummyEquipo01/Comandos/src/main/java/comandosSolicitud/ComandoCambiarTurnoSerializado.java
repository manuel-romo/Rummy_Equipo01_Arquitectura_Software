/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * @author pedro
 */
public class ComandoCambiarTurnoSerializado implements ICommand{
    private int numeroJugador;
    private final String type = "ComandoCambiarTurnoSerializado";

    public ComandoCambiarTurnoSerializado(int numeroJugador) {
        this.numeroJugador = numeroJugador;
    }

    public int getNumeroJugador() {
        return numeroJugador;
    }

    @Override
    public String getType() {
        return type;
    }
    
    
}
