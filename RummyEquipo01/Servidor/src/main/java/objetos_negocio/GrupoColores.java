
package objetos_negocio;

import enumeradores.ColorFicha;
import excepciones.GrupoExcedeLimiteException;
import excepciones.RummyException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author juanpheras
 */
public class GrupoColores extends Grupo {

    /**
     * Constructor de el grupo de colores.
     *
     * @param numero numero identificador del grupo.
     * @param fichas Fichas con las que se iniciara en el grupo.
     */
    public GrupoColores(Integer numero, List<Ficha> fichas) {
        super(numero, fichas);
    }

    public GrupoColores(List<Ficha> fichas) {
        super(fichas);
    }
    

    @Override
    public boolean comprobarValidez() {
        // Máximo 4 fichas
        if (this.fichas.size() < 3 || this.fichas.size() > 4) {
            return false;
        }

        // Número base
        Integer numeroGrupo = this.fichas.stream()
                .filter(f -> f instanceof FichaNormal)
                .map(f -> ((FichaNormal) f).getNumero())
                .findFirst()
                .orElse(null);

        // Si no hay ficha normal → solo comodines → inválido
        if (numeroGrupo == null) {
            return false;
        }

        // Validar que todos los números coincidan (normal) excepto comodines
        boolean numerosValidos = this.fichas.stream()
                .filter(f -> f instanceof FichaNormal)
                .allMatch(f -> ((FichaNormal) f).getNumero() == numeroGrupo);

        if (!numerosValidos) {
            return false;
        }

        Set<ColorFicha> colores = this.fichas.stream()
                .filter(f -> f instanceof FichaNormal)
                .map(f -> ((FichaNormal) f).getColor())
                .collect(Collectors.toSet());

        return colores.size() == this.fichas.stream()
                .filter(f -> f instanceof FichaNormal)
                .count();
    }

    /**
     * Se comprueba la validez al momento de que se agregaron ficha(s).
     *
     * @param fichas
     * @return verdadero si el grupo si es valido, falso si no.
     */
    @Override
    public void agregarFichas(List<Ficha> fichas) throws RummyException {

        Integer numeroGrupo;
        if (this.fichas.isEmpty()) { //Validamos si el grupo tiene o no fichas
            agregarEnGrupoVacio(fichas);
        }  //Aqui es si el grupo ya cuenta con fichas y procedemos a hacer la lógica 
        
        numeroGrupo = obtenerNumeroGrupo();

        Set<ColorFicha> coloresUsados = obtenerColoresUsados();

        for (Ficha ficha : fichas) {

            if (ficha instanceof FichaNormal fn) {
                if (numeroGrupo != null && fn.getNumero() != numeroGrupo) {
                    throw new RummyException("El numero a agregar debe de coincidir con el numero de grupo");
                }
                if (numeroGrupo == null) {
                    numeroGrupo = fn.getNumero(); //Si el grupo no tenia numero, la ficha a agregar lo define 
                }

                // Regla 2: color no repetido
                if (coloresUsados.contains(fn.getColor())) {
                    throw new RummyException(
                            "El color " + fn.getColor() + " ya existe en el grupo");
                }

                coloresUsados.add(fn.getColor());
            } else if (ficha instanceof FichaComodin) {
                //UN comodin no necesita validación
            }

        }

        validarMaximoFichas(this.fichas.size() + fichas.size());

        for (Ficha ficha : fichas) {
            ficha.setTieneGrupo(true);
            ficha.setGrupo(this);
        }

        this.fichas.addAll(fichas);

    }

    private void agregarEnGrupoVacio(List<Ficha> nuevas) throws RummyException {
        validarMaximoFichas(nuevas.size());
        nuevas.forEach(f -> f.setTieneGrupo(true));
        nuevas.forEach(f -> f.setGrupo(this));
        this.fichas.addAll(nuevas);
        
    }
    
    private Integer obtenerNumeroGrupo(){
        return this.fichas.stream()
            .filter(f -> f instanceof FichaNormal)
            .map(f -> ((FichaNormal) f).getNumero())
            .findFirst()
            .orElse(null);
    }

    private void validarMaximoFichas(int totalFichas) throws RummyException {
        if (totalFichas > 4) {
            throw new RummyException("El grupo que quieres formar no puede ser de más de 4 fichas");
        }
    }
    
    private Set<ColorFicha> obtenerColoresUsados(){
        return this.fichas.stream()
                .filter(f -> f instanceof FichaNormal)
                .map(f -> ((FichaNormal) f).getColor())
                .collect(Collectors.toSet());
    }

}
