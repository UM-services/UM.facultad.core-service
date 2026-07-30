package um.facultad.rest.hexagonal.inscripciones.inscripcion.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.in.FindInscripcionByUniqueUseCase;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.out.InscripcionRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindInscripcionByUniqueUseCaseImpl implements FindInscripcionByUniqueUseCase {

    private final InscripcionRepository inscripcionRepository;

    @Override
    public Optional<Inscripcion> findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
        return inscripcionRepository.findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(facultadId, personaId, documentoId, lectivoId);
    }

}
