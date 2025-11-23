
package com.ensamblador;

import cliente.ColaMensajesEnviar;
import cliente.GestorConexiones;
import comunicacion.Comunicacion;
import comunicacion.IComunicacion;
import deserializador.Deserializador;
import directorioServidor.DirectorioServidor;
import ejercerTurno.Controlador;
import ejercerTurno.IReceptorEventos;
import ejercerTurno.Modelo;
import ejercerTurno.VistaMesaJuego;
import interfaces.IReceptor;
import interfaces.ISuscriptor;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import objetosPresentacion.GestorEventos;
import objetosPresentacion.IComponente;
import objetosPresentacion.IGestorEventos;
import objetosPresentacion.PanelCasilla;
import objetosPresentacion.PanelJugadorExterno;
import objetosPresentacion.PanelJugadorPrincipal;
import objetosPresentacion.PanelMesaJuego;
import objetosPresentacion.PanelMonton;
import objetosPresentacion.PanelMovimiento;
import objetosPresentacion.PanelTablero;
import objetosPresentacion.PosicionPanel;
import serializador.Serializador;
import servidor.ColaMensajesRecibidos;
import servidor.Servidor;

/**
 *
 * @author Romo López Manuel
 * ID: 00000253080
 */
public class EnsambladorCliente {

    private static int TOTAL_CASILLAS_TABLERO =500;
    private static int TOTAL_CASILLAS_MANO = 14;
    
    public static void main(String[] args) {
        
        // Creación de clases de componentes
        IComponente panelMonton = new PanelMonton();
        
        PanelCasilla[] panelesCasillaTablero = new PanelCasilla[TOTAL_CASILLAS_TABLERO];

        for (int i = 0; i < TOTAL_CASILLAS_TABLERO; i++) {
            panelesCasillaTablero[i] = new PanelCasilla(i + 1);
        }
        
        
        IComponente panelTablero = new PanelTablero(panelesCasillaTablero);
        
        PanelCasilla[] panelesCasillaJugador = new PanelCasilla[TOTAL_CASILLAS_MANO];
         
        for (int i = 0; i < TOTAL_CASILLAS_MANO; i++) {
            panelesCasillaJugador[i] = new PanelCasilla(i + 1);
        }
        
        IComponente panelJugadorPrincipal = new PanelJugadorPrincipal(panelesCasillaJugador);
        IComponente panelJugadorExterno1 = new PanelJugadorExterno(PosicionPanel.CENTRO_ARRIBA, "Sandy43", "avatar2.png", "14");
        IComponente panelJugadorExterno2 = new PanelJugadorExterno(PosicionPanel.DERECHA_CENTRO, "Lucas12", "avatar1.png", "14");
        IComponente panelJugadorExterno3 = new PanelJugadorExterno(PosicionPanel.IZQUIERDA_CENTRO, "Juan27", "avatar3.png", "14");
        
        IComponente panelMesaJuego = new PanelMesaJuego();
        
        panelMesaJuego.agregarComponente(panelMonton);
        panelMesaJuego.agregarComponente(panelTablero);
        panelMesaJuego.agregarComponente(panelJugadorExterno1);
        panelMesaJuego.agregarComponente(panelJugadorExterno2);
        panelMesaJuego.agregarComponente(panelJugadorExterno3);
        panelMesaJuego.agregarComponente(panelJugadorPrincipal);

        Map<Integer, Color> mapaColoresSeleccionados = Map.of(
            1, Color.RED,
            2, Color.BLUE,
            3, Color.GREEN,
            4, Color.DARK_GRAY
        );      
        
        Map<Integer,Integer> mapaIdsCasillasPanelesJugador = new HashMap<>();
        
        mapaIdsCasillasPanelesJugador.put(1, 1);
        mapaIdsCasillasPanelesJugador.put(2, 2);
        mapaIdsCasillasPanelesJugador.put(3, 3);
        mapaIdsCasillasPanelesJugador.put(4, 4);
        mapaIdsCasillasPanelesJugador.put(5, 5);
        mapaIdsCasillasPanelesJugador.put(6, 6);
        mapaIdsCasillasPanelesJugador.put(7, 7);
        mapaIdsCasillasPanelesJugador.put(8, 8);
        mapaIdsCasillasPanelesJugador.put(9, 9);
        mapaIdsCasillasPanelesJugador.put(10, 10);
        mapaIdsCasillasPanelesJugador.put(11, 11);
        
        Map<Integer,Integer> mapaIdsCasillasPanelesTablero = new HashMap<>();
        
        mapaIdsCasillasPanelesTablero.put(1, 22);
        mapaIdsCasillasPanelesTablero.put(2, 23);        
        mapaIdsCasillasPanelesTablero.put(3, 24);
        
        mapaIdsCasillasPanelesTablero.put(5, 25);
        mapaIdsCasillasPanelesTablero.put(6, 26);
        mapaIdsCasillasPanelesTablero.put(7, 27);        
        mapaIdsCasillasPanelesTablero.put(8, 28);
        mapaIdsCasillasPanelesTablero.put(9, 29);
        
        IComunicacion comunicacion = new Comunicacion();
        
        Modelo modelo = new Modelo(comunicacion);
        Controlador controlador = new Controlador(modelo);
        
        IComponente panelMovimiento = new PanelMovimiento();
        
        VistaMesaJuego vistaMesaJuego = new VistaMesaJuego(
                controlador,
                panelMesaJuego, 
                panelMovimiento,
                mapaColoresSeleccionados,
                mapaIdsCasillasPanelesTablero,
                mapaIdsCasillasPanelesJugador);
        
        modelo.suscribirse(vistaMesaJuego);
                
        IGestorEventos gestorEventos = new GestorEventos(vistaMesaJuego, (IReceptorEventos)vistaMesaJuego);
        
        ((PanelTablero) panelTablero).setGestorEventos(gestorEventos);
        ((PanelJugadorPrincipal) panelJugadorPrincipal).setGestorEventos(gestorEventos);
        ((PanelMovimiento) panelMovimiento).setGestorEventos(gestorEventos);

        
        Serializador serializadorCliente = new Serializador();

        DirectorioServidor directorioServidor = new DirectorioServidor(new String[]{"127.0.0.1", "50000"});
 
        ISuscriptor gestorConexiones = new GestorConexiones(); 
        
        ColaMensajesEnviar colaMensajesEnviar = new ColaMensajesEnviar();
        
        colaMensajesEnviar.setSuscriptor(gestorConexiones);
        
        new Thread(colaMensajesEnviar).start();
        
        ColaMensajesRecibidos colaMensajesRecibidos = new ColaMensajesRecibidos();
        
        Servidor servidor = new Servidor(50000);
        
        new Thread(servidor).start();
        new Thread(colaMensajesRecibidos).start();

        Deserializador deserializadorCliente = new Deserializador();
        
        
        // Conexión de componentes (Envío):
        modelo.setFiltroEnvioMensaje(serializadorCliente);
        
        serializadorCliente.setFiltroSiguiente(directorioServidor);
        
        directorioServidor.setDispatcher(colaMensajesEnviar);
        
        // Conexión de componentes (Recepción):
        colaMensajesRecibidos.setReceptor(deserializadorCliente);
        
        deserializadorCliente.setFiltroSiguiente(modelo);
        
        
    }
}
