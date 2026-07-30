package um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.ports.in;

import java.math.BigDecimal;
import java.util.List;

import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.model.InscripcionDetalle;

public interface FindInscripcionesDetalleByPersonaUseCase {

    List<InscripcionDetalle> findByPersona(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer lectivoId);

}
