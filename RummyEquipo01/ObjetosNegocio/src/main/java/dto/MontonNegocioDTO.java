
package dto;

import java.util.List;

/**
 *
 * @author pedro
 */
public class MontonNegocioDTO {
    private List<FichaNegocioDTO> fichas;

    public MontonNegocioDTO(List<FichaNegocioDTO> fichas) {
        this.fichas = fichas;
    }

    public List<FichaNegocioDTO> getFichas() {
        return fichas;
    }
    
}
