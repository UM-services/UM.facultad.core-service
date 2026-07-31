package um.facultad.rest.hexagonal.personas.domicilio.application.exception;

import java.math.BigDecimal;

public class DomicilioException extends RuntimeException {

    private static final long serialVersionUID = 462198878153217521L;

    public DomicilioException() {
        super("Domicilio not found");
    }

    public DomicilioException(BigDecimal personaId, Integer documentoId) {
        super("Cannot find Domicilio " + personaId + "/" + documentoId);
    }

}
