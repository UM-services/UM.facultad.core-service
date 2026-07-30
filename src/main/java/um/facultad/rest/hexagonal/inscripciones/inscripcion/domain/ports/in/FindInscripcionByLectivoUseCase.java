package um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.in;

import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;

import java.util.List;

public interface FindInscripcionByLectivoUseCase {

    List<Inscripcion> findByLectivo(Integer facultadId, Integer lectivoId);

}
