package um.facultad.rest.hexagonal.matriculacion.domain.ports.out;

import um.facultad.rest.hexagonal.matriculacion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.matriculacion.domain.model.Persona;

import java.math.BigDecimal;

public interface MatriculacionContextRepository {

    Persona findPersonaByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId);

    Inscripcion findInscripcionByPersonaIdAndDocumentoIdAndLectivoIdAndFacultadId(BigDecimal personaId, Integer documentoId, Integer lectivoId, Integer facultadId);

}
