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
    private final String type = "ComandoRestablecerRespuesta";

    public ComandoRestablecerRespuesta(TableroDTO tablero) {
        this.tablero = tablero;
    }

    public TableroDTO getTablero() {
        return tablero;
    }

    @Override
    public String getType() {
        return type;
    }

    
    
}
