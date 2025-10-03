
package com.equipo01.dto;

/**
 *
 * @author 
 */
public class JugadorPrincipalPresentacion {
    private FichaPresentacionDTO[] fichas;

    public JugadorPrincipalPresentacion(FichaPresentacionDTO[] fichas) {
        this.fichas = fichas;
    }

    public FichaPresentacionDTO[] getFichas() {
        return fichas;
    }
    
    
}
