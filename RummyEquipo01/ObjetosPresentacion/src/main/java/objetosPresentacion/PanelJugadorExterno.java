
package objetosPresentacion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */

public class PanelJugadorExterno extends JPanel implements IComponente{
    
    private PosicionPanel posicionPanel;
    private Color COLOR_FONDO_PANEL_MANO = new Color(69, 42, 32);
    
    private JPanel panelMano = new JPanel();
    private JPanel panelLateralMano1 = new JPanel();
    private JPanel panelLateralMano2 = new JPanel();
    
    private JPanel panelSuperiorLateralMano1 = new JPanel();
    private JPanel panelSuperiorLateralMano2 = new JPanel();
    
    private JPanel panelEsquina1 = new JPanel();
    private JPanel panelEsquina2 = new JPanel();

    private JLabel nombreJugador = new JLabel();
    private JLabel avatarJugadro = new JLabel();
    private JLabel cantidadFichasRestantes = new JLabel();
    
    
    public PanelJugadorExterno(PosicionPanel posicionPanel){
        
        this.posicionPanel = posicionPanel;
                
        setOpaque(false);
        
        panelMano.setBackground(COLOR_FONDO_PANEL_MANO);
        panelLateralMano1.setBackground(COLOR_FONDO_PANEL_MANO);
        panelLateralMano2.setBackground(COLOR_FONDO_PANEL_MANO);
        panelSuperiorLateralMano1.setOpaque(false);
        panelSuperiorLateralMano2.setOpaque(false);
        panelEsquina1.setOpaque(false);
        panelEsquina2.setOpaque(false);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        
        if(posicionPanel.equals(PosicionPanel.IZQUIERDA_CENTRO)){
            configurarPanelManoIzquierdaCentro();
            configurarPanelLateralMano1IzquierdaCentro();
            configurarPanelLateralMano2IzquierdaCentro();
            configurarPanelSuperiorLateralMano1IzquierdaCentro();
            configurarPanelSuperiorLateralMano2IzquierdaCentro();
            configurarPanelEsquina1IzquierdaCentro();
            configurarPanelEsquina2IzquierdaCentro();
        } 
        else if(posicionPanel.equals(PosicionPanel.DERECHA_CENTRO)){
            configurarPanelManoDerechaCentro();
            configurarPanelLateralMano1DerechaCentro();
            configurarPanelLateralMano2DerechaCentro();
            configurarPanelSuperiorLateralMano1DerechaCentro();
            configurarPanelSuperiorLateralMano2DerechaCentro();
            configurarPanelEsquina1DerechaCentro();
            configurarPanelEsquina2DerechaCentro();
        } 
        else if(posicionPanel.equals(PosicionPanel.CENTRO_ARRIBA)){
            configurarPanelManoCentroArriba();
            configurarPanelLateralMano1CentroArriba();
            configurarPanelLateralMano2CentroArriba();
            configurarPanelSuperiorLateralMano1CentroArriba();
            configurarPanelSuperiorLateralMano2CentroArriba();
            configurarPanelEsquina1CentroArriba();
            configurarPanelEsquina2CentroArriba();
        }
        
    }
    
     // Métodos para panel en Derecha Centro
    
    private void configurarPanelManoDerechaCentro(){
        
        GridBagConstraints gridBagConstraintsPanelMano = new GridBagConstraints();
        
        gridBagConstraintsPanelMano.gridx = 7;
        gridBagConstraintsPanelMano.gridy = 4;
        gridBagConstraintsPanelMano.weightx = 1;
        gridBagConstraintsPanelMano.weighty = 6;
        gridBagConstraintsPanelMano.gridwidth = 2;
        gridBagConstraintsPanelMano.gridheight = 3;
        gridBagConstraintsPanelMano.fill = GridBagConstraints.BOTH;
        add(panelMano, gridBagConstraintsPanelMano);
    }
    
