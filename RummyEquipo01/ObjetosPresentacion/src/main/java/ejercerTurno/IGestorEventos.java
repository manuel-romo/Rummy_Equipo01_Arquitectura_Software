
package ejercerTurno;

import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import objetosPresentacion.IComponente;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */
public interface IGestorEventos {
    
    public abstract void seleccionarFicha(MouseEvent e);
    public abstract void fichaSoltada(MouseEvent e);
    public abstract void quitarFichaCasilla(JPanel fichaArrastrada);
    
}
