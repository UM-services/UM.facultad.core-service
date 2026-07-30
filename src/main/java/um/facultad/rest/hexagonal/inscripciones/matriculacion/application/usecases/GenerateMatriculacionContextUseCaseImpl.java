package um.facultad.rest.hexagonal.inscripciones.matriculacion.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.inscripciones.matriculacion.application.service.MatriculacionContextService;
import um.facultad.rest.hexagonal.inscripciones.matriculacion.domain.model.MatriculacionContext;
import um.facultad.rest.hexagonal.inscripciones.matriculacion.domain.ports.in.GenerateMatriculacionContextUseCase;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class GenerateMatriculacionContextUseCaseImpl implements GenerateMatriculacionContextUseCase {

    private final MatriculacionContextService matriculacionContextService;

    @Override
    public MatriculacionContext generateContextByPersonaAndLectivo(BigDecimal personaId, Integer documentoId, Integer lectivoId, Integer facultadId) {
        return MatriculacionContext.builder()
                .persona(matriculacionContextService.getPersona(personaId, documentoId))
                .inscripcion(matriculacionContextService.getInscripcion(personaId, documentoId, lectivoId, facultadId))
                .build();
    }

}
