
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
import objetosPresentacion.PanelJugadorPrincipal;
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
    private JPanel fichaMover;
    private JPanel casillaOriginal;
   
    private JPanel panelCasillaEliminar;
    
    private JPanel panelCasillaAgregar;
    private JPanel panelCasillaAgregarDerecha;
    private JPanel panelCasillaAgregarIzquierda;
    
    private boolean comprobacionPendienteAgregarDerecha = false;
    private boolean comprobacionPendienteAgregarIzquierda = false;
    
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
        this.setVisible(vistaHabilitada);
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
                = new JugadorPrincipalInformacionPanel(obtenerFichasInformacionPanel(fichas), 
                        mapaIdsCasillasFichasMano);
  
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
        
        quitarFichasPendientes();
        
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
        
        
        VisitorPintar visitorPintar = crearVisitorPintar(estadoActual);
        panelMesaJuego.aceptar(visitorPintar);
        
        repaint();
        revalidate();
        
        
        
            
    }

    @Override
    public void seleccionarFicha(MouseEvent e) {
        
        PanelFicha ficha = (PanelFicha)e.getSource();
        
        if(!ficha.isSeleccionada() && fichaMover == null){
            
            fichaMover = ficha;
            
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

            ficha.setSeleccionada(false);
            
            ficha.setVisible(true);
            
            this.fichaMover = null;
            
        }
        
    }

    @Override
    public void fichaSoltada(MouseEvent e) {
        
        Point dropPoint = e.getPoint();
        
        Point contentPanePoint = SwingUtilities.convertPoint(panelMovimiento, dropPoint, getContentPane());
        
        Component componenteDestino = getContentPane().findComponentAt(contentPanePoint);
        

        if(componenteDestino instanceof PanelCasilla || componenteDestino instanceof PanelFicha){
            
            if(componenteDestino instanceof PanelCasilla){
                
                PanelCasilla casillaDestino = (PanelCasilla)componenteDestino;
                
                if(casillaDestino.getComponentCount() > 0){
                    
                    System.out.println("Error");
                    
                } else{
                    
                    int nuevoValorX;
                    int nuevoValorY;
                    
                    nuevoValorX = panelCasillaAgregar.getWidth() + panelCasillaAgregar.getWidth()/2;
                    nuevoValorY = dropPoint.y + panelCasillaAgregar.getHeight()/2;
                    
                    Point contentPanePointDerecha = new Point(nuevoValorX, nuevoValorY);
                    
                    Component componenteDestinoDerecha = getContentPane().findComponentAt(contentPanePointDerecha);
                    
                    if(componenteDestinoDerecha != null){
                        panelCasillaAgregarDerecha = (JPanel)componenteDestinoDerecha;
                        comprobacionPendienteAgregarDerecha = true;
                    }
                    
                    nuevoValorX = panelCasillaAgregar.getWidth() - panelCasillaAgregar.getWidth()/2;
                    nuevoValorY = dropPoint.y + panelCasillaAgregar.getHeight()/2;
                    
                    Point contentPanePointIzquierda = new Point(nuevoValorX, nuevoValorY);
                    
                    Component componenteDestinoIzquierda = getContentPane().findComponentAt(contentPanePointIzquierda);
                    
                    if(componenteDestinoIzquierda != null){
                        panelCasillaAgregarIzquierda = (JPanel)componenteDestinoIzquierda;
                        comprobacionPendienteAgregarIzquierda = true;
                    }
                }
                
                
            } else{
                
                System.out.println("Error");
                
            }
            
//            
//            PanelCasilla panelCasillaOriginal = (PanelCasilla) casillaOriginal;
//            
//            PanelFicha panelFichaOriginal = (PanelFicha) fichaMover;
//            
//            PanelCasilla panelCasillDestino = (PanelCasilla) componenteDestino;
//            
//            agregarFichaCasilla(panelCasillDestino, fichaMover);
//            fichaMover.setVisible(true);
            
        }
        
        panelMovimiento.setVisible(false);
        
    }
    
    
    private void agregarFichasPendientes(){
        
        if(!comprobacionPendienteAgregarDerecha && !comprobacionPendienteAgregarIzquierda){
            
        } else if(comprobacionPendienteAgregarDerecha){
            
        } else if(comprobacionPendienteAgregarIzquierda){
            
        } else{
            
        }
        
        
    }
    
    @Override
    public void quitarFichaCasilla(JPanel fichaArrastrada){

        JPanel panelFicha = fichaArrastrada;
        
        if(fichaMover.getParent() != null){

            panelCasillaEliminar = (JPanel)fichaMover.getParent();
        
            Integer idPanelFichaEliminar = ((PanelFicha)panelFicha).getIdFicha();

            int[] fichasQuitar = {idPanelFichaEliminar};

            if(panelCasillaEliminar.getParent() instanceof PanelTablero){
                
                
                controlador.quitarFichasTablero(fichasQuitar);
                
            } else if(panelCasillaEliminar.getParent() instanceof PanelJugadorPrincipal){
                controlador.quitarFichasJugador(fichasQuitar);
            }
            
        }
  
    }
    
    private void quitarFichasPendientes(){
        
        if(panelCasillaEliminar != null && !movimientoInvalido){
            
            if(panelCasillaEliminar.getParent() instanceof PanelJugadorPrincipal){
                mapaIdsCasillasFichasMano.replace(((PanelCasilla)panelCasillaEliminar).getId(), null);  
                
            } else if (panelCasillaEliminar.getParent() instanceof PanelTablero){
                mapaIdsCasillasFichasTablero.replace(((PanelCasilla)panelCasillaEliminar).getId(), null);
            }
            
        }
        
    }
    
    
    
//    private void agregarFichasPendientes(){
//         
//        Integer idCasillaDestino = ((PanelCasilla)panelCasillaAgregar).getId();
//        Integer idFichaAgregar = ((PanelFicha)fichaMover).getIdFicha();
//
//        mapaIdsCasillasFichasTablero.replace(idCasillaDestino, idFichaAgregar);
//
//    }
    
    
    
    
    
}
