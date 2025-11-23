package objetos_negocio;

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
import dto.MontonDTO;
import dto.TableroDTO;
import enumeradores.ColorFicha;
import enumeradores.ColorFichaDTO;
import excepciones.RummyException;
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

    private void seleccionarFichasTablero(int[] idsFichas, String nombreJugador) {

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
        try {
            List<Ficha> fichasObtenidas = new LinkedList<>();
            for (int id : idsFichas) {
                Ficha ficha = encontrarFichaPorId(id);
                fichasObtenidas.add(ficha);
            }

            if (!esPrimerTurnoJugador(nombreJugador)) {
                Grupo grupo = verificarTipoGrupo(fichasObtenidas,nombreJugador );
                grupo.agregarFichas(fichasObtenidas);
                grupos.add(grupo);
            } else {
                if (validarPrimerTurno(fichasObtenidas)) {
                    Grupo grupo = verificarTipoGrupo(fichasObtenidas, nombreJugador);
                    grupo.agregarFichas(fichasObtenidas);
                    grupos.add(grupo);
                }
            }
        } catch (RummyException ex){
            ICommand comandoTableroInvalido = new ComandoTableroInvalido(nombreJugador);
            fachadaTablero.enviarComando(comandoTableroInvalido);
        }

    }

    private void agregarFichasTableroGrupo(int[] idsFichas, int[] idsFichasGrupo, String nombreJugador) {
       
    }

    private void quitarFichasJugador(int[] idsFichas, String nombreJugador) {

        List<Ficha> fichasQuitar = new LinkedList<>();

        for (int idFicha : idsFichas) {

            fichasQuitar.add(encontrarFichaPorId(idFicha));

        }

        jugadorTurno.quitarFichas(fichasQuitar);

    }

    private void quitarFichasTablero(int[] idsFichas, String nombreJugador) {
        List<Ficha> fichasQuitar = new LinkedList<>();
        for (int idFicha : idsFichas) {

            fichasQuitar.add(encontrarFichaPorId(idFicha));
        }
        for(Grupo grupo : grupos){
            for(Ficha ficha : grupo.getFichas()){
                for(Ficha fichaQuitar : fichasQuitar){
                    if(fichaQuitar.getId().equals(grupo.getFichas().getFirst().getId()) || fichaQuitar.getId().equals(grupo.getFichas().getLast().getId())){
                        if(fichaQuitar.getId().equals(ficha.getId())){
                            grupo.getFichas().remove(ficha);
                        }
                    }else{
                        ICommand comando = new ComandoTableroInvalido(nombreJugador);
                        fachadaTablero.ejecutar(comando);
                    }
                }
            }
        }
    }

    private void terminarTurno(String nombreJugador) {
        if (validarTablero()) {
            ICommand comandoTerminarTurno = new ComandoTerminarTurno(nombreJugador);

            fachadaTablero.enviarComando(comandoTerminarTurno);

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

        List<GrupoDTO> listaGruposDto = new LinkedList<>();

        for (Grupo grupo : grupos) {

            listaGruposDto.add(obtenerGrupoDto(grupo));

        }

        MontonDTO montonDto = obtenerMontoDTO(monton);

        return new TableroDTO(listaGruposDto, listaFichasJugadorDto, montonDto);

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

    public Grupo verificarTipoGrupo(List<Ficha> fichas, String nombreJugador) {
        if(esPrimerTurnoJugador(nombreJugador)){
            if(!validarPrimerTurno(fichas)){
                ICommand comando = new ComandoTableroInvalido(nombreJugador);
            }
        }
        ColorFicha colorFicha = fichas.getFirst().getColor();
        for (Ficha ficha : fichas) {
            if (ficha.getColor() != colorFicha) {
                return new GrupoSecuencia(fichas);
            }
        }
        return new GrupoColores(fichas);
    }

    public boolean validarPrimerTurno(List<Ficha> fichas) {
        int suma = 0;

        for (Ficha ficha : fichas) {
            if (ficha instanceof FichaNormal) {
                suma += ((FichaNormal) ficha).getNumero();
            }
        }
        return suma >= 30;
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
