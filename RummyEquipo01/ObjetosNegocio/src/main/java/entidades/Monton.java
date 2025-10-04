package entidades;

/**
 *
 * @author pedro
 */
public class Monton {
    private Ficha[] fichas;

    /**
     * Obtiene el arreglo de fichas que forman parte del montón.
     * 
     * @return el arreglo de fichas.
     */
    public Ficha[] getFichas() {
        return fichas;
    }

    /**
     * Asigna las fichas que formarán parte del montón.
     * 
     * @param fichas el arreglo de fichas a asignar.
     */
    public void setFichas(Ficha[] fichas) {
        this.fichas = fichas;
    }
        
    /**
     * Devuelve el número de fichas que contiene actualmente el montón.
     * 
     * @return la cantidad de fichas, o 0 si aún no se han asignado.
     */
    public int getNumeroFichas() {
        if (fichas == null) {
            return 0;
        }
        return fichas.length;
    }
}