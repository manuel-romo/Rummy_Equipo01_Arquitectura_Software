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
public class ComandoRespuestaMovimiento implements ICommand{
    private TableroDTO tablero;
    private boolean movimientoValido;

    public ComandoRespuestaMovimiento(TableroDTO tablero, boolean movimientoValido) {
        this.tablero = tablero;
        this.movimientoValido = movimientoValido;
    }

    public TableroDTO getTablero() {
        return tablero;
    }

    public boolean isMovimientoValido() {
        return movimientoValido;
    }
    
    
}
