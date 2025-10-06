package objetosPresentacion;

import ejercerTurno.IGestorEventos;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class PanelMovimiento extends JPanel {

    private JPanel fichaArrastrada;
    private Point offset; // Diferencia entre la esquina de la ficha y donde se hizo clic
    private Point posicionArrastre; // Posición actual de la ficha en el panel

    private IGestorEventos gestorEventos; // Referencia a tu vista para notificar el drop

    public PanelMovimiento(IGestorEventos gestor) {
        this.gestorEventos = gestor;
        setOpaque(false);
        setLayout(null);
        
        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (fichaArrastrada == null) return;

                System.out.println("moviendo...");
                // Calculamos la nueva posición de la esquina superior izquierda
                int newX = e.getX() - offset.x;
                int newY = e.getY() - offset.y;
                
                // Movemos el componente directamente
                fichaArrastrada.setLocation(newX, newY);

                revalidate();
                repaint();
            }

            
            @Override
            public void mouseReleased(MouseEvent e) {
                if (fichaArrastrada == null) return;
                
                gestorEventos.fichaSoltada(e);
                
                // Limpiamos el panel
                remove(fichaArrastrada);
                fichaArrastrada = null;
                
                setVisible(false);
                
                revalidate();
                repaint();
                
                
                
            }
        };
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    public void iniciarArrastre(JPanel ficha, MouseEvent e) {
        this.fichaArrastrada = ficha;
        this.offset = e.getPoint();
        
        // Convertimos la posición inicial al sistema de coordenadas del GlassPane
        Point puntoEnGlassPane = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), this);
        int startX = puntoEnGlassPane.x - offset.x;
        int startY = puntoEnGlassPane.y - offset.y;
        
        // Posicionamos la ficha en el GlassPane
        fichaArrastrada.setLocation(startX, startY);
        // El setSize ya lo haces en VistaMesaJuego, lo cual está bien.
        
        // Añadimos la ficha como un hijo del GlassPane
        add(fichaArrastrada);
        
        setVisible(true);
        repaint();
    }

}