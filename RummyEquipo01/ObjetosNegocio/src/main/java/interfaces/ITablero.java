package interfaces;


public interface ITablero {
    public abstract boolean agregarFichasTablero(int [] idFichas);
    public abstract boolean agregarFichasTablero(int [] idsFicha, Integer numeroGrupo);
    public abstract boolean quitarFichasJugador(int [] posiciones);
    public abstract boolean quitarFichasTablero(int [] idFichas);
    public abstract boolean seleccionarFichasTablero(int [] idFichas);
}
