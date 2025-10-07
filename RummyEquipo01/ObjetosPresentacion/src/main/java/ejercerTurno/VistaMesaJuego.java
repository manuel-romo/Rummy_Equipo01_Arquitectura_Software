
package ejercerTurno;

import objetosPresentacion.PanelMovimiento;
import dto.ColorFichaPresentacionDTO;
import dto.ComodinPresentacionDTO;
import dto.FichaNormalPresentacionDTO;
import dto.FichaPresentacionDTO;
import dto.JugadorExternoPresentacionDTO;
import dto.JugadorPrincipalPresentacionDTO;
import dto.MontonPresentacionDTO;
import dto.TableroPresentacionDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import objetosPresentacion.IComponente;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import objetosPresentacion.EstadoActual;
import objetosPresentacion.FichaInformacionPanel;
import objetosPresentacion.JugadorExternoInformacionPanel;
import objetosPresentacion.JugadorPrincipalInformacionPanel;
import objetosPresentacion.MontonInformacionPanel;
import objetosPresentacion.PanelCasilla;
import objetosPresentacion.PanelFicha;
import objetosPresentacion.PanelTablero;
import objetosPresentacion.TableroInformacionPanel;
import objetosPresentacion.VisitorPintar;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */
public class VistaMesaJuego extends JFrame implements ISuscriptor, IGestorEventos{
    
    private IComponente panelMesaJuego;
    
    private Dimension tamanioVentanaVista = new Dimension(1000, 700);
    private Controlador controlador;
    
    private Color COLOR_COMODIN = Color.BLACK;
    
    private Map<Integer, Color> mapaColoresJugador;
    
    /**
     * Mapa con clave igual al id de Casilla y valor igual al id de Ficha, en el tablero.
     */
    private Map<Integer, Integer> mapaIdsCasillasFichasTablero;
    
    /**
     * Mapa con clave igual al id de Casilla y valor igual al id de Ficha, en la mano del jugador.
     */
    private Map<Integer, Integer> mapaIdsCasillasFichasMano;
    
    private boolean tableroInvalido;
    private boolean movimientoInvalido;
    
    private PanelMovimiento panelMovimiento;
    private JPanel fichaOriginal;
    private JPanel casillaOriginal;
   
    private JPanel panelCasillaEliminar;
    private JPanel panelFichaEliminar;
    
    public VistaMesaJuego(
            Controlador controlador,
            IComponente componente,
            Map<Integer, Color> mapaColoresJugador, 
            Map<Integer, Integer> mapaIdsCasillasFichasTablero, 
            Map<Integer, Integer> mapaIdsCasillasFichasMano){
        
        this.controlador = controlador;
        this.mapaColoresJugador = mapaColoresJugador;
        this.mapaIdsCasillasFichasTablero = mapaIdsCasillasFichasTablero;
        this.mapaIdsCasillasFichasMano = mapaIdsCasillasFichasMano;
        
        setSize(tamanioVentanaVista);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        agregarPanelComponente(componente);
        
        panelMovimiento = new PanelMovimiento(this);
        setGlassPane(panelMovimiento);
        
        setVisible(true);
    }
    
    public void agregarPanelComponente(IComponente componente){
        panelMesaJuego = componente;
        add((JPanel)componente);
 
    }
    
    public void seleccionarFichasTablero(int[] idsFichas){
        controlador.seleccionarFichasTablero(idsFichas);
    }
    
    public void quitarFichasJugador(int[] posicionesFichas){
        controlador.quitarFichasJugador(posicionesFichas);
    }
    
    public void quitarFichasTablero(int[] idsFichas){
        controlador.quitarFichasTablero(idsFichas);
    }
    
    public void agregarFichasTablero(int[] idsFichas, int numeroGrupo){
        controlador.agregarFichasTablero(idsFichas, numeroGrupo);
    }
    
    public void agregarFichasTablero(int[] idsFichas){
        controlador.agregarFichasTablero(idsFichas);
    }
    
    public void terminarTurno(){
        controlador.terminarTurno();
    }
    
    private void habilitarVista(boolean vistaHabilitada){
        
    }
    
    private Color determinarColor(ColorFichaPresentacionDTO colorFicha){
        
        switch (colorFicha) {
            
            case ColorFichaPresentacionDTO.COLOR_A:
                
                return mapaColoresJugador.get(1);

            case ColorFichaPresentacionDTO.COLOR_B:
                
                return mapaColoresJugador.get(2);
             
            case ColorFichaPresentacionDTO.COLOR_C:
                
                return mapaColoresJugador.get(3);
                
            case ColorFichaPresentacionDTO.COLOR_D:
                
                return mapaColoresJugador.get(4);
                
            default:
              return null;
        }
        
    }
    
