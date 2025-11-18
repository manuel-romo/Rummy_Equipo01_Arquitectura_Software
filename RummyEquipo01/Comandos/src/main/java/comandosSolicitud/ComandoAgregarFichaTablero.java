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
    private String nombreJugador;

    public ComandoAgregarFichaTablero(int[] idFichas, String nombreJugador) {
        this.idFichas = idFichas;
        this.nombreJugador = nombreJugador;
    }

    public int[] getIdFichas() {
        return idFichas;
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
