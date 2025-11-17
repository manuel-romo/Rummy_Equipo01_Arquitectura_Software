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
public class ComandoQuitarFichaTablero implements ICommand{
    private int[] idFichas;
    private int[] idFichasGrupo;
    private CommandType type;

    public ComandoQuitarFichaTablero(int[] idFichas, int[] idFichasGrupo,  CommandType type) {
        this.idFichas = idFichas;
        this.idFichasGrupo = idFichasGrupo;
        this.type = type;
    }

    public int[] getIdFichas() {
        return idFichas;
    }

    public int[] getIdFichasGrupo() {
        return idFichasGrupo;
    }
    
    
}
