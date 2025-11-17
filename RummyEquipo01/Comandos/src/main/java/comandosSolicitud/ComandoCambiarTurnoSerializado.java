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
    private CommandType type;

    public ComandoCambiarTurnoSerializado(int numeroJugador,  CommandType type) {
        this.numeroJugador = numeroJugador;
        this.type = type;
    }

    public int getNumeroJugador() {
        return numeroJugador;
    }
    
    
}
