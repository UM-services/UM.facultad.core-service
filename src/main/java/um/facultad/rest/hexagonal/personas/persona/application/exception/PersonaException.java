package um.facultad.rest.hexagonal.personas.persona.application.exception;

import java.math.BigDecimal;

public class PersonaException extends RuntimeException {

    private static final long serialVersionUID = 5733282570465285417L;

    public PersonaException() {
        super("Persona not found");
    }

    public PersonaException(BigDecimal personaId, Integer documentoId) {
        super("Cannot find Persona " + personaId + "/" + documentoId);
    }

}
