package interfaces;

import entidades.Jugador;
import entidades.Monton;


public interface ITablero {
    public abstract boolean agregarFichasTablero(int [] idFichas);
    public abstract boolean agregarFichasTablero(int [] idFichas, int numeroGrupo);
    public abstract boolean quitarFichasJugador(int []  idFichas);
    public abstract boolean quitarFichasTablero(int [] idFichas);
    public abstract boolean seleccionarFichasTablero(int [] idFichas);
    public abstract boolean terminarTurno();
    public abstract Jugador obtenerJugadorPrincipal();
    public abstract Jugador obtenerJugadoresExternos();
    public abstract Monton obtenerMonton();
}
