package um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.ports.out;

import java.math.BigDecimal;
import java.util.List;

import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.model.InscripcionDetalle;

public interface InscripcionDetalleRepository {

    List<InscripcionDetalle> findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoId(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer lectivoId);

    List<InscripcionDetalle> saveAll(List<InscripcionDetalle> inscripcionesDetalle);

}
