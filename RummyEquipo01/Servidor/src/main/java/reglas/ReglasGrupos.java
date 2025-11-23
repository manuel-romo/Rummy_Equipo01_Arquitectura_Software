
package reglas;

import enumeradores.ColorFicha;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import objetos_negocio.Ficha;
import objetos_negocio.FichaComodin;
import objetos_negocio.FichaNormal;

/**
 *
 * @author Romo López Manuel
 * ID: 00000253080
 */
public class ReglasGrupos {
    
    
    public static boolean esGrupoSecuencia(List<Ficha> listaFichas){
        
        // Se ordenan las fichas de menor a mayor por número.
        listaFichas.sort((ficha1, ficha2) -> {

            if (ficha1.isEsComodin() && ficha2.isEsComodin()){
                return 0;
            }
            if (ficha1.isEsComodin()){
                return 1;
            }
            if (ficha2.isEsComodin()){
                return -1;
            }

            FichaNormal fichaNormal1 = (FichaNormal) ficha1;
            FichaNormal fichaNormal2 = (FichaNormal) ficha2;

            return Integer.compare(fichaNormal1.getNumero(), fichaNormal2.getNumero());
        
        });
        
        List<Ficha> listaComodines = new LinkedList<>();
        
        for(Ficha ficha: listaFichas){
            
            if(ficha.isEsComodin()){
                listaComodines.add(ficha);
            }
            
        }
        
        if(listaComodines.size() == listaFichas.size()){
            return true;
        }
        
        List<Ficha> listaFinalFichas = new LinkedList<>();
        
        int numeroSecuenciaSiguiente = ((FichaNormal)listaFichas.get(0)).getNumero();
        ColorFicha color = listaFichas.get(0).getColor();
        
        for(Ficha ficha: listaFichas){
            
            if(!ficha.isEsComodin()){
                
                if(((FichaNormal)ficha).getNumero() == numeroSecuenciaSiguiente && ficha.getColor() == color){
                
                    listaFinalFichas.add(ficha);

                    numeroSecuenciaSiguiente++;

                } else if(ficha.getColor() == color){

                    if(listaComodines.isEmpty()){
                       return false; 
                    }
                    
                    int cantidadComodinesNecesarios = ((FichaNormal)ficha).getNumero() - numeroSecuenciaSiguiente;

                    if(cantidadComodinesNecesarios <= 0 || cantidadComodinesNecesarios > listaComodines.size()){
                        return false;
                    }
                    
                    for(int i = 0; i < cantidadComodinesNecesarios; i++){
                        
                        listaFinalFichas.add(listaComodines.get(i));    
                    
                    }
                    
                    for(int i = 0; i < cantidadComodinesNecesarios; i++){
                        
                        listaComodines.remove(0); 
                    
                    }
                    
                    listaFinalFichas.add(ficha);
                                       
                    numeroSecuenciaSiguiente+= cantidadComodinesNecesarios + 1;

                } else{
                    
                    return false;
                    
                }
                
            } 
            
            
        }
        
        return true;
        
    }
    
    public static boolean esGrupoColores(List<Ficha> listaFichas){
        return false;
    }
}
