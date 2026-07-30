package um.facultad.rest.hexagonal.tesoreriaEstado.application.exception;

import java.math.BigDecimal;

public class TesoreriaEstadoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TesoreriaEstadoException() {
        super("TesoreriaEstado not found");
    }

    public TesoreriaEstadoException(Integer facultadId, BigDecimal personaId, Integer documentoId) {
        super("Cannot find TesoreriaEstado " + facultadId + "/" + personaId + "/" + documentoId);
    }
}
