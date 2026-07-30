package um.facultad.rest.hexagonal.inscripciones.inscripcion.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.in.FindInscripcionByCursoUseCase;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.out.InscripcionRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindInscripcionByCursoUseCaseImpl implements FindInscripcionByCursoUseCase {

    private final InscripcionRepository inscripcionRepository;

    @Override
    public List<Inscripcion> findByCurso(Integer facultadId, Integer lectivoId, Integer geograficaId, Integer curso) {
        return inscripcionRepository.findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCurso(facultadId, lectivoId, geograficaId, curso);
    }

}