    private FichaInformacionPanel[] obtenerFichasInformacionPanel(FichaPresentacionDTO[] fichas){
        
        List<FichaInformacionPanel> listaFichaInformacionPanel = new LinkedList<>();

        for(FichaPresentacionDTO ficha: fichas){
            
            if(ficha instanceof FichaNormalPresentacionDTO){
                
                FichaNormalPresentacionDTO fichaNormal = (FichaNormalPresentacionDTO) ficha;
                
                listaFichaInformacionPanel.add(new FichaInformacionPanel(
                    fichaNormal.getIdFicha(),
                    String.valueOf(fichaNormal.getValor()),
                    determinarColor(fichaNormal.getColor())
                    ));   
            } else{
                
                ComodinPresentacionDTO comodin = (ComodinPresentacionDTO) ficha;
                
                listaFichaInformacionPanel.add(new FichaInformacionPanel(
                    comodin.getIdFicha(),
                    comodin.getValor(),
                    COLOR_COMODIN));  
            }
            
        }
        
        FichaInformacionPanel[] fichasInformacionPanel = listaFichaInformacionPanel.toArray(new FichaInformacionPanel[0]);
        
        return fichasInformacionPanel;

    }
    
    private JugadorExternoInformacionPanel[] obtenerJugadoresExternoInformacion(JugadorExternoPresentacionDTO[] jugadoresExternoPresentacionDTOs){
        
        List<JugadorExternoInformacionPanel> listaJugadoresExternoInformacion = new LinkedList<>();
        
        for(JugadorExternoPresentacionDTO jugadorExternoPresentacionDTO: jugadoresExternoPresentacionDTOs){
            
            listaJugadoresExternoInformacion.add(new JugadorExternoInformacionPanel(
                    jugadorExternoPresentacionDTO.getAvatar(),
                    jugadorExternoPresentacionDTO.getNombre(),
                    String.valueOf(jugadorExternoPresentacionDTO.getFichasRestantes()),
                    jugadorExternoPresentacionDTO.getNumeroSecuencia()));
            
        }
        
        JugadorExternoInformacionPanel[] jugadoresExternoInformacion = listaJugadoresExternoInformacion.toArray(new JugadorExternoInformacionPanel[0]);
    
        return jugadoresExternoInformacion;
        
    }
    
    private JugadorPrincipalInformacionPanel obtenerJugadorPrincipalInformacionPanel(JugadorPrincipalPresentacionDTO jugadorPrincipalPresentacionDTO){
        
        FichaPresentacionDTO[] fichas = jugadorPrincipalPresentacionDTO.getFichas();
        
        JugadorPrincipalInformacionPanel jugadorPrincipalInformacionPanel 
                = new JugadorPrincipalInformacionPanel(obtenerFichasInformacionPanel(fichas), mapaIdsCasillasFichasMano);
  
        return jugadorPrincipalInformacionPanel;
        
    }
    
    private MontonInformacionPanel obtenerMontonInformacionPanel(MontonPresentacionDTO montonPresentacionDTO){
        
        MontonInformacionPanel montonInformacionPanel
                = new MontonInformacionPanel(String.valueOf(montonPresentacionDTO.getNumeroFichasMonton()));
        
        return montonInformacionPanel;
        
    }
    
    private TableroInformacionPanel obtenerTableroInformacionPanel(TableroPresentacionDTO tableroPresentacionDTO){
        
        FichaPresentacionDTO[] fichas = tableroPresentacionDTO.getFichas();
        
        TableroInformacionPanel tableroInformacionPanel 
                = new TableroInformacionPanel(obtenerFichasInformacionPanel(fichas), mapaIdsCasillasFichasTablero);
        
        return tableroInformacionPanel;
        
    }
    
    private VisitorPintar crearVisitorPintar(EstadoActual estadoActual){
        VisitorPintar visitorPintar = new VisitorPintar(estadoActual);
        return visitorPintar;
    }

    @Override
    public void actualizar(IModelo modelo) {
        JugadorPrincipalPresentacionDTO jugadorPrincipalPresentacionDTO = modelo.obtenerJugadorPrincipal();
        JugadorExternoPresentacionDTO[] jugadoresExternoPresentacionDTOs = modelo.obtenerJugadoresExternos();
        TableroPresentacionDTO tableroPresentacionDTO = modelo.obtenerTablero();
        MontonPresentacionDTO montonPresentacionDTO = modelo.obtenerMontonPresentacion();
        String mensajeMovimientoInvalido = modelo.obtenerMensajeMovimientoInvalido();
        String mensajeTableroInvalido = modelo.obtenerMensajeTableroInvalido();
        
        
        JugadorExternoInformacionPanel[] jugadoresExternosInformacionPanel 
                = obtenerJugadoresExternoInformacion(jugadoresExternoPresentacionDTOs);
        
        JugadorPrincipalInformacionPanel jugadorPrincipalInformacionPanel
                = obtenerJugadorPrincipalInformacionPanel(jugadorPrincipalPresentacionDTO);
        
        MontonInformacionPanel montonInformacionPanel = obtenerMontonInformacionPanel(montonPresentacionDTO);
        
        TableroInformacionPanel tableroInformacionPanel = obtenerTableroInformacionPanel(tableroPresentacionDTO);
        
        movimientoInvalido = mensajeMovimientoInvalido != null? true : false;
        tableroInvalido = mensajeTableroInvalido != null? true : false;
        
        EstadoActual estadoActual = new EstadoActual(
                jugadoresExternosInformacionPanel,
                jugadorPrincipalInformacionPanel,
                montonInformacionPanel,
                tableroInformacionPanel,
                mensajeMovimientoInvalido,
                mensajeTableroInvalido);
        
        quitarFichasPendientes();
        
        VisitorPintar visitorPintar = crearVisitorPintar(estadoActual);
        panelMesaJuego.aceptar(visitorPintar);
        
        repaint();
        revalidate();
    }

