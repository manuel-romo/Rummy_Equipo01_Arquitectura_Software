
package objetosPresentacion;

import ejercerTurno.IReceptorEventos;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class GestorEventos implements IGestorEventos{

    private IReceptorEventos receptorEventos;
    
    private JFrame framePrincipal;
    
    private PanelMovimiento panelMovimiento;
            
    private List<PanelFicha> fichasMovimiento = new LinkedList<>();
    
    private List<PanelCasilla> paneleslCasillaEliminarFicha = new LinkedList<>();
    private List<PanelCasilla> panelesCasillaAgregarFicha = new LinkedList<>();
    
    public GestorEventos (JFrame framePrincipal, IReceptorEventos receptorEventos){
       
        this.receptorEventos = receptorEventos;
        this.framePrincipal = framePrincipal;
        
        this.panelMovimiento = (PanelMovimiento)framePrincipal.getGlassPane();
         
    }
    
    @Override
    public void seleccionarFicha(MouseEvent e, boolean seleccionada) {
        
        PanelFicha ficha = (PanelFicha)e.getSource();
        
        if(!ficha.isSeleccionada() && seleccionada){
            
            boolean seleccionValida = true;
            
            if(!fichasMovimiento.isEmpty()){
                    
                PanelFicha fichaMovimientoReferencia = fichasMovimiento.get(0);
                Container contenedorAbueloFichaReferencia = fichaMovimientoReferencia.getParent().getParent();

                Container contenedorAbueloFichaSeleccionada = ficha.getParent().getParent();

                if(contenedorAbueloFichaSeleccionada instanceof PanelTablero){

                    List<PanelFicha> fichasAdyacentesIzquierda = new LinkedList<>();
                    List<PanelFicha> fichasAdyacentesDerecha = new LinkedList<>();

                    if(contenedorAbueloFichaReferencia instanceof PanelJugadorPrincipal){

                        System.out.println("Error");
                        return;

                    }

                    PanelCasilla panelCasilla = (PanelCasilla)fichaMovimientoReferencia.getParent();

                    Point posicionPanelCasilla = panelCasilla.getLocation();

                    int posicionFichaDerecha = 1;

                    while(true){

                        Point puntoLugarVerificar = new Point();

                        puntoLugarVerificar.setLocation(posicionPanelCasilla.x + (double)(panelCasilla.getWidth()/2) + ((panelCasilla.getWidth()) * posicionFichaDerecha), 
                                posicionPanelCasilla.y + (double)(panelCasilla.getWidth() / 2));

                        Component componenteVerificar = contenedorAbueloFichaSeleccionada.getComponentAt(puntoLugarVerificar);

                        posicionFichaDerecha++;

                        if(componenteVerificar instanceof PanelCasilla){

                            PanelCasilla panelCasillaVerificar = (PanelCasilla)componenteVerificar;

                            if(panelCasillaVerificar.getComponentCount() > 0){

                                PanelFicha panelFicha = panelCasillaVerificar.getPanelFicha();

                                fichasAdyacentesDerecha.add(panelFicha);

                                if(!panelFicha.isSeleccionada()){                  
                                    break;   
                                }

                            } else{
                                break;  
                            }

                        } else{
                            break;
                        }

                    }

                    int posicionFichaIzquierda = 1;

                    while(true){

                        Point puntoLugarVerificar = new Point();

                        puntoLugarVerificar.setLocation(posicionPanelCasilla.x + (double)(panelCasilla.getWidth()/2) - (panelCasilla.getWidth() * posicionFichaIzquierda), 
                                posicionPanelCasilla.y + (double)(panelCasilla.getWidth() / 2));

                        Component componenteVerificar = contenedorAbueloFichaSeleccionada.getComponentAt(puntoLugarVerificar);

                        posicionFichaIzquierda++;

                        if(componenteVerificar instanceof PanelCasilla){

                            PanelCasilla panelCasillaVerificar = (PanelCasilla)componenteVerificar;

                            if(panelCasillaVerificar.getComponentCount() > 0){

                                PanelFicha panelFicha = panelCasillaVerificar.getPanelFicha();

                                fichasAdyacentesIzquierda.add(panelFicha);

                                if(!panelFicha.isSeleccionada()){                  
                                    break;   
                                }

                            } else{
                                break;  
                            }

                        } else{
                            break;
                        }

                    }

                    boolean fichaEncontrada = false;
                    for(PanelFicha fichaAdyacente: fichasAdyacentesDerecha){

                        if(fichaAdyacente.getIdFicha() == ficha.getIdFicha()){
                            fichaEncontrada = true;
                        }
                    }

                    for(PanelFicha fichaAdyacente: fichasAdyacentesIzquierda){

                        if(fichaAdyacente.getIdFicha() == ficha.getIdFicha()){
                            fichaEncontrada = true;
                        }
                    }
                    
                    seleccionValida = fichaEncontrada;


                } else{

                    if(contenedorAbueloFichaReferencia instanceof PanelTablero){
  
                        seleccionValida = false;      

                    }


                }
            }
            
            if(seleccionValida){

                ficha.setSeleccionada(true);

                fichasMovimiento.add(ficha);

            } else{
                System.out.println("Error");
            }
           
        } else if(ficha.isSeleccionada() && !seleccionada){
            
            Container contenedorAbueloFichaSeleccionada = ficha.getParent().getParent();
            
            boolean tieneFichaAdyacenteDerechaSeleccionada = false;
            boolean tieneFichaAdyacenteIzquierdaSeleccionada = false;
            
            if(contenedorAbueloFichaSeleccionada instanceof PanelTablero && fichasMovimiento.size() > 1){
                
                PanelCasilla panelCasilla = (PanelCasilla)ficha.getParent();

                // Verificación derecha
                Point posicionPanelCasilla = panelCasilla.getLocation();

                Point puntoLugarVerificarDerecha = new Point();

                puntoLugarVerificarDerecha.setLocation(posicionPanelCasilla.x + (double)(panelCasilla.getWidth()/2) + panelCasilla.getWidth(), 
                        posicionPanelCasilla.y + (double)(panelCasilla.getWidth() / 2));

                Component componenteVerificarDerecha = contenedorAbueloFichaSeleccionada.getComponentAt(puntoLugarVerificarDerecha);

                if(componenteVerificarDerecha instanceof PanelCasilla){

                    PanelCasilla panelCasillaVerificar = (PanelCasilla)componenteVerificarDerecha;

                    if(panelCasillaVerificar.getComponentCount() > 0){

                        PanelFicha panelFicha = panelCasillaVerificar.getPanelFicha();

                        if(panelFicha.isSeleccionada()){                  
                            tieneFichaAdyacenteDerechaSeleccionada = true;
                        }
                    }
                }
                
                // Verificación izquierda
                Point puntoLugarVerificarIzquierda = new Point();

                puntoLugarVerificarIzquierda.setLocation(posicionPanelCasilla.x + (double)(panelCasilla.getWidth()/2) - panelCasilla.getWidth(), 
                        posicionPanelCasilla.y + (double)(panelCasilla.getWidth() / 2));

                Component componenteVerificarIzquierda = contenedorAbueloFichaSeleccionada.getComponentAt(puntoLugarVerificarIzquierda);

                if(componenteVerificarIzquierda instanceof PanelCasilla){

                    PanelCasilla panelCasillaVerificar = (PanelCasilla)componenteVerificarIzquierda;

                    if(panelCasillaVerificar.getComponentCount() > 0){

                        PanelFicha panelFicha = panelCasillaVerificar.getPanelFicha();

                        if(panelFicha.isSeleccionada()){                  
                            tieneFichaAdyacenteIzquierdaSeleccionada = true;
                        }
                    }
                }
                
            }
            
            if(!(tieneFichaAdyacenteDerechaSeleccionada && tieneFichaAdyacenteIzquierdaSeleccionada)){
                
                ficha.setSeleccionada(false);
            
                fichasMovimiento.remove(ficha);
            }
            
            
        }
    }
    
    @Override
    public void iniciarArrastreFichas(){
        
        PanelFicha[] fichasArrastradas = fichasMovimiento.toArray(new PanelFicha[0]);
        
        panelMovimiento.iniciarArrastre(fichasArrastradas);
        
        quitarFichasCasillas();

    }
    
    @Override
    public void presionarFicha(){
        
        for(PanelFicha ficha: fichasMovimiento){
            ficha.presionarFicha();
        }
        
    }
    
    @Override
    public void dejarPresionarFicha(){
        
        for(PanelFicha ficha: fichasMovimiento){
            ficha.dejarPresionarFicha();
        }
        
    }
    
    

    @Override
    public void fichaSoltada(MouseEvent e) {
        
        List<Integer> listaFichasIdsGrupo = new LinkedList<>();
        
        List<Integer> listaIdsFichasAgregar = new LinkedList<>();
        
        panelesCasillaAgregarFicha = new LinkedList<>();
        
        for(PanelFicha ficha: fichasMovimiento){
            
            int indiceFichaMovimiento = fichasMovimiento.indexOf(ficha);
            
            int offsetX = indiceFichaMovimiento * (ficha.getWidth() + 15);
            
            Point dropPoint = e.getPoint();
            
            if(e.getComponent() instanceof PanelFicha){
                dropPoint = SwingUtilities.convertPoint(e.getComponent(), dropPoint, panelMovimiento);
            }
            
            dropPoint.x = dropPoint.x + offsetX;
            
            Point contentPanePoint = SwingUtilities.convertPoint(panelMovimiento, dropPoint, framePrincipal.getContentPane());
            
            Component componenteDestino = framePrincipal.getContentPane().findComponentAt(contentPanePoint);
            
            if(componenteDestino instanceof PanelCasilla){

                PanelCasilla casillaDestino = (PanelCasilla)componenteDestino;

                panelesCasillaAgregarFicha.add(casillaDestino);

                if(casillaDestino.getComponentCount() > 0){

                    System.out.println("Error");

                    return;

                } else{

                    Container contenedorCasillas = casillaDestino.getParent();

                    // Búsqueda de Ficha derecha
                    int puntoX_Derecha = casillaDestino.getX() + casillaDestino.getWidth() + 25;
                    int puntoY_Centro = casillaDestino.getY() + casillaDestino.getHeight() / 2; // Centro vertical

                    Point puntoPruebaDerecha = SwingUtilities.convertPoint(
                        contenedorCasillas, 
                        new Point(puntoX_Derecha, puntoY_Centro), 
                        framePrincipal.getContentPane()
                    );

                    Component componenteDerecho = framePrincipal.getContentPane().findComponentAt(puntoPruebaDerecha);

                    if (componenteDerecho instanceof PanelCasilla || componenteDerecho instanceof PanelFicha) {

                        if(componenteDerecho instanceof PanelFicha){
                            componenteDerecho = componenteDerecho.getParent();
                        }

                        PanelCasilla casillaDerecha = (PanelCasilla) componenteDerecho;

                        if (casillaDerecha.getComponentCount() > 0) {

                            PanelFicha fichaEncontrada = (PanelFicha) casillaDerecha.getComponent(0);

                            listaFichasIdsGrupo.add(fichaEncontrada.getIdFicha()); 
                        }
                    }

                    // Búsqueda Ficha izquierda
                    int puntoX_Izquierda = casillaDestino.getX() - 25;

                    Point puntoPruebaIzquierda = SwingUtilities.convertPoint(
                        contenedorCasillas, 
                        new Point(puntoX_Izquierda, puntoY_Centro), 
                        framePrincipal.getContentPane()
                    );

                    Component componenteIzquierdo = framePrincipal.getContentPane().findComponentAt(puntoPruebaIzquierda);

                    if (componenteIzquierdo instanceof PanelCasilla || componenteIzquierdo instanceof PanelFicha) {

                        if(componenteIzquierdo instanceof PanelFicha){
                            componenteIzquierdo = componenteIzquierdo.getParent();
                        }

                        PanelCasilla casillaIzquierda = (PanelCasilla) componenteIzquierdo;
                        if (casillaIzquierda.getComponentCount() > 0) {
                            PanelFicha fichaEncontrada = (PanelFicha) casillaIzquierda.getComponent(0);
                            listaFichasIdsGrupo.add(fichaEncontrada.getIdFicha());
                        }
                    }

                    listaIdsFichasAgregar.add(ficha.getIdFicha());
                }
                
            } else{
                
                System.out.println("Error");
                
                return;

            }

        }
        
        int[] idsFichasGrupo = listaFichasIdsGrupo.stream().
                            mapToInt(Integer::intValue).
                            toArray();

        int[] idsFichasAgregar = listaIdsFichasAgregar.stream().
                            mapToInt(Integer::intValue).
                            toArray();

        int[] casillasAgregar = panelesCasillaAgregarFicha.stream()
                           .mapToInt(PanelCasilla::getId)
                           .toArray();

        panelMovimiento.setVisible(false);
        
        fichasMovimiento = new LinkedList<>();
        
        if(idsFichasGrupo.length != 0){

            receptorEventos.agregarFichasTablero(casillasAgregar, idsFichasAgregar, idsFichasGrupo);

        } else{

            receptorEventos.agregarFichasTablero(casillasAgregar, idsFichasAgregar);
        }
        
    }

    
    @Override
    public void quitarFichasCasillas() {
        
        paneleslCasillaEliminarFicha = new LinkedList<>();
        List<Integer> idsFichasQuitar = new LinkedList<>();
        
        boolean fichasJugador = true;
        
        for(PanelFicha ficha: fichasMovimiento){
            
            if(ficha.getParent() != null){

                Integer idFichaEliminar = ficha.getIdFicha();

                PanelCasilla panelCasillaQuitar = (PanelCasilla)ficha.getParent();

                paneleslCasillaEliminarFicha.add(panelCasillaQuitar);
                
                idsFichasQuitar.add(idFichaEliminar);
                
                if(ficha.getParent().getParent() instanceof PanelTablero){
                    fichasJugador = false;
                }

            }
        }
        
        int[] fichasQuitar = idsFichasQuitar.stream()
                                    .mapToInt(Integer::intValue)
                                    .toArray();

        int[] casillasQuitar = paneleslCasillaEliminarFicha.stream()
                                   .mapToInt(PanelCasilla::getId)
                                   .toArray();

        if(fichasJugador){
            
            receptorEventos.quitarFichasJugador(casillasQuitar, fichasQuitar);

        } else{

            receptorEventos.quitarFichasTablero(casillasQuitar, fichasQuitar);
            
        }
        
    }
    
    @Override
    public void borrarFichasMovimiento(){
        
        fichasMovimiento = new LinkedList<>();
        panelMovimiento.borrarContenido();
        
    }
    
    @Override
    public void arrastreFichaMovimiento(MouseEvent e){
        
        panelMovimiento.arrastrarFichas(e);
        
    }
    
    @Override
    public void soltarFichasMovimiento(MouseEvent e){
        
        panelMovimiento.dejarArrastrarFichas(e);
        
    }
    
}
