
package objetosPresentacion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    
    private Color COLOR_FONDO = new Color(207, 196, 136);
    
    private String TITULO_MENSAJE_MOVIMIENTO_INVALIDO = "Movimiento inválido";
    private String TITULO_MENSAJE_TABLERO_INVALIDO = "Tablero inválido";
    
    public PanelMesaJuego(){
        
        setBackground(COLOR_FONDO);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        
    }
    
    private void aniadirComponente(IComponente componente){
 
        JPanel panel = (JPanel)componente;
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
         
        if(componente.getPosicion().equals(PosicionPanel.CENTRO_ARRIBA)){
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.weightx = 1;
            gridBagConstraints.weighty = 1;
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.fill = GridBagConstraints.BOTH;

            add(panel, gridBagConstraints);

        } 
        else if(componente.getPosicion().equals(PosicionPanel.IZQUIERDA_CENTRO)){
        
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.weightx = 1;
            gridBagConstraints.weighty = 6;
            gridBagConstraints.gridwidth = 1;
            gridBagConstraints.fill = GridBagConstraints.BOTH;

            add(panel, gridBagConstraints);
        }  

        else if(componente.getPosicion().equals(PosicionPanel.DERECHA_CENTRO)){
        
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.weightx = 1;
            gridBagConstraints.weighty = 6;
            gridBagConstraints.gridwidth = 1;
            gridBagConstraints.fill = GridBagConstraints.BOTH;

            add(panel, gridBagConstraints);
        }
        else if(componente.getPosicion().equals(PosicionPanel.CENTRO)){
            
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.weightx = 9;
            gridBagConstraints.weighty = 6;
            gridBagConstraints.gridwidth = 1;
            gridBagConstraints.fill = GridBagConstraints.BOTH;

            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            
            add(scrollPane, gridBagConstraints);
        }
        else if(componente.getPosicion().equals(PosicionPanel.ABAJO_CENTRO)){
            
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.weightx = 1;
            gridBagConstraints.weighty = 1.5;
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.fill = GridBagConstraints.BOTH;

            add(panel, gridBagConstraints);
            
        } else if(componente.getPosicion().equals(PosicionPanel.IZQUIERDA_ABAJO)){
            
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.weightx = 1;
            gridBagConstraints.weighty = 1;
            gridBagConstraints.gridwidth = 1;
            gridBagConstraints.fill = GridBagConstraints.BOTH;

            add(panel, gridBagConstraints);
        }
    }
    
    private void mostrarMensajeMovimientoInvalido(String mensajeMovimientoInvalido){
        
        if(mensajeMovimientoInvalido != null){
            JOptionPane.showMessageDialog(
                this, 
                mensajeMovimientoInvalido, 
                TITULO_MENSAJE_MOVIMIENTO_INVALIDO, 
                JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    private void mostrarMensajeTableroInvalido(String mensajeTableroInvalido){
        
        if(mensajeTableroInvalido != null){
            JOptionPane.showMessageDialog(
                this, 
                mensajeTableroInvalido, 
                TITULO_MENSAJE_TABLERO_INVALIDO, 
                JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    @Override
    public void agregarComponente(IComponente componente) {
        componentes.add(componente);
        aniadirComponente(componente);
        
    }

    @Override
    public void removerComponente(IComponente componente) {
        componentes.remove(componente);
    }

    @Override
    public void aceptar(IVisitor visitor) {
        visitor.visitar(this);
        
        for(IComponente componente: componentes){
            componente.aceptar(visitor);
        }
        
    }

    public void pintar(IEstadoMesaJuego estadoMesaJuego) {
        
        String mensajeMovimientoInvalido = estadoMesaJuego.getMensajeMovimientoInvalido();
        String mensajeTableroInvalido = estadoMesaJuego.getMensajeTableroInvalido();
        
        mostrarMensajeMovimientoInvalido(mensajeMovimientoInvalido);
        mostrarMensajeTableroInvalido(mensajeTableroInvalido);
        repaint();
    }

    @Override
    public PosicionPanel getPosicion() {
        return POSICION_PANEL;
    }
    
}
