
package objetosPresentacion;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author romom
 */
public class PanelTablero extends JPanel implements IComponente{

    private Color COLOR_FONDO = new Color(60, 130, 72);
    private PosicionPanel POSICION_PANEL = PosicionPanel.CETRO;
    
    public PanelTablero(){
        setBackground(COLOR_FONDO);
    }
    
    
    @Override
    public void agregarComponente(IComponente componente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removerComponente(IComponente componente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aceptar(IVisitor visitor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void pintar(IEstadoTablero estadoTablero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PosicionPanel getPosicion() {
        return POSICION_PANEL;
    }

    
    
}
