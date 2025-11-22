/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author juanpheras
 */
public class FichaNormal extends Ficha {
    
    private ColorFicha color;
    private int numero;
    
    /**
     * Constructor de una ficha normal. 
     * @param id Id de la ficha.
     * @param color color de la ficha iniciada.
     * @param numero valor de la ficha.
     */
    public FichaNormal(Integer id, int numero, ColorFicha color){
        super(id);
        this.color = color;
        this.numero = numero;
    }

    /**
     * Getter del color de la ficha.
     * @return  Categoria del color.
     */
    public ColorFicha getColor() {
        return color;
    }

    /**
     * Setter del atributo color.
     * @param color Categoria del color nuevo.
     */
    public void setColor(ColorFicha color) {
        this.color = color;
    }

    /**
     * Valor que representa la ficha normal. 
     * @return 
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Setter del numero de la ficha normal.
     * @param numero valor del nuevo numero a cambiar,
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean isComodin() {
        return false;
    }
    
    
}
