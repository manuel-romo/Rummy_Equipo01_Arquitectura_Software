
package dto;

import java.util.List;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */
public class GrupoSecuenciaNegocioDTO extends GrupoNegocioDTO{
    
    public GrupoSecuenciaNegocioDTO(int numero, List<FichaNegocioDTO> fichasNegocioDTO) {
        super(numero, fichasNegocioDTO);
    }
    
    public GrupoSecuenciaNegocioDTO(int numero) {
        super(numero, null);
    }
    
}
