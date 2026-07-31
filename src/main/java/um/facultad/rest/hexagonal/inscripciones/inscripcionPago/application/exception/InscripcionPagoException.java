package um.facultad.rest.hexagonal.inscripciones.inscripcionPago.application.exception;

import java.math.BigDecimal;

public class InscripcionPagoException extends RuntimeException {

    public InscripcionPagoException() {
        super("InscripcionPago not found");
    }

    public InscripcionPagoException(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
        super("Cannot find InscripcionPago " + facultadId + "/" + personaId + "/" + documentoId + "/" + lectivoId);
    }

}
