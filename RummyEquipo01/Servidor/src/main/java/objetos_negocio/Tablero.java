package objetos_negocio;

import comandosRespuesta.ComandoCambioTurno;
import comandosRespuesta.ComandoIniciarTurno;
import comandosRespuesta.ComandoRespuestaMovimiento;
import comandosRespuesta.ComandoTableroInvalido;
import comandosSolicitud.ComandoAgregarFichasTablero;
import comandosSolicitud.ComandoAgregarFichasTableroGrupo;
import comandosSolicitud.ComandoQuitarFichasJugador;
import comandosSolicitud.ComandoQuitarFichasTablero;
import comandosSolicitud.ComandoSeleccionarFichasTablero;
import comandosSolicitud.ComandoTerminarTurno;
import comandosSolicitud.CommandType;
import dto.FichaComodinDTO;
import dto.FichaDTO;
import dto.FichaNormalDTO;
import dto.GrupoDTO;
import dto.JugadorDTO;
import dto.MontonDTO;
import dto.TableroDTO;
import enumeradores.ColorFicha;
import enumeradores.ColorFichaDTO;
import excepciones.RummyException;
import fabricaGrupos.FabricaGrupos;
import interfaces.ICommand;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase de Negocio para el servidor el cual valida todo el tablero cuando se
 * termina el turno.
 *
 * @author Juan Heras
 */
public class Tablero {

    private Jugador jugadorTurno;
    private List<Jugador> jugadores;
    private List<Ficha> fichas;
    private List<Grupo> grupos;
    private Monton monton;
    private FachadaTablero fachadaTablero;
    
    private static int numeroGrupoActual = 0;

    public void ejecutar(ICommand comando) throws RummyException {

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

                agregarFichasTableroGrupos(
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

    private void seleccionarFichasTablero(Integer[] idsFichas, String nombreJugador) {

        boolean esPrimerTurnoJugador = esPrimerTurnoJugador(nombreJugador);

        if (esPrimerTurnoJugador) {

            for (int idFicha : idsFichas) {

                Ficha ficha = encontrarFichaPorId(idFicha);

                if (ficha != null && ficha.isTieneGrupo()) {

                    ICommand comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(obtenerTableroDto(), false, nombreJugador);

                    fachadaTablero.enviarComando(comandoRespuestaMovimiento);

                }

            }

        } else {

            ICommand comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(obtenerTableroDto(), false, nombreJugador);

            fachadaTablero.enviarComando(comandoRespuestaMovimiento);

        }

    }

    private void agregarFichasTablero(int[] idsFichas, String nombreJugador) {

        List<Ficha> fichasAgregar = new LinkedList<>();
        for (int id : idsFichas) {
            Ficha ficha = encontrarFichaPorId(id);
            fichasAgregar.add(ficha);
        }

        if (!esPrimerTurnoJugador(nombreJugador)) {

            Grupo grupo = FabricaGrupos.crearGrupo(++numeroGrupoActual, fichasAgregar);
            grupos.add(grupo);

        } else {

            // Revisar si no se hace nada
        }

    }

    private void agregarFichasTableroGrupos(Integer[] idsFichas, Integer[] idsFichasGrupo, String nombreJugador) {
       
        List<Ficha> fichasAgregar = new LinkedList<>();
        for (int id : idsFichas) {
            Ficha ficha = encontrarFichaPorId(id);
            fichasAgregar.add(ficha);
        }
        
        if(idsFichasGrupo.length > 0 && idsFichasGrupo.length <= 2){
            
            Grupo primerGrupoAgregar = null;
            if(idsFichasGrupo[0] != null){
                primerGrupoAgregar = encontrarFichaPorId(idsFichasGrupo[0]).getGrupo();
            }
            
            Grupo segundoGrupoAgregar = null;
            if(idsFichasGrupo[1] != null){
                segundoGrupoAgregar = encontrarFichaPorId(idsFichasGrupo[1]).getGrupo();
            }
            
            try {

                if (primerGrupoAgregar != null && segundoGrupoAgregar != null) {

                    // Se crea una lista con la combinación de todas las fichas.
                    List<Ficha> fusion = new LinkedList<>();
                    fusion.addAll(primerGrupoAgregar.getFichas());
                    fusion.addAll(fichasAgregar);
                    fusion.addAll(segundoGrupoAgregar.getFichas());

                    Grupo nuevoGrupoUnificado = FabricaGrupos.crearGrupo(++numeroGrupoActual, fusion);

                    // Si el nuevo grupo es válido, se eliminan los grupos anteriores.
                    this.grupos.remove(primerGrupoAgregar);
                    this.grupos.remove(segundoGrupoAgregar);

                    // Se agrega el nuevo grupo.
                    this.grupos.add(nuevoGrupoUnificado);

                } 
                // Agregar fichas sólo al primer grupo
                else if (primerGrupoAgregar != null) {
                    primerGrupoAgregar.agregarFichasFinal(fichasAgregar);
                } 
                // Agregar fichas sólo al segundo grupo
                else if (segundoGrupoAgregar != null) {
                    segundoGrupoAgregar.agregarFichasInicio(fichasAgregar);
                } 

                ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                        obtenerTableroDto(), 
                        true, 
                        nombreJugador);
                
                fachadaTablero.ejecutar(comandoRespuestaMovimiento);
                

            } catch (RummyException ex) {
                
                ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                        obtenerTableroDto(), 
                        false, 
                        nombreJugador, 
                        ex.getMessage());
                
                fachadaTablero.ejecutar(comandoRespuestaMovimiento);
            }
        }
    }

