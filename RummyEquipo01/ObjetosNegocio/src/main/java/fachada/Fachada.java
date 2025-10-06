/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import dto.ComodinNegocioDTO;
import dto.FichaNegocioDTO;
import dto.JugadorNegocioDTO;
import dto.MontonNegocioDTO;
import entidades.ColorFicha;
import entidades.Ficha;
import entidades.FichaNormal;
import entidades.Grupo;
import entidades.GrupoSecuencia;
import entidades.Jugador;
import entidades.Monton;
import interfaces.ITablero;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author pedro
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

        Ficha f1 = new FichaNormal(0, ColorFicha.COLOR_A, 12);
        Ficha f2 = new FichaNormal(1, ColorFicha.COLOR_B, 2);
        Ficha f3 = new FichaNormal(2, ColorFicha.COLOR_C, 6);
        Ficha f4 = new FichaNormal(3, ColorFicha.COLOR_A, 11);
        Ficha f5 = new FichaNormal(4, ColorFicha.COLOR_A, 10);
        Grupo g1 = new GrupoSecuencia(0, List.of(f5, f4, f1));
        
        
        
        Ficha f6 = new FichaNormal(6, ColorFicha.COLOR_A, 12);
        Ficha f7 = new FichaNormal(7, ColorFicha.COLOR_B, 2);
        Ficha f8 = new FichaNormal(8, ColorFicha.COLOR_C, 6);
        Ficha f9 = new FichaNormal(9, ColorFicha.COLOR_A, 11);
        Ficha f10 = new FichaNormal(10, ColorFicha.COLOR_A, 10);
        
        Monton monton = new Monton(List.of(f6,f7,f8,f9,f10));

        Jugador j1 = new Jugador("...", "taza123", true, List.of(f5, f4, f1));
        Jugador j2 = new Jugador("...", "raco123", false, List.of(f2, f3));

        jugadores.add(j1);
        jugadores.add(j2);

        fichas.addAll(List.of(f1, f2, f3, f4, f5));

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

    /**
     * Método para validar todos los grupos en los tableros
     *
     * @return
     */
    public boolean validarGrupos() {
        return true; //Retornamos true en este momento "mock"
    }

    @Override
    public boolean terminarTurno() {
        return this.validarGrupos();
    }

    @Override
    public JugadorNegocioDTO obtenerJugadorPrincipal() {

        Jugador jugadorPrincipal = this.jugadores.get(0);
        List<Ficha> fichasJugador = jugadorPrincipal.getFichas();
        List<FichaNegocioDTO> fichasNegocio = new ArrayList<>();
        List<ComodinNegocioDTO> comodinesNegocio = new ArrayList<>();

        for (Ficha ficha : fichasJugador) {
            // Si es una FichaNormal
            if (ficha instanceof FichaNormal) {
                FichaNormal fichaNormal = (FichaNormal) ficha;

                FichaNegocioDTO fichaDTO = new FichaNegocioDTO(
                        fichaNormal.getId(),
                        fichaNormal.getColor(),
                        fichaNormal.getNumero()
                );
                fichasNegocio.add(fichaDTO);
            }
        }

        JugadorNegocioDTO jugadorPrincipalDTO = new JugadorNegocioDTO(fichasNegocio, jugadorPrincipal.getAvatar(), jugadorPrincipal.getNombre(), jugadorPrincipal.isEsPrimerTurno());
        return jugadorPrincipalDTO;
    }

    @Override
    public JugadorNegocioDTO obtenerJugadoresExternos() {
         Jugador jugadorPrincipal = this.jugadores.get(1);
        List<Ficha> fichasJugador = jugadorPrincipal.getFichas();
        List<FichaNegocioDTO> fichasNegocio = new ArrayList<>();

        for (Ficha ficha : fichasJugador) {
            // Si es una FichaNormal
            if (ficha instanceof FichaNormal) {
                FichaNormal fichaNormal = (FichaNormal) ficha;

                FichaNegocioDTO fichaDTO = new FichaNegocioDTO(
                        fichaNormal.getId(),
                        fichaNormal.getColor(),
                        fichaNormal.getNumero()
                );
                fichasNegocio.add(fichaDTO);
            }
        }

        JugadorNegocioDTO jugadorPrincipalDTO = new JugadorNegocioDTO(fichasNegocio, jugadorPrincipal.getAvatar(), jugadorPrincipal.getNombre(), jugadorPrincipal.isEsPrimerTurno());
        return jugadorPrincipalDTO;
    }

    @Override
    public MontonNegocioDTO obtenerMonton() {
        List<Ficha> fichasMonton = monton.getFichas();
        List<FichaNegocioDTO> fichasNegocio = new ArrayList<>();

        for (Ficha ficha : fichasMonton) {
            // Si es una FichaNormal
            if (ficha instanceof FichaNormal) {
                FichaNormal fichaNormal = (FichaNormal) ficha;

                FichaNegocioDTO fichaDTO = new FichaNegocioDTO(
                        fichaNormal.getId(),
                        fichaNormal.getColor(),
                        fichaNormal.getNumero()
                );
                fichasNegocio.add(fichaDTO);
            }
        }
        
        return new MontonNegocioDTO(fichasNegocio);
    }

}
