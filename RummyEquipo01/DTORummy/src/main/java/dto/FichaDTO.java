/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;
import entidades.ColorFicha;

/**
 *
 * @author ramon
 */
public class FichaDTO {
   private String valor;
   private ColorFicha color;
   private int id;
   private boolean tieneGrupo;

    public FichaDTO(String valor, ColorFicha color, int id) {
        this.valor = valor;
        this.color = color;
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ColorFicha getColor() {
        return color;
    }

    public void setColor(ColorFicha color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTieneGrupo() {
        return tieneGrupo;
    }

    public void setTieneGrupo(boolean tieneGrupo) {
        this.tieneGrupo = tieneGrupo;
    }
    
    
   
   
}
 