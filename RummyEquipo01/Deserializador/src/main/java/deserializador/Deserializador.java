
package deserializador;
import com.google.gson.Gson;
import dto.RespuestaDTO;
import interfaces.ICommand;
import interfaces.IFiltro;
import interfaces.IReceptorExterno;
/**
 *
 * @author ramon
 */
public class Deserializador implements IReceptorExterno{
    private IFiltro filtroSiguiente;
    private final Gson gson = new Gson();

    /***
     * Método constructor que recibe una instancia que implementa IReceptorRespuestaDeserializada para avisarle.
     * @param receptorRespuestaDeserializada instancia de IReceptorRespuestaDeserializada
     */
    public Deserializador() {;
    }
    
    /**
     * Método que recibe el JSON y deserializa el comando para que se pueda utilizar.
     * @param Comando serializado que se deserializa.
     * @return 
     */
    private ICommand deserializarRespuesta(String respuesta){
        return gson.fromJson(respuesta, ICommand.class);
    }

    public void setFiltroSiguiente(IFiltro filtroSiguiente) {
        this.filtroSiguiente = filtroSiguiente;
    }

    @Override
    public void notificar(String mensajeRecibido) {
        
    }
    
    
    
}
