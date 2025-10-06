

package objetosPresentacion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 * Panel que representa una ficha y puede ser arrastrado por el usuario.
 * @author 
 */
public class PanelFicha extends JPanel {

    private Integer idFicha;
    private String valor;
    private Color colorValor;
    
    private Point offset; 

    public PanelFicha(ActionListener actionListener, Integer idFicha, String valor, Color colorTexto) {
        this.idFicha = idFicha;
        this.valor = valor;
        this.colorValor = colorTexto;
        setPreferredSize(new Dimension(50, 70));
        
        ArrastreListener listener = new ArrastreListener();
        
        addMouseListener(listener);
        
        addMouseMotionListener(listener);
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
    
    // Método para pintar la ficha
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.getBackground()); // Usa el color de fondo actual
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(colorValor);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString(valor, getWidth() / 2 - g.getFontMetrics().stringWidth(valor) / 2, getHeight() / 2 + 7);
    }
    
    /**
     * Clase interna para manejar la lógica de arrastre.
     */
    private class ArrastreListener extends MouseAdapter {
        
        @Override
        public void mousePressed(MouseEvent e) {
            // 'e.getPoint()' son las coordenadas del clic DENTRO del panel.
            // Lo guardamos para saber el "punto de agarre".
            offset = e.getPoint(); 
            setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // 'e.getLocationOnScreen()' nos da la posición del cursor en la pantalla.
            // 'getLocationOnScreen()' nos da la posición del panel en la pantalla.
            int newX = e.getXOnScreen() - getLocationOnScreen().x - offset.x;
            int newY = e.getYOnScreen() - getLocationOnScreen().y - offset.y;

            // Se calcula la nueva posición y se actualiza
            Point newLocation = new Point(getLocation().x + newX, getLocation().y + newY);
            setLocation(newLocation);
        }
    }
}