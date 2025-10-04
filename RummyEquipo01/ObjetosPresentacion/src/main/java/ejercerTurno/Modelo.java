

package ejercerTurno;

import dto.JugadorExternoPresentacionDTO;
import dto.JugadorPrincipalPresentacionDTO;
import dto.MontonPresentacionDTO;
import implementaciones.Tablero;
import interfaces.ITablero;
import java.util.ArrayList;
import java.util.List;


public class Modelo implements IPublicador, IModelo{

    
    private ITablero tablero = new Tablero();
    /**
     * Lista de suscriptores del modelo para notificar cambios a la vista.
     */
    private List<ISuscriptor> suscriptores = new ArrayList<>();
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
     * Atributo que indica si el movimiento hecho fue valido o no.
     */
    private boolean movimientoValido;
    
    
    /**
     * Mensaje indicando que el tablero no esta correcto al finalizar la revisión de turno.
     */
    private String  MENSAJE_TABLERO_INVALIDO;
    
    /**
     * Mensaje que aparece cuando se hace un movimiento que no es valido.
     */
    private String  MENSAJE_MOVIMIENTO_INVALIDO;

    public ITablero getTablero() {
        return tablero;
    }

    public void setTablero(ITablero tablero) {
        this.tablero = tablero;
    }

    public List<ISuscriptor> getSuscriptores() {
        return suscriptores;
    }

    public void setSuscriptores(List<ISuscriptor> suscriptores) {
        this.suscriptores = suscriptores;
    }

    public boolean isTableroInvalido() {
        return tableroInvalido;
    }

    public void setTableroInvalido(boolean tableroInvalido) {
        this.tableroInvalido = tableroInvalido;
    }

    public boolean isVistaHabilitado() {
        return vistaHabilitado;
    }

    public void setVistaHabilitado(boolean vistaHabilitado) {
        this.vistaHabilitado = vistaHabilitado;
    }

    public boolean isMovimientoValido() {
        return movimientoValido;
    }

    public void setMovimientoValido(boolean movimientoValido) {
        this.movimientoValido = movimientoValido;
    }

    public String getMENSAJE_TABLERO_INVALIDO() {
        return MENSAJE_TABLERO_INVALIDO;
    }

    public void setMENSAJE_TABLERO_INVALIDO(String MENSAJE_TABLERO_INVALIDO) {
        this.MENSAJE_TABLERO_INVALIDO = MENSAJE_TABLERO_INVALIDO;
    }

    public String getMENSAJE_MOVIMIENTO_INVALIDO() {
        return MENSAJE_MOVIMIENTO_INVALIDO;
    }

    public void setMENSAJE_MOVIMIENTO_INVALIDO(String MENSAJE_MOVIMIENTO_INVALIDO) {
        this.MENSAJE_MOVIMIENTO_INVALIDO = MENSAJE_MOVIMIENTO_INVALIDO;
    }

    
    
    
    public void seleccionarFichasTablero(int[] posicionesFichas) {}

    public void quitarFichasJugador(int[] posicionesFichas) {}

    public void quitarFichasTablero(int[] idFichas) {
        tablero.quitarFichasTablero(idFichas);
        this.setMovimientoValido(false);
        this.notificar();
        
    }

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
