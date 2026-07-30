package um.facultad.rest.hexagonal.inscripciones.inscripcion.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.in.FindInscripcionAnterioresUseCase;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.out.InscripcionRepository;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FindInscripcionAnterioresUseCaseImpl implements FindInscripcionAnterioresUseCase {

    private final InscripcionRepository inscripcionRepository;

    @Override
    public List<Inscripcion> findAnteriores(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer lectivoId) {
        return inscripcionRepository.findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoIdLessThanOrderByLectivoIdDesc(personaId, documentoId, facultadId, lectivoId);
    }

}
