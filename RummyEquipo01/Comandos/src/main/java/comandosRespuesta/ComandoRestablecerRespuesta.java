/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comandosRespuesta;

import dto.TableroDTO;
import interfaces.ICommand;

/**
 *
 * @author pedro
 */
public class ComandoRestablecerRespuesta implements ICommand {
    private TableroDTO tablero;

    public ComandoRestablecerRespuesta(TableroDTO tablero) {
        this.tablero = tablero;
    }

    public TableroDTO getTablero() {
        return tablero;
    }

    
    
}
