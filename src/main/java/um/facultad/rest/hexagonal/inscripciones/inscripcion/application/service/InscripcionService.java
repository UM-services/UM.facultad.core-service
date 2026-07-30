package um.facultad.rest.hexagonal.inscripciones.inscripcion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.application.exception.InscripcionException;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.in.*;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InscripcionService {

    private final FindInscripcionByLectivoUseCase findInscripcionByLectivoUseCase;
    private final FindInscripcionByCursoUseCase findInscripcionByCursoUseCase;
    private final FindInscripcionByCursoSinProvisoriaUseCase findInscripcionByCursoSinProvisoriaUseCase;
    private final FindInscripcionAnterioresUseCase findInscripcionAnterioresUseCase;
    private final FindInscripcionByUniqueUseCase findInscripcionByUniqueUseCase;
    private final SaveAllInscripcionUseCase saveAllInscripcionUseCase;

    public List<Inscripcion> findAllByLectivo(Integer facultadId, Integer lectivoId) {
        return findInscripcionByLectivoUseCase.findByLectivo(facultadId, lectivoId);
    }

    public List<Inscripcion> findAllByCurso(Integer facultadId, Integer lectivoId, Integer geograficaId, Integer curso) {
        return findInscripcionByCursoUseCase.findByCurso(facultadId, lectivoId, geograficaId, curso);
    }

    public List<Inscripcion> findAllByCursoSinProvisoria(Integer facultadId, Integer lectivoId, Integer geograficaId, Integer curso) {
        return findInscripcionByCursoSinProvisoriaUseCase.findByCursoSinProvisoria(facultadId, lectivoId, geograficaId, curso);
    }

    public List<Inscripcion> findAllAnteriores(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer lectivoId) {
        return findInscripcionAnterioresUseCase.findAnteriores(personaId, documentoId, facultadId, lectivoId);
    }

    public Inscripcion findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
        return findInscripcionByUniqueUseCase.findByUnique(facultadId, personaId, documentoId, lectivoId)
                .orElseThrow(() -> new InscripcionException(facultadId, personaId, documentoId, lectivoId));
    }

    public List<Inscripcion> saveAll(List<Inscripcion> inscriptos) {
        return saveAllInscripcionUseCase.saveAll(inscriptos);
    }

}
