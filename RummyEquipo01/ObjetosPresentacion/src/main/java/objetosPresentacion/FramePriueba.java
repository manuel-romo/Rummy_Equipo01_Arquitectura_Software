
package objetosPresentacion;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author romom
 */
public class FramePriueba extends JFrame{

    public static void main(String[] args){
        FramePriueba f = new FramePriueba();
    }
    
    public FramePriueba() throws HeadlessException {
        
        PanelJugadorExterno panelJugadorExterno = new PanelJugadorExterno();
        PanelRotador panelRotador = new PanelRotador(panelJugadorExterno, ABORT);
        setSize(1000,1000);
        setVisible(true);
        
        
    }
    
    
}
