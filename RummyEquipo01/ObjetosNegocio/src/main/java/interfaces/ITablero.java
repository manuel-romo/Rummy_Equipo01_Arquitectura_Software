package interfaces;

import dto.GrupoNegocioDTO;
import dto.JugadorNegocioDTO;
import dto.MontonNegocioDTO;
import dto.TableroNegocioDTO;

public interface ITablero {
    public abstract boolean agregarFichasTablero(int [] idFichas);
    public abstract boolean agregarFichasTablero(int [] idFichas, int numeroGrupo);
    public abstract boolean quitarFichasJugador(int []  idFichas);
    public abstract boolean quitarFichasTablero(int [] idFichas);
    public abstract boolean seleccionarFichasTablero(int [] idFichas);
    public abstract void iniciarTurno(TableroNegocioDTO tableroNegocio);
    public abstract boolean validarGrupos();
    public abstract JugadorNegocioDTO obtenerJugadorPrincipal();
    public abstract JugadorNegocioDTO[] obtenerJugadoresExternos();
    public abstract GrupoNegocioDTO[] obtenerGruposNegocio();
    public abstract MontonNegocioDTO obtenerMonton();
}
