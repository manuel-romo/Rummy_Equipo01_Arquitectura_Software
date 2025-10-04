
package objetosPresentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */
public class PanelMesaJuego extends JPanel implements IComponente{

    private List<IComponente> componentes = new LinkedList<>();
    
    private Color COLOR_FONDO = new Color(232, 217, 172);
    
    private GridBagConstraints gridBagConstraintsPanelFila1 = new GridBagConstraints();
    private GridBagConstraints gridBagConstraintsPanelFila2 = new GridBagConstraints();
    private GridBagConstraints gridBagConstraintsPanelFila3 = new GridBagConstraints();
    private GridBagConstraints gridBagConstraintsPanelFila4 = new GridBagConstraints();
    private GridBagConstraints gridBagConstraintsPanelFila5 = new GridBagConstraints();
    
    private JPanel panelFila1 = new JPanel();
    private JPanel panelFila2 = new JPanel();
    private JPanel panelFila3 = new JPanel();
    private JPanel panelFila4 = new JPanel();
    private JPanel panelFila5 = new JPanel(); 
    
    public PanelMesaJuego(){
        
        setBackground(COLOR_FONDO);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        
        panelFila1.setBackground(Color.red);
        panelFila2.setBackground(Color.green);
        panelFila3.setBackground(Color.blue);
        panelFila4.setBackground(Color.gray);
        panelFila5.setBackground(Color.black);
        
        gridBagConstraintsPanelFila1.gridx = 0;
        gridBagConstraintsPanelFila1.gridy = 0;
        gridBagConstraintsPanelFila1.weightx = 1;
        gridBagConstraintsPanelFila1.weighty = 1;
        gridBagConstraintsPanelFila1.gridwidth = 3;
        gridBagConstraintsPanelFila1.fill = GridBagConstraints.BOTH;
        
        gridBagConstraintsPanelFila2.gridx = 1;
        gridBagConstraintsPanelFila2.gridy = 1;
        gridBagConstraintsPanelFila2.weightx = 9;
        gridBagConstraintsPanelFila2.weighty = 6;
        gridBagConstraintsPanelFila2.gridwidth = 1;
        gridBagConstraintsPanelFila2.fill = GridBagConstraints.BOTH;
        
        gridBagConstraintsPanelFila3.gridx = 0;
        gridBagConstraintsPanelFila3.gridy = 2;
        gridBagConstraintsPanelFila3.weightx = 1;
        gridBagConstraintsPanelFila3.weighty = 2;
        gridBagConstraintsPanelFila3.gridwidth = 3;
        gridBagConstraintsPanelFila3.fill = GridBagConstraints.BOTH;
        
        gridBagConstraintsPanelFila4.gridx = 0;
        gridBagConstraintsPanelFila4.gridy = 1;
        gridBagConstraintsPanelFila4.weightx = 1;
        gridBagConstraintsPanelFila4.weighty = 6;
        gridBagConstraintsPanelFila4.gridwidth = 1;
        gridBagConstraintsPanelFila4.fill = GridBagConstraints.BOTH;
        
        gridBagConstraintsPanelFila5.gridx = 2;
        gridBagConstraintsPanelFila5.gridy = 1;
        gridBagConstraintsPanelFila5.weightx = 1;
        gridBagConstraintsPanelFila5.weighty = 6;
        gridBagConstraintsPanelFila5.gridwidth = 1;
        gridBagConstraintsPanelFila5.fill = GridBagConstraints.BOTH;
        
        
        add(panelFila1, gridBagConstraintsPanelFila1);
        add(panelFila2, gridBagConstraintsPanelFila2);
        add(panelFila3, gridBagConstraintsPanelFila3);
        add(panelFila4, gridBagConstraintsPanelFila4);
        add(panelFila5, gridBagConstraintsPanelFila5);
 
        
    }
    
    @Override
    public void agregarComponente(IComponente componente) {
        componentes.add(componente);
    }

    @Override
    public void removerComponente(IComponente componente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aceptar(IVisitor visitor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void pintar() {
        System.out.println("Pintando PanelMesaJuego");
    }

    @Override
    public boolean tienePosicion() {
        return false;
    }
    
    
}
