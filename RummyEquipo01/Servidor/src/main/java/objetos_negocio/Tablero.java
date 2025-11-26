package objetos_negocio;

import comandosRespuesta.ComandoCambioTurno;
import comandosRespuesta.ComandoIniciarTurno;
import comandosRespuesta.ComandoRespuestaMovimiento;
import comandosRespuesta.ComandoTableroInvalido;
import comandosSolicitud.ComandoAgregarFichasJugador;
import comandosSolicitud.ComandoAgregarFichasTablero;
import comandosSolicitud.ComandoAgregarFichasTableroGrupo;
import comandosSolicitud.ComandoQuitarFichasJugador;
import comandosSolicitud.ComandoQuitarFichasTablero;
import comandosSolicitud.ComandoSeleccionarFichasTablero;
import comandosSolicitud.ComandoTerminarTurno;
import comandosSolicitud.ComandoTomarFicha;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de Negocio para el servidor el cual valida todo el tablero cuando se
 * termina el turno.
 *
 * @author Juan Heras
 */
public class Tablero {

    private Jugador jugadorTurno;
    private List<Jugador> jugadores = new LinkedList<>();
    private List<Ficha> fichas = new LinkedList<>();
    private List<Grupo> grupos = new LinkedList<>();
    private Monton monton;
    private FachadaTablero fachadaTablero;

    private List<Grupo> gruposInicialesTurno = new LinkedList<>();
    private Grupo grupoPrimerTurno;

    private boolean fichaTomada;

    private int numeroGrupoActual = 0;

    private final int MAXIMO_NUMERO_FICHA = 13;
    private final int NUMERO_COMODINES = 2;

    private final String MENSAJE_CAMBIO_TURNO = "Espere a que termine su turno.";
    private final String MENSAJE_INICIO_TURNO = "¡Ha iniciado su turno!";
    private final String MENSAJE_QUITAR_FICHA_GRUPO_PRIMER_TURNO = "No puede quitar fichas de otros grupos en su primer turno.";
    private final String MENSAJE_GRUPO_INVALIDO = "No se puede formar ese grupo.";
    private final String MENSAJE_AGREGAR_FICHA_GRUPO_PRIMER_TURNO = "No puede agregar fichas a otros grupos en su primer turno.";
    private final String MENSAJE_AGREGAR_FICHAS_TABLERO_JUGADOR = "No puede agregar fichas del tablero a su mano.";
    private final String MENSAJE_AGREGAR_FICHA_MAS_UN_GRUPO_PRIMER_TURNO = "No puede agregar más de un grupo en su primer turno.";

