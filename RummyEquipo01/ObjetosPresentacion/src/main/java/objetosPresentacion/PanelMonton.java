    
package objetosPresentacion;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
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
    private Color COLOR_FONDO = new Color(255, 234, 150);
    private String VALOR_LABEL_PANEL = "Fichas restantes: ";
    private JLabel labelNumeroFichasMonton = new JLabel();
    
    Font fuenteDatosJugador = new Font("Arial", Font.BOLD, 18);
    
    public PanelMonton(){
        
        setBackground(COLOR_FONDO);
        
        setLayout(new GridBagLayout());
                

    }
    
    private void actualizarNumeroFichasRestantes(String numeroFichasRestantes){
        
        removeAll();

        JPanel panelAuxiliar = new JPanel();
        
        panelAuxiliar.setLayout(new BoxLayout(panelAuxiliar, BoxLayout.Y_AXIS));
        panelAuxiliar.setOpaque(false);
                
        JLabel labelMonton = new JLabel(VALOR_LABEL_PANEL);
        
        labelMonton.setFont(fuenteDatosJugador);
        
        JPanel panelAuxiliarEncabezado = new JPanel();
        panelAuxiliarEncabezado.setOpaque(false);      
        panelAuxiliarEncabezado.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        panelAuxiliarEncabezado.add(labelMonton);
        
        panelAuxiliar.add(panelAuxiliarEncabezado);
        
        labelNumeroFichasMonton = new JLabel(numeroFichasRestantes);
        
        labelNumeroFichasMonton.setFont(fuenteDatosJugador);
        
        JPanel panelAuxiliarFichasMonton = new JPanel();
        panelAuxiliarFichasMonton.setOpaque(false);
        panelAuxiliarFichasMonton.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        panelAuxiliarFichasMonton.add(labelNumeroFichasMonton);
        
        panelAuxiliar.add(panelAuxiliarFichasMonton);
        
        add(panelAuxiliar);
        
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
        actualizarNumeroFichasRestantes(numeroFichasMonton);
        repaint();
    }

    @Override
    public PosicionPanel getPosicion() {
        return POSICION_PANEL;
    }

 
    
}
