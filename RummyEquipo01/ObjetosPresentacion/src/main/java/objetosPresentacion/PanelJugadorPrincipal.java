
package objetosPresentacion;

import dto.FichaPresentacionDTO;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JPanel;
import objetosPresentacion.FichaInformacionPanel;


public class PanelJugadorPrincipal extends JPanel implements IComponente{

    
    private Color COLOR_FONDO = new Color(45, 54, 140);
    private Color COLOR_FONDO_MANO = new Color(69, 42, 32);
    
    private Insets SEPARACION_CASILLAS = new Insets(4, 4, 0, 4);
    
    private final PosicionPanel POSICION_PANEL = PosicionPanel.ABAJO_CENTRO;
    
    private PanelCasilla[] panelesCasillas;
    
    private JPanel panelManoFichas = new JPanel();
    private JPanel panelOpciones = new JPanel();
    
    private JPanel panelSuperiorFichas = new JPanel();
    private JPanel panelInferiorFichas = new JPanel();
    
    private JPanel panelEsquinaSuperiorDerechaMano = new JPanel();
    private JPanel panelEsquinaSuperiorIzquierdaMano = new JPanel();
    
    private JButton botonTerminarTurno = new JButton("Terminar turno");
    private JButton botonFinalizarPartida = new JButton("Finalizar partida");
    private JButton botonAbandonar = new JButton("Abandonar");
    
    private Map<Integer, Integer> mapaCasillasFichas;
    
    private IGestorEventos gestorEventos;
    
    private boolean enTurno;
    
    public PanelJugadorPrincipal(PanelCasilla[] panelesCasillas){
        
        this.panelesCasillas = panelesCasillas;
        
        setBackground(COLOR_FONDO);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        
        configurarPanelManoFichas();
        configurarPanelesMano();
        configurarPanelOpciones();
        configurarBotonesOpciones();
    }
    
    public void setGestorEventos(IGestorEventos gestorEventos){
        this.gestorEventos = gestorEventos;
    }
    
    private void configurarPanelManoFichas(){
        
        GridBagConstraints gridBagConstraintsPanelMano = new GridBagConstraints();
        
        gridBagConstraintsPanelMano.gridx = 1;
        gridBagConstraintsPanelMano.gridy = 0;
        gridBagConstraintsPanelMano.weightx = 1;
        gridBagConstraintsPanelMano.weighty = 1;
        gridBagConstraintsPanelMano.gridwidth = 1;
        gridBagConstraintsPanelMano.gridheight = 2;
        gridBagConstraintsPanelMano.fill = GridBagConstraints.BOTH;
        add(panelManoFichas, gridBagConstraintsPanelMano);
        
        panelManoFichas.setLayout(new GridBagLayout());
        panelManoFichas.setOpaque(false);
        
    }
    
    private void configurarPanelOpciones(){
        GridBagConstraints gbcPanelOpciones = new GridBagConstraints();
        
        gbcPanelOpciones.gridx = 2;
        gbcPanelOpciones.gridy = 0;
        gbcPanelOpciones.weightx = 7;
        gbcPanelOpciones.weighty = 1;
        gbcPanelOpciones.gridwidth = 1;
        gbcPanelOpciones.gridheight = 1;
        gbcPanelOpciones.fill = GridBagConstraints.BOTH;
        
        add(panelOpciones, gbcPanelOpciones);
        
        panelOpciones.setLayout(new GridBagLayout());
    }
    
