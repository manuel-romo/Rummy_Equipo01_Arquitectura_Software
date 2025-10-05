package ejercerTurno;

import dto.JugadorExternoPresentacionDTO;
import dto.JugadorPrincipalPresentacionDTO;
import dto.MontonPresentacionDTO;
import fachada.Fachada;
import interfaces.ITablero;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Modelo que representa la parte lógica del patrón MVC para el caso de uso "Ejercer Turno".
 * 
 * Se encarga de coordinar la comunicación entre la vista y la capa de negocio (a través de la fachada),
 * manejar el estado actual del tablero y notificar a las vistas suscritas cuando hay cambios.
 * 
 * En esta versión, la fachada funciona como un mock que simula la lógica del tablero real,
 * permitiendo probar el flujo completo del caso de uso sin depender todavía de las entidades finales.
 */
public class Modelo implements IPublicador, IModelo {

    /**
     * Referencia a la fachada que actúa como simulador del tablero.
     */
    private ITablero tablero = new Fachada();
    /**
     * Lista de suscriptores del modelo para notificar cambios a la vista.
     */
    private List<ISuscriptor> suscriptores = new ArrayList<>();
    /**
     * Indica si el tablero actual es inválido.
     */
    private boolean tableroInvalido;
    /**
     * Indica si la vista está habilitada para interactuar.
     */
    private boolean vistaHabilitado;
    /**
     * Indica si el último movimiento realizado fue inválido.
     */
    private boolean movimientoInvalido;
    /**
     * Mensaje mostrado cuando el tablero resulta inválido al finalizar un turno.
     */
    private String MENSAJE_TABLERO_INVALIDO;
    /**
     * Mensaje mostrado cuando el jugador realiza un movimiento no permitido.
     */
    private String MENSAJE_MOVIMIENTO_INVALIDO;

    /**
     * Obtiene la fachada que representa el tablero actual.
     * @return objeto que implementa {@link ITablero}.
     */
    public ITablero getTablero() {
        return tablero;
    }

    /**
     * Asigna una nueva fachada al tablero.
     * @param tablero implementación de {@link ITablero}.
     */
    public void setTablero(ITablero tablero) {
        this.tablero = tablero;
    }

    /**
     * Obtiene la lista de vistas suscritas al modelo.
     * @return lista de objetos que implementan {@link ISuscriptor}.
     */
    public List<ISuscriptor> getSuscriptores() {
        return suscriptores;
    }

    /**
     * Asigna la lista de vistas suscritas al modelo.
     * @param suscriptores lista de suscriptores.
     */
    public void setSuscriptores(List<ISuscriptor> suscriptores) {
        this.suscriptores = suscriptores;
    }

    /**
     * Indica si el tablero es inválido.
     * @return {@code true} si el tablero no cumple las reglas, {@code false} en caso contrario.
     */
    public boolean isTableroInvalido() {
        return tableroInvalido;
    }

    /**
     * Define si el tablero es inválido.
     * @param tableroInvalido valor booleano indicando si el tablero es inválido.
     */
    public void setTableroInvalido(boolean tableroInvalido) {
        this.tableroInvalido = tableroInvalido;
    }

    /**
     * Indica si la vista está habilitada para interactuar.
     * @return {@code true} si está habilitada, {@code false} en caso contrario.
     */
    public boolean isVistaHabilitado() {
        return vistaHabilitado;
    }

    /**
     * Define si la vista está habilitada para la interacción del jugador.
     * @param vistaHabilitado valor booleano que indica si la vista está activa.
     */
    public void setVistaHabilitado(boolean vistaHabilitado) {
        this.vistaHabilitado = vistaHabilitado;
    }

    /**
     * Indica si el último movimiento fue inválido.
     * @return {@code true} si el movimiento no fue válido, {@code false} en caso contrario.
     */
    public boolean isMovimientoInvalido() {
        return movimientoInvalido;
    }

    /**
     * Define si el último movimiento fue inválido.
     * @param movimientoInvalido valor booleano que indica si el movimiento fue inválido.
     */
    public void setMovimientoInvalido(boolean movimientoInvalido) {
        this.movimientoInvalido = movimientoInvalido;
    }

    /**
     * Obtiene el mensaje que se muestra cuando el tablero es inválido.
     * @return mensaje asociado al tablero inválido.
     */
    public String getMENSAJE_TABLERO_INVALIDO() {
        return MENSAJE_TABLERO_INVALIDO;
    }

