
package objetos_negocio;

import comandosRespuesta.ComandoIniciarTurno;
import comandosRespuesta.ComandoRespuestaMovimiento;
import comandosSolicitud.ComandoAgregarFichasTablero;
import comandosSolicitud.ComandoAgregarFichasTableroGrupo;
import comandosSolicitud.ComandoQuitarFichasJugador;
import comandosSolicitud.ComandoQuitarFichasTablero;
import comandosSolicitud.ComandoSeleccionarFichasTablero;
import comandosSolicitud.ComandoTerminarTurno;
import comandosSolicitud.CommandType;
import dto.FichaDTO;
import dto.GrupoDTO;
import dto.TableroDTO;
import interfaces.ICommand;
import java.util.List;

/**
 * Clase de Negocio para el servidor el cual valida todo el tablero cuando se termina el turno.
 * @author Juan Heras
 */
public class Tablero {
    
    private Jugador jugadorTurno;
    private List<Jugador> jugadores;
    private TableroDTO tablero;
    private FachadaTablero fachadaTablero;
    
    public void ejecutar(ICommand comando){
        
        CommandType tipoComando = CommandType.fromNombre(comando.getType());
        
        switch (tipoComando) {
            
            case CommandType.SELECCIONAR_FICHAS_TABLERO:
                
                ComandoSeleccionarFichasTablero comandoSeleccionarFichasTablero = (ComandoSeleccionarFichasTablero) comando;
                
                seleccionarFichasTablero(
                        comandoSeleccionarFichasTablero.getIdsFichas(), 
                        comandoSeleccionarFichasTablero.getNombreJugador()
                );
                
                break;
                
            case CommandType.AGREGAR_FICHAS_TABLERO:
                
                ComandoAgregarFichasTablero comandoAgregarFichasTablero = (ComandoAgregarFichasTablero) comando;
                
                agregarFichasTablero(
                        comandoAgregarFichasTablero.getIdsFichas(), 
                        comandoAgregarFichasTablero.getNombreJugador()
                );
                
                break;
                
            case CommandType.AGREGAR_FICHAS_TABLERO_GRUPO:
                
                ComandoAgregarFichasTableroGrupo comandoAgregarFichasTableroGrupo = (ComandoAgregarFichasTableroGrupo) comando;
                
                agregarFichasTableroGrupo(
                        comandoAgregarFichasTableroGrupo.getIdsFichas(),
                        comandoAgregarFichasTableroGrupo.getIdsFichasGrupo(),
                        comandoAgregarFichasTableroGrupo.getNombreJugador());
                
                break;
                
            case CommandType.QUITAR_FICHAS_JUGADOR:
                
                ComandoQuitarFichasJugador comandoQuitarFichasJugador = (ComandoQuitarFichasJugador) comando;
                
                quitarFichasJugador(
                        comandoQuitarFichasJugador.getIdsFichas(), 
                        comandoQuitarFichasJugador.getNombreJugador());
                
                break;
                
            case CommandType.QUITAR_FICHAS_TABLERO:
                
                ComandoQuitarFichasTablero comandoQuitarFichasTablero = (ComandoQuitarFichasTablero) comando;
                
                quitarFichasTablero(
                        comandoQuitarFichasTablero.getIdsFichas(), 
                        comandoQuitarFichasTablero.getNombreJugador());
                
                break;
                
            case CommandType.TERMINAR_TURNO:
                
                
                ComandoTerminarTurno comandoTerminarTurno = (ComandoTerminarTurno) comando;
                
                terminarTurno(comandoTerminarTurno.getNombreJugador());
                
                break;
                
            default:
                throw new AssertionError();
        }
        
    }
    
    
    private void seleccionarFichasTablero(int[] idsFichas, String nombreJugador){
        
        boolean esPrimerTurnoJugador = esPrimerTurnoJugador(nombreJugador);
        
        if(esPrimerTurnoJugador){
            
            for(int idFicha: idsFichas){
                
                FichaDTO ficha = encontrarFichaPorId(idFicha);
                
                if(ficha != null && ficha.isTieneGrupo()){
                    
                    ICommand comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(tablero, false, nombreJugador);
                    
                    fachadaTablero.enviarComando(comandoRespuestaMovimiento);
                    
                }
                
            }
            
            
        } else{
            
            ICommand comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(tablero, false, nombreJugador);
            
            fachadaTablero.enviarComando(comandoRespuestaMovimiento);
            
        }
            
        
    }
    
    private void agregarFichasTablero(int[] idsFichas, String nombreJugador){
        
    }
    
    private void agregarFichasTableroGrupo(int[] idsFichas, int[] idsFichasGrupo, String nombreJugador){
        
    }
    
    private void quitarFichasJugador(int[] idsFichas, String nombreJugador){
        
    }
    
    private void quitarFichasTablero(int[] idsFichas, String nombreJugador){
        
    }
    
    private void terminarTurno(String nombreJugador){
        
    }
    
    private boolean esPrimerTurnoJugador(String nombreJugador){
        
        String nombreJugadorTurno = jugadorTurno.getNombre();
        

        return jugadorTurno.isPrimerTurno();
            
    }
    
    private FichaDTO encontrarFichaPorId(int idFicha){

        for(FichaDTO ficha: fichas){
            
            if(ficha.getId() == idFicha){
                return ficha;
            }
            
        }
        
        return null;
        
    }
    
    
    
    public boolean validarTablero(){
        for (Grupo grupo : grupos) {
            if(!grupo.comprobarValidez()){
                return false;
            }
        }
        return true;
    }
}
