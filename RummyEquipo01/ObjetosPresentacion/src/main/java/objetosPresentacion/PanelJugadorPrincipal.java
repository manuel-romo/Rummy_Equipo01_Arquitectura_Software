
package objetosPresentacion;

import java.awt.Color;
import javax.swing.JPanel;


public class PanelJugadorPrincipal extends JPanel implements IComponente{

    
    private Color COLOR_FONDO = new Color(45, 54, 140);
    
    private final PosicionPanel POSICION_PANEL = PosicionPanel.ABAJO_CENTRO;
    
    public PanelJugadorPrincipal(){
        
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

    public void pintar(IEstadoJugadorPrincipal estadoJugadorPrincpal) {
        System.out.println("Pintando PanelJugadorPrincipal");
    }

    public boolean tienePosicion() {
        return false;
    }

    @Override
    public PosicionPanel getPosicion() {
        return POSICION_PANEL;

    }
    
}
