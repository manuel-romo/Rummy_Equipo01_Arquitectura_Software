package objetosPresentacion;


import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class PanelMovimiento extends JPanel implements IComponente {

    private PanelFicha[] fichasArrastradas;
    
    private boolean arrastrandoFichas;

    private IGestorEventos gestorEventos;
    
    private Integer numeroFichaArrastrada;
    
    private MouseAdapter ma;

    public PanelMovimiento() {
        setOpaque(false);
        setLayout(null);
        
        ma = new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                
                if (fichasArrastradas == null) {
                    return;
                }

                int indiceInicio = 0;
                int indiceMaximo = fichasArrastradas.length;
                boolean moverEnGrupo = true;

                Point puntoInicioEvento = e.getPoint();

                if (e.getComponent() instanceof PanelFicha) {
                    PanelFicha panelFicha = (PanelFicha) e.getComponent();
                    puntoInicioEvento = SwingUtilities.convertPoint(panelFicha, puntoInicioEvento, PanelMovimiento.this);

                    moverEnGrupo = false;
                    for (int i = 0; i < fichasArrastradas.length; i++) {
                        if (fichasArrastradas[i].getIdFicha().equals(panelFicha.getIdFicha())) {
                            indiceInicio = i;
                            indiceMaximo = i + 1;
                            numeroFichaArrastrada = i;
                            break;
                        }
                    }

                } else{
                    numeroFichaArrastrada = null;
                }

                for (int i = indiceInicio; i < indiceMaximo; i++) {
                    int nuevoX = puntoInicioEvento.x - 30;
                    int nuevoY = puntoInicioEvento.y - 30;

                    if (moverEnGrupo) {
                        fichasArrastradas[i].setLocation(nuevoX + (fichasArrastradas[i].getWidth() + 15) * i, nuevoY);
                    } else {
                        fichasArrastradas[i].setLocation(nuevoX, nuevoY);
                    }
                }

                revalidate();
                repaint();
            }

            
            @Override
            public void mouseReleased(MouseEvent e) {
                
                gestorEventos.fichaSoltada(e);
                   
            }

            
        };
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    public void iniciarArrastre(PanelFicha[] fichas) {
        
        this.fichasArrastradas = new PanelFicha[fichas.length];
        
        this.arrastrandoFichas = true;
        
        for(int i = 0; i < fichas.length; i++){

            Point puntoEnGlassPane = SwingUtilities.convertPoint(fichas[i], fichas[i].getLocation(), this);

            PanelFicha fichaCopia = new PanelFicha(
                            gestorEventos,
                            fichas[i].getIdFicha(),
                            fichas[i].getValor(), 
                            fichas[i].getColorValor(), 
                            fichas[i].isSeleccionada());
            
            fichaCopia.setLocation(puntoEnGlassPane);
            
            fichaCopia.setSize(fichas[i].getSize());
            
            fichasArrastradas[i] = fichaCopia;
            
            add(fichaCopia);
            
            fichaCopia.setVisible(true);
            
            fichaCopia.setEnMovimiento(true);
            
        }
        
        setVisible(true);

        repaint();
    }
    
    public void setGestorEventos(IGestorEventos gestorEventos){
        this.gestorEventos = gestorEventos;
    }
    
    public void arrastrarFichas(MouseEvent e){
        ma.mouseDragged(e);
    }
    
    public void dejarArrastrarFichas(MouseEvent e){
        ma.mouseReleased(e);
    }
    
    public void pintar(IEstadoPanelMovimiento estadoPanelMovimiento){
        boolean movimientoValido = estadoPanelMovimiento.getMovimientoValido();
        
        if(!arrastrandoFichas && movimientoValido){
            this.removeAll();
        }
        
    }
    
    public void borrarContenido(){

        arrastrandoFichas = false;

        removeAll();
                    
    }

    public Integer getNumeroFichaArrastrada() {
        return numeroFichaArrastrada;
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

    @Override
    public PosicionPanel getPosicion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}