/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.List;

/**
 *
 * @author pedro
 */
public class JugadorNegocioDTO {
    private List<FichaNegocioDTO> fichas;
    private String avatar;
    private String nombre;
    private boolean esPrimerTurno;
    /**
     * Constructor donde el primer turno se setea a true
     * @param fichas
     * @param avatar
     * @param nombre 
     */
    public JugadorNegocioDTO(List<FichaNegocioDTO> fichas, String avatar, String nombre) {
        this.fichas = fichas;
        this.avatar = avatar;
        this.nombre = nombre;
        esPrimerTurno = true;
    }

    public JugadorNegocioDTO(List<FichaNegocioDTO> fichas, String avatar, String nombre, boolean esPrimerTurno) {
        this.fichas = fichas;
        this.avatar = avatar;
        this.nombre = nombre;
        this.esPrimerTurno = esPrimerTurno;
    }

    public JugadorNegocioDTO() {
    }

    public List<FichaNegocioDTO> getFichas() {
        return fichas;
    }

    public void setFichas(List<FichaNegocioDTO> fichas) {
        this.fichas = fichas;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEsPrimerTurno() {
        return esPrimerTurno;
    }

    public void setEsPrimerTurno(boolean esPrimerTurno) {
        this.esPrimerTurno = esPrimerTurno;
    }
    
}
