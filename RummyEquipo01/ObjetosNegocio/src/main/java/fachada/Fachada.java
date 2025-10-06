
package fachada;

import dto.ColorFichaNegocioDTO;
import dto.ComodinNegocioDTO;
import dto.FichaNegocioDTO;
import dto.FichaNormalNegocioDTO;
import dto.GrupoColoresNegocioDTO;
import dto.GrupoNegocioDTO;
import dto.GrupoSecuenciaNegocioDTO;
import dto.JugadorNegocioDTO;
import dto.MontonNegocioDTO;
import dto.TableroNegocioDTO;
import entidades.ColorFicha;
import entidades.Comodin;
import entidades.Ficha;
import entidades.FichaNormal;
import entidades.Grupo;
import entidades.GrupoColores;
import entidades.GrupoSecuencia;
import entidades.Jugador;
import entidades.Monton;
import interfaces.ITablero;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 
 */
public class Fachada implements ITablero {

    private List<Grupo> grupos;
    private List<Ficha> fichas;
    private List<Jugador> jugadores;
    private Monton monton;

    public Fachada() {
        this.grupos = new ArrayList<>();
        this.fichas = new ArrayList<>();
        this.jugadores = new ArrayList<>();

        List<Ficha> fichasNegocioJugador1 = List.of(
            new FichaNormal(1, 8, ColorFicha.COLOR_C),
            new FichaNormal(2, 5, ColorFicha.COLOR_A),
            new FichaNormal(3, 13, ColorFicha.COLOR_B),
            new FichaNormal(4, 1, ColorFicha.COLOR_D),
            new FichaNormal(5, 10, ColorFicha.COLOR_A),
            new FichaNormal(6, 4, ColorFicha.COLOR_C),
            new FichaNormal(7, 7, ColorFicha.COLOR_B),
            new FichaNormal(8, 2, ColorFicha.COLOR_D),
            new FichaNormal(9, 6, ColorFicha.COLOR_A),
            new FichaNormal(10, 11, ColorFicha.COLOR_B),
            new FichaNormal(11, 9, ColorFicha.COLOR_D)
        );

        List<Ficha> fichasNegocioJugador2 = List.of(
            new FichaNormal(12, 1, ColorFicha.COLOR_B),
            new FichaNormal(13, 12, ColorFicha.COLOR_A),
            new FichaNormal(14, 5, ColorFicha.COLOR_C),
            new FichaNormal(15, 8, ColorFicha.COLOR_D),
            new FichaNormal(16, 3, ColorFicha.COLOR_B),
            new FichaNormal(17, 7, ColorFicha.COLOR_A),
            new FichaNormal(18, 10, ColorFicha.COLOR_C),
            new FichaNormal(19, 13, ColorFicha.COLOR_D),
            new FichaNormal(20, 2, ColorFicha.COLOR_B),
            new FichaNormal(21, 6, ColorFicha.COLOR_C)
        );


        List<Ficha> fichasNegocioGrupo1 = List.of(
            new FichaNormal(22, 9, ColorFicha.COLOR_A),
            new FichaNormal(23, 9, ColorFicha.COLOR_B),
            new FichaNormal(24, 9, ColorFicha.COLOR_C)
        );


        List<Ficha> fichasNegocioGrupo2 = List.of(
            new FichaNormal(25, 4, ColorFicha.COLOR_D),
            new FichaNormal(26, 5, ColorFicha.COLOR_D),
            new FichaNormal(27, 6, ColorFicha.COLOR_D),
            new FichaNormal(28, 7, ColorFicha.COLOR_D),
            new FichaNormal(29, 8, ColorFicha.COLOR_D)
        );


        List<Ficha> fichasMonton = List.of(
            new FichaNormal(30, 1, ColorFicha.COLOR_C),
            new FichaNormal(31, 11, ColorFicha.COLOR_A),
            new FichaNormal(32, 12, ColorFicha.COLOR_D),
            new FichaNormal(33, 4, ColorFicha.COLOR_A),
            new FichaNormal(34, 10, ColorFicha.COLOR_B),
            new FichaNormal(35, 3, ColorFicha.COLOR_C),
            new FichaNormal(36, 12, ColorFicha.COLOR_C),
            new FichaNormal(37, 5, ColorFicha.COLOR_B),
            new FichaNormal(38, 2, ColorFicha.COLOR_A),
            new FichaNormal(39, 13, ColorFicha.COLOR_A),
            new FichaNormal(40, 8, ColorFicha.COLOR_B),
            new FichaNormal(41, 11, ColorFicha.COLOR_D),
            new FichaNormal(42, 6, ColorFicha.COLOR_B),
            new FichaNormal(43, 9, ColorFicha.COLOR_A),
            new FichaNormal(44, 1, ColorFicha.COLOR_C),
            new FichaNormal(45, 12, ColorFicha.COLOR_B),
            new FichaNormal(46, 5, ColorFicha.COLOR_A),
            new FichaNormal(47, 7, ColorFicha.COLOR_C),
            new FichaNormal(48, 10, ColorFicha.COLOR_D),
            new FichaNormal(49, 3, ColorFicha.COLOR_A),
            new FichaNormal(50, 13, ColorFicha.COLOR_C),
            new FichaNormal(51, 8, ColorFicha.COLOR_A),
            new FichaNormal(52, 11, ColorFicha.COLOR_A),
            new FichaNormal(53, 2, ColorFicha.COLOR_C),
            new FichaNormal(54, 1, ColorFicha.COLOR_A),
            new FichaNormal(55, 6, ColorFicha.COLOR_A),
            new FichaNormal(56, 10, ColorFicha.COLOR_A),
            new FichaNormal(57, 4, ColorFicha.COLOR_B),
            new FichaNormal(58, 9, ColorFicha.COLOR_B),
            new FichaNormal(59, 12, ColorFicha.COLOR_D),
            new FichaNormal(60, 5, ColorFicha.COLOR_B),
            new FichaNormal(61, 8, ColorFicha.COLOR_B),
            new FichaNormal(62, 1, ColorFicha.COLOR_B),
            new FichaNormal(63, 6, ColorFicha.COLOR_C),
            new FichaNormal(64, 11, ColorFicha.COLOR_C),
            new FichaNormal(65, 3, ColorFicha.COLOR_D),
            new FichaNormal(66, 7, ColorFicha.COLOR_B),
            new FichaNormal(67, 10, ColorFicha.COLOR_B),
            new FichaNormal(68, 2, ColorFicha.COLOR_B),
            new FichaNormal(69, 5, ColorFicha.COLOR_C),
            new FichaNormal(70, 9, ColorFicha.COLOR_D),
            new FichaNormal(71, 12, ColorFicha.COLOR_A),
            new FichaNormal(72, 4, ColorFicha.COLOR_A),
            new FichaNormal(73, 8, ColorFicha.COLOR_C),
            new FichaNormal(74, 11, ColorFicha.COLOR_B),
            new FichaNormal(75, 2, ColorFicha.COLOR_D),
            new FichaNormal(76, 7, ColorFicha.COLOR_D),
            new FichaNormal(77, 1, ColorFicha.COLOR_D),
            new FichaNormal(78, 6, ColorFicha.COLOR_D),
            new FichaNormal(79, 13, ColorFicha.COLOR_D),
            new FichaNormal(80, 4, ColorFicha.COLOR_B),
            new FichaNormal(81, 9, ColorFicha.COLOR_C),
            new FichaNormal(82, 12, ColorFicha.COLOR_C),
            new FichaNormal(83, 3, ColorFicha.COLOR_B),
            new FichaNormal(84, 8, ColorFicha.COLOR_A),
            new FichaNormal(85, 11, ColorFicha.COLOR_D),
            new FichaNormal(86, 2, ColorFicha.COLOR_A),
            new FichaNormal(87, 7, ColorFicha.COLOR_A),
            new FichaNormal(88, 10, ColorFicha.COLOR_C),
            new FichaNormal(89, 1, ColorFicha.COLOR_B),
            new FichaNormal(90, 5, ColorFicha.COLOR_D),
            new FichaNormal(91, 13, ColorFicha.COLOR_A),
            new FichaNormal(92, 4, ColorFicha.COLOR_C),
            new FichaNormal(93, 9, ColorFicha.COLOR_C),
            new FichaNormal(94, 3, ColorFicha.COLOR_D),
            new FichaNormal(95, 7, ColorFicha.COLOR_C),
            new FichaNormal(96, 11, ColorFicha.COLOR_C),
            new FichaNormal(97, 2, ColorFicha.COLOR_C),
            new FichaNormal(98, 6, ColorFicha.COLOR_D),
            new FichaNormal(99, 13, ColorFicha.COLOR_B),
            new FichaNormal(100, 3, ColorFicha.COLOR_A),
            new FichaNormal(101, 8, ColorFicha.COLOR_D),
            new FichaNormal(102, 1, ColorFicha.COLOR_A),
            new FichaNormal(103, 7, ColorFicha.COLOR_D),
            new FichaNormal(104, 4, ColorFicha.COLOR_D),
            new Comodin(105),
            new Comodin(106)
        );

        Monton monton = new Monton(fichasMonton);

        Grupo grupo1 = new GrupoColores(1, fichasNegocioGrupo1);
        Grupo grupo2 = new GrupoSecuencia(2, fichasNegocioGrupo2);

        Jugador jugador1 = new Jugador("/avatar2.png", "Sandy_43", false, fichasNegocioJugador1);
        Jugador jugador2 = new Jugador("/avatar3.png", "Juan_27", false, fichasNegocioJugador2);

        jugadores.add(jugador1);
        jugadores.add(jugador2);

        fichas.addAll(fichasMonton);
        fichas.addAll(fichasNegocioGrupo1);
        fichas.addAll(fichasNegocioGrupo2);
        fichas.addAll(fichasNegocioJugador1);
        fichas.addAll(fichasNegocioJugador2);
        
        grupos.add(grupo1);
        grupos.add(grupo2);

    }

