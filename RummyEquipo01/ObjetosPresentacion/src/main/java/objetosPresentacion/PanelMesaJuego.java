
package objetosPresentacion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import objetosPresentacion.IComponente;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */
public class PanelMesaJuego extends JPanel implements IComponente{

    private PosicionPanel POSICION_PANEL = PosicionPanel.SIN_POSICION;
    
    private List<IComponente> componentes = new LinkedList<>();
    
    private Color COLOR_FONDO = new Color(232, 217, 172);
    
    int componentesConPosicion = 0;
    
    public PanelMesaJuego(){
        
        setBackground(COLOR_FONDO);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        
    }
    
    private void aniadirComponente(IComponente componente){
 
        JPanel panel = (JPanel)componente;
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        PanelRotador panelRotado;
         
        if(componente.getPosicion().equals(PosicionPanel.EXTREMO) && componentesConPosicion < 3){
            
            switch (componentesConPosicion) {

                case 0:
                    gridBagConstraints.gridx = 0;
                    gridBagConstraints.gridy = 0;
                    gridBagConstraints.weightx = 1;
                    gridBagConstraints.weighty = 1;
                    gridBagConstraints.gridwidth = 3;
                    gridBagConstraints.fill = GridBagConstraints.BOTH;

                    
                    add(panel, gridBagConstraints);

                    break;

                case 1:
                    gridBagConstraints.gridx = 0;
                    gridBagConstraints.gridy = 1;
                    gridBagConstraints.weightx = 1;
                    gridBagConstraints.weighty = 6;
                    gridBagConstraints.gridwidth = 1;
                    gridBagConstraints.fill = GridBagConstraints.BOTH;

                    panelRotado = new PanelRotador(panel, -90);
                    add(panelRotado, gridBagConstraints);

                    break;

                case 2:

                    gridBagConstraints.gridx = 2;
                    gridBagConstraints.gridy = 1;
                    gridBagConstraints.weightx = 1;
                    gridBagConstraints.weighty = 6;
                    gridBagConstraints.gridwidth = 1;
                    gridBagConstraints.fill = GridBagConstraints.BOTH;

                    panelRotado = new PanelRotador(panel, 90);
                    add(panelRotado, gridBagConstraints);

                    break;

                default:

            }

            componentesConPosicion++;

        }
        else if(componente.getPosicion().equals(PosicionPanel.CETRO)){
            
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.weightx = 9;
            gridBagConstraints.weighty = 6;
            gridBagConstraints.gridwidth = 1;
            gridBagConstraints.fill = GridBagConstraints.BOTH;

            add(panel, gridBagConstraints);
        }
        else if(componente.getPosicion().equals(PosicionPanel.ABAJO_CENTRO)){
            
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.weightx = 1;
            gridBagConstraints.weighty = 2;
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.fill = GridBagConstraints.BOTH;

            add(panel, gridBagConstraints);
            
        } else if(componente.getPosicion().equals(PosicionPanel.IZQUIERDA_ABAJO)){
            
//            gridBagConstraints.gridx = 0;
//            gridBagConstraints.gridy = 2;
//            gridBagConstraints.weightx = 1;
//            gridBagConstraints.weighty = 2;
//            gridBagConstraints.gridwidth = 3;
//            gridBagConstraints.fill = GridBagConstraints.BOTH;
//
//            add(panel, gridBagConstraints);
        }
    }
    
    @Override
    public void agregarComponente(IComponente componente) {
        componentes.add(componente);
        aniadirComponente(componente);
        
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
    public PosicionPanel getPosicion() {
        return POSICION_PANEL;
    }
    
}
