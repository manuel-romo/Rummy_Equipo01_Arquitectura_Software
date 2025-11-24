
package ejercerTurno;

import javax.swing.JPanel;


public interface IReceptorEventos {
    
    public abstract void quitarFichasTablero(Integer[] idsCasillas, Integer[] idsFichas);
    
    public abstract void quitarFichasJugador(Integer[] idsCasillas, Integer[] posicionesFichas);
    
    public abstract void agregarFichasTablero(Integer[] idsCasillas, Integer[] idsFichas);
    
    public abstract void agregarFichasTablero(Integer[] idsCasillas, Integer[] idsFichas, Integer[] idsFichasGrupo);
    
}