    @Override
    public boolean agregarFichasTablero(int[] idFichas) {
        if (idFichas.length == 0) {
            return false;
        }

        List<Ficha> listaFichas = new ArrayList<>();
        for (int i = 0; i < idFichas.length; i++) {
            Ficha fichaNueva = obtenerFichaPorId(idFichas[i]);
            listaFichas.add(fichaNueva);
        }
        Grupo grupo = new GrupoSecuencia(1, listaFichas);
        return true;
    }

    @Override
    public boolean agregarFichasTablero(int[] idFichas, int numeroGrupo) {
        if (idFichas.length == 0) {
            return false;
        }
        List<Ficha> listaFichas = new ArrayList<>();
        for (int i = 0; i < idFichas.length; i++) {
            Ficha fichaNueva = obtenerFichaPorId(idFichas[i]);
            listaFichas.add(fichaNueva);
        }
        Grupo grupo = obtenerGrupoPorId(numeroGrupo);
        grupo.agregarFichas(fichas);
        return true;
    }

    @Override
    public boolean quitarFichasJugador(int[] idFichas) {
        if (idFichas.length == 0) {
            return false;
        }
        List fichas = new LinkedList();
        Jugador jugador1 = jugadores.get(1);
        for (int i = 0; i < idFichas.length; i++) {
            Ficha ficha = obtenerFichaPorId(idFichas[i]);
            fichas.add(ficha);
        }
        jugador1.quitarFichas(fichas);
        return true;
    }

