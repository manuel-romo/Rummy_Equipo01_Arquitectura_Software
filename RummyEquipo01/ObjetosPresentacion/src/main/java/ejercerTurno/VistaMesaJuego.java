
package ejercerTurno;

import dto.ColorFichaPresentacionDTO;
import dto.ComodinPresentacionDTO;
import dto.FichaNormalPresentacionDTO;
import dto.FichaPresentacionDTO;
import dto.JugadorExternoPresentacionDTO;
import dto.JugadorPrincipalPresentacionDTO;
import dto.MontonPresentacionDTO;
import dto.TableroPresentacionDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;
import objetosPresentacion.IComponente;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import objetosPresentacion.EstadoActual;
import objetosPresentacion.FichaInformacionPanel;
import objetosPresentacion.JugadorExternoInformacionPanel;
import objetosPresentacion.JugadorPrincipalInformacionPanel;
import objetosPresentacion.MontonInformacionPanel;
import objetosPresentacion.TableroInformacionPanel;
import objetosPresentacion.VisitorPintar;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 * 
 */
public class VistaMesaJuego extends JFrame implements ISuscriptor, IReceptorEventos{
    
    private List<IComponente> componentes = new LinkedList<>();
    
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
    private Map<Integer, Integer> mapaIdsCasillasFichasJugador;
    
    private Integer[] idsCasillasAgregarTablero;
    private Integer[] idsCasillasQuitarTablero;
    
    private Integer[] idsCasillasQuitarJugador;
    
    private Integer[] idsFichasAgregar;
    
    private boolean tableroInvalido;
    private boolean movimientoInvalido;
    
    public VistaMesaJuego(
            Controlador controlador,
            IComponente componente,
            IComponente componenteGlassPane,
            Map<Integer, Color> mapaColoresJugador, 
            Map<Integer, Integer> mapaIdsCasillasFichasTablero, 
            Map<Integer, Integer> mapaIdsCasillasFichasMano){
        
        this.controlador = controlador;
        this.mapaColoresJugador = mapaColoresJugador;
        this.mapaIdsCasillasFichasTablero = mapaIdsCasillasFichasTablero;
        this.mapaIdsCasillasFichasJugador = mapaIdsCasillasFichasMano;
        
        setSize(tamanioVentanaVista);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        agregarPanelComponente(componente);
        agregarGlassPane(componenteGlassPane);
        
        agregarComponente(componente);
        agregarComponente(componenteGlassPane);
           
        setVisible(true);
    }
    
    public void agregarPanelComponente(IComponente componente){
        add((JPanel)componente);
 
    }
    
    public void agregarGlassPane(IComponente componente){
        this.setGlassPane((JPanel)componente);
    }
    
    public void agregarComponente(IComponente componente){
        componentes.add(componente);
    }

    
    @Override
    public void quitarFichasJugador(Integer[] idsCasillas, Integer[] posicionesFichas){
        
        idsCasillasQuitarJugador = idsCasillas;
        
        controlador.quitarFichasJugador(posicionesFichas);
    }
    
    @Override
    public void quitarFichasTablero(Integer[] idsCasillas, Integer[] idsFichas){
        
        idsCasillasQuitarTablero = idsCasillas;
        
        controlador.quitarFichasTablero(idsFichas);
    }
    
    @Override
    public void agregarFichasTablero(Integer[] idsCasillas, Integer[] idsFichas, Integer[] idsFichasGrupo){
        idsCasillasAgregarTablero = idsCasillas;
        idsFichasAgregar = idsFichas;
        
        controlador.agregarFichasTablero(idsFichas, idsFichasGrupo);
    }
    
    @Override
    public void agregarFichasTablero(Integer[] idsCasillas, Integer[] idsFichas){
        idsCasillasAgregarTablero = idsCasillas;
        idsFichasAgregar = idsFichas;
        
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
        
        System.out.println("FICHAS JUGADOR PRINCIPAL");
        for(FichaPresentacionDTO f: fichas){
            System.out.println(f.getIdFicha());
        }
        System.out.println("************************");
        
        
        JugadorPrincipalInformacionPanel jugadorPrincipalInformacionPanel 
                = new JugadorPrincipalInformacionPanel(obtenerFichasInformacionPanel(fichas), 
                        mapaIdsCasillasFichasJugador);
  
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
  
        actualizarMapaCasillasFichas(!movimientoInvalido);
        
        EstadoActual estadoActual = new EstadoActual(
                jugadoresExternosInformacionPanel,
                jugadorPrincipalInformacionPanel,
                montonInformacionPanel,
                tableroInformacionPanel,
                mensajeMovimientoInvalido,
                mensajeTableroInvalido,
                !movimientoInvalido);
        
        
        VisitorPintar visitorPintar = crearVisitorPintar(estadoActual);
        
        for(IComponente componente: componentes){
            componente.aceptar(visitorPintar);
        }
        repaint();
        revalidate();
      
    }
    
    private void actualizarMapaCasillasFichas(boolean movimientoValido){
        
        if(movimientoValido){

            if(idsFichasAgregar != null && idsCasillasAgregarTablero != null){
                
                for(int i = 0; i < idsFichasAgregar.length; i++){

                    mapaIdsCasillasFichasTablero.put(idsCasillasAgregarTablero[i], idsFichasAgregar[i]);

                }

                idsCasillasAgregarTablero = null;

                idsFichasAgregar = null;

                
            }
            
            else if(idsCasillasQuitarTablero != null){
                
                for(int i = 0; i < idsCasillasQuitarTablero.length; i++){
                        
                    mapaIdsCasillasFichasTablero.remove(idsCasillasQuitarTablero[i]);

                }

                idsCasillasQuitarTablero = null;
                
            } else if(idsCasillasQuitarJugador != null){

                System.out.println("QUINTANDO CASILLAS");
                for(int i = 0; i < idsCasillasQuitarJugador.length; i++){

                    System.out.println(idsCasillasQuitarJugador[i]);
                    mapaIdsCasillasFichasJugador.remove(idsCasillasQuitarJugador[i]);

                }

                idsCasillasQuitarJugador = null;
                
            }
            
            
        }
        
        
    }
    
}
