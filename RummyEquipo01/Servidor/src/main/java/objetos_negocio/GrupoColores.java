/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos_negocio;

import java.util.List;

/**
 *
 * @author juanpheras
 */
public class GrupoColores extends Grupo {

    public GrupoColores(Integer numero, List<Ficha> fichas) {
        super(numero, fichas);
    }

    /**
     * Método que regresa true si el grupo es valido, es decir que cumpla con la
     * secuencia de que sean del mismo color
     *
     * @return true si es válido, falso de lo contario.
     */
    @Override
    public boolean comprobarValidez() {
        return true;
    }
}