    public void iniciarJuego() {

        List<Ficha> fichasJugador1 = new LinkedList<>(List.of(
                new FichaNormal(1, ColorFicha.COLOR_C, false, 6),
                new FichaNormal(2, ColorFicha.COLOR_A, false, 11),
                new FichaNormal(3, ColorFicha.COLOR_D, false, 3),
                new FichaNormal(4, ColorFicha.COLOR_B, false, 11),
                new FichaNormal(5, ColorFicha.COLOR_A, false, 12),
                new FichaNormal(6, ColorFicha.COLOR_C, false, 1),
                new FichaNormal(7, ColorFicha.COLOR_B, false, 7),
                new FichaNormal(8, ColorFicha.COLOR_D, false, 4),
                new FichaNormal(9, ColorFicha.COLOR_C, false, 11),
                new FichaNormal(10, ColorFicha.COLOR_A, false, 5),
                new FichaNormal(11, ColorFicha.COLOR_D, false, 11),
                new FichaNormal(12, ColorFicha.COLOR_A, false, 8),
                new FichaNormal(13, ColorFicha.COLOR_D, false, 13),
                new FichaNormal(14, ColorFicha.COLOR_A, false, 6)
        ));

        List<Ficha> fichasJugador2 = new LinkedList<>(List.of(
                new FichaNormal(15, ColorFicha.COLOR_A, false, 10),
                new FichaNormal(16, ColorFicha.COLOR_A, false, 11),
                new FichaNormal(17, ColorFicha.COLOR_C, false, 10),
                new FichaNormal(18, ColorFicha.COLOR_A, false, 13),
                new FichaNormal(19, ColorFicha.COLOR_D, false, 9),
                new FichaNormal(20, ColorFicha.COLOR_D, false, 5),
                new FichaNormal(21, ColorFicha.COLOR_A, false, 12),
                new FichaNormal(22, ColorFicha.COLOR_D, false, 1),
                new FichaNormal(23, ColorFicha.COLOR_D, false, 11),
                new FichaNormal(24, ColorFicha.COLOR_B, false, 2),
                new FichaNormal(25, ColorFicha.COLOR_C, false, 8),
                new FichaNormal(26, ColorFicha.COLOR_A, false, 13),
                new FichaNormal(27, ColorFicha.COLOR_B, false, 6),
                new FichaNormal(28, ColorFicha.COLOR_C, false, 7)
        ));

        List<Ficha> fichasMonton = new LinkedList<>(List.of(
                new FichaNormal(29, ColorFicha.COLOR_C, false, 3),
                new FichaNormal(30, ColorFicha.COLOR_B, false, 11),
                new FichaNormal(31, ColorFicha.COLOR_D, false, 12),
                new FichaNormal(32, ColorFicha.COLOR_B, false, 4),
                new FichaNormal(33, ColorFicha.COLOR_C, false, 9),
                new FichaNormal(34, ColorFicha.COLOR_C, false, 5),
                new FichaNormal(35, ColorFicha.COLOR_D, false, 10),
                new FichaNormal(36, ColorFicha.COLOR_A, false, 1),
                new FichaNormal(37, ColorFicha.COLOR_C, false, 2),
                new FichaNormal(38, ColorFicha.COLOR_B, false, 8),
                new FichaNormal(39, ColorFicha.COLOR_C, false, 13),
                new FichaNormal(40, ColorFicha.COLOR_D, false, 6),
                new FichaNormal(41, ColorFicha.COLOR_C, false, 11),
                new FichaNormal(42, ColorFicha.COLOR_B, false, 12),
                new FichaNormal(43, ColorFicha.COLOR_C, false, 4),
                new FichaNormal(44, ColorFicha.COLOR_A, false, 9),
                new FichaNormal(45, ColorFicha.COLOR_B, false, 5),
                new FichaNormal(46, ColorFicha.COLOR_B, false, 10),
                new FichaNormal(47, ColorFicha.COLOR_B, false, 1),
                new FichaNormal(48, ColorFicha.COLOR_A, false, 2),
                new FichaNormal(49, ColorFicha.COLOR_D, false, 8),
                new FichaNormal(50, ColorFicha.COLOR_B, false, 13),
                new FichaNormal(51, ColorFicha.COLOR_C, false, 6),
                new FichaNormal(52, ColorFicha.COLOR_D, false, 7),
                new FichaNormal(53, ColorFicha.COLOR_B, false, 3),
                new FichaNormal(54, ColorFicha.COLOR_A, false, 11),
                new FichaNormal(55, ColorFicha.COLOR_A, false, 12),
                new FichaNormal(56, ColorFicha.COLOR_D, false, 4),
                new FichaNormal(57, ColorFicha.COLOR_B, false, 9),
                new FichaNormal(58, ColorFicha.COLOR_A, false, 5),
                new FichaNormal(59, ColorFicha.COLOR_C, false, 10),
                new FichaNormal(60, ColorFicha.COLOR_C, false, 1),
                new FichaNormal(61, ColorFicha.COLOR_D, false, 2),
                new FichaNormal(62, ColorFicha.COLOR_A, false, 8),
                new FichaNormal(63, ColorFicha.COLOR_D, false, 13),
                new FichaNormal(64, ColorFicha.COLOR_A, false, 6),
                new FichaNormal(65, ColorFicha.COLOR_B, false, 7),
                new FichaNormal(66, ColorFicha.COLOR_A, false, 3),
                new FichaNormal(67, ColorFicha.COLOR_D, false, 11),
                new FichaNormal(68, ColorFicha.COLOR_C, false, 12),
                new FichaNormal(69, ColorFicha.COLOR_A, false, 4),
                new FichaNormal(70, ColorFicha.COLOR_D, false, 9),
                new FichaNormal(71, ColorFicha.COLOR_D, false, 5),
                new FichaNormal(72, ColorFicha.COLOR_A, false, 10),
                new FichaNormal(73, ColorFicha.COLOR_D, false, 1),
                new FichaNormal(74, ColorFicha.COLOR_B, false, 2),
                new FichaNormal(75, ColorFicha.COLOR_C, false, 8),
                new FichaNormal(76, ColorFicha.COLOR_A, false, 13),
                new FichaNormal(77, ColorFicha.COLOR_B, false, 6),
                new FichaNormal(78, ColorFicha.COLOR_C, false, 7),
                new FichaNormal(79, ColorFicha.COLOR_D, false, 3),
                new FichaNormal(80, ColorFicha.COLOR_B, false, 11),
                new FichaNormal(81, ColorFicha.COLOR_D, false, 12),
                new FichaNormal(82, ColorFicha.COLOR_B, false, 4),
                new FichaNormal(83, ColorFicha.COLOR_C, false, 9),
                new FichaNormal(84, ColorFicha.COLOR_C, false, 5),
                new FichaNormal(85, ColorFicha.COLOR_D, false, 10),
                new FichaNormal(86, ColorFicha.COLOR_A, false, 1),
                new FichaNormal(87, ColorFicha.COLOR_C, false, 2),
                new FichaNormal(88, ColorFicha.COLOR_B, false, 8),
                new FichaNormal(89, ColorFicha.COLOR_C, false, 13),
                new FichaNormal(90, ColorFicha.COLOR_D, false, 6),
                new FichaNormal(91, ColorFicha.COLOR_A, false, 7),
                new FichaNormal(92, ColorFicha.COLOR_C, false, 3),
                new FichaNormal(93, ColorFicha.COLOR_C, false, 11),
                new FichaNormal(94, ColorFicha.COLOR_B, false, 12),
                new FichaNormal(95, ColorFicha.COLOR_C, false, 4),
                new FichaNormal(96, ColorFicha.COLOR_A, false, 9),
                new FichaNormal(97, ColorFicha.COLOR_B, false, 5),
                new FichaNormal(98, ColorFicha.COLOR_B, false, 10),
                new FichaNormal(99, ColorFicha.COLOR_B, false, 1),
                new FichaNormal(100, ColorFicha.COLOR_A, false, 2),
                new FichaNormal(101, ColorFicha.COLOR_D, false, 8),
                new FichaNormal(102, ColorFicha.COLOR_B, false, 13),
                new FichaNormal(103, ColorFicha.COLOR_C, false, 6),
                new FichaNormal(104, ColorFicha.COLOR_D, false, 7),
                new FichaComodin(105, ColorFicha.COLOR_COMODIN, true, "*"),
                new FichaComodin(106, ColorFicha.COLOR_COMODIN, true, "*")
        ));

        fichas.addAll(fichasJugador1);
        fichas.addAll(fichasJugador2);
        fichas.addAll(fichasMonton);

        monton = new Monton(fichasMonton);

        Jugador jugador1 = new Jugador("avatar2.png", "qwe", true, fichasJugador1);

        Jugador jugador2 = new Jugador("avatar3.png", "asd", true, fichasJugador2);

        jugadorTurno = jugador1;

        jugadores = Arrays.asList(jugador1, jugador2);

        gruposInicialesTurno = new LinkedList();

        // Enviando mensajes a jugadores.
        notificarTodosCambioTurno();

    }

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

