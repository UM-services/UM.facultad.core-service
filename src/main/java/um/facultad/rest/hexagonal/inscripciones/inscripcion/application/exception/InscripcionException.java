package um.facultad.rest.hexagonal.inscripciones.inscripcion.application.exception;

import java.math.BigDecimal;

public class InscripcionException extends RuntimeException {

    public InscripcionException() {
        super("Inscripcion not found");
    }

    public InscripcionException(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
        super("Cannot find Inscripcion " + facultadId + "/" + personaId + "/" + documentoId + "/" + lectivoId);
    }

}
