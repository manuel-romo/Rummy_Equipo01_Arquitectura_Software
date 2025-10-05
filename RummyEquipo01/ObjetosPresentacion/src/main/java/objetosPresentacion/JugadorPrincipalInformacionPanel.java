
package objetosPresentacion;

import java.util.Map;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 */
public class JugadorPrincipalInformacionPanel {
   
    private FichaInformacionPanel[] fichasJugadorPrincipal;

    public JugadorPrincipalInformacionPanel(FichaInformacionPanel[] fichasJugadorPrincipal) {
        this.fichasJugadorPrincipal = fichasJugadorPrincipal;
    }

    public FichaInformacionPanel[] getFichasJugadorPrincipal() {
        return fichasJugadorPrincipal;
    }
}
