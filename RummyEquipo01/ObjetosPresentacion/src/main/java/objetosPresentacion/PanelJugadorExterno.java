
package objetosPresentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */

public class PanelJugadorExterno extends JPanel implements IComponente{
    
    private final PosicionPanel POSICION_PANEL = PosicionPanel.EXTREMO;
    
    private Color COLOR_FONDO_PANEL_MANO = new Color(69, 42, 32);
    
    private JPanel panelMano = new JPanel();
    private JPanel panelLateralMano1 = new JPanel();
    private JPanel panelLateralMano2 = new JPanel();
    
    private JPanel panelSuperiorLateralMano1 = new JPanel();
    private JPanel panelSuperiorLateralMano2 = new JPanel();
    
    private JPanel panelEsquina1 = new JPanel();
    private JPanel panelEsquina2 = new JPanel();

    
    public PanelJugadorExterno(){
        
        panelMano.setBackground(COLOR_FONDO_PANEL_MANO);
        panelLateralMano1.setBackground(COLOR_FONDO_PANEL_MANO);
        panelLateralMano2.setBackground(COLOR_FONDO_PANEL_MANO);
        panelSuperiorLateralMano1.setBackground(Color.BLACK);
        panelSuperiorLateralMano2.setBackground(Color.BLACK);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        
        configurarPanelMano();
        configurarPanelLateralMano1();
        configurarPanelLateralMano2();
        configurarPanelSuperiorLateralMano1();
        configurarPanelSuperiorLateralMano2();
        configurarPanelEsquina1();
        configurarPanelEsquina2();
        
    }
    
    private void configurarPanelMano(){
        
        GridBagConstraints gridBagConstraintsPanelMano = new GridBagConstraints();
        
        gridBagConstraintsPanelMano.gridx = 2;
        gridBagConstraintsPanelMano.gridy = 0;
        gridBagConstraintsPanelMano.weightx = 1.5;
        gridBagConstraintsPanelMano.weighty = 1;
        gridBagConstraintsPanelMano.gridwidth = 3;
        gridBagConstraintsPanelMano.gridheight = 2;
        gridBagConstraintsPanelMano.fill = GridBagConstraints.BOTH;
        add(panelMano, gridBagConstraintsPanelMano);
    }

    private void configurarPanelLateralMano1(){
        
        GridBagConstraints gridBagConstraintsPanelLateralMano1 = new GridBagConstraints();
        
        gridBagConstraintsPanelLateralMano1.gridx = 1;
        gridBagConstraintsPanelLateralMano1.gridy = 1;
        gridBagConstraintsPanelLateralMano1.weightx = 0.1;
        gridBagConstraintsPanelLateralMano1.weighty = 1;
        gridBagConstraintsPanelLateralMano1.gridwidth = 1;
        gridBagConstraintsPanelLateralMano1.gridheight = 1;
        gridBagConstraintsPanelLateralMano1.fill = GridBagConstraints.BOTH;
        
        panelLateralMano1.setBackground(Color.red);
        add(panelLateralMano1, gridBagConstraintsPanelLateralMano1);
    }
    
    private void configurarPanelLateralMano2(){
        
        GridBagConstraints gridBagConstraintsPanelLateralMano2 = new GridBagConstraints();
        
        gridBagConstraintsPanelLateralMano2.gridx = 5;
        gridBagConstraintsPanelLateralMano2.gridy = 1;
        gridBagConstraintsPanelLateralMano2.weightx = 0.1;
        gridBagConstraintsPanelLateralMano2.weighty = 1;
        gridBagConstraintsPanelLateralMano2.gridwidth = 1;
        gridBagConstraintsPanelLateralMano2.gridheight = 1;
        gridBagConstraintsPanelLateralMano2.fill = GridBagConstraints.BOTH;
       
        panelLateralMano2.setBackground(Color.green);
        add(panelLateralMano2, gridBagConstraintsPanelLateralMano2);
    }
    
    private void configurarPanelSuperiorLateralMano1(){
        
        GridBagConstraints gridBagConstraintsPanelSuperiorLateralMano1 = new GridBagConstraints();
        
        gridBagConstraintsPanelSuperiorLateralMano1.gridx = 1;
        gridBagConstraintsPanelSuperiorLateralMano1.gridy = 0;
        gridBagConstraintsPanelSuperiorLateralMano1.weightx = 0.1;
        gridBagConstraintsPanelSuperiorLateralMano1.weighty = 1;
        gridBagConstraintsPanelSuperiorLateralMano1.gridwidth = 1;
        gridBagConstraintsPanelSuperiorLateralMano1.gridheight = 1;
        gridBagConstraintsPanelSuperiorLateralMano1.fill = GridBagConstraints.BOTH;
        
        add(panelSuperiorLateralMano1, gridBagConstraintsPanelSuperiorLateralMano1);
        
    }
    
    private void configurarPanelSuperiorLateralMano2(){
        
        GridBagConstraints gridBagConstraintsPanelSuperiorLateralMano2 = new GridBagConstraints();
        
        gridBagConstraintsPanelSuperiorLateralMano2.gridx = 5;
        gridBagConstraintsPanelSuperiorLateralMano2.gridy = 0;
        gridBagConstraintsPanelSuperiorLateralMano2.weightx = 0.1;
        gridBagConstraintsPanelSuperiorLateralMano2.weighty = 1;
        gridBagConstraintsPanelSuperiorLateralMano2.gridwidth = 1;
        gridBagConstraintsPanelSuperiorLateralMano2.gridheight = 1;
        gridBagConstraintsPanelSuperiorLateralMano2.fill = GridBagConstraints.BOTH;
        
        add(panelSuperiorLateralMano2, gridBagConstraintsPanelSuperiorLateralMano2);
        
    }
    
    private void configurarPanelEsquina1(){
        
        GridBagConstraints gridBagConstraintsPanelEsquina1 = new GridBagConstraints();
        
        gridBagConstraintsPanelEsquina1.gridx = 0;
        gridBagConstraintsPanelEsquina1.gridy = 0;
        gridBagConstraintsPanelEsquina1.weightx = 1;
        gridBagConstraintsPanelEsquina1.weighty = 1;
        gridBagConstraintsPanelEsquina1.gridwidth = 1;
        gridBagConstraintsPanelEsquina1.gridheight = 2;
        gridBagConstraintsPanelEsquina1.fill = GridBagConstraints.BOTH;
        
        panelEsquina1.setBackground(Color.black);
        add(panelEsquina1, gridBagConstraintsPanelEsquina1);
        
    }
    
    private void configurarPanelEsquina2(){
        
        GridBagConstraints gridBagConstraintsPanelEsquina2 = new GridBagConstraints();
        
        gridBagConstraintsPanelEsquina2.gridx = 6;
        gridBagConstraintsPanelEsquina2.gridy = 0;
        gridBagConstraintsPanelEsquina2.weightx = 1;
        gridBagConstraintsPanelEsquina2.weighty = 1;
        gridBagConstraintsPanelEsquina2.gridwidth = 1;
        gridBagConstraintsPanelEsquina2.gridheight = 2;
        gridBagConstraintsPanelEsquina2.fill = GridBagConstraints.BOTH;
        
        panelEsquina2.setBackground(Color.black);
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
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void pintar(IEstadoJugadorExterno estadoJugadorExterno) {
        System.out.println("Pintando PanelJugadorPrincipal");
    }

    @Override
    public PosicionPanel getPosicion() {
        return POSICION_PANEL;
    }
    
    @Override
    public Dimension getPreferredSize() {
        
        return new Dimension(700, 120);
    }
    
}
