/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comandosRespuesta;

import comandosSolicitud.CommandType;
import interfaces.ICommand;

/**
 *
 * @author pedro
 */
public class ComandoTableroInvalido implements ICommand{
    private CommandType type;

    public ComandoTableroInvalido(CommandType type) {
        this.type = type;
    }
    
    
    
}
