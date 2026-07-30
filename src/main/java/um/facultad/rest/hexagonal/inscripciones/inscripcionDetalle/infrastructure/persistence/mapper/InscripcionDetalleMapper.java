package um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.carreras.materia.infrastructure.persistence.mapper.MateriaMapper;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.model.InscripcionDetalle;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.persistence.entity.InscripcionDetalleEntity;

@Component
@RequiredArgsConstructor
public class InscripcionDetalleMapper {

    private final MateriaMapper materiaMapper;

    public InscripcionDetalleEntity toEntity(InscripcionDetalle domain) {
        if (domain == null)
            return null;
        InscripcionDetalleEntity.InscripcionDetalleEntityBuilder builder = InscripcionDetalleEntity.builder()
                .personaId(domain.getPersonaId())
                .documentoId(domain.getDocumentoId())
                .lectivoId(domain.getLectivoId())
                .facultadId(domain.getFacultadId())
                .planId(domain.getPlanId())
                .materiaId(domain.getMateriaId())
                .inscripciondetalleId(domain.getInscripciondetalleId())
                .divisionId(domain.getDivisionId())
                .materia(materiaMapper.toEntity(domain.getMateria()));
        if (domain.getCursoId() != null)
            builder.cursoId(domain.getCursoId());
        if (domain.getPeriodoId() != null)
            builder.periodoId(domain.getPeriodoId());
        if (domain.getRecursa() != null)
            builder.recursa(domain.getRecursa());
        if (domain.getImprimir() != null)
            builder.imprimir(domain.getImprimir());
        if (domain.getMoroso() != null)
            builder.moroso(domain.getMoroso());
        if (domain.getLibre() != null)
            builder.libre(domain.getLibre());
        if (domain.getCondicional() != null)
            builder.condicional(domain.getCondicional());
        return builder.build();
    }

    public InscripcionDetalle toDomain(InscripcionDetalleEntity entity) {
        if (entity == null)
            return null;
        InscripcionDetalle.InscripcionDetalleBuilder builder = InscripcionDetalle.builder()
                .personaId(entity.getPersonaId())
                .documentoId(entity.getDocumentoId())
                .lectivoId(entity.getLectivoId())
                .facultadId(entity.getFacultadId())
                .planId(entity.getPlanId())
                .materiaId(entity.getMateriaId())
                .inscripciondetalleId(entity.getInscripciondetalleId())
                .divisionId(entity.getDivisionId())
                .materia(materiaMapper.toDomain(entity.getMateria()));
        if (entity.getCursoId() != null)
            builder.cursoId(entity.getCursoId());
        if (entity.getPeriodoId() != null)
            builder.periodoId(entity.getPeriodoId());
        if (entity.getRecursa() != null)
            builder.recursa(entity.getRecursa());
        if (entity.getImprimir() != null)
            builder.imprimir(entity.getImprimir());
        if (entity.getMoroso() != null)
            builder.moroso(entity.getMoroso());
        if (entity.getLibre() != null)
            builder.libre(entity.getLibre());
        if (entity.getCondicional() != null)
            builder.condicional(entity.getCondicional());
        return builder.build();
    }

}
