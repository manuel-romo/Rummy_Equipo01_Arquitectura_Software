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
public class ComandoQuitarFichasJugador implements ICommand{
    private String type = "ComandoQuitarFichasJugador";
    
    private int[] idFichas;

    public ComandoQuitarFichasJugador(int[] idFichas) {
        this.idFichas = idFichas;
    }

    @Override
    public String getType() {
        return type;
    }
    
}
