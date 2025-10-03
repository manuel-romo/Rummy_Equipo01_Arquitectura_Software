
package com.equipo01.dto;

/**
 *
 * @author 
 */
public class JugadorPrincipalPresentacionDTO extends JugadorPresentacionDTO{
    private FichaPresentacionDTO[] fichas;

    public JugadorPrincipalPresentacionDTO(String avatar, String nombre, int numeroSecuencia, FichaPresentacionDTO[] fichas) {
        super(avatar, nombre, numeroSecuencia);
        this.fichas = fichas;
    }

    public FichaPresentacionDTO[] getFichas() {
        return fichas;
    }
    
    
}
