
package deserializador;
import com.google.gson.Gson;
import dto.RespuestaDTO;
import interfaces.ICommand;
import interfaces.IReceptorRespuestaDeserializada;
/**
 *
 * @author ramon
 */
public class Deserializador {
    private IReceptorRespuestaDeserializada receptorRespuestaDeserializada;
    private final Gson gson = new Gson();

    /***
     * Método constructor que recibe una instancia que implementa IReceptorRespuestaDeserializada para avisarle.
     * @param receptorRespuestaDeserializada instancia de IReceptorRespuestaDeserializada
     */
    public Deserializador(IReceptorRespuestaDeserializada receptorRespuestaDeserializada) {
        this.receptorRespuestaDeserializada = receptorRespuestaDeserializada;
    }
    
    /**
     * Método que recibe el JSON y deserializa el comando para que se pueda utilizar.
     * @param Comando serializado que se deserializa.
     * @return 
     */
    private ICommand deserializarRespuesta(String respuesta){
        return gson.fromJson(respuesta, ICommand.class);
    }
}
