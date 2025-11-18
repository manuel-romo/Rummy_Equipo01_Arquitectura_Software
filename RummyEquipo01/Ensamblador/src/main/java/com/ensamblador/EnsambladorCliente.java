/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

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
import interfaces.IReceptorExterno;
import interfaces.ISuscriptor;
import java.awt.Color;
import java.util.HashMap;
import java.util.List;
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

        
        
        // Filtro Serializador
        
        Serializador serializadorCliente = new Serializador();
        
        // Filtro Directorio Servidor
        
        DirectorioServidor directorioServidor = new DirectorioServidor(new String[]{"127.0.0.1", "50000"});
        
        
        // Pipe de Conexión
        
        // Cliente
        ISuscriptor gestor = new GestorConexiones(); 
        ColaMensajesEnviar colaMensajesEnviar = new ColaMensajesEnviar(gestor);
        
        new Thread(colaMensajesEnviar).start();
        
        ColaMensajesRecibidos colaMensajesRecibidos = new ColaMensajesRecibidos();
        
        IReceptor receptor = (IReceptor)colaMensajesRecibidos;
        
        // Servidor
        Servidor servidor = new Servidor(50000, receptor);
        
        new Thread(servidor).start();
        new Thread(colaMensajesRecibidos).start();
        
//        colaMensajesEnviar.agregarMensaje("Prueba de mensaje a enviar", new String[]{"127.0.0.1", "50000"});
        
        // Deserializador
        
        Deserializador deserializadorCliente = new Deserializador();
        
        // Conexiones
        
        // Ida
        modelo.setFiltroEnvioMensaje(serializadorCliente);
        
        serializadorCliente.setFiltroSiguiente(directorioServidor);
        
        directorioServidor.setDispatcher(colaMensajesEnviar);
        
        // Vuelta
        colaMensajesRecibidos.setReceptor(deserializadorCliente);
        
        deserializadorCliente.setFiltroSiguiente(modelo);
        
        
    }
}
