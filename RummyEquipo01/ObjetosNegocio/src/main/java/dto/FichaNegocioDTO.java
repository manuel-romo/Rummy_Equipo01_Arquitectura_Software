/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.ColorFicha;

/**
 *
 * @author pedro
 */
public class FichaNegocioDTO {
    public int id;
    public ColorFicha color;
    public int numero;

    public FichaNegocioDTO(int id, ColorFicha color, int numero) {
        this.id = id;
        this.color = color;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public ColorFicha getColor() {
        return color;
    }

    public int getNumero() {
        return numero;
    }

   
    
}
