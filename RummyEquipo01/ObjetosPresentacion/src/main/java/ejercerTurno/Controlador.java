

package ejercerTurno;

public class Controlador {

    private Modelo modelo;

    public Controlador(){
        modelo = new Modelo();
    }

    public void seleccionarFichasTablero(int[] idsFichas) {
        modelo.seleccionarFichasTablero(idsFichas);
    }

    public void quitarFichasJugador(int[] posicionesFichas) {
        modelo.quitarFichasJugador(posicionesFichas);
    }

    public void quitarFichasTablero(int[] idsFichas) {
        modelo.quitarFichasTablero(idsFichas);
    }

    public void agregarFichasTablero(int[] idsFichas, int numeroGrupo) {
        modelo.agregarFichasTablero(idsFichas, numeroGrupo);
    }
    
    public void agregarFichasTablero(int[] idsFichas) {
        modelo.agregarFichasTablero(idsFichas);
    }
    
    public void terminarTurno(){
        modelo.terminarTurno(); 
    }
    
}