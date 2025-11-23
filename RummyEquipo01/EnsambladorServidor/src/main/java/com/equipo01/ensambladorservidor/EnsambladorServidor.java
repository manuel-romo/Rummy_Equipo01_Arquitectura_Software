
package com.equipo01.ensambladorservidor;

import cliente.Cliente;
import cliente.ColaMensajesEnviar;
import cliente.GestorConexiones;
import deserializador.Deserializador;
import directorio.DirectorioJugadores;
import interfaces.ISuscriptor;
import java.io.IOException;
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
            GestorConexiones gestorConexiones = new GestorConexiones();
            
            ColaMensajesEnviar colaMensajesEnviar = new ColaMensajesEnviar();
            
            DirectorioJugadores directorioJugadores = new DirectorioJugadores();
            
            Serializador serializador = new Serializador();
            
            FachadaTablero fachadaTablero = new FachadaTablero();
            
            Servidor servidorServidor = new Servidor(50000);
            
            ColaMensajesRecibidos colaMensajesRecibidos = new ColaMensajesRecibidos();
            
            Deserializador deserializador = new Deserializador();
            
            // Conexión de componentes (Envío).
            
            colaMensajesEnviar.setSuscriptor(gestorConexiones);
            
            directorioJugadores.setDispatcher(colaMensajesEnviar);
            
            serializador.setFiltroSiguiente(directorioJugadores);
            
            fachadaTablero.setFiltroSiguiente(serializador);
            
            
            // Conexión de componentes (Recepción).
            
            servidorServidor.setReceptor(colaMensajesRecibidos);
            
            colaMensajesRecibidos.setReceptor(deserializador);
            
            deserializador.setFiltroSiguiente(fachadaTablero);
               
            
        } catch (Exception ex) {
            
        }
        
        
        
        
        
        
    }
}
