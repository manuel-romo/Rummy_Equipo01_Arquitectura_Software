
package ejercerTurno;

import javax.swing.JPanel;


public interface IReceptorEventos {
    
    public abstract void quitarFichasTablero(int[] idsCasillas, int[] idsFichas);
    
    public abstract void quitarFichasJugador(int[] idsCasillas, int[] posicionesFichas);
    
    public abstract void agregarFichasTablero(int[] idsCasillas, int[] idsFichas);
    
    public abstract void agregarFichasTablero(int[] idsCasillas, int[] idsFichas, int[] idsFichasGrupo);
    
}
