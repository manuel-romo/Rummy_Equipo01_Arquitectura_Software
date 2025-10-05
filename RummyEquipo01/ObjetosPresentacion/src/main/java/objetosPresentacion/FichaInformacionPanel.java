
package objetosPresentacion;

import java.awt.Color;

/**
 *
 * @author Manuel Romo López
 * ID: 00000253080
 */
public class FichaInformacionPanel {
    
    private String valor;
    private Color color;

    public FichaInformacionPanel(String valor, Color color) {
        this.valor = valor;
        this.color = color;
    }

    public String getValor() {
        return valor;
    }

    public Color getColor() {
        return color;
    }
    
}
