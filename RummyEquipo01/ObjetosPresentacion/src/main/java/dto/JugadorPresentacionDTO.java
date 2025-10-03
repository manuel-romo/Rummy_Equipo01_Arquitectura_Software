
package dto;

/**
 *
 * @author 
 */
public abstract class JugadorPresentacionDTO {
    private String avatar;
    private String nombre;
    private int numeroSecuencia;

    public JugadorPresentacionDTO(String avatar, String nombre, int numeroSecuencia) {
        this.avatar = avatar;
        this.nombre = nombre;
        this.numeroSecuencia = numeroSecuencia;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroSecuencia() {
        return numeroSecuencia;
    }
    
    
    
}