    private void quitarFichasJugador(Integer[] idsFichas, String nombreJugador) {

        List<Ficha> fichasQuitar = new LinkedList<>();

        for (int idFicha : idsFichas) {

            fichasQuitar.add(encontrarFichaPorId(idFicha));

        }

        jugadorTurno.quitarFichas(fichasQuitar);

    }

    private void quitarFichasTablero(int[] idsFichas, String nombreJugador) {
        
        List<Grupo> gruposFichasQuitar = new LinkedList<>();
        
        for (int idFicha : idsFichas) {

            Ficha fichaQuitar = encontrarFichaPorId(idFicha);
            
            gruposFichasQuitar.add(fichaQuitar.getGrupo());
            
            Grupo grupoFichaQuitar = fichaQuitar.getGrupo();
            
            grupoFichaQuitar.quitarFicha(fichaQuitar);
            
        }

    }

    private void terminarTurno(String nombreJugador) {
        
        if (validarTablero()) {
            
            for(Jugador jugador: jugadores){
                
                if(jugador.getNombre().equals(jugadorTurno.getNombre())){
                    
                    jugadorTurno = jugador;
                    
                }
                
            }
            
            for(Jugador jugador: jugadores){
                
                if(jugador.getNombre() != jugadorTurno.getNombre()){
                    
                    ComandoCambioTurno comandoCambioTurno = new ComandoCambioTurno(obtenerTableroDto(), jugador.getNombre());
                    
                    fachadaTablero.ejecutar(comandoCambioTurno);
                    
                } else{
                    
                    ComandoIniciarTurno comandoIniciarTurno = new ComandoIniciarTurno(obtenerTableroDto(), nombreJugador);

                    fachadaTablero.enviarComando(comandoIniciarTurno);
                    
                }
                
                
            }

        } else {
            
            ICommand comandoTableroInvalido = new ComandoTableroInvalido(nombreJugador);

            fachadaTablero.enviarComando(comandoTableroInvalido);
        }

    }

    private boolean esPrimerTurnoJugador(String nombreJugador) {

        String nombreJugadorTurno = jugadorTurno.getNombre();

        return jugadorTurno.isPrimerTurno();

    }

    private TableroDTO obtenerTableroDto() {

        List<FichaDTO> listaFichasJugadorDto = new LinkedList<>();

        for (Ficha ficha : jugadorTurno.getFichas()) {

            listaFichasJugadorDto.add(obtenerFichaDto(ficha));

        }
        
        JugadorDTO jugadorDto = new JugadorDTO(listaFichasJugadorDto, jugadorTurno.getAvatar(), jugadorTurno.getNombre());
        
        List<JugadorDTO> jugadoresNoTurnoDtp = new LinkedList<>();
        
        for(Jugador jugador: jugadores){
            
            if(!jugador.getNombre().equals(jugadorTurno.getNombre())){
                
                List<FichaDTO> listaFichasJugadorNoTurnoDto = new LinkedList<>();

                for (Ficha ficha : jugador.getFichas()) {

                    listaFichasJugadorNoTurnoDto.add(obtenerFichaDto(ficha));

                }
                
                JugadorDTO jugadorNoTurnoDTO = new JugadorDTO(listaFichasJugadorNoTurnoDto, jugador.getAvatar(), jugador.getNombre());
                
                jugadoresNoTurnoDtp.add(jugadorNoTurnoDTO);
                
            }
            
        }
        

        List<GrupoDTO> gruposDTO = new LinkedList<>();

        for (Grupo grupo : grupos) {

            gruposDTO.add(obtenerGrupoDto(grupo));

        }

        MontonDTO montonDto = obtenerMontoDTO(monton);

        return new TableroDTO(
                gruposDTO.toArray(new GrupoDTO[0]), 
                montonDto, 
                jugadorDto, 
                jugadoresNoTurnoDtp.toArray(new JugadorDTO[0]));

    }

    private GrupoDTO obtenerGrupoDto(Grupo grupo) {

        List<FichaDTO> listaFichasDto = new LinkedList<>();

        for (Ficha ficha : grupo.getFichas()) {

            listaFichasDto.add(obtenerFichaDto(ficha));

        }

        return new GrupoDTO(listaFichasDto);

    }

    private FichaDTO obtenerFichaDto(Ficha ficha) {

        ColorFichaDTO colorFichaDto = null;

        switch (ficha.getColor()) {

            case ColorFicha.COLOR_A:

                colorFichaDto = ColorFichaDTO.COLOR_A;

                break;

            case ColorFicha.COLOR_B:

                colorFichaDto = ColorFichaDTO.COLOR_B;

                break;

            case ColorFicha.COLOR_C:

                colorFichaDto = ColorFichaDTO.COLOR_C;

                break;

            case ColorFicha.COLOR_COMODIN:

                colorFichaDto = ColorFichaDTO.COLOR_COMODIN;

                break;

            default:
                throw new AssertionError();
        }

        if (ficha instanceof FichaComodin) {

            String valorComodin = ((FichaComodin) ficha).getValor();
            return new FichaComodinDTO(colorFichaDto, ficha.getId(), valorComodin);

        } else if (ficha instanceof FichaNormal) {

            int numeroFicha = ((FichaNormal) ficha).getNumero();
            return new FichaNormalDTO(colorFichaDto, ficha.getId(), numeroFicha);
            
        }

        return null;

    }

    private MontonDTO obtenerMontoDTO(Monton monton) {

        return new MontonDTO(monton.getCantidadFichas());

    }

    private Ficha encontrarFichaPorId(int idFicha) {

        for (Ficha ficha : fichas) {

            if (ficha.getId() == idFicha) {
                return ficha;
            }

        }

        return null;

    }

    public boolean validarTablero() {
        for (Grupo grupo : grupos) {
            if (!grupo.comprobarValidez()) {
                return false;
            }
        }
        return true;
    }
    
}
