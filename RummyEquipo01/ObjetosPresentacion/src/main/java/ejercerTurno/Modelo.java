package ejercerTurno;

import dto.ColorFichaNegocioDTO;
import dto.ColorFichaPresentacionDTO;
import dto.FichaNegocioDTO;
import dto.FichaPresentacionDTO;
import dto.GrupoNegocioDTO;
import dto.JugadorExternoPresentacionDTO;
import dto.JugadorNegocioDTO;
import dto.JugadorPrincipalPresentacionDTO;
import dto.MontonNegocioDTO;
import dto.MontonPresentacionDTO;
import dto.TableroNegocioDTO;
import dto.TableroPresentacionDTO;
import fachada.Fachada;
import interfaces.ITablero;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import comunicacion.IComunicacion;
import dto.ComodinNegocioDTO;
import dto.ComodinPresentacionDTO;
import dto.FichaNormalNegocioDTO;
import dto.FichaNormalPresentacionDTO;

/**
 * Clase Modelo que representa la parte lógica del patrón MVC para el caso de
 * uso "Ejercer Turno".
 *
 * Se encarga de coordinar la comunicación entre la vista y la capa de negocio
 * (a través de la fachada), manejar el estado actual del tablero y notificar a
 * las vistas suscritas cuando hay cambios.
 *
 * En esta versión, la fachada funciona como un mock que simula la lógica del
 * tablero real, permitiendo probar el flujo completo del caso de uso sin
 * depender todavía de las entidades finales.
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
    private boolean vistaHabilitada;
    /**
     * Indica si el último movimiento realizado fue inválido.
     */
    private boolean movimientoInvalido;
    /**
     * Mensaje mostrado cuando el tablero resulta inválido al finalizar un
     * turno.
     */
    private String MENSAJE_TABLERO_INVALIDO;
    /**
     * Mensaje mostrado cuando el jugador realiza un movimiento no permitido.
     */
    private String MENSAJE_MOVIMIENTO_INVALIDO;
    
    private IComunicacion comunicacion;
    
    public Modelo(IComunicacion comunicacion){
        
        this.comunicacion = comunicacion;
        
    }

    /**
     * Obtiene la fachada que representa el tablero actual.
     *
     * @return objeto que implementa {@link ITablero}.
     */
    public ITablero getTablero() {
        return tablero;
    }

    /**
     * Asigna una nueva fachada al tablero.
     *
     * @param tablero implementación de {@link ITablero}.
     */
    public void setTablero(ITablero tablero) {
        this.tablero = tablero;
    }

    /**
     * Obtiene la lista de vistas suscritas al modelo.
     *
     * @return lista de objetos que implementan {@link ISuscriptor}.
     */
    public List<ISuscriptor> getSuscriptores() {
        return suscriptores;
    }

    /**
     * Asigna la lista de vistas suscritas al modelo.
     *
     * @param suscriptores lista de suscriptores.
     */
    public void setSuscriptores(List<ISuscriptor> suscriptores) {
        this.suscriptores = suscriptores;
    }

    /**
     * Indica si el tablero es inválido.
     *
     * @return {@code true} si el tablero no cumple las reglas, {@code false} en
     * caso contrario.
     */
    public boolean isTableroInvalido() {
        return tableroInvalido;
    }

    /**
     * Define si el tablero es inválido.
     *
     * @param tableroInvalido valor booleano indicando si el tablero es
     * inválido.
     */
    public void setTableroInvalido(boolean tableroInvalido) {
        this.tableroInvalido = tableroInvalido;
    }

    /**
     * Indica si la vista está habilitada para interactuar.
     *
     * @return {@code true} si está habilitada, {@code false} en caso contrario.
     */
    public boolean isVistaHabilitado() {
        return vistaHabilitada;
    }

    /**
     * Define si la vista está habilitada para la interacción del jugador.
     *
     * @param vistaHabilitado valor booleano que indica si la vista está activa.
     */
    public void setVistaHabilitado(boolean vistaHabilitado) {
        this.vistaHabilitada = vistaHabilitado;
    }

    /**
     * Indica si el último movimiento fue inválido.
     *
     * @return {@code true} si el movimiento no fue válido, {@code false} en
     * caso contrario.
     */
    public boolean isMovimientoInvalido() {
        return movimientoInvalido;
    }

    /**
     * Define si el último movimiento fue inválido.
     *
     * @param movimientoInvalido valor booleano que indica si el movimiento fue
     * inválido.
     */
    public void setMovimientoInvalido(boolean movimientoInvalido) {
        this.movimientoInvalido = movimientoInvalido;
    }

    /**
     * Simula la selección de fichas del tablero.
     *
     * @param posicionesFichas arreglo con las posiciones seleccionadas.
     */
    public void seleccionarFichasTablero(int[] posicionesFichas) {
        
        boolean movimientoValido = tablero.seleccionarFichasTablero(posicionesFichas);
        this.setMovimientoInvalido(!movimientoValido);
        this.notificar();
    }

    /**
     * Simula la acción de quitar fichas del jugador actual.
     *
     * @param posicionesFichas arreglo de posiciones de fichas a eliminar.
     */
    public void quitarFichasJugador(int[] posicionesFichas) {
        
        boolean movimientoValido = tablero.quitarFichasJugador(posicionesFichas);
        this.setMovimientoInvalido(!movimientoValido);
        this.notificar();
    }

    /**
     * Quita fichas del tablero según los identificadores proporcionados.
     *
     * @param idFichas colección de IDs de fichas a eliminar.
     */
    public void quitarFichasTablero(int[] idFichas) {
        boolean movimientoValido = tablero.quitarFichasTablero(idFichas);
        this.setMovimientoInvalido(!movimientoValido);
        this.notificar();
    }

    /**
     * Agrega fichas a un grupo ya existente del tablero.
     *
     * @param idsFichas colección de IDs de fichas a agregar.
     * @param numeroGrupo número del grupo al que se agregarán las fichas.
     */
    public void agregarFichasTablero(int[] idsFichas, int[] idsFichasGrupo) {
        boolean movimientoValido = tablero.agregarFichasTablero(idsFichas, idsFichasGrupo);
        this.setMovimientoInvalido(!movimientoValido);
        this.notificar();
    }

    /**
     * Agrega fichas al tablero que no pertenecen a un grupo existente.
     *
     * @param idsFichas colección de IDs de fichas a agregar.
     */
    public void agregarFichasTablero(int[] idsFichas) {
        boolean movimientoValido = tablero.agregarFichasTablero(idsFichas);
        this.setMovimientoInvalido(!movimientoValido);
        this.notificar();
    }

    public void iniciarTurno(TableroNegocioDTO tableroNegocio){
    
        tablero.iniciarTurno(tableroNegocio);
        notificar();
        
    }
    
    
    /**
     * Finaliza el turno actual y pasa al siguiente jugador. Si el tablero no es
     * válido, se marca el estado correspondiente.
     */
    public void terminarTurno() {
        if (tablero.validarGrupos()) {
            this.setTableroInvalido(false);
            this.setVistaHabilitado(false);
            
            JugadorNegocioDTO jugadorPrincipal = tablero.obtenerJugadorPrincipal();
            JugadorNegocioDTO[] jugadoresExternos = tablero.obtenerJugadoresExternos();
            MontonNegocioDTO montonNegocio = tablero.obtenerMonton();
            GrupoNegocioDTO[] gruposNegocio = tablero.obtenerGruposNegocio();
            
            TableroNegocioDTO tableroNegocio =
                    new TableroNegocioDTO(jugadorPrincipal, 
                            jugadoresExternos, 
                            gruposNegocio, 
                            montonNegocio);
            
            comunicacion.avisarFinalizacionTurno(tableroNegocio);
            
        } else {
            this.setTableroInvalido(true);
        }
        this.notificar();
        
        
    }

    /**
     * Suscribe una nueva vista (suscriptor) al modelo.
     *
     * @param suscriptor instancia que implementa {@link ISuscriptor}.
     */
    @Override
    public void suscribirse(ISuscriptor suscriptor) {
        suscriptores.add(suscriptor);
    }

    /**
     * Elimina una vista (suscriptor) de la lista de notificación.
     *
     * @param suscriptor instancia que implementa {@link ISuscriptor}.
     */
    @Override
    public void desuscribirse(ISuscriptor suscriptor) {
        suscriptores.remove(suscriptor);
    }

    /**
     * Notifica a todas las vistas suscritas los cambios realizados en el
     * modelo.
     */
    @Override
    public void notificar() {
        for (ISuscriptor suscriptor : suscriptores) {
            suscriptor.actualizar(this);
        }
    }

    @Override
    public JugadorPrincipalPresentacionDTO obtenerJugadorPrincipal() {
        
        List<FichaNegocioDTO> fichasNegocio = tablero.obtenerJugadorPrincipal().getFichas();
        
        List<FichaPresentacionDTO> fichasPresentacion = new LinkedList<>();
        
        for (FichaNegocioDTO fichaNegocioDTO : fichasNegocio) {
            
            FichaPresentacionDTO fichaPresentacion = obtenerFichaPresentacionDTO(fichaNegocioDTO);
            fichasPresentacion.add(fichaPresentacion);
            
        }
        
        FichaPresentacionDTO[] fichasArreglo = fichasPresentacion.toArray(new FichaPresentacionDTO[0]);
        
        return new JugadorPrincipalPresentacionDTO(fichasArreglo);
    }

    @Override
    public MontonPresentacionDTO obtenerMontonPresentacion() {
        
        return obtenerMontonPresentacionDTO(tablero.obtenerMonton());
        
    }
    
    private MontonPresentacionDTO obtenerMontonPresentacionDTO(MontonNegocioDTO montonNegocioDTO){
        
        return new MontonPresentacionDTO(montonNegocioDTO.getFichas().size());
        
    }

    @Override
    public String obtenerMensajeMovimientoInvalido() {
        
        if(movimientoInvalido){
            return MENSAJE_MOVIMIENTO_INVALIDO;
        }
        
        return null;
    }

    @Override
    public String obtenerMensajeTableroInvalido() {
        
        if(tableroInvalido){
            return MENSAJE_TABLERO_INVALIDO;
        }
        
        return null;
    }

    @Override
    public boolean isVistaHabilitada() {
        return vistaHabilitada;
    }

    @Override
    public JugadorExternoPresentacionDTO[] obtenerJugadoresExternos() {
        
        JugadorNegocioDTO[] jugadoresExternosNegocio = tablero.obtenerJugadoresExternos();
        
        List<JugadorExternoPresentacionDTO> jugadoresExternosPresentacionDTO = new LinkedList<>();
        
        for(JugadorNegocioDTO jugadorExternoNegocio: jugadoresExternosNegocio){

            List<FichaNegocioDTO> fichasNegocio = jugadorExternoNegocio.getFichas();
           
            int cantidadFichasRestante = fichasNegocio.size();
            
            jugadoresExternosPresentacionDTO.add(new JugadorExternoPresentacionDTO(
                    jugadorExternoNegocio.getAvatar(), 
                    jugadorExternoNegocio.getNombre(),
                    cantidadFichasRestante));
            
        }

        JugadorExternoPresentacionDTO[] jugadoresExternosPresentacion 
                = jugadoresExternosPresentacionDTO.toArray(new JugadorExternoPresentacionDTO[0]);
        
        return jugadoresExternosPresentacion;
        
 
    }

    @Override
    public TableroPresentacionDTO obtenerTablero() {
        
        GrupoNegocioDTO[] gruposNegocio = tablero.obtenerGruposNegocio();
        
        System.out.println("Cantidad de grupos obtenidos");
        System.out.println(gruposNegocio.length);
        
        List<FichaPresentacionDTO> fichasPresentacion = new LinkedList<>();
        
        for(GrupoNegocioDTO grupoNegocio: gruposNegocio){
            
            List<FichaNegocioDTO> fichasNegocio = grupoNegocio.getFichasNegocioDTO();
            
            for(FichaNegocioDTO fichaNegocioDTO: fichasNegocio){
                
                fichasPresentacion.add(obtenerFichaPresentacionDTO(fichaNegocioDTO));
                
            }
            
        }
        
        TableroPresentacionDTO tableroPresentacion 
                = new TableroPresentacionDTO(fichasPresentacion.toArray(new FichaPresentacionDTO[0]));
        
        return tableroPresentacion;
        
    }
    
    private FichaPresentacionDTO obtenerFichaPresentacionDTO(FichaNegocioDTO fichaNegocioDTO){
        
        FichaPresentacionDTO fichaPresentacionDTO;
        
        if(fichaNegocioDTO instanceof FichaNormalNegocioDTO){
            
            FichaNormalNegocioDTO fichaNormalNegocio = (FichaNormalNegocioDTO) fichaNegocioDTO;
            
            ColorFichaNegocioDTO colorFichaNegocio = fichaNormalNegocio.getColor();
            ColorFichaPresentacionDTO colorFichaPresentacion;

            switch (colorFichaNegocio) {

                case ColorFichaNegocioDTO.COLOR_A:
                    colorFichaPresentacion = ColorFichaPresentacionDTO.COLOR_A;
                    break;
                case ColorFichaNegocioDTO.COLOR_B:
                    colorFichaPresentacion = ColorFichaPresentacionDTO.COLOR_B;
                    break;   
                case ColorFichaNegocioDTO.COLOR_C:
                    colorFichaPresentacion = ColorFichaPresentacionDTO.COLOR_C;
                    break;  
                case ColorFichaNegocioDTO.COLOR_D:
                    colorFichaPresentacion = ColorFichaPresentacionDTO.COLOR_D;
                    break;

                default:
                    throw new AssertionError();
            }
        
        fichaPresentacionDTO = new FichaNormalPresentacionDTO(
                fichaNormalNegocio.getNumero(), 
                fichaNormalNegocio.getId(),
                colorFichaPresentacion);
        
            
        } else{
            
            ComodinNegocioDTO comodinNegocioDTO = (ComodinNegocioDTO) fichaNegocioDTO;
             
            fichaPresentacionDTO = new ComodinPresentacionDTO(
                comodinNegocioDTO.getValor(), 
                comodinNegocioDTO.getId());
            
        }
        
        
        
        return fichaPresentacionDTO;
        
    }


}
