package um.facultad.rest.hexagonal.tesoreriaEstado.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.tesoreriaEstado.domain.model.TesoreriaEstado;
import um.facultad.rest.hexagonal.tesoreriaEstado.infrastructure.persistence.entity.TesoreriaEstadoEntity;

@Component
public class TesoreriaEstadoMapper {

    public TesoreriaEstadoEntity toEntity(TesoreriaEstado domain) {
        if (domain == null) return null;
        TesoreriaEstadoEntity.TesoreriaEstadoEntityBuilder builder = TesoreriaEstadoEntity.builder()
                .tesoreriaEstadoId(domain.getTesoreriaEstadoId())
                .facultadId(domain.getFacultadId())
                .personaId(domain.getPersonaId())
                .documentoId(domain.getDocumentoId())
                .fechaTope(domain.getFechaTope());
        if (domain.getDeuda() != null) builder.deuda(domain.getDeuda());
        if (domain.getManual() != null) builder.manual(domain.getManual());
        if (domain.getImportado() != null) builder.importado(domain.getImportado());
        if (domain.getObservaciones() != null) builder.observaciones(domain.getObservaciones());
        if (domain.getUuid() != null) builder.uuid(domain.getUuid());
        return builder.build();
    }

    public TesoreriaEstado toDomain(TesoreriaEstadoEntity entity) {
        if (entity == null) return null;
        TesoreriaEstado.TesoreriaEstadoBuilder builder = TesoreriaEstado.builder()
                .tesoreriaEstadoId(entity.getTesoreriaEstadoId())
                .facultadId(entity.getFacultadId())
                .personaId(entity.getPersonaId())
                .documentoId(entity.getDocumentoId())
                .fechaTope(entity.getFechaTope());
        if (entity.getDeuda() != null) builder.deuda(entity.getDeuda());
        if (entity.getManual() != null) builder.manual(entity.getManual());
        if (entity.getImportado() != null) builder.importado(entity.getImportado());
        if (entity.getObservaciones() != null) builder.observaciones(entity.getObservaciones());
        if (entity.getUuid() != null) builder.uuid(entity.getUuid());
        return builder.build();
    }
}
