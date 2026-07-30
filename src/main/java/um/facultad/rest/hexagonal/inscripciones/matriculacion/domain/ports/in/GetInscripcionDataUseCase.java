package um.facultad.rest.hexagonal.inscripciones.matriculacion.domain.ports.in;

import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;

import java.math.BigDecimal;

public interface GetInscripcionDataUseCase {

    Inscripcion getInscripcion(BigDecimal personaId, Integer documentoId, Integer lectivoId, Integer facultadId);

}