    private void configurarPanelesMano(){
        
        GridBagConstraints gbcPanelSuperiorFichas = new GridBagConstraints();
        
        gbcPanelSuperiorFichas.gridx = 1;
        gbcPanelSuperiorFichas.gridy = 0;
        gbcPanelSuperiorFichas.weightx = 1;
        gbcPanelSuperiorFichas.weighty = 1;
        gbcPanelSuperiorFichas.gridwidth = 1;
        gbcPanelSuperiorFichas.gridheight = 1;
        gbcPanelSuperiorFichas.fill = GridBagConstraints.BOTH;
        
        panelManoFichas.add(panelSuperiorFichas, gbcPanelSuperiorFichas);
         
        panelSuperiorFichas.setLayout(new GridBagLayout());
        panelSuperiorFichas.setBackground(COLOR_FONDO_MANO);
        
        
        
        GridBagConstraints gbcPanelInferiorFichas = new GridBagConstraints();
        
        gbcPanelInferiorFichas.gridx = 0;
        gbcPanelInferiorFichas.gridy = 1;
        gbcPanelInferiorFichas.weightx = 0.7;
        gbcPanelInferiorFichas.weighty = 1;
        gbcPanelInferiorFichas.gridwidth = 3;
        gbcPanelInferiorFichas.gridheight = 1;
        gbcPanelInferiorFichas.fill = GridBagConstraints.BOTH;
        
        panelManoFichas.add(panelInferiorFichas, gbcPanelInferiorFichas);
        
        panelInferiorFichas.setLayout(new GridBagLayout());
        panelInferiorFichas.setBackground(COLOR_FONDO_MANO);

       
        
        GridBagConstraints gbcPanelEsquinaSuperiorDerecha = new GridBagConstraints();
        
        gbcPanelEsquinaSuperiorDerecha.gridx = 0;
        gbcPanelEsquinaSuperiorDerecha.gridy = 0;
        gbcPanelEsquinaSuperiorDerecha.weightx = 3;
        gbcPanelEsquinaSuperiorDerecha.weighty = 1;
        gbcPanelEsquinaSuperiorDerecha.gridwidth = 1;
        gbcPanelEsquinaSuperiorDerecha.gridheight = 1;
        gbcPanelEsquinaSuperiorDerecha.fill = GridBagConstraints.BOTH;
        
        panelManoFichas.add(panelEsquinaSuperiorDerechaMano, gbcPanelEsquinaSuperiorDerecha);
        panelEsquinaSuperiorDerechaMano.setOpaque(false);
        
        GridBagConstraints gbcPanelEsquinaSuperiorIzquierda = new GridBagConstraints();
        
        gbcPanelEsquinaSuperiorIzquierda.gridx = 2;
        gbcPanelEsquinaSuperiorIzquierda.gridy = 0;
        gbcPanelEsquinaSuperiorIzquierda.weightx = 3;
        gbcPanelEsquinaSuperiorIzquierda.weighty = 1;
        gbcPanelEsquinaSuperiorIzquierda.gridwidth = 1;
        gbcPanelEsquinaSuperiorIzquierda.gridheight = 1;
        gbcPanelEsquinaSuperiorIzquierda.fill = GridBagConstraints.BOTH;
        
        panelManoFichas.add(panelEsquinaSuperiorIzquierdaMano, gbcPanelEsquinaSuperiorIzquierda);
        panelEsquinaSuperiorIzquierdaMano.setOpaque(false);
        
        
        int cantidadFichasPanelInferior = 0;
        int cantidadFichasPanelSuperior = 0;
        
        for(PanelCasilla panelCasilla: panelesCasillas){
            
            if(cantidadFichasPanelInferior < 8){
                
                GridBagConstraints gbcPanelFichaActual = new GridBagConstraints();
        
                gbcPanelFichaActual.gridx = cantidadFichasPanelInferior;
                gbcPanelFichaActual.gridy = 1;
                gbcPanelFichaActual.fill = GridBagConstraints.BOTH;

                gbcPanelFichaActual.insets = SEPARACION_CASILLAS;
                panelInferiorFichas.add(panelCasilla, gbcPanelFichaActual);
        
                cantidadFichasPanelInferior++;
                
            } else{
                
                GridBagConstraints gbcPanelFichaActual = new GridBagConstraints();
        
                gbcPanelFichaActual.gridx = cantidadFichasPanelSuperior;
                gbcPanelFichaActual.gridy = 0;
                gbcPanelFichaActual.fill = GridBagConstraints.BOTH;

                gbcPanelFichaActual.insets = SEPARACION_CASILLAS;
                panelSuperiorFichas.add(panelCasilla, gbcPanelFichaActual);
                
                cantidadFichasPanelSuperior++;
            }
            
        }
        
    }
    