    private void configurarPanelLateralMano1DerechaCentro(){
        
        GridBagConstraints gridBagConstraintsPanelLateralMano1 = new GridBagConstraints();
        
        gridBagConstraintsPanelLateralMano1.gridx = 7;
        gridBagConstraintsPanelLateralMano1.gridy = 3;
        gridBagConstraintsPanelLateralMano1.weightx = 0.1;
        gridBagConstraintsPanelLateralMano1.weighty = 1;
        gridBagConstraintsPanelLateralMano1.gridwidth = 1;
        gridBagConstraintsPanelLateralMano1.gridheight = 1;
        gridBagConstraintsPanelLateralMano1.fill = GridBagConstraints.BOTH;
        
        add(panelLateralMano1, gridBagConstraintsPanelLateralMano1);
    }
    
    private void configurarPanelLateralMano2DerechaCentro(){
        
        GridBagConstraints gridBagConstraintsPanelLateralMano2 = new GridBagConstraints();
        
        gridBagConstraintsPanelLateralMano2.gridx = 7;
        gridBagConstraintsPanelLateralMano2.gridy = 7;
        gridBagConstraintsPanelLateralMano2.weightx = 0.1;
        gridBagConstraintsPanelLateralMano2.weighty = 1;
        gridBagConstraintsPanelLateralMano2.gridwidth = 1;
        gridBagConstraintsPanelLateralMano2.gridheight = 1;
        gridBagConstraintsPanelLateralMano2.fill = GridBagConstraints.BOTH;
       
        add(panelLateralMano2, gridBagConstraintsPanelLateralMano2);
    }
    
    private void configurarPanelSuperiorLateralMano1DerechaCentro(){
        
        GridBagConstraints gridBagConstraintsPanelSuperiorLateralMano1 = new GridBagConstraints();
        
        gridBagConstraintsPanelSuperiorLateralMano1.gridx = 8;
        gridBagConstraintsPanelSuperiorLateralMano1.gridy = 3;
        gridBagConstraintsPanelSuperiorLateralMano1.weightx = 0.1;
        gridBagConstraintsPanelSuperiorLateralMano1.weighty = 1;
        gridBagConstraintsPanelSuperiorLateralMano1.gridwidth = 1;
        gridBagConstraintsPanelSuperiorLateralMano1.gridheight = 1;
        gridBagConstraintsPanelSuperiorLateralMano1.fill = GridBagConstraints.BOTH;
        
        add(panelSuperiorLateralMano1, gridBagConstraintsPanelSuperiorLateralMano1);
        
    }
    
    private void configurarPanelSuperiorLateralMano2DerechaCentro(){
        
        GridBagConstraints gridBagConstraintsPanelSuperiorLateralMano2 = new GridBagConstraints();
        
        gridBagConstraintsPanelSuperiorLateralMano2.gridx = 8;
        gridBagConstraintsPanelSuperiorLateralMano2.gridy = 7;
        gridBagConstraintsPanelSuperiorLateralMano2.weightx = 0.1;
        gridBagConstraintsPanelSuperiorLateralMano2.weighty = 1;
        gridBagConstraintsPanelSuperiorLateralMano2.gridwidth = 1;
        gridBagConstraintsPanelSuperiorLateralMano2.gridheight = 1;
        gridBagConstraintsPanelSuperiorLateralMano2.fill = GridBagConstraints.BOTH;
        
        add(panelSuperiorLateralMano2, gridBagConstraintsPanelSuperiorLateralMano2);
        
    }
    
    private void configurarPanelEsquina1DerechaCentro(){
        
        GridBagConstraints gridBagConstraintsPanelEsquina1 = new GridBagConstraints();
        
        gridBagConstraintsPanelEsquina1.gridx = 7;
        gridBagConstraintsPanelEsquina1.gridy = 2;
        gridBagConstraintsPanelEsquina1.weightx = 1;
        gridBagConstraintsPanelEsquina1.weighty = 1;
        gridBagConstraintsPanelEsquina1.gridwidth = 2;
        gridBagConstraintsPanelEsquina1.gridheight = 1;
        gridBagConstraintsPanelEsquina1.fill = GridBagConstraints.BOTH;
        
        add(panelEsquina1, gridBagConstraintsPanelEsquina1);
        
    }
    
