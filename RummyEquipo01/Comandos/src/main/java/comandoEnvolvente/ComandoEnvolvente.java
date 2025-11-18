/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comandoEnvolvente;

import interfaces.ICommand;

/**
 *
 * @author pedro
 */
public class ComandoEnvolvente implements ICommand {

    private final String type = "ComandoEnvolvente";
    private String mensajeSerializado;
    private String nombreJugador;

    public ComandoEnvolvente(String mensajeSerializado, String nombreJugador) {
        this.mensajeSerializado = mensajeSerializado;
        this.nombreJugador = nombreJugador;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getMensajeSerializado() {
        return mensajeSerializado;
    }

    @Override
    public String getNombreJugador() {
        return nombreJugador;
    }
}