    @Override
    public boolean quitarFichasTablero(int[] idFichas) {
        if (idFichas.length == 0) {
            return false;
        }
        for (int i = 0; i < idFichas.length; i++) {
            Ficha ficha = obtenerFichaPorId(idFichas[i]);
            Grupo grupo = ficha.getGrupo();
            List fichas = new LinkedList();
            fichas.add(ficha);
            grupo.removerFichas(fichas);
        }
        return true;
    }

    @Override
    public boolean seleccionarFichasTablero(int[] idFichas) {
        if (idFichas.length == 0) {
            return false;
        }
        List<Ficha> fichasSeleccionadas = new ArrayList<>();
        for (int i = 0; i < idFichas.length; i++) {
            Ficha fichaSeleccionada = obtenerFichaPorId(idFichas[i]);
            fichasSeleccionadas.add(fichaSeleccionada);
        }
        return true;
    }

    private Ficha obtenerFichaPorId(int idFicha) {
        for (Ficha ficha : fichas) {
            if (ficha.getId() == idFicha) {
                return ficha;
            }
        }
        return null;
    }

    private Grupo obtenerGrupoPorId(int numeroGrupo) {
        for (Grupo grupo : grupos) {
            if (grupo.getNumero() == numeroGrupo) {
                return grupo;
            }
        }
        return null;
    }


    @Override
    public boolean validarGrupos() {
        return true;
    }

    @Override
    public JugadorNegocioDTO obtenerJugadorPrincipal() {
        
        Jugador jugadorPrincipal = this.jugadores.get(0);
        List<Ficha> fichasJugador = jugadorPrincipal.getFichas();
        List<FichaNegocioDTO> fichasNegocio = new LinkedList<>();
        List<ComodinNegocioDTO> comodinesNegocio = new LinkedList<>();

        for (Ficha ficha : fichasJugador) {
            // Si es una FichaNormal
            if (ficha instanceof FichaNormal) {
                FichaNormal fichaNormal = (FichaNormal) ficha;

                FichaNegocioDTO fichaNegocio = obtenerFichaNegocioDTO(fichaNormal);
                
                fichasNegocio.add(fichaNegocio);
            }
        }

        JugadorNegocioDTO jugadorPrincipalDTO = new JugadorNegocioDTO(
                fichasNegocio, 
                jugadorPrincipal.getAvatar(), 
                jugadorPrincipal.getNombre(), 
                jugadorPrincipal.isEsPrimerTurno());
        
        return jugadorPrincipalDTO;
    }