            case CommandType.AGREGAR_FICHAS_JUGADOR:

                ComandoAgregarFichasJugador comandoAgregarFichasJugador = (ComandoAgregarFichasJugador) comando;

                agregarFichasJugador(
                        comandoAgregarFichasJugador.getIdsFichas(),
                        comandoAgregarFichasJugador.getNombreJugador()
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

            case CommandType.TOMAR_FICHA:
                
                ComandoTomarFicha comandoTomarFicha = (ComandoTomarFicha) comando;

                tomarFicha(comandoTomarFicha.getNombreJugador());
                
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

                    ICommand comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                            obtenerTableroDto(jugadorTurno.getNombre()),
                            false,
                            nombreJugador);

                    fachadaTablero.enviarComando(comandoRespuestaMovimiento);

                }

            }

        } else {

            ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                    obtenerTableroDto(jugadorTurno.getNombre()),
                    false,
                    nombreJugador);

            fachadaTablero.enviarComando(comandoRespuestaMovimiento);

        }

    }

    private void agregarFichasJugador(Integer[] idsFichas, String nombreJugador) {

        List<Ficha> fichasInicialesTurno = obtenerFichasInicialesTurno();

        List<Ficha> fichasAgregar = new LinkedList<>();
        for (int id : idsFichas) {
            Ficha ficha = encontrarFichaPorId(id);

            if (fichasInicialesTurno.contains(ficha)) {

                ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                        obtenerTableroDto(jugadorTurno.getNombre()),
                        false,
                        nombreJugador,
                        MENSAJE_AGREGAR_FICHAS_TABLERO_JUGADOR);

                fachadaTablero.enviarComando(comandoRespuestaMovimiento);

                return;
            }

            fichasAgregar.add(ficha);
        }

        jugadorTurno.getFichas().addAll(fichasAgregar);

        ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                obtenerTableroDto(jugadorTurno.getNombre()),
                true,
                nombreJugador);

        fachadaTablero.enviarComando(comandoRespuestaMovimiento);

    }

    private List<Ficha> obtenerFichasInicialesTurno() {

        List<Ficha> fichasInicialesTurno = new LinkedList<>();

        for (Grupo grupo : gruposInicialesTurno) {

            fichasInicialesTurno.addAll(grupo.getFichas());

        }

        return fichasInicialesTurno;

    }

    private void agregarFichasTablero(Integer[] idsFichas, String nombreJugador) {

        boolean esPrimerTurno = esPrimerTurnoJugador(nombreJugador);

        if (esPrimerTurno && grupoPrimerTurno != null) {

            ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                    obtenerTableroDto(jugadorTurno.getNombre()),
                    false,
                    nombreJugador,
                    MENSAJE_AGREGAR_FICHA_MAS_UN_GRUPO_PRIMER_TURNO);

            fachadaTablero.enviarComando(comandoRespuestaMovimiento);
            return;

        } else {

            List<Ficha> fichasAgregar = new LinkedList<>();
            for (int id : idsFichas) {
                Ficha ficha = encontrarFichaPorId(id);
                fichasAgregar.add(ficha);
            }

            Grupo grupo;
            try {
                grupo = FabricaGrupos.crearGrupo(
                        ++numeroGrupoActual,
                        fichasAgregar,
                        esPrimerTurno,
                        MAXIMO_NUMERO_FICHA);
            } catch (RummyException ex) {

                ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                        obtenerTableroDto(jugadorTurno.getNombre()),
                        false,
                        nombreJugador,
                        ex.getMessage());

                fachadaTablero.enviarComando(comandoRespuestaMovimiento);

                return;
            }

            if (grupo == null) {
                ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                        obtenerTableroDto(jugadorTurno.getNombre()),
                        true,
                        nombreJugador,
                        MENSAJE_GRUPO_INVALIDO);

                fachadaTablero.enviarComando(comandoRespuestaMovimiento);
                return;
            }

            grupos.add(grupo);

            if (esPrimerTurno) {

                grupoPrimerTurno = grupo;

            }

            ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                    obtenerTableroDto(jugadorTurno.getNombre()),
                    true,
                    nombreJugador);

            fachadaTablero.enviarComando(comandoRespuestaMovimiento);
        }

    }

    private void agregarFichasTableroGrupos(Integer[] idsFichas, Integer[] idsFichasGrupo, String nombreJugador) {

        List<Ficha> fichasAgregar = new LinkedList<>();
        for (int id : idsFichas) {
            Ficha ficha = encontrarFichaPorId(id);
            fichasAgregar.add(ficha);
        }

        if (idsFichasGrupo.length == 2) {

            Grupo primerGrupoAgregar = null;
            if (idsFichasGrupo[0] != null) {
                primerGrupoAgregar = encontrarFichaPorId(idsFichasGrupo[0]).getGrupo();
            }

            Grupo segundoGrupoAgregar = null;
            if (idsFichasGrupo[1] != null) {
                segundoGrupoAgregar = encontrarFichaPorId(idsFichasGrupo[1]).getGrupo();
            }

            try {

                if (primerGrupoAgregar != null && segundoGrupoAgregar != null) {

                    // No se pueden agregar fichas a grupos si es el primer turno del jugador.
                    if (esPrimerTurnoJugador(nombreJugador)) {

                        ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                                obtenerTableroDto(jugadorTurno.getNombre()),
                                false,
                                jugadorTurno.getNombre(),
                                MENSAJE_AGREGAR_FICHA_GRUPO_PRIMER_TURNO);

                        fachadaTablero.enviarComando(comandoRespuestaMovimiento);

                        return;

                    }

                    // Se crea una lista con la combinación de todas las fichas.
                    List<Ficha> fichasFusionadas = new LinkedList<>();
                    fichasFusionadas.addAll(primerGrupoAgregar.getFichas());
                    fichasFusionadas.addAll(fichasAgregar);
                    fichasFusionadas.addAll(segundoGrupoAgregar.getFichas());

                    Grupo nuevoGrupoUnificado = FabricaGrupos.crearGrupo(
                            ++numeroGrupoActual,
                            fichasFusionadas,
                            esPrimerTurnoJugador(nombreJugador),
                            MAXIMO_NUMERO_FICHA);

                    // Si el nuevo grupo es válido, se eliminan los grupos anteriores.
                    this.grupos.remove(primerGrupoAgregar);
                    this.grupos.remove(segundoGrupoAgregar);

                    // Se agrega el nuevo grupo.
                    this.grupos.add(nuevoGrupoUnificado);

                } // Agregar fichas sólo al primer grupo
                else if (primerGrupoAgregar != null) {

                    if (esPrimerTurnoJugador(nombreJugador) && primerGrupoAgregar.isPrimerTurno()) {

                        ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                                obtenerTableroDto(jugadorTurno.getNombre()),
                                false,
                                jugadorTurno.getNombre(),
                                MENSAJE_AGREGAR_FICHA_GRUPO_PRIMER_TURNO);

                        fachadaTablero.enviarComando(comandoRespuestaMovimiento);

                        return;

                    }

                    primerGrupoAgregar.agregarFichasFinal(fichasAgregar);
                } // Agregar fichas sólo al segundo grupo
                else if (segundoGrupoAgregar != null) {

                    if (esPrimerTurnoJugador(nombreJugador) && segundoGrupoAgregar.isPrimerTurno()) {

                        ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                                obtenerTableroDto(jugadorTurno.getNombre()),
                                false,
                                jugadorTurno.getNombre(),
                                MENSAJE_AGREGAR_FICHA_GRUPO_PRIMER_TURNO);

                        fachadaTablero.enviarComando(comandoRespuestaMovimiento);

                        return;

                    }

                    segundoGrupoAgregar.agregarFichasInicio(fichasAgregar);

                }

                ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                        obtenerTableroDto(jugadorTurno.getNombre()),
                        true,
                        nombreJugador);

                fachadaTablero.enviarComando(comandoRespuestaMovimiento);

            } catch (RummyException ex) {

                ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                        obtenerTableroDto(jugadorTurno.getNombre()),
                        false,
                        nombreJugador,
                        ex.getMessage());

                fachadaTablero.enviarComando(comandoRespuestaMovimiento);
            }
        }
    }

    private void quitarFichasJugador(Integer[] idsFichas, String nombreJugador) {

        List<Ficha> fichasQuitar = new LinkedList<>();

        for (int idFicha : idsFichas) {

            fichasQuitar.add(encontrarFichaPorId(idFicha));

        }

        jugadorTurno.getFichas().removeAll(fichasQuitar);

        ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                obtenerTableroDto(jugadorTurno.getNombre()),
                true,
                nombreJugador);

        fachadaTablero.enviarComando(comandoRespuestaMovimiento);

    }

    private void quitarFichasTablero(Integer[] idsFichas, String nombreJugador) {

        // Validación de fichas (Turno)
        if (esPrimerTurnoJugador(nombreJugador)) {
            ComandoRespuestaMovimiento comandoError = new ComandoRespuestaMovimiento(
                    obtenerTableroDto(jugadorTurno.getNombre()),
                    false,
                    jugadorTurno.getNombre(),
                    MENSAJE_QUITAR_FICHA_GRUPO_PRIMER_TURNO
            );
            fachadaTablero.enviarComando(comandoError);
            return;
        }

        // Se verifica si al quitar la ficha, los grupos restantes son válidos.
        try {
            for (int idFicha : idsFichas) {
                Ficha fichaQuitar = encontrarFichaPorId(idFicha);

                Grupo grupoActual = fichaQuitar.getGrupo();
                List<Ficha> fichasDelGrupo = grupoActual.getFichas();
                int indiceFicha = fichasDelGrupo.indexOf(fichaQuitar);

                // Se crean listas temporales simulando la separación.
                List<Ficha> subGrupoIzquierda = new ArrayList<>(fichasDelGrupo.subList(0, indiceFicha));
                List<Ficha> subGrupoDerecha = new ArrayList<>(fichasDelGrupo.subList(indiceFicha + 1, fichasDelGrupo.size()));

                // Solo se valida si la sublista no está vacía.
                if (!subGrupoIzquierda.isEmpty()) {
                    Grupo.validarCreacionGrupo(subGrupoIzquierda, false, MAXIMO_NUMERO_FICHA);
                }

                if (!subGrupoDerecha.isEmpty()) {
                    Grupo.validarCreacionGrupo(subGrupoDerecha, false, MAXIMO_NUMERO_FICHA);
                }
            }
        } catch (RummyException ex) {
            ComandoRespuestaMovimiento comandoError = new ComandoRespuestaMovimiento(
                    obtenerTableroDto(jugadorTurno.getNombre()),
                    false,
                    jugadorTurno.getNombre(),
                    ex.getMessage()
            );
            fachadaTablero.enviarComando(comandoError);
            return;
        }

        // Se realiza la separación
        try {
            for (int idFicha : idsFichas) {
                Ficha fichaQuitar = encontrarFichaPorId(idFicha);
                Grupo grupoOriginal = fichaQuitar.getGrupo();

                // Usamos una copia de la lista antes de quitar nada para saber dónde cortar
                List<Ficha> fichasSnapshot = new ArrayList<>(grupoOriginal.getFichas());
                int indiceFicha = fichasSnapshot.indexOf(fichaQuitar);

                grupoOriginal.quitarFicha(fichaQuitar);

                // Calculamos las sublistas basándonos en la copia (snapshot) que hicimos al principio
                List<Ficha> listaIzquierda = new ArrayList<>(fichasSnapshot.subList(0, indiceFicha));
                List<Ficha> listaDerecha = new ArrayList<>(fichasSnapshot.subList(indiceFicha + 1, fichasSnapshot.size()));

                // El grupo original se queda con la parte izquierda.
                if (!listaIzquierda.isEmpty()) {
                    // Sobrescribimos las fichas del grupo original solo con la parte izquierda
                    grupoOriginal.setFichas(listaIzquierda);
                } else {
                    // Si la izquierda quedó vacía, eliminamos el grupo original de la lista global
                    grupos.remove(grupoOriginal);
                }

                // Se crea el grupo derecho, si hay fichas.
                if (!listaDerecha.isEmpty()) {
                    Grupo nuevoGrupo = FabricaGrupos.crearGrupo(++numeroGrupoActual, listaDerecha, false, MAXIMO_NUMERO_FICHA);
                    this.grupos.add(nuevoGrupo);
                }
            }
        } catch (RummyException ex) {
            ComandoRespuestaMovimiento comandoError = new ComandoRespuestaMovimiento(
                    obtenerTableroDto(jugadorTurno.getNombre()),
                    false,
                    jugadorTurno.getNombre(),
                    ex.getMessage()
            );
            fachadaTablero.enviarComando(comandoError);
            return;
        }

        ComandoRespuestaMovimiento comandoExito = new ComandoRespuestaMovimiento(
                obtenerTableroDto(jugadorTurno.getNombre()),
                true,
                nombreJugador
        );
        fachadaTablero.enviarComando(comandoExito);
    }

    private void terminarTurno(String nombreJugador) {

        if (validarTablero(nombreJugador)) {

            if (jugadorTurno.isPrimerTurno()) {
                jugadorTurno.setPrimerTurno(false);
            }

            grupoPrimerTurno.setPrimerTurno(false);
            grupoPrimerTurno = null;

            pasarSiguienteJugador();

            gruposInicialesTurno = new LinkedList();

            for (Grupo grupo : grupos) {

                List<Ficha> copiaFichas = new LinkedList<>(grupo.getFichas());

                try {
                    Grupo grupoCopia = FabricaGrupos.crearGrupo(
                            grupo.getNumero(),
                            copiaFichas,
                            false,
                            MAXIMO_NUMERO_FICHA);

                    gruposInicialesTurno.add(grupoCopia);

                    notificarTodosCambioTurno();

                } catch (RummyException ex) {

                }

            }

        } else {

            ICommand comandoTableroInvalido = new ComandoTableroInvalido(nombreJugador);

            fachadaTablero.enviarComando(comandoTableroInvalido);

        }

    }

    private void pasarSiguienteJugador() {

        int indice = jugadores.indexOf(jugadorTurno);
        if (indice == jugadores.size() - 1) {
            jugadorTurno = jugadores.get(0);
        } else {
            jugadorTurno = jugadores.get(indice + 1);
        }

    }

    private void notificarTodosCambioTurno() {

        for (Jugador jugador : jugadores) {
            if (!jugador.getNombre().equals(jugadorTurno.getNombre())) {

                ComandoCambioTurno comandoCambioTurno = new ComandoCambioTurno(
                        obtenerTableroDto(jugador.getNombre()),
                        jugador.getNombre(),
                        MENSAJE_CAMBIO_TURNO);

                fachadaTablero.enviarComando(comandoCambioTurno);

            } else {

                ComandoIniciarTurno comandoIniciarTurno = new ComandoIniciarTurno(
                        obtenerTableroDto(jugador.getNombre()),
                        jugador.getNombre(),
                        MENSAJE_INICIO_TURNO);

                fachadaTablero.enviarComando(comandoIniciarTurno);

            }
        }
    }

    private void tomarFicha(String nombreJugador) {
  
        Ficha fichaSeleccionada = null;
        if (!monton.getFichasMonton().isEmpty()) {

            Random rand = new Random();

            int indiceAleatorio = rand.nextInt(monton.getFichasMonton().size());

            fichaSeleccionada = monton.getFichasMonton().get(indiceAleatorio);

            monton.getFichasMonton().remove(fichaSeleccionada);
            
            jugadorTurno.getFichas().add(fichaSeleccionada);

                ComandoRespuestaMovimiento comandoRespuestaMovimiento = new ComandoRespuestaMovimiento(
                obtenerTableroDto(jugadorTurno.getNombre()), 
                true, 
                nombreJugador
            );
            fachadaTablero.enviarComando(comandoRespuestaMovimiento);
                    
                    
            return;
        }

    }

    private boolean esPrimerTurnoJugador(String nombreJugador) {

        String nombreJugadorTurno = jugadorTurno.getNombre();

        return jugadorTurno.isPrimerTurno();

    }

    private TableroDTO obtenerTableroDto(String nombreJugador) {

        JugadorDTO jugadorDto = null;

        List<JugadorDTO> otrosJugadoresDto = new LinkedList<>();

        for (Jugador jugador : jugadores) {

            if (!jugador.getNombre().equals(nombreJugador)) {

                List<FichaDTO> listaFichasOtroJugadorDto = new LinkedList<>();

                for (int i = 0; i < jugador.getFichas().size(); i++) {

                    listaFichasOtroJugadorDto.add(null);

                }

                JugadorDTO otroJugadorDto = new JugadorDTO(
                        listaFichasOtroJugadorDto,
                        jugador.getAvatar(),
                        jugador.getNombre());

                otrosJugadoresDto.add(otroJugadorDto);

            } else {

                List<FichaDTO> listaFichasJugadorDto = new LinkedList<>();

                for (Ficha ficha : jugador.getFichas()) {

                    listaFichasJugadorDto.add(obtenerFichaDto(ficha));

                }

                jugadorDto = new JugadorDTO(
                        listaFichasJugadorDto,
                        jugador.getAvatar(),
                        jugador.getNombre());

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
                otrosJugadoresDto.toArray(new JugadorDTO[0]));

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

            case ColorFicha.COLOR_D:

                colorFichaDto = ColorFichaDTO.COLOR_D;

                break;

            case ColorFicha.COLOR_COMODIN:

                colorFichaDto = ColorFichaDTO.COLOR_COMODIN;

                break;

            default:
                throw new AssertionError();
        }

        if (ficha instanceof FichaComodin) {

            String valorComodin = ((FichaComodin) ficha).getValor();
            return new FichaComodinDTO(colorFichaDto, ficha.getId(), valorComodin, "Comodin");

        } else if (ficha instanceof FichaNormal) {

            int numeroFicha = ((FichaNormal) ficha).getNumero();
            return new FichaNormalDTO(colorFichaDto, ficha.getId(), numeroFicha, "Normal");

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

    public boolean validarTablero(String nombreJugador) {

        boolean esPrimerTurno = esPrimerTurnoJugador(nombreJugador);

        if (esPrimerTurno && grupoPrimerTurno == null) {

            return false;
        }

        for (Grupo grupo : grupos) {
            if (!grupo.comprobarValidez()) {
                return false;
            }
        }
        return true;
    }

    public void setFachadaTablero(FachadaTablero fachadaTablero) {
        this.fachadaTablero = fachadaTablero;
    }

}
