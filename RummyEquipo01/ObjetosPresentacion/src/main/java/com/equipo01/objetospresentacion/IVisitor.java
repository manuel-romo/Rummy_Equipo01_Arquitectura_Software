
package com.equipo01.objetospresentacion;


public interface IVisitor {
    public abstract void visitar(PanelMonton panelMonton);
    public abstract void visitar(PanelJugadorPrincipal panelJugadorPrincipal);
    public abstract void visitar(PanelJugadorExterno panelJugadorExerno);
}
