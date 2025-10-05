
package objetosPresentacion;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PanelRotador extends JPanel {
    private final JPanel panel;
    private final int anguloRotacion;

    public PanelRotador(JPanel panel, int anguloRotacion) {
        this.panel = panel;
        this.anguloRotacion = anguloRotacion;
        setLayout(null);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension originalSize = panel.getPreferredSize();
        // Devuelve las dimensiones intercambiadas
        return new Dimension(originalSize.height, originalSize.width);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g.create();
        
        // El tamaño del panel hijo debe ajustarse a las dimensiones intercambiadas del rotador
        panel.setBounds(0, 0, getHeight(), getWidth());

        if (anguloRotacion == 90) {
            g2d.rotate(Math.toRadians(90));
            g2d.translate(0, -getHeight());
        } else if (anguloRotacion == -90) {
            g2d.rotate(Math.toRadians(-90));
            g2d.translate(-getWidth(), 0);
        }

        panel.paint(g2d);
        g2d.dispose();
    }
}