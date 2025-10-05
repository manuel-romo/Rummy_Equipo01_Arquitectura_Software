
package objetosPresentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author
 * 
 */
public class PanelFicha extends JPanel{

    private String valor;
    private Color COLOR_FONDO = new Color(255, 245, 229); 
    private Color colorValor;

    // Constructor
    public PanelFicha(String valor, Color colorTexto) {
        this.valor = valor;
        this.colorValor = colorTexto;
        setPreferredSize(new Dimension(50, 70));
    }

    // Getters y setters
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
        repaint(); // Actualizar la ficha visualmente
    }

    // Método para pintar la ficha
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // fondo de la ficha
        g.setColor(COLOR_FONDO);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

        // borde de la ficha
        g.setColor(Color.BLACK);
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);

        // texto de la ficha
        g.setColor(colorValor);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(valor, getWidth() / 2 - g.getFontMetrics().stringWidth(valor) / 2, getHeight() / 2 + 7);
    }

}
