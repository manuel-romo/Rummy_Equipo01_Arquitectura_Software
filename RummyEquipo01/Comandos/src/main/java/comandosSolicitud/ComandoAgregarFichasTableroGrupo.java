/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comandosSolicitud;

import interfaces.ICommand;

/**
 *
 * @author pedro
 */
public class ComandoAgregarFichasTableroGrupo implements ICommand {
    private int[] idFichas;
    private int[] idFichasGrupo;

    public ComandoAgregarFichasTableroGrupo(int[] idFichas, int[] idFichasGrupo) {
        this.idFichas = idFichas;
        this.idFichasGrupo = idFichasGrupo;
    }

    public int[] getIdFichas() {
        return idFichas;
    }

    public int[] getIdFichasGrupo() {
        return idFichasGrupo;
    }
    
    
}
