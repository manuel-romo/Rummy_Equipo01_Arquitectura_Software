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
public class GrupoNegocioDTO {
    private int numero;
    
    private List<FichaNegocioDTO> fichasNegocioDTO;
    
    
    private List<ComodinNegocioDTO> comodinesNegocioDTO;

    public GrupoNegocioDTO(int numero, List<FichaNegocioDTO> fichasNegocioDTO, List<ComodinNegocioDTO> comodinesNegocioDTO) {
        this.numero = numero;
        this.fichasNegocioDTO = fichasNegocioDTO;
        this.comodinesNegocioDTO = comodinesNegocioDTO;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<FichaNegocioDTO> getFichasNegocioDTO() {
        return fichasNegocioDTO;
    }

    public void setFichasNegocioDTO(List<FichaNegocioDTO> fichasNegocioDTO) {
        this.fichasNegocioDTO = fichasNegocioDTO;
    }

    public List<ComodinNegocioDTO> getComodinesNegocioDTO() {
        return comodinesNegocioDTO;
    }

    public void setComodinesNegocioDTO(List<ComodinNegocioDTO> comodinesNegocioDTO) {
        this.comodinesNegocioDTO = comodinesNegocioDTO;
    }
    
}
