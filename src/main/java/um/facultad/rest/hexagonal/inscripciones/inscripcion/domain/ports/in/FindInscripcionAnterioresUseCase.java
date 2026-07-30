package um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.in;

import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;

import java.math.BigDecimal;
import java.util.List;

public interface FindInscripcionAnterioresUseCase {

    List<Inscripcion> findAnteriores(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer lectivoId);

}
