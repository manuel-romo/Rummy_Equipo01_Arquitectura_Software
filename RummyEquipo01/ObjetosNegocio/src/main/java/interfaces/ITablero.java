package interfaces;

import dto.GrupoNegocioDTO;
import dto.JugadorNegocioDTO;
import dto.MontonNegocioDTO;
import dto.TableroNegocioDTO;

public interface ITablero {
    public abstract boolean agregarFichasTablero(Integer [] idFichas);
    public abstract boolean agregarFichasTablero(Integer [] idFichas, int[] numerosGrupo);
    public abstract boolean quitarFichasJugador(Integer []  idFichas);
    public abstract boolean quitarFichasTablero(Integer [] idFichas);
    public abstract boolean seleccionarFichasTablero(Integer [] idFichas);
    public abstract void iniciarTurno(TableroNegocioDTO tableroNegocio);
    public abstract boolean validarGrupos();
    public abstract JugadorNegocioDTO obtenerJugadorPrincipal();
    public abstract JugadorNegocioDTO[] obtenerJugadoresExternos();
    public abstract GrupoNegocioDTO[] obtenerGruposNegocio();
    public abstract MontonNegocioDTO obtenerMonton();
}