    @Override
    public JugadorNegocioDTO[] obtenerJugadoresExternos() {
        
        Jugador jugadorPrincipal = this.jugadores.get(1);
        List<Ficha> fichasJugador = jugadorPrincipal.getFichas();
        List<FichaNegocioDTO> fichasNegocio = new ArrayList<>();

        for (Ficha ficha : fichasJugador) {
            // Si es una FichaNormal
            if (ficha instanceof FichaNormal) {
                FichaNormal fichaNormal = (FichaNormal) ficha;

                
                fichasNegocio.add(obtenerFichaNegocioDTO(fichaNormal));
            }
        }

        JugadorNegocioDTO jugadorPrincipalDTO = new JugadorNegocioDTO(
                fichasNegocio, 
                jugadorPrincipal.getAvatar(), 
                jugadorPrincipal.getNombre(), 
                jugadorPrincipal.isEsPrimerTurno());
        
        JugadorNegocioDTO[] jugadoresNegocioDTO = {jugadorPrincipalDTO};
        
        return jugadoresNegocioDTO;
        
    }
    

    @Override
    public MontonNegocioDTO obtenerMonton() {
        List<Ficha> fichasMonton = monton.getFichas();
        List<FichaNegocioDTO> fichasNegocio = new LinkedList<>();

        for (Ficha ficha : fichasMonton) {
            // Si es una FichaNormal
            if (ficha instanceof FichaNormal) {
                FichaNormal fichaNormal = (FichaNormal) ficha;

                FichaNegocioDTO fichaNegocio = obtenerFichaNegocioDTO(fichaNormal);
                
                fichasNegocio.add(fichaNegocio);
            }
        }
        
        return new MontonNegocioDTO(fichasNegocio);
    }
    
    private FichaNegocioDTO obtenerFichaNegocioDTO(FichaNormal ficha){
        
        FichaNormal fichaNormal = (FichaNormal) ficha;

        ColorFicha colorFicha = fichaNormal.getColor();
        ColorFichaNegocioDTO colorFichaNegocio;

        switch (colorFicha) {
            case ColorFicha.COLOR_A:
                colorFichaNegocio = ColorFichaNegocioDTO.COLOR_A;
                break;
            case ColorFicha.COLOR_B:
                colorFichaNegocio = ColorFichaNegocioDTO.COLOR_B;
                break;
            case ColorFicha.COLOR_C:
                colorFichaNegocio = ColorFichaNegocioDTO.COLOR_C;
                break;
            case ColorFicha.COLOR_D:
                colorFichaNegocio = ColorFichaNegocioDTO.COLOR_D;
                break;

            default:
                throw new AssertionError();
        }

        FichaNegocioDTO fichaNegocio = new FichaNormalNegocioDTO(
                colorFichaNegocio,
                fichaNormal.getNumero(),
                fichaNormal.getId()
        );

        return fichaNegocio;
        
    }

        

    @Override
    public GrupoNegocioDTO[] obtenerGruposNegocio() {
        

        List<FichaNegocioDTO> fichasNegocioGrupo1 = new LinkedList<>();
        
        for(Ficha fichaGrupo1: grupos.get(0).getFichas()){
            
            fichasNegocioGrupo1.add(obtenerFichaNegocioDTO((FichaNormal)fichaGrupo1));
            
        }
         
        
        GrupoNegocioDTO grupoNegocio1 = 
            new GrupoColoresNegocioDTO(1, fichasNegocioGrupo1);
        
        
        List<FichaNegocioDTO> fichasNegocioGrupo2 = new LinkedList<>();
        
        for(Ficha fichaGrupo2: grupos.get(1).getFichas()){
            
            fichasNegocioGrupo1.add(obtenerFichaNegocioDTO((FichaNormal)fichaGrupo2));
            
        }
        
        GrupoNegocioDTO grupoNegocio2 = 
            new GrupoSecuenciaNegocioDTO(2, fichasNegocioGrupo2);
        
        
        GrupoNegocioDTO[] gruposNegocio = {grupoNegocio1, grupoNegocio2};
        
        return gruposNegocio;
        
    }

    @Override
    public void iniciarTurno(TableroNegocioDTO tableroNegocio) {
        
    }

}
