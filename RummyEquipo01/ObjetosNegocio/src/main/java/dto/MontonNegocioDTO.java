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
public class MontonNegocioDTO {
    private List<FichaNegocioDTO> fichas;

    public MontonNegocioDTO(List<FichaNegocioDTO> fichas) {
        this.fichas = fichas;
    }

    public List<FichaNegocioDTO> getFichas() {
        return fichas;
    }

    public void setFichas(List<FichaNegocioDTO> fichas) {
        this.fichas = fichas;
    }
    
}
