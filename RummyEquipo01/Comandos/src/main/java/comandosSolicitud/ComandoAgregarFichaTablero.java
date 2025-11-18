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
    private final String type = "ComandoAgregarFichaTablero";

    public ComandoAgregarFichaTablero(int[] idFichas) {
        this.idFichas = idFichas;
    }

    public int[] getIdFichas() {
        return idFichas;
    }

    @Override
    public String getType() {
        return type;
    }
    
    
}
