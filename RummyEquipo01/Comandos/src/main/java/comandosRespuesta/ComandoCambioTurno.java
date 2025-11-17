/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comandosRespuesta;

import interfaces.ICommand;

/**
 *
 * @author pedro
 */
public class ComandoCambioTurno implements ICommand {
    private int numeroJugador;

    public ComandoCambioTurno(int numeroJugador) {
        this.numeroJugador = numeroJugador;
    }

    public int getNumeroJugador() {
        return numeroJugador;
    }
    
    
}
