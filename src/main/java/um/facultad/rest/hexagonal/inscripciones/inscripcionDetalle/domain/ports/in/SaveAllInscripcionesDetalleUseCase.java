package um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.ports.in;

import java.util.List;

import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.model.InscripcionDetalle;

public interface SaveAllInscripcionesDetalleUseCase {

    List<InscripcionDetalle> saveAll(List<InscripcionDetalle> inscripcionesDetalle);

}
