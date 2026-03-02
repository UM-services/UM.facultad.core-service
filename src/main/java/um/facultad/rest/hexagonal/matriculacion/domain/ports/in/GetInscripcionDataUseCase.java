package um.facultad.rest.hexagonal.matriculacion.domain.ports.in;

import um.facultad.rest.hexagonal.matriculacion.domain.model.Inscripcion;

import java.math.BigDecimal;

public interface GetInscripcionDataUseCase {

    Inscripcion getInscripcion(BigDecimal personaId, Integer documentoId, Integer lectivoId, Integer facultadId);

}
