package um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.in;

import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;

import java.math.BigDecimal;
import java.util.Optional;

public interface FindInscripcionByUniqueUseCase {

    Optional<Inscripcion> findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId);

}
