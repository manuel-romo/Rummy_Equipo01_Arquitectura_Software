

package com.equipo01.ejercerturno;

import java.util.List;


public class Modelo implements IPublicador{

    private List<ISuscriptor> suscriptores;
    
    public void seleccionarFichasTablero(int[] posicionesFichas) {}

    public void quitarFichasJugador(int[] posicionesFichas) {}

    public void quitarFichasTablero(int[] idsFichas) {}

    public void agregarFichasTablero(int[] idsFichas, int numeroGrupo) {}
 
    public void agregarFichasTablero(int[] idsFichas){}
    
     public void terminarTurno() {}

    @Override
    public void suscribirse(ISuscriptor suscriptor) {
        suscriptores.add(suscriptor);
    }

    @Override
    public void desuscribirse(ISuscriptor suscriptor) {
        suscriptores.remove(suscriptor);
    }

    @Override
    public void notificar() {
        
        for(ISuscriptor suscriptor: suscriptores){
            suscriptor.actualizar(this);
        }
    }


}
