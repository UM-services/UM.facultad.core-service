package um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.ports.out.InscripcionRepository;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.persistence.mapper.InscripcionMapper;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.persistence.repository.JpaInscripcionRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaInscripcionRepositoryAdapter implements InscripcionRepository {

    private final JpaInscripcionRepository jpaInscripcionRepository;
    private final InscripcionMapper inscripcionMapper;

    @Override
    public List<Inscripcion> findAllByFacultadIdAndLectivoId(Integer facultadId, Integer lectivoId) {
        return jpaInscripcionRepository.findAllByFacultadIdAndLectivoId(facultadId, lectivoId)
                .stream()
                .map(inscripcionMapper::toDomain)
                .toList();
    }

    @Override
    public List<Inscripcion> findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCurso(Integer facultadId, Integer lectivoId, Integer geograficaId, Integer curso) {
        return jpaInscripcionRepository.findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCurso(facultadId, lectivoId, geograficaId, curso)
                .stream()
                .map(inscripcionMapper::toDomain)
                .toList();
    }

    @Override
    public List<Inscripcion> findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCursoAndProvisoria(Integer facultadId, Integer lectivoId, Integer geograficaId, Integer curso, Byte provisoria) {
        return jpaInscripcionRepository.findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCursoAndProvisoria(facultadId, lectivoId, geograficaId, curso, provisoria)
                .stream()
                .map(inscripcionMapper::toDomain)
                .toList();
    }

    @Override
    public List<Inscripcion> findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoIdLessThanOrderByLectivoIdDesc(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer lectivoId) {
        return jpaInscripcionRepository.findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoIdLessThanOrderByLectivoIdDesc(personaId, documentoId, facultadId, lectivoId)
                .stream()
                .map(inscripcionMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Inscripcion> findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
        return jpaInscripcionRepository.findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(facultadId, personaId, documentoId, lectivoId)
                .map(inscripcionMapper::toDomain);
    }

    @Override
    public List<Inscripcion> saveAll(List<Inscripcion> inscriptos) {
        var entities = inscriptos.stream()
                .map(inscripcionMapper::toEntity)
                .toList();
        return jpaInscripcionRepository.saveAll(entities)
                .stream()
                .map(inscripcionMapper::toDomain)
                .toList();
    }

}
