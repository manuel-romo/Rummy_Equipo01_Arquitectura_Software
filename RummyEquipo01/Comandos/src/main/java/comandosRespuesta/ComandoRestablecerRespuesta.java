/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comandosRespuesta;

import comandosSolicitud.CommandType;
import dto.TableroDTO;
import interfaces.ICommand;

/**
 *
 * Comando de respuesta que envía el tablero restablecido al jugador.
 * 
 * @author pedro
 */
public class ComandoRestablecerRespuesta implements ICommand {
    private TableroDTO tablero;
    private final String type = "ComandoRestablecerRespuesta";
    private String nombreJugador;

    public ComandoRestablecerRespuesta(TableroDTO tablero, String nombreJugador) {
        this.tablero = tablero;
        this.nombreJugador = nombreJugador;
    }

    public TableroDTO getTablero() {
        return tablero;
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
