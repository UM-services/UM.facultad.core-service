package um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.web.mapper;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.carreras.materia.infrastructure.web.mapper.MateriaDtoMapper;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.model.InscripcionDetalle;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.web.dto.InscripcionDetalleResponse;

@Component
@RequiredArgsConstructor
public class InscripcionDetalleDtoMapper {

    private final MateriaDtoMapper materiaDtoMapper;

    public InscripcionDetalleResponse toResponse(InscripcionDetalle domain) {
        if (domain == null)
            return null;
        InscripcionDetalleResponse.InscripcionDetalleResponseBuilder builder = InscripcionDetalleResponse.builder()
                .personaId(domain.getPersonaId())
                .documentoId(domain.getDocumentoId())
                .lectivoId(domain.getLectivoId())
                .facultadId(domain.getFacultadId())
                .planId(domain.getPlanId())
                .materiaId(domain.getMateriaId())
                .inscripciondetalleId(domain.getInscripciondetalleId())
                .divisionId(domain.getDivisionId())
                .materia(materiaDtoMapper.toResponse(domain.getMateria()));
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

}
