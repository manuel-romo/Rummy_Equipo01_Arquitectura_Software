///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package serializador;
//
//import interfaces.ICommand;
//import interfaces.IFiltro;
//
///**
// *
// * @author pedro
// */
//public class Serializador implements IFiltro {
//
//    private IFiltro filtroSiguiente;
//    private final gson = new Gson();
//    private String serializarAccion(ICommand command) {
//        
//    }
//
//    private void enviarAccionSerializada(String accionSerializada) {
//
//    }
//
//    @Override
//    public void ejecutar(ICommand comando) {
//        String accion = this.serializarAccion(comando);
//        this.enviarAccionSerializada(accion);
//
//        if (filtroSiguiente != null) {
//            filtroSiguiente.ejecutar(comando);
//        }
//    }
//}
