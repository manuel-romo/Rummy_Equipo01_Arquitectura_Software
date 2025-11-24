
package deserializador;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import comandosRespuesta.ComandoCambioTurno;
import comandosRespuesta.ComandoIniciarTurno;
import comandosRespuesta.ComandoReestablecerRespuesta;
import comandosRespuesta.ComandoRespuestaMovimiento;
import comandosRespuesta.ComandoTableroInvalido;
import comandosSolicitud.ComandoAgregarFichasTablero;
import comandosSolicitud.ComandoAgregarFichasTableroGrupo;
import comandosSolicitud.ComandoQuitarFichasJugador;
import comandosSolicitud.ComandoQuitarFichasTablero;
import comandosSolicitud.ComandoReestablecerTablero;
import comandosSolicitud.ComandoSeleccionarFichasTablero;
import comandosSolicitud.ComandoTerminarTurno;
import dto.FichaDTO;
import interfaces.ICommand;
import interfaces.IFiltro;
import interfaces.IReceptorExterno;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author ramon
 */
public class Deserializador implements IReceptorExterno{
    
    private IFiltro filtroSiguiente;
    private final Gson gson;
    private final Map<String, Class<? extends ICommand>> registroComandos;

    public Deserializador() {

        this.registroComandos = new HashMap<>();
        registrarComandos();

        this.gson = new GsonBuilder()
                .registerTypeAdapter(FichaDTO.class, new FichaAdaptador())
                .create();
    }
    
    private void registrarComandos() {
        registroComandos.put("ComandoIniciarTurno", ComandoIniciarTurno.class);
        registroComandos.put("ComandoCambioTurno", ComandoCambioTurno.class);
        registroComandos.put("ComandoRespuestaMovimiento", ComandoRespuestaMovimiento.class);
        registroComandos.put("ComandoReestablecerRespuesta", ComandoReestablecerRespuesta.class);
        registroComandos.put("ComandoTableroInvalido", ComandoTableroInvalido.class);
        registroComandos.put("ComandoAgregarFichasTablero", ComandoAgregarFichasTablero.class);
        registroComandos.put("ComandoAgregarFichasTableroGrupo", ComandoAgregarFichasTableroGrupo.class);
        registroComandos.put("ComandoQuitarFichasJugador", ComandoQuitarFichasJugador.class);
        registroComandos.put("ComandoQuitarFichasTablero", ComandoQuitarFichasTablero.class);
        registroComandos.put("ComandoReestablecerTablero", ComandoReestablecerTablero.class);
        registroComandos.put("ComandoSeleccionarFichasTablero", ComandoSeleccionarFichasTablero.class);
        registroComandos.put("ComandoTerminarTurno", ComandoTerminarTurno.class);
    }
    
    /**
     * Método que recibe el JSON y deserializa el comando para que se pueda utilizar.
     * @param Comando serializado que se deserializa.
     * @return 
     */
    private ICommand deserializarRespuesta(String respuesta) {
        try {

            JsonObject objetoJson = JsonParser.parseString(respuesta).getAsJsonObject();
            
            if (!objetoJson.has("type")){
                return null;
            }
            
            String type = objetoJson.get("type").getAsString();
            
            Class<? extends ICommand> claseComando = registroComandos.get(type);

            if (claseComando != null) {
                
                return gson.fromJson(objetoJson, claseComando);
            }

        } catch (JsonSyntaxException e) {
            System.out.println(e.getMessage());
            System.err.println("Error al deserializar JSON: " + e.getMessage());
        }
        return null;
    }

    public void setFiltroSiguiente(IFiltro filtroSiguiente) {
        this.filtroSiguiente = filtroSiguiente;
    }

    @Override
    public void notificar(String mensajeRecibido) {
        filtroSiguiente.ejecutar(deserializarRespuesta(mensajeRecibido));
        
    }
    
    
}
