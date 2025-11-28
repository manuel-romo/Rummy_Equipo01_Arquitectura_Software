
package ensamblador;

import cliente.ColaMensajesEnviar;
import cliente.GestorConexiones;
import deserializador.Deserializador;
import directorio.DirectorioJugadores;
import java.util.Scanner;
import objetos_negocio.FachadaTablero;
import objetos_negocio.Tablero;
import serializador.Serializador;
import servidor.ColaMensajesRecibidos;
import servidor.Servidor;

/**
 *
 * @author Romo López Manuel
 * ID: 00000253080
 * 
 */
public class EnsambladorServidor {

    public static void main(String[] args) {
        
        
        Scanner escaner = new Scanner(System.in);
        
        try {
            
            // Creación de clases de componentes.
            GestorConexiones gestorConexiones = new GestorConexiones();
            
            ColaMensajesEnviar colaMensajesEnviar = new ColaMensajesEnviar();
            
            DirectorioJugadores directorioJugadores = new DirectorioJugadores();
            
            Serializador serializador = new Serializador();
            
            FachadaTablero fachadaTablero = new FachadaTablero();
            
            Tablero tablero = new Tablero();
            
            Servidor servidorServidor = new Servidor(50000);
            
            ColaMensajesRecibidos colaMensajesRecibidos = new ColaMensajesRecibidos();
            
            Deserializador deserializador = new Deserializador();
            
            // Conexión de componentes (Envío).
            
            colaMensajesEnviar.setSuscriptor(gestorConexiones);
            
            directorioJugadores.setDispatcher(colaMensajesEnviar);
            
            serializador.setFiltroSiguiente(directorioJugadores);
            
            fachadaTablero.setFiltroSiguiente(serializador);
            
            tablero.setFachadaTablero(fachadaTablero);
            
            fachadaTablero.setTablero(tablero);
            
            // Conexión de componentes (Recepción).
            
            servidorServidor.setReceptor(colaMensajesRecibidos);
            
            colaMensajesRecibidos.setReceptor(deserializador);
            
            deserializador.setFiltroSiguiente(fachadaTablero);
            
            new Thread(colaMensajesEnviar).start();
            
            new Thread(servidorServidor).start();
            new Thread(colaMensajesRecibidos).start();
            
            tablero.iniciarJuego();
               
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
}
