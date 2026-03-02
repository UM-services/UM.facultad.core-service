package um.facultad.rest.hexagonal.matriculacion.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.matriculacion.application.service.MatriculacionContextService;
import um.facultad.rest.hexagonal.matriculacion.domain.model.MatriculacionContext;
import um.facultad.rest.hexagonal.matriculacion.domain.ports.in.GenerateMatriculacionContextUseCase;

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
