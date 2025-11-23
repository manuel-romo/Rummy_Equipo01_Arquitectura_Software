
package com.equipo01.ensambladorservidor;

import cliente.Cliente;
import cliente.ColaMensajesEnviar;
import deserializador.Deserializador;
import directorio.DirectorioJugadores;
import interfaces.ISuscriptor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos_negocio.FachadaTablero;
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
        
        
        try {
            
            // Creación de clases de componentes.
            
            ISuscriptor clienteServidor;
            
            clienteServidor = new Cliente("127.0.0.1", 50000);
            
            ColaMensajesEnviar colaMensajesEnviar = new ColaMensajesEnviar(clienteServidor);
            
            DirectorioJugadores directorioJugadores = new DirectorioJugadores();
            
            Serializador serializador = new Serializador();
            
            FachadaTablero fachadaTablero = new FachadaTablero();
            
            Servidor servidorServidor = new Servidor(50000);
            
            ColaMensajesRecibidos colaMensajesRecibidos = new ColaMensajesRecibidos();
            
            Deserializador deserializador = new Deserializador();
            
            // Conexión de componentes (Envío).
            
            directorioJugadores.setDispatcher(colaMensajesEnviar);
            
            serializador.setFiltroSiguiente(directorioJugadores);
            
            fachadaTablero.setFiltroSiguiente(serializador);
            
            
            // Conexión de componentes (Recepción).
            
            servidorServidor.setReceptor(colaMensajesRecibidos);
            
            colaMensajesRecibidos.setReceptor(deserializador);
            
            deserializador.setFiltroSiguiente(fachadaTablero);
               
            
        } catch (IOException ex) {
            
        }
        
        
        
        
        
        
    }
}
