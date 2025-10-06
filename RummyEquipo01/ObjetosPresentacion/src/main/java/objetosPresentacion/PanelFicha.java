

package objetosPresentacion;

import com.sun.java.accessibility.util.AWTEventMonitor;
import ejercerTurno.IGestorEventos;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 * Panel que representa una ficha y puede ser arrastrado por el usuario.
 * @author 
 */
public class PanelFicha extends JPanel {

    private Integer idFicha;
    private String valor;
    private Color colorValor;
    private IGestorEventos gestorEventos;
    private boolean seleccionada;
    private Color COLOR_FONDO_NO_SELECCIONADA = new Color(240, 238, 223);
    private Color COLOR_FONDO_SELECCIONADA = new Color(242, 238, 172);
    
    private Dimension tamanioPanel = new Dimension(50, 70);

    public PanelFicha(IGestorEventos gestorEventos, Integer idFicha, String valor, Color colorTexto, boolean seleccionada) {
        this.idFicha = idFicha;
        this.valor = valor;
        this.colorValor = colorTexto;
        this.gestorEventos = gestorEventos;
        this.seleccionada = seleccionada;
        setPreferredSize(tamanioPanel);
        configurarListeners();
    }
    
    public PanelFicha(IGestorEventos gestorEventos, Integer idFicha, String valor, Color colorTexto, boolean seleccionada, Color colorFondo) {
        this.idFicha = idFicha;
        this.valor = valor;
        this.colorValor = colorTexto;
        this.gestorEventos = gestorEventos;
        this.seleccionada = seleccionada;
        setBackground(colorFondo);
        setPreferredSize(tamanioPanel);
        configurarListeners();
    }

    // Getters y setters
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
        repaint();
    }

    public Integer getIdFicha() {
        return idFicha;
    }

    public Color getColorValor() {
        return colorValor;
    }

    public boolean isSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(boolean seleccionada) {
        this.seleccionada = seleccionada;
        
        if(seleccionada){
            setBackground(COLOR_FONDO_SELECCIONADA);
        }
        else{
            setBackground(COLOR_FONDO_NO_SELECCIONADA);
        }
    }
    
    private void configurarListeners(){
        MouseAdapter listener  = new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }
            
            @Override
            public void mouseDragged(MouseEvent e) {
//                gestorEventos.fichaPresionada(e);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                gestorEventos.seleccionarFicha(e);
            }
        };
        
        addMouseListener(listener);
        addMouseMotionListener(listener);

    }
    
    
    
    // Método para pintar la ficha
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(colorValor);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString(valor, getWidth() / 2 - g.getFontMetrics().stringWidth(valor) / 2, getHeight() / 2 + 7);
    }
    
}