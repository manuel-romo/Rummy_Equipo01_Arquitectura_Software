/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comandosRespuesta;

import comandosSolicitud.CommandType;
import interfaces.ICommand;

/**
 * Comando de respuesta que indica que inicia el turno del jugador. 
 * 
 * @author pedro
 */
public class ComandoIniciarTurno implements ICommand{
    private final String type = "ComandoIniciarTurno";
    private String nombreJugador;
    
    public ComandoIniciarTurno(String nombreJugador) {
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
