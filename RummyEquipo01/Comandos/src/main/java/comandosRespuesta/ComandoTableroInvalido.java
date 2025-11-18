/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comandosRespuesta;

import comandosSolicitud.CommandType;
import interfaces.ICommand;

/**
 * Comando de respuesta que indica que el tablero es inválido para el jugador.
 * 
 * @author pedro
 */
public class ComandoTableroInvalido implements ICommand {

    private final String type = "ComandoTableroInvalido";
    private String nombreJugador;

    public ComandoTableroInvalido(String nombreJugador) {
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
