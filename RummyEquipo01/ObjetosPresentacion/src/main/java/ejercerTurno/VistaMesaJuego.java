
package ejercerTurno;

import dto.ColorFicha;
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
public class VistaMesaJuego extends JFrame implements ISuscriptor{
    
    private IComponente panelMesaJuego;
    
    private Dimension tamanioVentanaVista = new Dimension(1000, 700);
    private Controlador controlador;
    
    private Map<Integer, FichaPresentacionDTO> mapaFichasCasillasTablero;
    private Map<Integer, FichaPresentacionDTO> mapaFichasCasillasJugador;
    
    private Map<Integer, Color> mapaColoresJugador;
    
//    private Map<Integer, FichaInformacionPanel> mapaCasillasFichas;
    
    public VistaMesaJuego(IComponente componente){
        
        setSize(tamanioVentanaVista);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        agregarPanelComponente(componente);
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
    
    private Color determinarColor(ColorFicha colorFicha){
        
        switch (colorFicha) {
            
            case ColorFicha.COLOR_A:
                
                return mapaColoresJugador.get(1);

            case ColorFicha.COLOR_B:
                
                return mapaColoresJugador.get(2);
             
            case ColorFicha.COLOR_C:
                
                return mapaColoresJugador.get(3);
                
            case ColorFicha.COLOR_D:
                
                return mapaColoresJugador.get(4);
                
            default:
              return null;
        }
        
    }
    
    private FichaInformacionPanel[] obtenerFichasInformacionPanel(FichaPresentacionDTO[] fichas){
        
        List<FichaInformacionPanel> listaFichaInformacionPanel = new LinkedList<>();

        for(FichaPresentacionDTO ficha: fichas){
            
            listaFichaInformacionPanel.add(new FichaInformacionPanel(
                    String.valueOf(ficha.getValor()),
                    determinarColor(ficha.getColor())
                    ));   
        }
        
        FichaInformacionPanel[] fichasInformacionPanel = (FichaInformacionPanel[])listaFichaInformacionPanel.toArray();
        
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
        
        JugadorExternoInformacionPanel[] jugadoresExternoInformacion = (JugadorExternoInformacionPanel[])listaJugadoresExternoInformacion.toArray();
    
        return jugadoresExternoInformacion;
        
    }
    
    private JugadorPrincipalInformacionPanel obtenerJugadorPrincipalInformacionPanel(JugadorPrincipalPresentacionDTO jugadorPrincipalPresentacionDTO){
        
        FichaPresentacionDTO[] fichas = jugadorPrincipalPresentacionDTO.getFichas();
        
        JugadorPrincipalInformacionPanel jugadorPrincipalInformacionPanel 
                = new JugadorPrincipalInformacionPanel(obtenerFichasInformacionPanel(fichas));
  
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
                = new TableroInformacionPanel(obtenerFichasInformacionPanel(fichas));
  
        return tableroInformacionPanel;
        
    }
    
    private VisitorPintar crearVisitorPintar(EstadoActual estadoActual){
        VisitorPintar visitorPintar = new VisitorPintar(estadoActual);
        return visitorPintar;
    }

    @Override
    public void actualizar(IModelo modelo) {
        
        modelo.obtenerJugadorPrincipal();
        modelo.obtenerJugadoresExternos();
        modelo.obtenerMensajeMovimientoInvalido();
        modelo.obtenerMensajeTableroInvalido();
        modelo.obtenerMontonPresentacion();
        
        FichaPresentacionDTO[] fichasPresentacionJugadorPrincipal = {
            new FichaPresentacionDTO(1, 2, ColorFicha.COLOR_A),
            new FichaPresentacionDTO(2, 12, ColorFicha.COLOR_B),
            new FichaPresentacionDTO(3, 1, ColorFicha.COLOR_B),
            new FichaPresentacionDTO(4, 13, ColorFicha.COLOR_C),
            new FichaPresentacionDTO(5, 3, ColorFicha.COLOR_A),
            new FichaPresentacionDTO(6, 4, ColorFicha.COLOR_A),
            new FichaPresentacionDTO(7, 8, ColorFicha.COLOR_C),
            new FichaPresentacionDTO(8, 10, ColorFicha.COLOR_B),
            new FichaPresentacionDTO(9, 10, ColorFicha.COLOR_A),
            new FichaPresentacionDTO(10, 2, ColorFicha.COLOR_A),
            new FichaPresentacionDTO(11, 4, ColorFicha.COLOR_A),
            new FichaPresentacionDTO(12, 10, ColorFicha.COLOR_B),
            new FichaPresentacionDTO(13, 1, ColorFicha.COLOR_B),
            new FichaPresentacionDTO(14, 1, ColorFicha.COLOR_B)
        
        };
        
        
        JugadorExternoPresentacionDTO jugadorExternoPresentacion1DTO = new JugadorExternoPresentacionDTO(
                "/avatar1", "Lucas12", 14);
        
        JugadorExternoPresentacionDTO jugadorExternoPresentacion2DTO = new JugadorExternoPresentacionDTO(
                "/avatar2", "Sandy43", 14);
        
        JugadorExternoPresentacionDTO jugadorExternoPresentacion3DTO = new JugadorExternoPresentacionDTO(
                "/avatar3", "Juan27", 14);
        
        JugadorExternoPresentacionDTO[] jugadoresExternoPresentacionDTOs = {
            jugadorExternoPresentacion1DTO, 
            jugadorExternoPresentacion2DTO, 
            jugadorExternoPresentacion3DTO};
        
        JugadorPrincipalPresentacionDTO jugadorPrincipalPresentacionDTO 
        = new JugadorPrincipalPresentacionDTO(fichasPresentacionJugadorPrincipal);
        
        
        MontonPresentacionDTO montonPresentacionDTO = new MontonPresentacionDTO(48);
        
        
        FichaPresentacionDTO[] fichasPresentacionTablero = {
            new FichaPresentacionDTO(15, 12, ColorFicha.COLOR_A),
            new FichaPresentacionDTO(16, 5, ColorFicha.COLOR_D),
            new FichaPresentacionDTO(17, 8, ColorFicha.COLOR_B),
            new FichaPresentacionDTO(18, 1, ColorFicha.COLOR_C),
            new FichaPresentacionDTO(19, 13, ColorFicha.COLOR_D),
            new FichaPresentacionDTO(20, 10, ColorFicha.COLOR_A),
            new FichaPresentacionDTO(21, 2, ColorFicha.COLOR_A),
            new FichaPresentacionDTO(22, 7, ColorFicha.COLOR_B),
            new FichaPresentacionDTO(23, 11, ColorFicha.COLOR_A),
            new FichaPresentacionDTO(24, 4, ColorFicha.COLOR_B),
            new FichaPresentacionDTO(25, 9, ColorFicha.COLOR_D),
            new FichaPresentacionDTO(26, 6, ColorFicha.COLOR_A),
            new FichaPresentacionDTO(27, 3, ColorFicha.COLOR_B),
            new FichaPresentacionDTO(28, 1, ColorFicha.COLOR_A),
            new FichaPresentacionDTO(29, 13, ColorFicha.COLOR_B),
            new FichaPresentacionDTO(30, 5, ColorFicha.COLOR_C),
            new FichaPresentacionDTO(31, 10, ColorFicha.COLOR_C),
            new FichaPresentacionDTO(32, 8, ColorFicha.COLOR_A),
            new FichaPresentacionDTO(33, 4, ColorFicha.COLOR_B),
            new FichaPresentacionDTO(34, 2, ColorFicha.COLOR_C)
        };
        
        TableroPresentacionDTO tableroPresentacionDTO = new TableroPresentacionDTO(fichasPresentacionTablero);
        
        String mensajeMovimientoInvalido = null;
        String mensajeTableroInvalido = null;
        
        // -----------------------------------------------------------------------------
        
        
        
        JugadorExternoInformacionPanel[] jugadoresExternosInformacionPanel 
                = obtenerJugadoresExternoInformacion(jugadoresExternoPresentacionDTOs);
        
        JugadorPrincipalInformacionPanel jugadorPrincipalInformacionPanel
                = obtenerJugadorPrincipalInformacionPanel(jugadorPrincipalPresentacionDTO);
        
        MontonInformacionPanel montonInformacionPanel = obtenerMontonInformacionPanel(montonPresentacionDTO);
        
        TableroInformacionPanel tableroInformacionPanel = obtenerTableroInformacionPanel(tableroPresentacionDTO);
        
        EstadoActual estadoActual = new EstadoActual(
                jugadoresExternosInformacionPanel,
                jugadorPrincipalInformacionPanel,
                montonInformacionPanel,
                tableroInformacionPanel,
                mensajeMovimientoInvalido,
                mensajeTableroInvalido);
        
        VisitorPintar visitorPintar = crearVisitorPintar(estadoActual);
        panelMesaJuego.aceptar(visitorPintar);
    }
    
    
}
