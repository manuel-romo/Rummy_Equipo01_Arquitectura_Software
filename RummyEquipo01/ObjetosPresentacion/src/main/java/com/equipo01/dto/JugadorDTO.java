
package com.equipo01.dto;

/**
 *
 * @author 
 */
public class JugadorDTO {
    private String avatar;
    private String nombre;
    private int Entero;

    public JugadorDTO(String avatar, String nombre, int Entero) {
        this.avatar = avatar;
        this.nombre = nombre;
        this.Entero = Entero;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEntero() {
        return Entero;
    }
    
    
    
}
