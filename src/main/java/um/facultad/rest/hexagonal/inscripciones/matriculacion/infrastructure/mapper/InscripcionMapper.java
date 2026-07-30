package um.facultad.rest.hexagonal.inscripciones.matriculacion.infrastructure.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.persistence.entity.InscripcionEntity;

@Component("matriculacionInscripcionMapper")
public class InscripcionMapper {

    private final um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.persistence.mapper.InscripcionMapper inscripcionDomainMapper;

    public InscripcionMapper(um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.persistence.mapper.InscripcionMapper inscripcionDomainMapper) {
        this.inscripcionDomainMapper = inscripcionDomainMapper;
    }

    public Inscripcion toModel(InscripcionEntity inscripcionEntity) {
        return inscripcionDomainMapper.toDomain(inscripcionEntity);
    }

}
