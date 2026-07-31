package um.facultad.rest.hexagonal.inscripciones.inscripcionPago.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.domain.model.InscripcionPago;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.infrastructure.persistence.entity.InscripcionPagoEntity;

@Component
@RequiredArgsConstructor
public class InscripcionPagoMapper {

    public InscripcionPagoEntity toEntity(InscripcionPago domain) {
        if (domain == null)
            return null;
        return InscripcionPagoEntity.builder()
                .inscripcionPagoId(domain.getInscripcionPagoId())
                .personaId(domain.getPersonaId())
                .documentoId(domain.getDocumentoId())
                .facultadId(domain.getFacultadId())
                .lectivoId(domain.getLectivoId())
                .personaIdPagador(domain.getPersonaIdPagador())
                .documentoIdPagador(domain.getDocumentoIdPagador())
                .build();
    }

    public InscripcionPago toDomain(InscripcionPagoEntity entity) {
        if (entity == null)
            return null;
        return InscripcionPago.builder()
                .inscripcionPagoId(entity.getInscripcionPagoId())
                .personaId(entity.getPersonaId())
                .documentoId(entity.getDocumentoId())
                .facultadId(entity.getFacultadId())
                .lectivoId(entity.getLectivoId())
                .personaIdPagador(entity.getPersonaIdPagador())
                .documentoIdPagador(entity.getDocumentoIdPagador())
                .build();
    }

}
