    
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
    private String numeroFichasMonton;
    
    public PanelMonton(){
        
        setBackground(COLOR_FONDO);
        JLabel labelInformativa = new JLabel(VALOR_LABEL_PANEL);
        
        add(labelInformativa);
                
        
    }
    
    private void actualizarNumeroFichasRestantes(int numeroFichasRestantes){
        
        this.numeroFichasMonton = String.valueOf(numeroFichasRestantes);
        
        JLabel labelNumeroFichasMonton = new JLabel(this.numeroFichasMonton);
        
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
        visitor.visitar(this);
    }

    public void pintar(IEstadoMonton estadoMonton) {
        
        String numeroFichasMonton = estadoMonton.getMonton().getNumeroFichasMonton();
        repaint();
    }

    @Override
    public PosicionPanel getPosicion() {
        return POSICION_PANEL;
    }

 
    
}
