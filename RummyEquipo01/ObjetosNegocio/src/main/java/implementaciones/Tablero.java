/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Ficha;
import entidades.Grupo;
import entidades.GrupoColores;
import entidades.GrupoSecuencia;
import entidades.Jugador;
import entidades.Monton;
import interfaces.ITablero;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author pedro
 */
public class Tablero implements ITablero {

    private Jugador jugadorPrincipal;
    private List<Jugador> listaJugaores;
    private Monton monton;
    private List<Grupo> gruposFichas;

    public Grupo obtenerGrupo(Integer numero) {
        throw new UnsupportedOperationException();
    }

    public List<Jugador> obtenerJugadoresExternos() {
        throw new UnsupportedOperationException();
    }

    public Monton obtenerMonton() {
        throw new UnsupportedOperationException();
    }

    /**
     * Método para obtener las fichas según los ids dados.
     *
     * @param idFichas ids de las fichas a obtener.
     * @return lista de instancias de las fichas con el idDado.
     */
    public List<Ficha> obtenerFichas(int[] idFichas) {

        // Convertimos ids a un Set para búsquedas y que no se haga un triple for
        Set<Integer> idsBuscados = Arrays.stream(idFichas)
                .boxed()
                .collect(Collectors.toSet());
        List<Ficha> fichasObtenidas = new ArrayList<>();

        for (Grupo grupos : gruposFichas) {
            for (Ficha ficha : grupos.getFichas()) {
                if (idsBuscados.contains(ficha.getId())) { //Verificamos si el set contiene el id de la ficha y si es asi lo agregamos.
                    fichasObtenidas.add(ficha);
                }
            }
        }
        return fichasObtenidas;
    }

    @Override
    public boolean agregarFichasTablero(int[] idFichas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregarFichasTablero(int[] idsFicha, Integer numeroGrupo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean quitarFichasJugador(int[] posiciones) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Método para quitar las fichas del tablero.
     *
     * @param idFichas ids de las fichas a quitar.
     * @return si se tuvo exito o no.
     */
    @Override
    public boolean quitarFichasTablero(int[] idFichas) {

        List<Ficha> fichasObtenidas = this.obtenerFichas(idFichas); //Obtenemos las fichas a remover
        Set<Grupo> grupos = new HashSet<>();
        if (fichasObtenidas.isEmpty()) {
            return false; // no hay fichas que remover
        }
        
        for (Ficha ficha : fichasObtenidas) {
            grupos.add(ficha.getGrupo());
        }

        for (Grupo grupo : grupos) {
            List<Ficha> fichasGrupo = fichasObtenidas.stream()
                    .filter(f -> f.getGrupo().equals(grupo))
                    .collect(Collectors.toList());
            grupo.removerFichas(fichasGrupo);
        }
        return true;
    }

    @Override
    public boolean seleccionarFichasTablero(int[] idFichas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
