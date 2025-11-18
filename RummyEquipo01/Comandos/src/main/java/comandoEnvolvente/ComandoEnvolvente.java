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

    public ComandoEnvolvente(String mensajeSerializado) {
        this.mensajeSerializado = mensajeSerializado;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getMensajeSerializado() {
        return mensajeSerializado;
    }
}
