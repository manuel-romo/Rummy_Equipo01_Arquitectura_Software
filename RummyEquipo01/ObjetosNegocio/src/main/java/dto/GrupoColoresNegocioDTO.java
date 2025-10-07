
package dto;

import java.util.List;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */

public class GrupoColoresNegocioDTO extends GrupoNegocioDTO{
    
    public GrupoColoresNegocioDTO(int numero, List<FichaNegocioDTO> fichasNegocioDTO) {
        super(numero, fichasNegocioDTO);
    }
    
    public GrupoColoresNegocioDTO(int numero) {
        super(numero, null);
    }
    
}
