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
import java.util.List;

/**
 *
 * @author pedro
 */
public class Tablero implements ITablero{
    private Jugador jugadorPrincipal;
    private List<Jugador> listaJugaores;
    private Monton monton;
    private List<GrupoSecuencia> gruposSecuencia;
    private List<GrupoColores> gruposColores;
    
    public Grupo obtenerGrupo(Integer numero){
        throw new UnsupportedOperationException();
    }
    
    public List<Jugador> obtenerJugadoresExternos(){
        throw new UnsupportedOperationException();
    }
    
    //public Monto obtenerMonto(){}

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

    @Override
    public boolean quitarFichasTablero(int[] idFichas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean seleccionarFichasTablero(int[] idFichas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
