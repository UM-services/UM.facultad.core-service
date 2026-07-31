package um.facultad.rest.hexagonal.inscripciones.matriculacion.infrastructure.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.application.exception.InscripcionException;
import um.facultad.rest.hexagonal.personas.persona.application.exception.PersonaException;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.persistence.entity.InscripcionEntity;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.persistence.mapper.InscripcionMapper;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.persistence.repository.JpaInscripcionRepository;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.personas.persona.domain.model.Persona;
import um.facultad.rest.hexagonal.inscripciones.matriculacion.domain.ports.out.MatriculacionContextRepository;
import um.facultad.rest.hexagonal.personas.persona.infrastructure.persistence.entity.PersonaEntity;
import um.facultad.rest.hexagonal.personas.persona.infrastructure.persistence.mapper.PersonaMapper;
import um.facultad.rest.hexagonal.personas.persona.infrastructure.persistence.repository.JpaPersonaRepository;

import java.math.BigDecimal;

@Component
public class MatriculacionContextRepositoryImpl implements MatriculacionContextRepository {

    private final JpaPersonaRepository personaRepository;
    private final PersonaMapper personaMapper;
    private final JpaInscripcionRepository inscripcionRepository;
    private final InscripcionMapper inscripcionMapper;

    @Autowired
    public MatriculacionContextRepositoryImpl(JpaPersonaRepository personaRepository, @Qualifier("personasPersonaMapper") PersonaMapper personaMapper, JpaInscripcionRepository inscripcionRepository, InscripcionMapper inscripcionMapper) {
        this.personaRepository = personaRepository;
        this.personaMapper = personaMapper;
        this.inscripcionRepository = inscripcionRepository;
        this.inscripcionMapper = inscripcionMapper;
    }

    @Override
    public Persona findPersonaByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId) {
        PersonaEntity personaEntity = personaRepository.findByPersonaIdAndDocumentoId(personaId, documentoId)
                .orElseThrow(() -> new PersonaException(personaId, documentoId));
        return personaMapper.toDomain(personaEntity);
    }

    @Override
    public Inscripcion findInscripcionByPersonaIdAndDocumentoIdAndLectivoIdAndFacultadId(BigDecimal personaId, Integer documentoId, Integer lectivoId, Integer facultadId) {
        InscripcionEntity inscripcionEntity = inscripcionRepository.findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(facultadId, personaId, documentoId, lectivoId)
                .orElseThrow(() -> new InscripcionException(facultadId, personaId, documentoId, lectivoId));
        return inscripcionMapper.toDomain(inscripcionEntity);
    }

}
