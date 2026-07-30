package um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.in;

import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;

import java.util.List;

public interface FindInscripcionByCursoUseCase {

    List<Inscripcion> findByCurso(Integer facultadId, Integer lectivoId, Integer geograficaId, Integer curso);

}
