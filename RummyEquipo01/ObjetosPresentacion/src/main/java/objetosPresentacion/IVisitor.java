
package objetosPresentacion;


public interface IVisitor {
    public abstract void visitar(PanelMonton panelMonton);
    public abstract void visitar(PanelJugadorPrincipal panelJugadorPrincipal);
    public abstract void visitar(PanelJugadorExterno panelJugadorExerno);
    public abstract void visitar(PanelMesaJuego panelMesaJuego);
}
