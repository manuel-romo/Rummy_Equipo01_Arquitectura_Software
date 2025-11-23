
package dto;

import java.util.List;

/**
 *
 * @author ramon
 */
public class TableroDTO {
    private List<GrupoDTO> grupos;
    private List<FichaDTO> fichas;
    private MontonDTO monton;

    public TableroDTO(List<GrupoDTO> grupos, List<FichaDTO> fichas, MontonDTO monton) {
        this.grupos = grupos;
        this.fichas = fichas;
        this.monton = monton;
    }
    
    public List<GrupoDTO> getGrupos() {
        return grupos;
    }

    public List<FichaDTO> getFichas() {
        return fichas;
    }

    public MontonDTO getMonton() {
        return monton;
    }
    
    
    
}
