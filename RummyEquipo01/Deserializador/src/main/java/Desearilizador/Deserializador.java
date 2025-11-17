/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Desearilizador;
import dto.RespuestaDTO;
import interfaces.IReceptorRespuestaDeserializada;
/**
 *
 * @author ramon
 */
public class Deserializador {
    private IReceptorRespuestaDeserializada receptorRespuestaDeserializada;

    public Deserializador(IReceptorRespuestaDeserializada receptorRespuestaDeserializada) {
        this.receptorRespuestaDeserializada = receptorRespuestaDeserializada;
    }
    
    private RespuestaDTO deserializarRespuesta(String respuesta){
        throw new ExceptionInInitializerError();
    }
}
