
package objetosPresentacion;

import javax.swing.JPanel;


public class PanelJugadorPrincipal extends JPanel implements IComponente{

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void pintar(IEstadoJugadorPrincipal estadoJugadorPrincpal) {
        System.out.println("Pintando PanelJugadorPrincipal");
    }

    @Override
    public boolean tienePosicion() {
        return false;
    }
    
}
