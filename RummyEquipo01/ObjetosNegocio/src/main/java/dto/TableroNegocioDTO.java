
package dto;

import java.util.List;

/**
 *
 * @author 
 */
public class TableroNegocioDTO {
    private JugadorNegocioDTO jugadorPrincipal;
    private JugadorNegocioDTO[] jugadoreExternos;
    private GrupoNegocioDTO[] grupos;
    private MontonNegocioDTO monton;

    public TableroNegocioDTO(JugadorNegocioDTO jugadorPrincipal, JugadorNegocioDTO[] jugadoreExternos, GrupoNegocioDTO[] grupos, MontonNegocioDTO monton) {
        this.jugadorPrincipal = jugadorPrincipal;
        this.jugadoreExternos = jugadoreExternos;
        this.grupos = grupos;
        this.monton = monton;
    }

    public JugadorNegocioDTO getJugadorPrincipal() {
        return jugadorPrincipal;
    }

    public JugadorNegocioDTO[] getJugadoreExternos() {
        return jugadoreExternos;
    }

    public GrupoNegocioDTO[] getGrupos() {
        return grupos;
    }

    public MontonNegocioDTO getMonton() {
        return monton;
    }

    
}
