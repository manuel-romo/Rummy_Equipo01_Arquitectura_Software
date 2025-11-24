

package ejercerTurno;

public class Controlador {

    private Modelo modelo;

    public Controlador(Modelo modelo){
        this.modelo = modelo;
    }
    
    public void seleccionarFichasTablero(Integer[] idsFichas) {
        modelo.seleccionarFichasTablero(idsFichas);
    }

    public void quitarFichasJugador(Integer[] posicionesFichas) {
        modelo.quitarFichasJugador(posicionesFichas);
    }

    public void quitarFichasTablero(Integer[] idsFichas) {
        modelo.quitarFichasTablero(idsFichas);
    }

    public void agregarFichasTablero(Integer[] idsFichas, Integer idsFichasGrupo[]) {
        modelo.agregarFichasTablero(idsFichas, idsFichasGrupo);
    }
    
    public void agregarFichasTablero(Integer[] idsFichas) {
        modelo.agregarFichasTablero(idsFichas);
    }
    
    public void terminarTurno(){
        modelo.terminarTurno(); 
    }
    
}