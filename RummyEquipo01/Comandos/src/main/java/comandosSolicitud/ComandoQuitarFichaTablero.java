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
    private final String type = "ComandoQuitarFichaTablero";

    public ComandoQuitarFichaTablero(int[] idFichas, int[] idFichasGrupo) {
        this.idFichas = idFichas;
        this.idFichasGrupo = idFichasGrupo;
    }

    public int[] getIdFichas() {
        return idFichas;
    }

    public int[] getIdFichasGrupo() {
        return idFichasGrupo;
    }

    @Override
    public String getType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