    private void agregarFichasMano(FichaInformacionPanel[] fichas){

        for(Map.Entry<Integer, Integer> entrada: mapaCasillasFichas.entrySet()){
            
            PanelCasilla panelCasilla = obtenerCasillaPorId(entrada.getKey());

            FichaInformacionPanel ficha = obtenerInformacionFichaPorId(entrada.getValue(), fichas);

            
            if(ficha != null){
                PanelFicha panelFicha = new PanelFicha(
                    gestorEventos, 
                    ficha.getId(), 
                    ficha.getValor(), 
                    ficha.getColor(),
                    false);

                panelCasilla.agregarFicha(panelFicha);
            }
            
            
        }
        
        for(PanelCasilla panelCasilla: panelesCasillas){
            
            if(!mapaCasillasFichas.keySet().contains(panelCasilla.getId())){
                
                panelCasilla.removeAll();
                
            }
            
        }
            
            

    }
    
    private PanelCasilla obtenerCasillaPorId(Integer idCasilla){
        
        for(PanelCasilla panelCasilla: panelesCasillas){
            
            if(panelCasilla.getId().equals(idCasilla)){
                panelCasilla.removeAll();
                return panelCasilla;
            }
        }
        return null;
    }
    
    
    private FichaInformacionPanel obtenerInformacionFichaPorId(Integer idFicha, FichaInformacionPanel[] fichas){
        
        for(FichaInformacionPanel ficha: fichas){

            if(ficha.getId().equals(idFicha)){
                return ficha;
            }
                
        }
        
        return null;
        
    }
   
    
    private void configurarBotonesOpciones(){
        
        GridBagConstraints gbcBtnTerminarTurno = new GridBagConstraints();
        
        gbcBtnTerminarTurno.gridx = 0;
        gbcBtnTerminarTurno.gridy = 0;
        gbcBtnTerminarTurno.weightx = 1;
        gbcBtnTerminarTurno.weighty = 1;
        gbcBtnTerminarTurno.gridwidth = 2;
        gbcBtnTerminarTurno.gridheight = 1;
        gbcBtnTerminarTurno.fill = GridBagConstraints.BOTH;

        gbcBtnTerminarTurno.insets = SEPARACION_CASILLAS;
        panelOpciones.add(botonTerminarTurno, gbcBtnTerminarTurno);
        
        
        GridBagConstraints gbcBtnFinalizarPartida= new GridBagConstraints();
        
        gbcBtnFinalizarPartida.gridx = 1;
        gbcBtnFinalizarPartida.gridy = 1;
        gbcBtnFinalizarPartida.weightx = 1;
        gbcBtnFinalizarPartida.weighty = 1;
        gbcBtnFinalizarPartida.gridwidth = 1;
        gbcBtnFinalizarPartida.gridheight = 1;
        gbcBtnFinalizarPartida.fill = GridBagConstraints.BOTH;

        gbcBtnFinalizarPartida.insets = SEPARACION_CASILLAS;
        panelOpciones.add(botonFinalizarPartida, gbcBtnFinalizarPartida);
        
        
        GridBagConstraints gbcBtnAbandonarPartida = new GridBagConstraints();
        
        gbcBtnAbandonarPartida.gridx = 0;
        gbcBtnAbandonarPartida.gridy = 1;
        gbcBtnAbandonarPartida.weightx = 1;
        gbcBtnAbandonarPartida.weighty = 1;
        gbcBtnAbandonarPartida.gridwidth = 1;
        gbcBtnAbandonarPartida.gridheight = 1;
        gbcBtnAbandonarPartida.fill = GridBagConstraints.BOTH;

        gbcBtnAbandonarPartida.insets = SEPARACION_CASILLAS;
        panelOpciones.add(botonAbandonar, gbcBtnAbandonarPartida);
        
    }
    
    
    @Override
    public void agregarComponente(IComponente componente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removerComponente(IComponente componente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aceptar(IVisitor visitor) {
        visitor.visitar(this);
    }

    public void pintar(IEstadoJugadorPrincipal estadoJugadorPrincpal) {
        
        mapaCasillasFichas = estadoJugadorPrincpal.getJugadorPrincipal().getMapaCasillasFichas();
        FichaInformacionPanel[] fichas = estadoJugadorPrincpal.getJugadorPrincipal().getFichasJugadorPrincipal();
        agregarFichasMano(fichas);
    }

    public boolean tienePosicion() {
        return false;
    }

    @Override
    public PosicionPanel getPosicion() {
        return POSICION_PANEL;

    }
    
}
