package um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.application.exception;

import java.math.BigDecimal;

public class InscripcionDetalleException extends RuntimeException {

    public InscripcionDetalleException() {
        super("InscripcionDetalle not found");
    }

    public InscripcionDetalleException(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer lectivoId) {
        super("Could not find InscripcionDetalle for personaId: " + personaId
                + ", documentoId: " + documentoId
                + ", facultadId: " + facultadId
                + ", lectivoId: " + lectivoId);
    }

}
