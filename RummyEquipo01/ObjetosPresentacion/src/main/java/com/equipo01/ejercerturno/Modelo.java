

package com.equipo01.ejercerturno;

import com.equipo01.dto.JugadorExternoPresentacionDTO;
import com.equipo01.dto.JugadorPrincipalPresentacionDTO;
import com.equipo01.dto.MontonPresentacionDTO;
import java.util.List;


public class Modelo implements IPublicador, IModelo{

    /**
     * Lista de suscriptores del modelo para notificar cambios a la vista.
     */
    private List<ISuscriptor> suscriptores;
    /**
     * 
     * Atributo que indica si el tabero es o no valido.
     */
    private boolean tableroInvalido;
    
    /**
     * Atributo que indica mediante el turno activo si el jugador puede o no interactuar con la vista.
     */
    private boolean vistaHabilitado;
    
    /**
     * Mensaje indicando que el tablero no esta correcto al finalizar la revisión de turno.
     */
    private String  MENSAJE_TABLERO_INVALIDO;
    
    /**
     * Mensaje que aparece cuando se hace un movimiento que no es valido.
     */
    private String  MENSAJE_MOVIMIENTO_INVALIDO;
    
    
    public void seleccionarFichasTablero(int[] posicionesFichas) {}

    public void quitarFichasJugador(int[] posicionesFichas) {}

    public void quitarFichasTablero(int[] idsFichas) {}

    public void agregarFichasTablero(int[] idsFichas, int numeroGrupo) {}
 
    public void agregarFichasTablero(int[] idsFichas){}
    
     public void terminarTurno() {}

    @Override
    public void suscribirse(ISuscriptor suscriptor) {
        suscriptores.add(suscriptor);
    }

    @Override
    public void desuscribirse(ISuscriptor suscriptor) {
        suscriptores.remove(suscriptor);
    }

    @Override
    public void notificar() {
        
        for(ISuscriptor suscriptor: suscriptores){
            suscriptor.actualizar(this);
        }
    }

    @Override
    public JugadorPrincipalPresentacionDTO obtenerJugadorPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public JugadorExternoPresentacionDTO[] obtenerJugadoresExternos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MontonPresentacionDTO[] obtenerMontonPresentacionDTO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String obtenerMensajeMovimientoInvalido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String obtenerMensajeTableroInvalido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isVistaHabilitada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
