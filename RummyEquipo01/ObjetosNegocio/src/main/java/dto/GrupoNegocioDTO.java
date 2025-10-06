
package dto;

import java.util.List;

/**
 *
 * @author 
 */
public abstract class GrupoNegocioDTO {
    
    private int numero;
    private List<FichaNegocioDTO> fichasNegocioDTO;

    public GrupoNegocioDTO(int numero, List<FichaNegocioDTO> fichasNegocioDTO) {
        this.numero = numero;
        this.fichasNegocioDTO = fichasNegocioDTO;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<FichaNegocioDTO> getFichasNegocioDTO() {
        return fichasNegocioDTO;
    }

    public void setFichasNegocioDTO(List<FichaNegocioDTO> fichasNegocioDTO) {
        this.fichasNegocioDTO = fichasNegocioDTO;
    }

    
    
}