    /**
     * Define el mensaje mostrado cuando el tablero es inválido.
     * @param MENSAJE_TABLERO_INVALIDO texto del mensaje de error.
     */
    public void setMENSAJE_TABLERO_INVALIDO(String MENSAJE_TABLERO_INVALIDO) {
        this.MENSAJE_TABLERO_INVALIDO = MENSAJE_TABLERO_INVALIDO;
    }

    /**
     * Obtiene el mensaje que se muestra cuando el jugador realiza un movimiento inválido.
     * @return mensaje de movimiento inválido.
     */
    public String getMENSAJE_MOVIMIENTO_INVALIDO() {
        return MENSAJE_MOVIMIENTO_INVALIDO;
    }

    /**
     * Define el mensaje que se muestra cuando el jugador realiza un movimiento inválido.
     * @param MENSAJE_MOVIMIENTO_INVALIDO texto del mensaje de error.
     */
    public void setMENSAJE_MOVIMIENTO_INVALIDO(String MENSAJE_MOVIMIENTO_INVALIDO) {
        this.MENSAJE_MOVIMIENTO_INVALIDO = MENSAJE_MOVIMIENTO_INVALIDO;
    }


    /**
     * Simula la selección de fichas del tablero.
     * @param posicionesFichas arreglo con las posiciones seleccionadas.
     */
    public void seleccionarFichasTablero(int[] posicionesFichas) {}

    /**
     * Simula la acción de quitar fichas del jugador actual.
     * @param posicionesFichas arreglo de posiciones de fichas a eliminar.
     */
    public void quitarFichasJugador(int[] posicionesFichas) {}

    /**
     * Quita fichas del tablero según los identificadores proporcionados.
     * @param idFichas colección de IDs de fichas a eliminar.
     */
    public void quitarFichasTablero(int[] idFichas) {
        tablero.quitarFichasTablero(idFichas);
        this.setMovimientoInvalido(false);
        this.notificar();
    }

    /**
     * Agrega fichas a un grupo ya existente del tablero.
     * @param idsFichas colección de IDs de fichas a agregar.
     * @param numeroGrupo número del grupo al que se agregarán las fichas.
     */
    public void agregarFichasTablero(int[] idsFichas, int numeroGrupo) {
        tablero.agregarFichasTablero(idsFichas, numeroGrupo);
        this.setMovimientoInvalido(false);
        this.notificar();
    }

    /**
     * Agrega fichas al tablero que no pertenecen a un grupo existente.
     * @param idsFichas colección de IDs de fichas a agregar.
     */
    public void agregarFichasTablero(int[] idsFichas) {
        tablero.agregarFichasTablero(idsFichas);
        this.setMovimientoInvalido(false);
        this.notificar();
    }

    /**
     * Finaliza el turno actual y pasa al siguiente jugador.
     * Si el tablero no es válido, se marca el estado correspondiente.
     */
    public void terminarTurno() {
        if (tablero.terminarTurno()) {
            this.setTableroInvalido(false);
            this.setVistaHabilitado(false);
        } else {
            this.setTableroInvalido(true);
        }
        this.notificar();
    }


    /**
     * Suscribe una nueva vista (suscriptor) al modelo.
     * @param suscriptor instancia que implementa {@link ISuscriptor}.
     */
    @Override
    public void suscribirse(ISuscriptor suscriptor) {
        suscriptores.add(suscriptor);
    }

    /**
     * Elimina una vista (suscriptor) de la lista de notificación.
     * @param suscriptor instancia que implementa {@link ISuscriptor}.
     */
    @Override
    public void desuscribirse(ISuscriptor suscriptor) {
        suscriptores.remove(suscriptor);
    }

    /**
     * Notifica a todas las vistas suscritas los cambios realizados en el modelo.
     */
    @Override
    public void notificar() {
        for (ISuscriptor suscriptor : suscriptores) {
            suscriptor.actualizar(this);
        }
    }


    @Override
    public JugadorPrincipalPresentacionDTO obtenerJugadorPrincipal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JugadorExternoPresentacionDTO[] obtenerJugadoresExternos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MontonPresentacionDTO[] obtenerMontonPresentacionDTO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String obtenerMensajeMovimientoInvalido() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String obtenerMensajeTableroInvalido() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isVistaHabilitada() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
