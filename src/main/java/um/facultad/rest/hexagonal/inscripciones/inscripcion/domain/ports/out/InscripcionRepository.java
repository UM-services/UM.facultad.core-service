package um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.out;

import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface InscripcionRepository {

    List<Inscripcion> findAllByFacultadIdAndLectivoId(Integer facultadId, Integer lectivoId);

    List<Inscripcion> findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCurso(Integer facultadId, Integer lectivoId, Integer geograficaId, Integer curso);

    List<Inscripcion> findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCursoAndProvisoria(Integer facultadId, Integer lectivoId, Integer geograficaId, Integer curso, Byte provisoria);

    List<Inscripcion> findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoIdLessThanOrderByLectivoIdDesc(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer lectivoId);

    Optional<Inscripcion> findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId);

    List<Inscripcion> saveAll(List<Inscripcion> inscriptos);

}
