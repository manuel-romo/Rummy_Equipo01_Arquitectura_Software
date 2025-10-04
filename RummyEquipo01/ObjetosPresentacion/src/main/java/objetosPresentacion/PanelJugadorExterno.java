
package objetosPresentacion;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */

public class PanelJugadorExterno extends JPanel implements IComponente{

    private Color COLOR_FONDO_PANEL_MANO = new Color(69, 42, 32);
    
    private JPanel panelMano = new JPanel();
    private JPanel panelLateralMano = new JPanel();
    
    public PanelJugadorExterno(){
        
        panelMano.setBackground(COLOR_FONDO_PANEL_MANO);
        panelLateralMano.setBackground(COLOR_FONDO_PANEL_MANO);
        
    }
    
    @Override
    public void agregarComponente(IComponente componente) {
        throw new UnsupportedOperationException("Not supported yet.");    
    }

    @Override
    public void removerComponente(IComponente componente) {
        throw new UnsupportedOperationException("Not supported yet.");    
    }

    @Override
    public void aceptar(IVisitor visitor) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void pintar(IEstadoJugadorExterno estadoJugadorExterno) {
        System.out.println("Pintando PanelJugadorPrincipal");
    }

    @Override
    public boolean tienePosicion() {
        return true;
    }
    
}
