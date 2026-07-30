package um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.in;

import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;

import java.util.List;

public interface SaveAllInscripcionUseCase {

    List<Inscripcion> saveAll(List<Inscripcion> inscriptos);

}
