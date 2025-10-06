package mock;

import dto.JugadorNegocioDTO;


public class ComunicacionMock {

    private static IComunicacionMock jugador1;
    private static IComunicacionMock jugador2;

    private static String nombreJugador1;
    private static String nombreJugador2;

    public static void registrarJugador(String nombre, IComunicacionMock vista) {
        if (jugador1 == null) {
            jugador1 = vista;
            nombreJugador1 = nombre;
        } else {
            jugador2 = vista;
            nombreJugador2 = nombre;
        }
    }

    public static void avisarFinTurno(JugadorNegocioDTO jugadorQueFinalizo) {
        if (jugador1 == null || jugador2 == null) return;

        if (jugadorQueFinalizo.getNombre().equals(nombreJugador1)) {
            jugador2.recibirAvisoFinTurno(jugadorQueFinalizo);
        } else if (jugadorQueFinalizo.getNombre().equals(nombreJugador2)){
            jugador1.recibirAvisoFinTurno(jugadorQueFinalizo);
        }
    }
}
