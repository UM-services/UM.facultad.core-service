package um.facultad.rest.hexagonal.matriculacion.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.exception.CarreraException;
import um.facultad.rest.exception.InscripcionException;
import um.facultad.rest.exception.PersonaException;
import um.facultad.rest.hexagonal.matriculacion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.matriculacion.domain.model.Persona;
import um.facultad.rest.hexagonal.matriculacion.domain.ports.out.MatriculacionContextRepository;
import um.facultad.rest.hexagonal.matriculacion.infrastructure.mapper.InscripcionMapper;
import um.facultad.rest.hexagonal.matriculacion.infrastructure.mapper.PersonaMapper;
import um.facultad.rest.model.*;
import um.facultad.rest.repository.*;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MatriculacionContextRepositoryImpl implements MatriculacionContextRepository {

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;
    private final InscripcionRepository inscripcionRepository;
    private final InscripcionMapper inscripcionMapper;
    private final CarreraRepository carreraRepository;
    private final InscripcionDetalleRepository inscripcionDetalleRepository;

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
        CarreraEntity carreraEntity = carreraRepository.findByFacultadIdAndPlanIdAndCarreraId(facultadId, inscripcionEntity.getPlanId(), inscripcionEntity.getCarreraId())
                .orElseThrow(() -> new CarreraException(facultadId, inscripcionEntity.getPlanId(),  inscripcionEntity.getCarreraId()));
        List<MateriaEntity> materiaEntityList = inscripcionDetalleRepository.findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoId(personaId, documentoId, facultadId, lectivoId)
                .stream()
                .map(InscripcionDetalleEntity::getMateria).toList();
        return inscripcionMapper.toModel(inscripcionEntity, carreraEntity, materiaEntityList);
    }

}
