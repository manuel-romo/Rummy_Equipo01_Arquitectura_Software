package interfaces;

import dto.JugadorNegocioDTO;
import dto.MontonNegocioDTO;
import entidades.Jugador;
import entidades.Monton;


public interface ITablero {
    public abstract boolean agregarFichasTablero(int [] idFichas);
    public abstract boolean agregarFichasTablero(int [] idFichas, int numeroGrupo);
    public abstract boolean quitarFichasJugador(int []  idFichas);
    public abstract boolean quitarFichasTablero(int [] idFichas);
    public abstract boolean seleccionarFichasTablero(int [] idFichas);
    public abstract boolean terminarTurno();
    public abstract JugadorNegocioDTO obtenerJugadorPrincipal();
    public abstract JugadorNegocioDTO obtenerJugadoresExternos();
    public abstract MontonNegocioDTO obtenerMonton();
}
