
package objetosPresentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author romom
 */
public class PanelTablero extends JPanel implements IComponente{

    private Color COLOR_FONDO = new Color(60, 130, 72);
    private PanelCasilla[] panelesCasillas;
    private int CANTIDAD_FILAS_CASILLAS = 20;
    private int CANTIDAD_COLUMNAS_CASILLAS = 50;
    private int ESPACION_VERTICAL_CASILLAS = 6;
    private int ESPACION_HORIZONTAL_CASILLAS = 6;
    
    private PosicionPanel POSICION_PANEL = PosicionPanel.CENTRO;
    private Dimension tamanio = new Dimension(1650,1600);
    
    public PanelTablero(PanelCasilla[] panelesCasillas){
        
        this.panelesCasillas = panelesCasillas;
        
        setBackground(COLOR_FONDO);
        setPreferredSize(tamanio);
        
        setLayout(new GridLayout(
                CANTIDAD_FILAS_CASILLAS, 
                CANTIDAD_COLUMNAS_CASILLAS, 
                ESPACION_HORIZONTAL_CASILLAS, 
                ESPACION_VERTICAL_CASILLAS));
        
        configurarPanelesCasillas();
    }
    
    private void configurarPanelesCasillas(){
        
        for(PanelCasilla panelCasilla: panelesCasillas){
            
            add(panelCasilla);
            
        }
        
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
