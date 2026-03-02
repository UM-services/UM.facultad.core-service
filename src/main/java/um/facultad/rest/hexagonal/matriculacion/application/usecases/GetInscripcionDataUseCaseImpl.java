package um.facultad.rest.hexagonal.matriculacion.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.matriculacion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.matriculacion.domain.ports.in.GetInscripcionDataUseCase;
import um.facultad.rest.hexagonal.matriculacion.domain.ports.out.MatriculacionContextRepository;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class GetInscripcionDataUseCaseImpl implements GetInscripcionDataUseCase {

    private final MatriculacionContextRepository matriculacionContextRepository;

    @Override
    public Inscripcion getInscripcion(BigDecimal personaId, Integer documentoId, Integer lectivoId, Integer facultadId) {
        return matriculacionContextRepository.findInscripcionByPersonaIdAndDocumentoIdAndLectivoIdAndFacultadId(personaId, documentoId, lectivoId, facultadId);
    }

}
