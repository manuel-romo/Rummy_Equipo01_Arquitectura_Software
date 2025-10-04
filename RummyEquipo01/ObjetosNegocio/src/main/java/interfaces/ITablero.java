package interfaces;


public interface ITablero {
    public abstract boolean agregarFichasTablero(Integer [] idFichas);
    public abstract boolean agregarFichasTablero(Integer [] idsFicha, Integer numeroGrupo);
    public abstract boolean quitarFichasJugador(Integer [] posiciones);
    public abstract boolean quitarFichasTablero(Integer [] idFichas);
    public abstract boolean seleccionarFichasTablero(Integer [] idFichas);
}
