package um.facultad.rest.hexagonal.inscripciones.inscripcion.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.in.FindInscripcionByLectivoUseCase;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.out.InscripcionRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindInscripcionByLectivoUseCaseImpl implements FindInscripcionByLectivoUseCase {

    private final InscripcionRepository inscripcionRepository;

    @Override
    public List<Inscripcion> findByLectivo(Integer facultadId, Integer lectivoId) {
        return inscripcionRepository.findAllByFacultadIdAndLectivoId(facultadId, lectivoId);
    }

}
