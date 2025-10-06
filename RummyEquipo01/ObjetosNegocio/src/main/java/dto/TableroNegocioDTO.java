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
public class TableroNegocioDTO {
    private JugadorNegocioDTO jugadorPrincipal;
    private List<JugadorNegocioDTO> jugadores;
    private List<GrupoNegocioDTO> grupoFichas;

    public TableroNegocioDTO(JugadorNegocioDTO jugadorPrincipal, List<JugadorNegocioDTO> jugadores, List<GrupoNegocioDTO> grupoFichas) {
        this.jugadorPrincipal = jugadorPrincipal;
        this.jugadores = jugadores;
        this.grupoFichas = grupoFichas;
    }

    public TableroNegocioDTO() {
    }

    public JugadorNegocioDTO getJugadorPrincipal() {
        return jugadorPrincipal;
    }

    public void setJugadorPrincipal(JugadorNegocioDTO jugadorPrincipal) {
        this.jugadorPrincipal = jugadorPrincipal;
    }

    public List<JugadorNegocioDTO> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorNegocioDTO> jugadores) {
        this.jugadores = jugadores;
    }

    public List<GrupoNegocioDTO> getGrupoFichas() {
        return grupoFichas;
    }

    public void setGrupoFichas(List<GrupoNegocioDTO> grupoFichas) {
        this.grupoFichas = grupoFichas;
    }
    
    
}
