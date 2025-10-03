
package dto;

/**
 *
 * @author romom
 */
public class JugadorExternoPresentacionDTO extends JugadorPresentacionDTO{
    
    int fichasRestantes;

    public JugadorExternoPresentacionDTO(String avatar, String nombre, int numeroSecuencia, int fichasRestantes) {
        super(avatar,nombre, numeroSecuencia);
        this.fichasRestantes = fichasRestantes;
    }

    public int getFichasRestantes() {
        return fichasRestantes;
    }
    
    
    
}
