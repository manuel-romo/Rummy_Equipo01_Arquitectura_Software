
package conexion;

import cliente.ColaMensajesEnviar;
import interfaces.IReceptor;
import interfaces.IReceptorExterno;
import interfaces.ISuscriptor;
import cliente.GestorConexiones;
import servidor.ColaMensajesRecibidos;
import servidor.Servidor;

/**
 *
 * @author romom
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ISuscriptor gestor = new GestorConexiones(); 
        ColaMensajesEnviar colaMensajesEnviar = new ColaMensajesEnviar(gestor);
        
        new Thread(colaMensajesEnviar).start();
        
        
        
        IReceptorExterno receptorExterno = null;
        
        ColaMensajesRecibidos colaMensajesRecibidos = new ColaMensajesRecibidos(receptorExterno);
        
        IReceptor receptor = (IReceptor)colaMensajesRecibidos;
        
        Servidor servidor = new Servidor(50000, receptor);
        
        new Thread(servidor).start();
        new Thread(colaMensajesRecibidos).start();
        
        colaMensajesEnviar.agregarMensaje("Prueba de mensaje a enviar", new String[]{"127.0.0.1", "50000"});
        
    }
    
}
