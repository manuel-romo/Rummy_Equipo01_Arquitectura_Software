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
    private String nombreJugador;
    
    private int[] idFichas;

    public ComandoQuitarFichasJugador(int[] idFichas, String nombreJugador) {
        this.idFichas = idFichas;
        this.nombreJugador = nombreJugador;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getNombreJugador() {
        return nombreJugador;
    }
    
}
