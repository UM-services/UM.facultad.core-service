package um.facultad.rest.hexagonal.matriculacion.domain.ports.in;

import um.facultad.rest.hexagonal.matriculacion.domain.model.MatriculacionContext;

import java.math.BigDecimal;

public interface GenerateMatriculacionContextUseCase {

    MatriculacionContext generateContextByPersonaAndLectivo(BigDecimal personaId, Integer documentoId, Integer lectivoId, Integer facultadId);

}
