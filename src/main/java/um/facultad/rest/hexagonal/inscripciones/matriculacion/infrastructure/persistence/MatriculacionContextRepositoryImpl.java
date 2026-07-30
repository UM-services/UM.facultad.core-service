package um.facultad.rest.hexagonal.inscripciones.matriculacion.infrastructure.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.application.exception.InscripcionException;
import um.facultad.rest.exception.PersonaException;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.persistence.entity.InscripcionEntity;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.persistence.repository.JpaInscripcionRepository;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.inscripciones.matriculacion.domain.model.Persona;
import um.facultad.rest.hexagonal.inscripciones.matriculacion.domain.ports.out.MatriculacionContextRepository;
import um.facultad.rest.hexagonal.inscripciones.matriculacion.infrastructure.mapper.InscripcionMapper;
import um.facultad.rest.hexagonal.inscripciones.matriculacion.infrastructure.mapper.PersonaMapper;
import um.facultad.rest.model.PersonaEntity;
import um.facultad.rest.repository.PersonaRepository;

import java.math.BigDecimal;

@Component
public class MatriculacionContextRepositoryImpl implements MatriculacionContextRepository {

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;
    private final JpaInscripcionRepository inscripcionRepository;
    private final InscripcionMapper inscripcionMapper;

    @Autowired
    public MatriculacionContextRepositoryImpl(PersonaRepository personaRepository, PersonaMapper personaMapper, JpaInscripcionRepository inscripcionRepository, @Qualifier("matriculacionInscripcionMapper") InscripcionMapper inscripcionMapper) {
        this.personaRepository = personaRepository;
        this.personaMapper = personaMapper;
        this.inscripcionRepository = inscripcionRepository;
        this.inscripcionMapper = inscripcionMapper;
    }

    @Override
    public Persona findPersonaByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId) {
        PersonaEntity personaEntity = personaRepository.findByPersonaIdAndDocumentoId(personaId, documentoId)
                .orElseThrow(() -> new PersonaException(personaId, documentoId));
        return personaMapper.toModel(personaEntity);
    }

    @Override
    public Inscripcion findInscripcionByPersonaIdAndDocumentoIdAndLectivoIdAndFacultadId(BigDecimal personaId, Integer documentoId, Integer lectivoId, Integer facultadId) {
        InscripcionEntity inscripcionEntity = inscripcionRepository.findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(facultadId, personaId, documentoId, lectivoId)
                .orElseThrow(() -> new InscripcionException(facultadId, personaId, documentoId, lectivoId));
        return inscripcionMapper.toModel(inscripcionEntity);
    }

}
