
package ensamblador;

import cliente.ColaMensajesEnviar;
import cliente.GestorConexiones;
import deserializador.Deserializador;
import directorioServidor.DirectorioServidor;
import ejercerTurno.Controlador;
import ejercerTurno.IReceptorEventos;
import ejercerTurno.Modelo;
import ejercerTurno.VistaMesaJuego;
import interfaces.ISuscriptor;
import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
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
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del jugador: ");
        String nombreJugador = sc.nextLine();
        
        System.out.println(nombreJugador);
        
        String direccionImagenAvatar = null;
        String puertoCliente = null;
        
        if(nombreJugador.equals("qwe")){
            
            direccionImagenAvatar = "avatar1.png";
            puertoCliente = "51000";
        }
        
        if(nombreJugador.equals("asd")){
            
            direccionImagenAvatar = "avatar2.png";
            puertoCliente = "52000";
            
        }
        
        // Creación de clases de componentes
        
        PanelCasilla[] panelesCasillaTablero = new PanelCasilla[TOTAL_CASILLAS_TABLERO];

        for (int i = 0; i < TOTAL_CASILLAS_TABLERO; i++) {
            panelesCasillaTablero[i] = new PanelCasilla(i + 1);
        }
        
        
        IComponente panelTablero = new PanelTablero(panelesCasillaTablero);
        
        List<PanelCasilla> panelesCasillaJugador = new LinkedList<>();
         
        for (int i = 0; i < TOTAL_CASILLAS_MANO; i++) {
            panelesCasillaJugador.add(new PanelCasilla(i + 1));
        }
        
        IComponente panelJugadorPrincipal = new PanelJugadorPrincipal(panelesCasillaJugador);
        IComponente panelJugadorExterno1 = new PanelJugadorExterno(PosicionPanel.CENTRO_ARRIBA, nombreJugador, direccionImagenAvatar);
//        IComponente panelJugadorExterno2 = new PanelJugadorExterno(PosicionPanel.DERECHA_CENTRO);
//        IComponente panelJugadorExterno3 = new PanelJugadorExterno(PosicionPanel.IZQUIERDA_CENTRO);
        
        IComponente panelMesaJuego = new PanelMesaJuego();
        IComponente panelMonton = new PanelMonton();
        
        panelMesaJuego.agregarComponente(panelMonton);
        panelMesaJuego.agregarComponente(panelTablero);
        panelMesaJuego.agregarComponente(panelJugadorExterno1);
//        panelMesaJuego.agregarComponente(panelJugadorExterno2);
//        panelMesaJuego.agregarComponente(panelJugadorExterno3);
        panelMesaJuego.agregarComponente(panelJugadorPrincipal);

        Map<Integer, Color> mapaColoresSeleccionados = Map.of(
            1, Color.RED,
            2, Color.BLUE,
            3, Color.GREEN,
            4, Color.DARK_GRAY
        );      
        
         Map<Integer,Integer> mapaIdsCasillasPanelesJugador = new HashMap<>();
        
        if(nombreJugador.equals("qwe")){
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
            mapaIdsCasillasPanelesJugador.put(12, 12);
            mapaIdsCasillasPanelesJugador.put(13, 13);
            mapaIdsCasillasPanelesJugador.put(14, 14);
        }
        
        if(nombreJugador.equals("asd")){
            mapaIdsCasillasPanelesJugador.put(1, 15);
            mapaIdsCasillasPanelesJugador.put(2, 16);
            mapaIdsCasillasPanelesJugador.put(3, 17);
            mapaIdsCasillasPanelesJugador.put(4, 18);
            mapaIdsCasillasPanelesJugador.put(5, 19);
            mapaIdsCasillasPanelesJugador.put(6, 20);
            mapaIdsCasillasPanelesJugador.put(7, 21);
            mapaIdsCasillasPanelesJugador.put(8, 22);
            mapaIdsCasillasPanelesJugador.put(9, 23);
            mapaIdsCasillasPanelesJugador.put(10, 24);
            mapaIdsCasillasPanelesJugador.put(11, 25);
            mapaIdsCasillasPanelesJugador.put(12, 26);
            mapaIdsCasillasPanelesJugador.put(13, 27);
            mapaIdsCasillasPanelesJugador.put(14, 28);
        }
        
        
        Map<Integer,Integer> mapaIdsCasillasPanelesTablero = new HashMap<>();
        
        for (int i = 0; i < TOTAL_CASILLAS_TABLERO; i++) {
            mapaIdsCasillasPanelesTablero.put(i + 1, null);
        }
        
        Modelo modelo = new Modelo(nombreJugador);
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
        ((PanelMonton)panelMonton).setGestorEventos(gestorEventos);
        ((PanelMovimiento) panelMovimiento).setGestorEventos(gestorEventos);

        
        Serializador serializadorCliente = new Serializador();

        DirectorioServidor directorioServidor = new DirectorioServidor(new String[]{"127.0.0.1", "50000"});
 
        ISuscriptor gestorConexiones = new GestorConexiones(); 
        
        ColaMensajesEnviar colaMensajesEnviar = new ColaMensajesEnviar();
        
        colaMensajesEnviar.setSuscriptor(gestorConexiones);
        
        new Thread(colaMensajesEnviar).start();
        
        ColaMensajesRecibidos colaMensajesRecibidos = new ColaMensajesRecibidos();
        
        Servidor servidor = new Servidor(Integer.valueOf(puertoCliente));
        
        servidor.setReceptor(colaMensajesRecibidos);
        
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
