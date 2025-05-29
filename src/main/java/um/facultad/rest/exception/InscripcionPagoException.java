package um.facultad.rest.exception;

import java.math.BigDecimal;

public class InscripcionPagoException extends RuntimeException {

    public InscripcionPagoException(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
        super("Cannot find InscripcionPago " + facultadId + "/" + personaId + "/" + documentoId + "/" + lectivoId);
    }

}