    @Override
    public void seleccionarFicha(MouseEvent e) {
        
        PanelFicha ficha = (PanelFicha)e.getSource();
        
        if(!ficha.isSeleccionada() && fichaOriginal == null){
            
            fichaOriginal = ficha;
            
            casillaOriginal = (JPanel)ficha.getParent();
            
            ficha.setSeleccionada(true);
            
            // Copia a arrastrar
            PanelFicha fichaReal = (PanelFicha) ficha;

            PanelFicha fichaParaArrastrar = new PanelFicha(
                this,
                fichaReal.getIdFicha(), 
                fichaReal.getValor(), 
                fichaReal.getColorValor(),
                fichaReal.isSeleccionada(),
                fichaReal.getBackground());

            fichaParaArrastrar.setSize(fichaReal.getSize());
            
            ficha.setVisible(false);
            
            panelMovimiento.iniciarArrastre(fichaParaArrastrar, e);
            
        } else{
            
            panelMovimiento.removeAll();

            ((PanelFicha)fichaOriginal).setSeleccionada(false);
            
            fichaOriginal.setVisible(true);
            
            this.fichaOriginal = null;
            
        }
        
    }

    @Override
    public void fichaPresionada(MouseEvent e) {
        
        

       
    }

    @Override
    public void fichaSoltada(MouseEvent e) {
        
        panelMovimiento.setVisible(false);

        Point dropPoint = e.getPoint();
        
        // Convierte el punto del glass pane al del content pane
        Point contentPanePoint = SwingUtilities.convertPoint(panelMovimiento, dropPoint, getContentPane());
        
        // Encuentra el componente en esa posición
        Component componenteDestino = getContentPane().findComponentAt(contentPanePoint);

        if(componenteDestino instanceof PanelCasilla){
            
            PanelCasilla panelCasillaOriginal = (PanelCasilla) casillaOriginal;
            
            PanelFicha panelFichaOriginal = (PanelFicha) fichaOriginal;
            
            PanelCasilla panelCasillDestino = (PanelCasilla) componenteDestino;
            
            agregarFichaCasilla(panelCasillDestino, fichaOriginal);
            fichaOriginal.setVisible(true);
            
        }
        
    }
    
    private void quitarFichaCasillaJugador(JPanel panelCasilla, JPanel panelFicha){
        
        Integer idCasillaQuitar = ((PanelCasilla)panelCasilla).getId();
        Integer idPanelFicha = ((PanelFicha)panelFicha).getIdFicha();
        
        int[] idsFichasAgregar = {idPanelFicha};
        quitarFichasTablero(idsFichasAgregar);
        
        panelCasilla.remove(panelFicha);
        
    }
    
    @Override
    public void quitarFichaCasillaTablero(JPanel fichaArrastrada){
        
        JPanel panelFicha = fichaArrastrada;
        
        if(fichaOriginal.getParent() != null){

            panelCasillaEliminar = (JPanel)fichaOriginal.getParent();
        
            Integer idPanelFichaEliminar = ((PanelFicha)panelFicha).getIdFicha();

            int[] fichasQuitar = {idPanelFichaEliminar};

            if(panelCasillaEliminar.getParent() instanceof PanelTablero){
                
                controlador.quitarFichasTablero(fichasQuitar);
                
            } else{
                controlador.quitarFichasJugador(fichasQuitar);
            }
            
        }
  
    }
    
    private void quitarFichasPendientes(){
        
        System.out.println(panelCasillaEliminar);
        System.out.println(movimientoInvalido);
        if(panelCasillaEliminar != null && !movimientoInvalido){
            panelCasillaEliminar.removeAll();
            mapaIdsCasillasFichasTablero.put(((PanelCasilla)panelCasillaEliminar).getId(), null);
        }
        
        
    }
    
    
    private void agregarFichaCasilla(JPanel panelCasilla, JPanel panelFicha){
        panelCasilla.add(panelFicha);

    }
    
    
    
    
    
}
