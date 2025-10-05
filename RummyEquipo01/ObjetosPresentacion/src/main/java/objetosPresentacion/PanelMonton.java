
package objetosPresentacion;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */
public class PanelMonton extends JPanel implements IComponente{

    private PosicionPanel POSICION_PANEL = PosicionPanel.IZQUIERDA_ABAJO;
    private Color COLOR_FONDO = new Color(212, 209, 186);
    private String VALOR_LABEL_PANEL = "Fichas restantes: ";
    
    private int numeroFichasMonton;
    
    public PanelMonton(){
        
        setBackground(COLOR_FONDO);
        JLabel labelNumeroFichasMonton = new JLabel(VALOR_LABEL_PANEL);
        add(labelNumeroFichasMonton);
                
        
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

    public void pintar(IEstadoMonton estadoMonton) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PosicionPanel getPosicion() {
        return POSICION_PANEL;
    }

 
    
}
