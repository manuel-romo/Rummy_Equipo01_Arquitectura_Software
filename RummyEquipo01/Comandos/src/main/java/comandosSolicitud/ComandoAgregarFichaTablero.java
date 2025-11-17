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
public class ComandoAgregarFichaTablero implements ICommand{
    private int[] idFichas;
    private CommandType type;

    public ComandoAgregarFichaTablero(int[] idFichas, CommandType type) {
        this.idFichas = idFichas;
        this.type = type;
    }

    public int[] getIdFichas() {
        return idFichas;
    }
    
    
}