    private void configurarPanelEsquina2DerechaCentro(){
        
        GridBagConstraints gridBagConstraintsPanelEsquina1 = new GridBagConstraints();
        
        gridBagConstraintsPanelEsquina1.gridx = 7;
        gridBagConstraintsPanelEsquina1.gridy = 8;
        gridBagConstraintsPanelEsquina1.weightx = 1;
        gridBagConstraintsPanelEsquina1.weighty = 1;
        gridBagConstraintsPanelEsquina1.gridwidth = 2;
        gridBagConstraintsPanelEsquina1.gridheight = 1;
        gridBagConstraintsPanelEsquina1.fill = GridBagConstraints.BOTH;
        
        add(panelEsquina2, gridBagConstraintsPanelEsquina1);
        
    }
    
    
    
    
    // Métodos para panel en Izquierda Centro
    private void configurarPanelManoIzquierdaCentro(){
        
        GridBagConstraints gridBagConstraintsPanelMano = new GridBagConstraints();
        
        gridBagConstraintsPanelMano.gridx = 0;
        gridBagConstraintsPanelMano.gridy = 4;
        gridBagConstraintsPanelMano.weightx = 1;
        gridBagConstraintsPanelMano.weighty = 5;
        gridBagConstraintsPanelMano.gridwidth = 2;
        gridBagConstraintsPanelMano.gridheight = 3;
        gridBagConstraintsPanelMano.fill = GridBagConstraints.BOTH;
        add(panelMano, gridBagConstraintsPanelMano);
    }
    
    private void configurarPanelLateralMano1IzquierdaCentro(){
        
        GridBagConstraints gridBagConstraintsPanelLateralMano1 = new GridBagConstraints();
        
        gridBagConstraintsPanelLateralMano1.gridx = 1;
        gridBagConstraintsPanelLateralMano1.gridy = 7;
        gridBagConstraintsPanelLateralMano1.weightx = 0.1;
        gridBagConstraintsPanelLateralMano1.weighty = 1;
        gridBagConstraintsPanelLateralMano1.gridwidth = 1;
        gridBagConstraintsPanelLateralMano1.gridheight = 1;
        gridBagConstraintsPanelLateralMano1.fill = GridBagConstraints.BOTH;
        
        add(panelLateralMano1, gridBagConstraintsPanelLateralMano1);
    }
    
    private void configurarPanelLateralMano2IzquierdaCentro(){
        
        GridBagConstraints gridBagConstraintsPanelLateralMano2 = new GridBagConstraints();
        
        gridBagConstraintsPanelLateralMano2.gridx = 1;
        gridBagConstraintsPanelLateralMano2.gridy = 3;
        gridBagConstraintsPanelLateralMano2.weightx = 0.1;
        gridBagConstraintsPanelLateralMano2.weighty = 1;
        gridBagConstraintsPanelLateralMano2.gridwidth = 1;
        gridBagConstraintsPanelLateralMano2.gridheight = 1;
        gridBagConstraintsPanelLateralMano2.fill = GridBagConstraints.BOTH;
       
        add(panelLateralMano2, gridBagConstraintsPanelLateralMano2);
    }
    
    private void configurarPanelSuperiorLateralMano1IzquierdaCentro(){
        
        GridBagConstraints gridBagConstraintsPanelSuperiorLateralMano1 = new GridBagConstraints();
        
        gridBagConstraintsPanelSuperiorLateralMano1.gridx = 0;
        gridBagConstraintsPanelSuperiorLateralMano1.gridy = 7;
        gridBagConstraintsPanelSuperiorLateralMano1.weightx = 0.1;
        gridBagConstraintsPanelSuperiorLateralMano1.weighty = 1;
        gridBagConstraintsPanelSuperiorLateralMano1.gridwidth = 1;
        gridBagConstraintsPanelSuperiorLateralMano1.gridheight = 1;
        gridBagConstraintsPanelSuperiorLateralMano1.fill = GridBagConstraints.BOTH;
        
        add(panelSuperiorLateralMano1, gridBagConstraintsPanelSuperiorLateralMano1);
        
    }
    
