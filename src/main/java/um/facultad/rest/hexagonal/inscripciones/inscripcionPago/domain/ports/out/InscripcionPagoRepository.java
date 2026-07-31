package um.facultad.rest.hexagonal.inscripciones.inscripcionPago.domain.ports.out;

import java.math.BigDecimal;
import java.util.Optional;

import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.domain.model.InscripcionPago;

public interface InscripcionPagoRepository {

    Optional<InscripcionPago> findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId);

}
