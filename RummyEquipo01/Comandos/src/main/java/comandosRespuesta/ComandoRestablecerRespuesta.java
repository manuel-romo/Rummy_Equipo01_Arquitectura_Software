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
 * @author pedro
 */
public class ComandoRestablecerRespuesta implements ICommand {
    private TableroDTO tablero;
    private CommandType type;

    public ComandoRestablecerRespuesta(TableroDTO tablero,  CommandType type) {
        this.tablero = tablero;
        this.type = type;
    }

    public TableroDTO getTablero() {
        return tablero;
    }

    
    
}
