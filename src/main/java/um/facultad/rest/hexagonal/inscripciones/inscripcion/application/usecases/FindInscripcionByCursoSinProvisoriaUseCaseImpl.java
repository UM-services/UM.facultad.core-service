package um.facultad.rest.hexagonal.inscripciones.inscripcion.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.in.FindInscripcionByCursoSinProvisoriaUseCase;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.out.InscripcionRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindInscripcionByCursoSinProvisoriaUseCaseImpl implements FindInscripcionByCursoSinProvisoriaUseCase {

    private final InscripcionRepository inscripcionRepository;

    @Override
    public List<Inscripcion> findByCursoSinProvisoria(Integer facultadId, Integer lectivoId, Integer geograficaId, Integer curso) {
        return inscripcionRepository.findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCursoAndProvisoria(facultadId, lectivoId, geograficaId, curso, (byte) 0);
    }

}
