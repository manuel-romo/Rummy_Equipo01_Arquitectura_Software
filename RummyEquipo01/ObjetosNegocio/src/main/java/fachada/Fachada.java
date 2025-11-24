//
//package fachada;
//
//import dto.ColorFichaNegocioDTO;
//import dto.ComodinNegocioDTO;
//import dto.FichaNegocioDTO;
//import dto.FichaNormalNegocioDTO;
//import dto.GrupoColoresNegocioDTO;
//import dto.GrupoNegocioDTO;
//import dto.GrupoSecuenciaNegocioDTO;
//import dto.JugadorNegocioDTO;
//import dto.MontonNegocioDTO;
//import dto.TableroNegocioDTO;
//import entidades.ColorFicha;
//import entidades.Comodin;
//import entidades.Ficha;
//import entidades.FichaNormal;
//import entidades.Grupo;
//import entidades.GrupoColores;
//import entidades.GrupoSecuencia;
//import entidades.Jugador;
//import entidades.Monton;
//import excepciones.RummyException;
//import interfaces.ITablero;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author 
// */
//public class Fachada implements ITablero {
//
//    private List<Grupo> grupos;
//    private List<Ficha> fichas;
//    private List<Jugador> jugadores;
//    private Monton monton;
//    
//
//    public Fachada() {
//        this.grupos = new ArrayList<>();
//        this.fichas = new ArrayList<>();
//        this.jugadores = new ArrayList<>();
//        
//    }
//    
//    @Override
//    public void iniciarTurno(TableroNegocioDTO tableroNegocio) {
//        
//        JugadorNegocioDTO jugadorPrincipalNegocio = tableroNegocio.getJugadorPrincipal();
//        JugadorNegocioDTO[] jugadoresExternosNegocio = tableroNegocio.getJugadoreExternos();
//        GrupoNegocioDTO[] gruposNegocio = tableroNegocio.getGrupos();
//        MontonNegocioDTO montonNegocio = tableroNegocio.getMonton();
//       
//        List<FichaNegocioDTO> fichasNegocioJugadorPrincipal = jugadorPrincipalNegocio.getFichas();
//        List<Ficha> fichasJugadorPrincipal = new LinkedList<>();
//        
//        for(FichaNegocioDTO fichaNegocio: fichasNegocioJugadorPrincipal){
//            
//            fichasJugadorPrincipal.add(obtenerFicha(fichaNegocio));
//            
//        }
//        
//        Jugador jugadorPrincipal = new Jugador(
//                jugadorPrincipalNegocio.getAvatar(), 
//                jugadorPrincipalNegocio.getNombre(),
//                jugadorPrincipalNegocio.isEsPrimerTurno(),
//                fichasJugadorPrincipal);
//        jugadores.add(jugadorPrincipal);
//        
//        fichas.addAll(fichasJugadorPrincipal);
//        
//
//        for(JugadorNegocioDTO jugadorExternoNegocio: jugadoresExternosNegocio){
//            
//            List<FichaNegocioDTO> fichasNegocioJugadorExterno = jugadorExternoNegocio.getFichas();
//            List<Ficha> fichasJugadorExterno = new LinkedList<>();
//
//            for(FichaNegocioDTO fichaNegocio: fichasNegocioJugadorExterno){
//
//                fichasJugadorExterno.add(obtenerFicha(fichaNegocio));
//
//            }
//            
//            Jugador jugadorExterno = new Jugador(
//                jugadorExternoNegocio.getAvatar(), 
//                jugadorExternoNegocio.getNombre(),
//                jugadorExternoNegocio.isEsPrimerTurno(),
//                fichasJugadorExterno);
//            
//            jugadores.add(jugadorExterno);
//            
//            fichas.addAll(fichasJugadorExterno);
//        }
//        
//
//        for(GrupoNegocioDTO grupoNegocio: gruposNegocio){
//            
//            Grupo grupo;
//            
//            List<FichaNegocioDTO> fichasNegocio = grupoNegocio.getFichasNegocioDTO();
//            List<Ficha> fichasGrupo = new LinkedList<>();
//            
//            for(FichaNegocioDTO fichaNegocio: fichasNegocio){
//                
//                Ficha ficha = obtenerFicha(fichaNegocio);
//                fichasGrupo.add(ficha);
//                
//            }
//            
//            if(grupoNegocio instanceof GrupoSecuenciaNegocioDTO){
//                
//                grupo = new GrupoSecuencia(fichasGrupo);
//                
//            } else{
//                
//                grupo = new GrupoColores(fichasGrupo);
//            }
//            
//            for(Ficha ficha: fichas){
//                
//                ficha.setGrupo(grupo);
//                
//            }
//            
//            
//            grupos.add(grupo);
//            
//            fichas.addAll(fichasGrupo);
//            
//        }
//        
//        
//        List<FichaNegocioDTO> fichasMonton = montonNegocio.getFichas();
//        List<Ficha> fichas = new LinkedList<>();
//        
//        for(FichaNegocioDTO ficha: fichasMonton){
//            
//            fichas.add(obtenerFicha(ficha));
//            
//        }
//        
//        monton = new Monton(fichas);
//        
//        
//    }
//    
//    private Ficha obtenerFicha(FichaNegocioDTO fichaNegocio){
//        
//        Ficha ficha;
//        
//        if(fichaNegocio instanceof FichaNormalNegocioDTO){
//            
//            FichaNormalNegocioDTO fichaNormalNegocio = (FichaNormalNegocioDTO) fichaNegocio;
//            
//            ColorFichaNegocioDTO colorFichaNegocio = fichaNormalNegocio.getColor();
//            ColorFicha colorFicha;
//            
//            switch (colorFichaNegocio) {
//                case ColorFichaNegocioDTO.COLOR_A:
//                    colorFicha = ColorFicha.COLOR_A;
//                    break;
//                case ColorFichaNegocioDTO.COLOR_B:
//                    colorFicha = ColorFicha.COLOR_B;
//                    break;
//                case ColorFichaNegocioDTO.COLOR_C:
//                    colorFicha = ColorFicha.COLOR_C;
//                    break;
//                case ColorFichaNegocioDTO.COLOR_D:
//                    colorFicha = ColorFicha.COLOR_D;
//                    break;
//
//                default:
//                    throw new AssertionError();
//            }
//            
//            ficha = new FichaNormal(
//                    fichaNormalNegocio.getId(), 
//                    fichaNormalNegocio.getNumero(),
//                    colorFicha);
//            
//        } else{
//            
//            ComodinNegocioDTO comodin = (ComodinNegocioDTO)fichaNegocio;
//            
//            ficha = new Comodin(
//                    comodin.getId());
//        }
//        
//        return ficha;
//        
//    }
//   
//
//    @Override
//    public boolean agregarFichasTablero(int[] idFichas) {
//        if (idFichas.length == 0) {
//            return false;
//        }
//        
//
//        List<Ficha> listaFichas = new ArrayList<>();
//        for (int i = 0; i < idFichas.length; i++) {
//            Ficha fichaNueva = obtenerFichaPorId(idFichas[i]);
//            listaFichas.add(fichaNueva);
//        }
//
//        Grupo grupoNuevo = new GrupoSecuencia(listaFichas);
//        
//        grupos.add(grupoNuevo);
//        
//        return true;
//    }
//
//    @Override
//    public boolean agregarFichasTablero(int[] idFichas, int[] idsFichasGrupo) {
//        if (idFichas.length == 0) {
//            return false;
//        }
//        List<Ficha> listaFichas = new ArrayList<>();
//        for (int i = 0; i < idFichas.length; i++) {
//            Ficha fichaNueva = obtenerFichaPorId(idFichas[i]);
//            listaFichas.add(fichaNueva);
//        }
//        
//        List<Grupo> listaGruposAgregar = new ArrayList<>();
//        for (int i = 0; i < idsFichasGrupo.length; i++) {
//            Ficha fichaGrupo = obtenerFichaPorId(idsFichasGrupo[i]);
//            
//            System.out.println("Id de FICHA " + fichaGrupo.getId());
//            System.out.println("Grupo de FICHA: " + fichaGrupo.getGrupo().getNumero());
//            Grupo grupoAgregar = fichaGrupo.getGrupo();
//            
//            if(!listaGruposAgregar.contains(grupoAgregar)){
//                listaGruposAgregar.add(grupoAgregar);
//            }
//            
//        }
//        
//        for(Grupo grupo: listaGruposAgregar){
//            
//            System.out.println("AGREGANDO A GRUPO: " + grupo.getNumero());
//
//            try {
//                grupo.agregarFichas(listaFichas);
//            } catch (RummyException ex) {
//                Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        }
//       
//        return true;
//    }
//
//    @Override
//    public boolean quitarFichasJugador(int[] idsFichas) {
//        if (idsFichas.length == 0) {
//            return false;
//        }
//        
//        Jugador jugador1 = jugadores.get(0);
//        
//        jugador1.quitarFichas(idsFichas);
//        return true;
//    }
//
//    @Override
//    public boolean quitarFichasTablero(int[] idFichas) {
//        if (idFichas.length == 0) {
//            return false;
//        }
//        
//        for (int i = 0; i < idFichas.length; i++) {
//            Ficha ficha = obtenerFichaPorId(idFichas[i]);
//            Grupo grupo = ficha.getGrupo();
//            List fichas = new LinkedList();
//            fichas.add(ficha);
//            grupo.removerFichas(fichas);
//            
//            
//        }
//        
//        return true;
//    }
//
//    @Override
//    public boolean seleccionarFichasTablero(int[] idFichas) {
//        if (idFichas.length == 0) {
//            return false;
//        }
//        List<Ficha> fichasSeleccionadas = new ArrayList<>();
//        for (int i = 0; i < idFichas.length; i++) {
//            Ficha fichaSeleccionada = obtenerFichaPorId(idFichas[i]);
//            fichasSeleccionadas.add(fichaSeleccionada);
//        }
//        return true;
//    }
//
//    private Ficha obtenerFichaPorId(int idFicha) {
//        for (Ficha ficha : fichas) {
//            
//            if (ficha.getId() == idFicha) {
//                return ficha;
//            }
//        }
//        return null;
//    }
//
//    private Grupo obtenerGrupoPorId(int numeroGrupo) {
//        for (Grupo grupo : grupos) {
//            if (grupo.getNumero() == numeroGrupo) {
//                return grupo;
//            }
//        }
//        return null;
//    }
//
//
//    @Override
//    public boolean validarGrupos() {
//        for (Grupo grupo : grupos) {
//            if (!grupo.comprobarValidez()) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public JugadorNegocioDTO obtenerJugadorPrincipal() {
//        
//        Jugador jugadorPrincipal = this.jugadores.get(0);
//        List<Ficha> fichasJugador = jugadorPrincipal.getFichas();
//        List<FichaNegocioDTO> fichasNegocio = new LinkedList<>();
//        List<ComodinNegocioDTO> comodinesNegocio = new LinkedList<>();
//
//        for (Ficha ficha : fichasJugador) {
//            // Si es una FichaNormal
//            if (ficha instanceof FichaNormal) {
//                FichaNormal fichaNormal = (FichaNormal) ficha;
//
//                FichaNegocioDTO fichaNegocio = obtenerFichaNegocioDTO(fichaNormal);
//                
//                fichasNegocio.add(fichaNegocio);
//            }
//        }
//
//        JugadorNegocioDTO jugadorPrincipalDTO = new JugadorNegocioDTO(
//                fichasNegocio, 
//                jugadorPrincipal.getAvatar(), 
//                jugadorPrincipal.getNombre(), 
//                jugadorPrincipal.isPrimerTurno());
//        
//        return jugadorPrincipalDTO;
//    }
//
//    @Override
//    public JugadorNegocioDTO[] obtenerJugadoresExternos() {
//        
//        Jugador jugadorPrincipal = this.jugadores.get(1);
//        List<Ficha> fichasJugador = jugadorPrincipal.getFichas();
//        List<FichaNegocioDTO> fichasNegocio = new ArrayList<>();
//
//        for (Ficha ficha : fichasJugador) {
//            // Si es una FichaNormal
//            if (ficha instanceof FichaNormal) {
//                FichaNormal fichaNormal = (FichaNormal) ficha;
//
//                
//                fichasNegocio.add(obtenerFichaNegocioDTO(fichaNormal));
//            }
//        }
//
//        JugadorNegocioDTO jugadorPrincipalDTO = new JugadorNegocioDTO(
//                fichasNegocio, 
//                jugadorPrincipal.getAvatar(), 
//                jugadorPrincipal.getNombre(), 
//                jugadorPrincipal.isPrimerTurno());
//        
//        JugadorNegocioDTO[] jugadoresNegocioDTO = {jugadorPrincipalDTO};
//        
//        return jugadoresNegocioDTO;
//        
//    }
//    
//
//    @Override
//    public MontonNegocioDTO obtenerMonton() {
//        List<Ficha> fichasMonton = monton.getFichas();
//        List<FichaNegocioDTO> fichasNegocio = new LinkedList<>();
//
//        for (Ficha ficha : fichasMonton) {
//            // Si es una FichaNormal
//            if (ficha instanceof FichaNormal) {
//                FichaNormal fichaNormal = (FichaNormal) ficha;
//
//                FichaNegocioDTO fichaNegocio = obtenerFichaNegocioDTO(fichaNormal);
//                
//                fichasNegocio.add(fichaNegocio);
//            }
//        }
//        
//        return new MontonNegocioDTO(fichasNegocio);
//    }
//    
//    private FichaNegocioDTO obtenerFichaNegocioDTO(FichaNormal ficha){
//        
//        FichaNormal fichaNormal = (FichaNormal) ficha;
//
//        ColorFicha colorFicha = fichaNormal.getColor();
//        ColorFichaNegocioDTO colorFichaNegocio;
//
//        switch (colorFicha) {
//            case ColorFicha.COLOR_A:
//                colorFichaNegocio = ColorFichaNegocioDTO.COLOR_A;
//                break;
//            case ColorFicha.COLOR_B:
//                colorFichaNegocio = ColorFichaNegocioDTO.COLOR_B;
//                break;
//            case ColorFicha.COLOR_C:
//                colorFichaNegocio = ColorFichaNegocioDTO.COLOR_C;
//                break;
//            case ColorFicha.COLOR_D:
//                colorFichaNegocio = ColorFichaNegocioDTO.COLOR_D;
//                break;
//
//            default:
//                throw new AssertionError();
//        }
//
//        FichaNegocioDTO fichaNegocio = new FichaNormalNegocioDTO(
//                fichaNormal.getNumero(),
//                fichaNormal.getId(),
//                colorFichaNegocio
//        );
//
//        return fichaNegocio;
//        
//    }
//
//        
//    @Override
//    public GrupoNegocioDTO[] obtenerGruposNegocio() {
//        
//        List<GrupoNegocioDTO> listaGruposNegocio = new LinkedList<>();
//        for(Grupo grupo: grupos){
//            
//            List<FichaNegocioDTO> fichasNegocioGrupo = new LinkedList<>();
//
//            for(Ficha fichaGrupo: grupo.getFichas()){
//
//                fichasNegocioGrupo.add(obtenerFichaNegocioDTO((FichaNormal)fichaGrupo));
//
//            }
//
//            if(grupo instanceof GrupoColores){
//                
//                GrupoNegocioDTO grupoNegocio = new GrupoColoresNegocioDTO(grupo.getNumero(), fichasNegocioGrupo);
//                listaGruposNegocio.add(grupoNegocio);
//                
//            } else if(grupo instanceof GrupoSecuencia){
//                GrupoNegocioDTO grupoNegocio = new GrupoSecuenciaNegocioDTO(grupo.getNumero(), fichasNegocioGrupo);
//                listaGruposNegocio.add(grupoNegocio);
//            }
//            
//        }
//        
//        GrupoNegocioDTO[] gruposNegocio = listaGruposNegocio.toArray(new GrupoNegocioDTO[0]);
//        
//        System.out.println("GRUPOS NEGOCIO OBTENIDOS......");
//        
//        for(GrupoNegocioDTO grupo: gruposNegocio){
//            System.out.println("---");
//            System.out.println(grupo.getNumero());
//            System.out.println("---");
//            System.out.println("Fichas del grupo: ");
//            
//            for(FichaNegocioDTO ficha: grupo.getFichasNegocioDTO()){
//                
//                System.out.println(ficha.getId());
//                
//            }
//        }
//        
//        System.out.println("-------------------------------");
//        
//        return gruposNegocio;
//        
//    }
//
//
//
//
//
//}
