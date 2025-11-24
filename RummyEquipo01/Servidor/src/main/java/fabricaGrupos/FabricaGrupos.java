
package fabricaGrupos;

import excepciones.RummyException;
import java.util.List;
import objetos_negocio.Ficha;
import objetos_negocio.Grupo;
import objetos_negocio.GrupoColores;
import objetos_negocio.GrupoSecuencia;


public class FabricaGrupos {
    
    public static Grupo crearGrupo(int numeroGrupo, List<Ficha> fichas){
        
        try{
            
            Grupo.validarGrupoColores(fichas);
            
            Grupo grupoColores = new GrupoColores(numeroGrupo, fichas);
            
            return grupoColores;
            
        } catch(RummyException ex){}
        
        
        try{
            
            Grupo.validarGrupoSecuencia(fichas);
            
            Grupo grupoSecuencia = new GrupoSecuencia(numeroGrupo, fichas);
            
            return grupoSecuencia;
            
        } catch(RummyException ex){}
        
        return null;
        
    }
    
}
