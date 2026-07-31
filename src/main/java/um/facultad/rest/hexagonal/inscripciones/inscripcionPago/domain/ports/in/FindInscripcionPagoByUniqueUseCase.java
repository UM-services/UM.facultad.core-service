package um.facultad.rest.hexagonal.inscripciones.inscripcionPago.domain.ports.in;

import java.math.BigDecimal;
import java.util.Optional;

import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.domain.model.InscripcionPago;

public interface FindInscripcionPagoByUniqueUseCase {

    Optional<InscripcionPago> findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId);

}