    private void configurarPanelSuperiorLateralMano2IzquierdaCentro(){
        
        GridBagConstraints gridBagConstraintsPanelSuperiorLateralMano2 = new GridBagConstraints();
        
        gridBagConstraintsPanelSuperiorLateralMano2.gridx = 0;
        gridBagConstraintsPanelSuperiorLateralMano2.gridy = 3;
        gridBagConstraintsPanelSuperiorLateralMano2.weightx = 0.1;
        gridBagConstraintsPanelSuperiorLateralMano2.weighty = 1;
        gridBagConstraintsPanelSuperiorLateralMano2.gridwidth = 1;
        gridBagConstraintsPanelSuperiorLateralMano2.gridheight = 1;
        gridBagConstraintsPanelSuperiorLateralMano2.fill = GridBagConstraints.BOTH;
        
        add(panelSuperiorLateralMano2, gridBagConstraintsPanelSuperiorLateralMano2);
        
    }
    
    private void configurarPanelEsquina1IzquierdaCentro(){
        
        GridBagConstraints gridBagConstraintsPanelEsquina1 = new GridBagConstraints();
        
        gridBagConstraintsPanelEsquina1.gridx = 0;
        gridBagConstraintsPanelEsquina1.gridy = 8;
        gridBagConstraintsPanelEsquina1.weightx = 1;
        gridBagConstraintsPanelEsquina1.weighty = 1;
        gridBagConstraintsPanelEsquina1.gridwidth = 2;
        gridBagConstraintsPanelEsquina1.gridheight = 1;
        gridBagConstraintsPanelEsquina1.fill = GridBagConstraints.BOTH;
        
        add(panelEsquina1, gridBagConstraintsPanelEsquina1);
        
    }
    
    private void configurarPanelEsquina2IzquierdaCentro(){
        
        GridBagConstraints gridBagConstraintsPanelEsquina1 = new GridBagConstraints();
        
        gridBagConstraintsPanelEsquina1.gridx = 0;
        gridBagConstraintsPanelEsquina1.gridy = 2;
        gridBagConstraintsPanelEsquina1.weightx = 1;
        gridBagConstraintsPanelEsquina1.weighty = 1;
        gridBagConstraintsPanelEsquina1.gridwidth = 2;
        gridBagConstraintsPanelEsquina1.gridheight = 1;
        gridBagConstraintsPanelEsquina1.fill = GridBagConstraints.BOTH;
        
        add(panelEsquina2, gridBagConstraintsPanelEsquina1);
        
    }
    
    
    
    
    
    // Métodos para panel en Centro Arriba
    
    private void configurarPanelManoCentroArriba(){
        
        GridBagConstraints gridBagConstraintsPanelMano = new GridBagConstraints();
        
        gridBagConstraintsPanelMano.gridx = 3;
        gridBagConstraintsPanelMano.gridy = 0;
        gridBagConstraintsPanelMano.weightx = 1.5;
        gridBagConstraintsPanelMano.weighty = 1;
        gridBagConstraintsPanelMano.gridwidth = 3;
        gridBagConstraintsPanelMano.gridheight = 2;
        gridBagConstraintsPanelMano.fill = GridBagConstraints.BOTH;
        add(panelMano, gridBagConstraintsPanelMano);
    }
    
    private void configurarPanelLateralMano1CentroArriba(){
        
        GridBagConstraints gridBagConstraintsPanelLateralMano1 = new GridBagConstraints();
        
        gridBagConstraintsPanelLateralMano1.gridx = 2;
        gridBagConstraintsPanelLateralMano1.gridy = 1;
        gridBagConstraintsPanelLateralMano1.weightx = 0.1;
        gridBagConstraintsPanelLateralMano1.weighty = 1;
        gridBagConstraintsPanelLateralMano1.gridwidth = 1;
        gridBagConstraintsPanelLateralMano1.gridheight = 1;
        gridBagConstraintsPanelLateralMano1.fill = GridBagConstraints.BOTH;
        
        add(panelLateralMano1, gridBagConstraintsPanelLateralMano1);
    }
    
