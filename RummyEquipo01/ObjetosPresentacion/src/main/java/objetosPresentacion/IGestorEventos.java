
package objetosPresentacion;

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
    
    public abstract void seleccionarFicha(MouseEvent e, boolean seleccionada);
    public abstract void fichaSoltada(MouseEvent e);
    public abstract void quitarFichasCasillas();
    public abstract void iniciarArrastreFichas();
    public abstract void presionarFicha();
    public abstract void dejarPresionarFicha();
    public abstract void borrarFichasMovimiento();
    public abstract void arrastreFichaMovimiento(MouseEvent e);
    public abstract void soltarFichasMovimiento(MouseEvent e);
}
