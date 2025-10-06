package mock;

import dto.JugadorNegocioDTO;


/**
 * Contrato que define qué debe hacer una vista cuando recibe una notificación.
 */
public interface IComunicacionMock {
    void recibirAvisoFinTurno(JugadorNegocioDTO jugadorQueFinalizo);
}