    private void configurarPanelLateralMano2CentroArriba(){
        
        GridBagConstraints gridBagConstraintsPanelLateralMano2 = new GridBagConstraints();
        
        gridBagConstraintsPanelLateralMano2.gridx = 6;
        gridBagConstraintsPanelLateralMano2.gridy = 1;
        gridBagConstraintsPanelLateralMano2.weightx = 0.1;
        gridBagConstraintsPanelLateralMano2.weighty = 1;
        gridBagConstraintsPanelLateralMano2.gridwidth = 1;
        gridBagConstraintsPanelLateralMano2.gridheight = 1;
        gridBagConstraintsPanelLateralMano2.fill = GridBagConstraints.BOTH;
       
        add(panelLateralMano2, gridBagConstraintsPanelLateralMano2);
    }
    
    private void configurarPanelSuperiorLateralMano1CentroArriba(){
        
        GridBagConstraints gridBagConstraintsPanelSuperiorLateralMano1 = new GridBagConstraints();
        
        gridBagConstraintsPanelSuperiorLateralMano1.gridx = 2;
        gridBagConstraintsPanelSuperiorLateralMano1.gridy = 0;
        gridBagConstraintsPanelSuperiorLateralMano1.weightx = 0.1;
        gridBagConstraintsPanelSuperiorLateralMano1.weighty = 1;
        gridBagConstraintsPanelSuperiorLateralMano1.gridwidth = 1;
        gridBagConstraintsPanelSuperiorLateralMano1.gridheight = 1;
        gridBagConstraintsPanelSuperiorLateralMano1.fill = GridBagConstraints.BOTH;
        
        add(panelSuperiorLateralMano1, gridBagConstraintsPanelSuperiorLateralMano1);
        
    }
    
    private void configurarPanelSuperiorLateralMano2CentroArriba(){
        
        GridBagConstraints gridBagConstraintsPanelSuperiorLateralMano2 = new GridBagConstraints();
        
        gridBagConstraintsPanelSuperiorLateralMano2.gridx = 6;
        gridBagConstraintsPanelSuperiorLateralMano2.gridy = 0;
        gridBagConstraintsPanelSuperiorLateralMano2.weightx = 0.1;
        gridBagConstraintsPanelSuperiorLateralMano2.weighty = 1;
        gridBagConstraintsPanelSuperiorLateralMano2.gridwidth = 1;
        gridBagConstraintsPanelSuperiorLateralMano2.gridheight = 1;
        gridBagConstraintsPanelSuperiorLateralMano2.fill = GridBagConstraints.BOTH;
        
        add(panelSuperiorLateralMano2, gridBagConstraintsPanelSuperiorLateralMano2);
        
    }
    
    private void configurarPanelEsquina1CentroArriba(){
        
        GridBagConstraints gridBagConstraintsPanelEsquina1 = new GridBagConstraints();
        
        gridBagConstraintsPanelEsquina1.gridx = 0;
        gridBagConstraintsPanelEsquina1.gridy = 0;
        gridBagConstraintsPanelEsquina1.weightx = 1;
        gridBagConstraintsPanelEsquina1.weighty = 1;
        gridBagConstraintsPanelEsquina1.gridwidth = 2;
        gridBagConstraintsPanelEsquina1.gridheight = 2;
        gridBagConstraintsPanelEsquina1.fill = GridBagConstraints.BOTH;
        
        add(panelEsquina1, gridBagConstraintsPanelEsquina1);
        
    }
    
    private void configurarPanelEsquina2CentroArriba(){
        
        GridBagConstraints gridBagConstraintsPanelEsquina2 = new GridBagConstraints();
        
        gridBagConstraintsPanelEsquina2.gridx = 7;
        gridBagConstraintsPanelEsquina2.gridy = 0;
        gridBagConstraintsPanelEsquina2.weightx = 1;
        gridBagConstraintsPanelEsquina2.weighty = 1;
        gridBagConstraintsPanelEsquina2.gridwidth = 2;
        gridBagConstraintsPanelEsquina2.gridheight = 2;
        gridBagConstraintsPanelEsquina2.fill = GridBagConstraints.BOTH;
        
        add(panelEsquina2, gridBagConstraintsPanelEsquina2);
        
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
        visitor.visitar(this);
    }

    public void pintar(IEstadoJugadorExterno estadoJugadorExterno) {
        System.out.println("Pintando PanelJugadorPrincipal");
        repaint();
    }

    @Override
    public PosicionPanel getPosicion() {
        return posicionPanel;
    }
    
}
