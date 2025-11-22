
package entidades;

/**
 *
 * @author juanpheras
 */
public class Comodin extends Ficha{
    
    private String valor;

    /**
     * Constructor que usa el constructor de la clase padre, y además inicializa el valor como "*" por ser comodin.
     * @param id id de la ficha.
     */
    public Comodin(Integer id) {
        super(id);
        this.valor = "*";
    }

    /**
     * Getter para el valor del comodin
     * @return valor de comodin.
     */
    public String getValor() {
        return valor;
    }

    @Override
    public boolean isComodin() {
        return true;
    }
    
    
    
    
    
}
